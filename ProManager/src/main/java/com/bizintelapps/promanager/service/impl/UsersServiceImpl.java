/*
 *  Copyright 2008 intesar.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.bizintelapps.promanager.service.impl;

import com.bizintelapps.mail.MailSender;
import com.bizintelapps.promanager.dao.AuthoritiesDao;
import com.bizintelapps.promanager.dao.OrganizationDao;
import com.bizintelapps.promanager.dao.PagingParams;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.converters.UsersConverter;
import com.bizintelapps.promanager.service.UsersService;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.entity.Authorities;
import com.bizintelapps.promanager.entity.Organization;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;
import com.bizintelapps.promanager.service.validator.UsersValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author intesar
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public void signUp(UsersDto usersDto) {
        Users u1 = usersDao.findByUsername(usersDto.getUsername());
        if (u1 != null && u1.getId() != null) {
            throw new ServiceRuntimeException(usersDto.getUsername() + " is already in use");
        }
        Users u2 = usersDao.findByEmail(usersDto.getEmail());
        if (u2 != null && u2.getId() != null) {
            throw new ServiceRuntimeException(usersDto.getEmail() + " is already in use");
        }
        Organization org = organizationDao.findByName(usersDto.getOrganization());
        if (org != null && org.getId() != null) {
            throw new ServiceRuntimeException(usersDto.getOrganization() + " is already in use");
        }
        // copy usersDto contents to new Users object and persist

        org = new Organization(null, usersDto.getOrganization(), new Date());
        organizationDao.create(org);
        org = organizationDao.findByName(org.getName());
        Users users = new Users();
        usersConverter.copyForSignUp(usersDto, users);
        users.setPassword(passwordEncryptor.encryptPassword(users.getPassword()));
        users.setIsEncrypted(true);
        users.setCreateDate(new Date());
        users.setLastUpdateDate(new Date());
        users.setOrganization(org);
        usersDao.create(users);
        Authorities authorities1 = new Authorities(null, users.getUsername(), Authorities.ROLE_ADMIN);
        Authorities authorities2 = new Authorities(null, users.getUsername(), Authorities.ROLE_USER);
        authoritiesDao.create(authorities1);
        authoritiesDao.create(authorities2);
    }

    @Override
    public List<UsersDto> saveAndGetUser(UsersDto usersDto, String savedBy) {
        saveUser(usersDto, savedBy);
        return getUsers(savedBy).getCurrentList();
    }

    @Override
    public void saveUser(UsersDto usersDto, String savedBy) {
        Users savedByUsers = usersDao.findByUsername(savedBy);
        // if id is null then persist
        if (usersDto.getId() == null) {
            // check user is admin
            if (!savedByUsers.isIsAdministrator()) {
                throw new ServiceRuntimeException("only administrators can create new users");
            }
            // check to see whether username or email is already in use
            Users u1 = usersDao.findByUsername(usersDto.getUsername());
            if (u1 != null && u1.getId() != null) {
                throw new ServiceRuntimeException(usersDto.getUsername() + " is already in use");
            }
            Users u2 = usersDao.findByEmail(usersDto.getEmail());
            if (u2 != null && u2.getId() != null) {
                throw new ServiceRuntimeException(usersDto.getEmail() + " is already in use");
            }
            // copy usersDto contents to new Users object and persist
            Users users = new Users();
            usersConverter.copyForCreate(usersDto, users);
            users.setCreateDate(new Date());
            users.setCreateUser(savedByUsers.getId());
            users.setLastUpdateDate(new Date());
            users.setLastUpdateUser(savedByUsers.getId());
            users.setOrganization(savedByUsers.getOrganization());
            users.setPassword(passwordEncryptor.encryptPassword(usersDto.getUsername()));
            users.setIsEncrypted(true);
            usersDao.create(users);
            Authorities authorities = new Authorities(null, users.getUsername(), Authorities.ROLE_USER);
            if (usersDto.isAdministrator()) {
                Authorities authorities1 = new Authorities(null, users.getUsername(), Authorities.ROLE_ADMIN);
                authoritiesDao.create(authorities1);
            }
            authoritiesDao.create(authorities);
        } else { // update state to db
            Users users = usersDao.read(usersDto.getId());
            // admin or self can update there records
            if (!savedByUsers.isIsAdministrator() || !savedByUsers.getOrganization().equals(users.getOrganization())) {
                throw new ServiceRuntimeException("only administrators or self can update records");
            }
            // copy usersDto contents to existing Users object and persist

            if (!users.getEmail().equalsIgnoreCase(usersDto.getEmail())) {
                Users u2 = usersDao.findByEmail(usersDto.getEmail());
                if (u2 != null && u2.getId() != null) {
                    throw new ServiceRuntimeException(usersDto.getEmail() + " is already in use");
                }
            }

            // check admin criteria
            if (users.getUsername().equals(savedByUsers.getUsername()) &&
                    users.isIsAdministrator() && usersDto.isAdministrator()) {
                throw new ServiceRuntimeException("User cannot demote himself");
            }
            log.debug("---------  usersDto.isAdministrator() " + usersDto.isAdministrator());
            log.debug("---------  users.isIsAdministrator() " + users.isIsAdministrator());
            log.debug("---------  usersDto.enabled() " + usersDto.isEnabled());
            log.debug("---------  users.enabled() " + users.getEnabled());

            if (usersDto.isAdministrator() && !users.isIsAdministrator()) {
                // add him to authority
                log.debug("--------- ADD AUTHORITY ");
                Authorities authority = new Authorities(null, usersDto.getUsername(), Authorities.ROLE_ADMIN);
                authoritiesDao.create(authority);
            } else if (!usersDto.isAdministrator() && users.isIsAdministrator()) {
                // remove him from authority
                log.debug("--------- DELETE AUTHORITY ");
                Authorities authorities = authoritiesDao.findByUsernameAndAuthority(usersDto.getUsername(), Authorities.ROLE_ADMIN);
                authoritiesDao.delete(authorities);
            }
            log.debug("--------- before copy ");
            usersConverter.copyForUpdate(usersDto, users);
            users.setLastUpdateDate(new Date());
            users.setLastUpdateUser(savedByUsers.getId());
            usersDao.update(users);
            log.debug("--------- after updated ");
        }
    }

    @Override
    public void deleteUser(Integer userId, String deletedBy) {
        Users users = usersDao.findByUsername(deletedBy);
        Users usersToBeDeleted = usersDao.read(userId);
        // find user is admin then only can delete other even they are administrators
        if ((users.getOrganization().equals(usersToBeDeleted.getOrganization()) && usersToBeDeleted.isIsAdministrator())) {
            usersDao.delete(usersToBeDeleted);
        } else {
            throw new ServiceRuntimeException("Only Administrator can delete users!");
        }
    }

    @Override
    public void changePassword(Integer userId, String oldPassword, String newPassword, String changedBy) {
        Users users = usersDao.read(userId);
        Users changedByUser = usersDao.findByUsername(changedBy);
        // changedBy administrator or self
        if (((users.getOrganization().equals(changedByUser.getOrganization()) && changedByUser.isIsAdministrator()) || changedByUser.equals(users)) && users.getPassword().equals(passwordEncryptor.encryptPassword(oldPassword))) {
            users.setPassword(passwordEncryptor.encryptPassword(newPassword));
            usersDao.update(users);
        } else {
            throw new ServiceRuntimeException("Only Administrator can change others password Or user can change there own Or Invalid Old Password");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        Users users = usersDao.findByUsername(username);
        //self
        if (users != null && users.getPassword().equals(passwordEncryptor.encryptPassword(oldPassword))) {
            users.setPassword(passwordEncryptor.encryptPassword(newPassword));
            usersDao.update(users);
        } else {
            throw new ServiceRuntimeException("Invalid Old Password");
        }
    }

    @Override
    public void requestPasswordKeySendToEmail(String username) {
        Users users = usersDao.findByUsername(username);
        if (users == null) {
            throw new ServiceRuntimeException("We didn't find your email in our system!");
        }
        // key is password - 3 chars
        String password = users.getPassword();
        String key = password.substring(0, password.length() - 5);
        // email this key
        this.mailSender.sendMail(new String[]{username}, "Password Resett Key", "Please ignore this email if you have " +
                "not requested for password reset key, as it won't harm your login, if you want to reset your password please " +
                "use this key :" + key);
    }

    @Override
    public void resetPasswordWithKey(String username, String emailKey, String newPassword) {
        Users users = usersDao.findByUsername(username);
        if (users == null) {
            throw new ServiceRuntimeException("We didn't find your email in our system!");
        }
        // key is password - 3 chars
        String password = users.getPassword();
        String key = password.substring(0, password.length() - 5);
        if (key.equals(emailKey)) {
            users.setPassword(passwordEncryptor.encryptPassword(newPassword));
            usersDao.update(users);
            mailSender.sendMail(new String[]{username}, "Password Changed", "");
        } else {
            throw new ServiceRuntimeException("Key mismatch, please remove spaces from begining and end of key and try again!");
        }
    }

    @Override
    public PagingParams<UsersDto> getUsers(String forUser) {
        PagingParams<UsersDto> pagingParams = new PagingParams<UsersDto>();
        Users users = usersDao.findByUsername(forUser);
        if (users.isIsAdministrator()) {
            List<UsersDto> list = usersConverter.copyAllForDisplay(usersDao.findByOrganizationId(users.getOrganization().getId()));
            pagingParams.setCurrentList(list);
        } else {
            List<UsersDto> list = new ArrayList<UsersDto>();
            UsersDto usersDto = new UsersDto();
            usersConverter.copyForDisplay(users, usersDto);
            list.add(usersDto);
        }
        return pagingParams;
    }

    @Override
    public void enableDisableUser(Integer userId, boolean enabled, String changedBy) {
        log.debug("---- executing findByUsername with " + changedBy);
        Users changedUser = usersDao.findByUsername(changedBy);
        log.debug("---- changedUser " + changedUser.getUsername());
        Users users = usersDao.read(userId);
        if ((users.getOrganization().equals(changedUser.getOrganization()) && changedUser.isIsAdministrator()) || changedUser.equals(users)) {
            users.setEnabled(enabled);
            usersDao.update(users);
        } else {
            throw new ServiceRuntimeException(changedBy + " is not an Administrator");
        }
    }
    // getter & setters
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setUsersValidator(UsersValidator usersValidator) {
        this.usersValidator = usersValidator;
    }

    public void setUsersConverter(UsersConverter usersConverter) {
        this.usersConverter = usersConverter;
    }

    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Autowired
    private UsersConverter usersConverter;
    @Autowired
    private UsersValidator usersValidator;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private PasswordEncryptor passwordEncryptor;
    @Autowired
    private AuthoritiesDao authoritiesDao;
    @Autowired
    private MailSender mailSender;
    private final Log log = LogFactory.getLog(getClass());
}
