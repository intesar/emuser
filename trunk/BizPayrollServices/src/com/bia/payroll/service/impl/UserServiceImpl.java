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
import com.bia.payroll.service.UserService;
import java.util.ArrayList;
import java.util.List;

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
        Authorities a2 = new Authorities(user.getUsername(), "ROLE_USER");
        authoritiesDao.create(a2);
    }

    public void addUser(String username, Users user) {
        Users user1 = usersDao.findByUsername(username);
        user.setOrganization(user1.getOrganization());
        if (user.getId() == null) {
            usersDao.create(user);
        } else {
            usersDao.update(user);
        }
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

    public Users getUser(String username) {
        return usersDao.findByUsername(username);
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
    private OrganizationDao organizationDao;
    private AuthoritiesDao authoritiesDao;
    private UsersDao usersDao;
}
