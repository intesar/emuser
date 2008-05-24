/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.imec.dao.UsersDao;
import com.bia.imec.entity.User;
import com.bia.imec.services.UserService;

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

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    
    private UsersDao usersDao;
}
