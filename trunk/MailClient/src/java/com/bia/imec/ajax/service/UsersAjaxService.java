/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.ajax.service;

import com.bia.imec.entity.Users;
import com.bia.imec.service.DateUtil;
import com.bia.imec.service.ServiceFactory;
import com.bia.imec.service.UsersService;
import java.util.List;

/**
 *
 * @author intesar
 */
public class UsersAjaxService {

    public List<Users> getAllUsers() {
        return this.usersService.getAll();
    }

    public String saveUsers(Users users) {
        this.usersService.updateUsers(users);
        return " User was saved on " + DateUtil.getDate();
    }

    public String createUsers ( Users users) {
        this.usersService.createUser(users);
        return " User was saved on " + DateUtil.getDate();
    }
    public String disableUsers(Integer id) {
        Users u = usersService.getUsers(id);
        u.setEnabled(false);
        usersService.updateUsers(u);
        return u.getFirstname() + " " + u.getLastname() + " is disabled on " + DateUtil.getDate();
    }
    
    public String enableUsers(Integer id) {
        Users u = usersService.getUsers(id);
        u.setEnabled(true);
        usersService.updateUsers(u);
        return u.getFirstname() + " " + u.getLastname() + " is enabled on " + DateUtil.getDate();
    }
    
    private UsersService usersService = (UsersService) ServiceFactory.getService("usersServiceImpl");

    public static void main(String[] args) {
        UsersAjaxService a = new UsersAjaxService();
        System.out.println(a.getAllUsers());
    }
}
