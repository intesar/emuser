/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.impl;

import com.bia.imec.ajax.service.AcegiUtil;
import com.bia.imec.dao.AuthoritiesDao;
import com.bia.imec.dao.UsersDao;
import com.bia.imec.entity.Authorities;
import com.bia.imec.entity.AuthoritiesPK;
import com.bia.imec.entity.Users;
import com.bia.imec.service.UsersService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intesar
 */
public class UsersServiceImpl implements UsersService {

    public List<Users> getAll() {
        System.out.println(" *************** ");
        String username = AcegiUtil.getUsername();
        List<Users> list = null;
        Users u = usersDao.findByUsername(username);
        Authorities authorities = authoritiesDao.read(new AuthoritiesPK(username, "ROLE_ADMIN"));
        if (authorities != null) {
            list = usersDao.readAll().getResults();
        } else {
            list = new ArrayList<Users>();
            list.add(u);
        }
        System.out.println(" ***************2 ");
        System.out.println(list);
        return list;

    }

    public void createUser(Users users) {
        this.usersDao.create(users);
    }

    public void mailPassword(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getUsername() {
        return AcegiUtil.getUsername();
    }

    public void updateUsers(Users users) {
        this.usersDao.update(users);
    }

    public Users getUsers(Integer id) {
        return usersDao.read(id);
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }
    private AuthoritiesDao authoritiesDao;
    private UsersDao usersDao;
}
