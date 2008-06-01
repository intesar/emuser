/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.dao.UsersDao;
import com.bia.imec.entity.User;
import com.bia.imec.services.EMailService;
import com.bia.imec.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.mail.MailException;

/**
 *
 * @author intesar
 */
public class UserServiceImpl implements UserService {

    public PagedResult<User> getAll(String username, PagingParams pagingParams) {
        User u = usersDao.findByUsersname(username);
        if (u.getIsadmin() == 1) {
            return usersDao.readAll(pagingParams);
        } else {
            PagedResult<User> pr = new PagedResult<User>();
            List<User> list = new ArrayList<User>();
            list.add(u);
            pr.setResults(list);
            return pr;
        }

    }

    public void createUser(String username, User users) {
        User u = usersDao.findByUsersname(username);

        if (users != null && users.getId() == null) {
            if (u.getIsadmin() == 0) {
                throw new RuntimeException(" Not an Admin to create User");
            }
            usersDao.create(users);
        } else {
            System.out.println ( " $$$$$$$$$ ");
            usersDao.update(users);
        }
    }

    public void mailPassword(String username) {
        User user = usersDao.findByUsersname(username);


        if (user != null) {

            String msg = " Dear " + user.getFirstname() + ", " +
                    user.getLastname() +
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

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setEMailService(EMailService eMailService) {
        this.eMailService = eMailService;
    }
    private EMailService eMailService;
    private UsersDao usersDao;
}
