/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.dao.AuthoritiesDao;

import com.bia.payroll.dao.OrganizationDao;
import com.bia.payroll.dao.UsersDao;
import com.bia.payroll.entity.Authorities;
import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;
import com.bia.payroll.service.EMailService;
import com.bia.payroll.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.mail.MailException;

/**
 *
 * @author intesar
 */
public class UserServiceImpl implements UserService {

    public void createUser(Oraganization organization, Users user) {
        //organization.getUsersCollection().add(user);
        organizationDao.create(organization);
        organization = organizationDao.findByName(organization.getName());
        user.setOrganization(organization);
        usersDao.create(user);
        Authorities a1 = new Authorities(user.getUsername(), "ROLE_ADMIN");
        authoritiesDao.create(a1);
        Authorities a2 = new Authorities(user.getUsername(), "ROLE_ACCOUNTANT");
        authoritiesDao.create(a2);
        Authorities a3 = new Authorities(user.getUsername(), "ROLE_USER");
        authoritiesDao.create(a3);
    }

    public void addUser(String username, Users user, boolean userIsAdmin, boolean userIsAccountant) {


        Users user1 = usersDao.findByUsername(username);
        user.setOrganization(user1.getOrganization());
        boolean isAdmin = false;
        if (user == null || user.getId() == null || user.getId() < 1) {

            List<Authorities> a = authoritiesDao.findByUsername(username);
            if (a != null && a.size() > 0) {
                for (Authorities auth : a) {
                    System.out.println ( " ************* " + auth.toString());
                    if (auth.getAuthority().equals("ROLE_ADMIN")) {
                        isAdmin = true;
                        usersDao.create(user);
                        Authorities a2 = new Authorities(user.getUsername(), "ROLE_USER");
                        authoritiesDao.create(a2);

                    }
                }
                if (!isAdmin) {
                    throw new RuntimeException(" You do not have Admin role to create users !");
                }
            }
        } else {
            usersDao.update(user);
        }

//        Authorities adm = authoritiesDao.findByUsernameAndAuthority(username, "ROLE_ADMIN");
//        Authorities acc = authoritiesDao.findByUsernameAndAuthority(username, "ROLE_ACCOUNTANT");
//        if (userIsAdmin) {
//            if (adm == null) {
//                Authorities a2 = new Authorities(user.getUsername(), "ROLE_ADMIN");
//                authoritiesDao.create(a2);
//            }
//        } else {
//            authoritiesDao.findAndDeleteByUsernameAndAuthority(username, "ROLE_ADMIN");
//        }
//        if (userIsAccountant) {
//            if (acc == null) {
//                Authorities a2 = new Authorities(user.getUsername(), "ROLE_ACCOUNTANT");
//                authoritiesDao.create(a2);
//            }
//        } else {
//            authoritiesDao.findAndDeleteByUsernameAndAuthority(username, "ROLE_ACCOUNTANT");
//        }

    }

    public PagedResult<Users> getAllUsers(String username) {
        Users user = usersDao.findByUsername(username);
        List<Authorities> list = authoritiesDao.findByUsername(username);
        for (Authorities authorities : list) {
            if (authorities.getAuthority().equalsIgnoreCase("role_admin")) {
                return usersDao.findByOrganization(user.getOrganization().getId());
            } else {
                List<Users> users = new ArrayList<Users>();
                users.add(user);
                PagedResult<Users> result = new PagedResult<Users>(1, users);
                return result;
            }
        }
        return null;
    }

    public void editUser(Users user) {
        usersDao.update(user);
    }

    public void changePassword(String username, String oldPassword, String newPassword) {

        Users user = usersDao.findByUsername(username);
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            usersDao.update(user);
        } else {
            throw new RuntimeException(" Invalid Old Password ");
        }
    }

    public void mailPassword(String username) {
        Users user = usersDao.findByUsername(username);


        if (user != null) {

            String msg = " Dear " + user.getFirstName() + ", " +
                    user.getLastName() +
                    " your password is : " + user.getPassword();
            try {
                this.eMailService.sendEmail(username, msg);
            } catch (MailException ex) {
                // simply log it and go on...
                ex.printStackTrace();
                throw new NullPointerException(ex.getMessage());
            }
        } else {
            throw new NullPointerException(" No user with the given email Address ");
        }
    }

    public Users getUser(String username) {
        return usersDao.findByUsername(username);
    }

    public Authorities getAuthority(String username, String authority) {
        return authoritiesDao.findByUsernameAndAuthority(username, authority);
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    public void setEMailService(EMailService eMailService) {
        this.eMailService = eMailService;
    }
    private EMailService eMailService;
    private OrganizationDao organizationDao;
    private AuthoritiesDao authoritiesDao;
    private UsersDao usersDao;
}
