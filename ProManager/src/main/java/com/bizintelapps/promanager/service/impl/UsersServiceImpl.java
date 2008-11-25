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

import com.bizintelapps.promanager.dao.PagingParams;
import com.bizintelapps.promanager.dao.UsersDao;
import com.bizintelapps.promanager.entity.Users;
import com.bizintelapps.promanager.service.converters.UsersConverter;
import com.bizintelapps.promanager.service.UsersService;
import com.bizintelapps.promanager.dto.UsersDto;
import com.bizintelapps.promanager.exceptions.ServiceRuntimeException;
import com.bizintelapps.promanager.service.validator.UsersValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class UsersServiceImpl implements UsersService {

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
            Users users = usersConverter.copyForCreate(usersDto, new Users());
            users.setCreateDate(new Date());
            users.setCreateUser(savedByUsers.getId());
            users.setLastUpdateDate(new Date());
            users.setLastUpdateUser(savedByUsers.getId());
            users.setOrganization(savedByUsers.getOrganization());
            usersDao.create(users);
        } else { // update state to db
            Users users = usersDao.read(usersDto.getId());
            // admin or self can update there records
            if (!savedByUsers.isIsAdministrator() || !(savedByUsers.getId() == users.getId())) {
                throw new ServiceRuntimeException("only administrators or self can update records");
            }
            // copy usersDto contents to existing Users object and persist
            
            if (!users.getEmail().equalsIgnoreCase(usersDto.getEmail())) {
                Users u2 = usersDao.findByEmail(usersDto.getEmail());
                if (u2 != null && u2.getId() != null) {
                    throw new ServiceRuntimeException(usersDto.getEmail() + " is already in use");
                }
            }
            usersConverter.copyForUpdate(usersDto, users);
            users.setLastUpdateDate(new Date());
            users.setLastUpdateUser(savedByUsers.getId());
            usersDao.update(users);
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
        if (((users.getOrganization().equals(changedByUser.getOrganization()) && changedByUser.isIsAdministrator()) || changedByUser.equals(users)) && users.getPassword().equals(oldPassword)) {
            users.setPassword(newPassword);
            usersDao.update(users);
        } else {
            throw new ServiceRuntimeException("Only Administrator can change others password Or user can change there own Or Invalid Old Password");
        }
    }

    @Override
    public PagingParams<UsersDto> getUsers(String forUser) {
        PagingParams<UsersDto> pagingParams = new PagingParams<UsersDto>();
        Users users = usersDao.findByUsername(forUser);
        if (users.isIsAdministrator()) {
            List<UsersDto> list = usersConverter.copyAllForDisplay(users.getOrganization().getUsersCollection());
            pagingParams.setCurrentList(list);
        } else {
            List<UsersDto> list = new ArrayList<UsersDto>();
            UsersDto usersDto = usersConverter.copyForDisplay(users, new UsersDto());
            list.add(usersDto);
        }
        return pagingParams;
    }
    
    @Override
    public void enableDisableUser(Integer userId, boolean enabled, String changedBy) {
        Users changedUser = usersDao.findByUsername(changedBy);
        Users users = usersDao.read(userId);
        if ((users.getOrganization().equals(changedUser.getOrganization()) && changedUser.isIsAdministrator()) || changedUser.equals(users)) {
            users.setEnabled(enabled);
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
    private UsersConverter usersConverter;
    private UsersValidator usersValidator;
    private UsersDao usersDao;
    private final Log log = LogFactory.getLog(getClass());
}
