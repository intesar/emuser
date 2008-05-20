/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.ajax;

import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;
import com.bia.payroll.service.ServiceFactory;
import com.bia.payroll.service.UserService;




/**
 *
 * @author intesar
 */
public class UserAjaxService {

    public String createUser(String companyName, String type, String companyDescription,
            String firstName, String lastName, String username, String password) {
        Oraganization o = new Oraganization();
        o.setDescription(companyDescription);
        o.setName(companyName);
        o.setType(type);
        Users u = new Users();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setOrganization(o);
        u.setPassword(password);
        u.setUsername(username);
        try {
            userService.createUser(o, u);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Account Created Successfully";

    }

    public void getAllUsers() {
    }

    public void editUser() {
    }

    public void changePassword() {
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
}
