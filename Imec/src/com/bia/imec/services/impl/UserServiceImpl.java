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
import org.springframework.mail.MailException;

/**
 *
 * @author intesar
 */
public class UserServiceImpl implements UserService {

    public PagedResult<User> getAll(PagingParams pagingParams) {
        return usersDao.readAll(pagingParams);
    }

    public void createUser(User users) {
        usersDao.create(users);
    }

    public void updateUser(User users) {
        usersDao.update(users);
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
