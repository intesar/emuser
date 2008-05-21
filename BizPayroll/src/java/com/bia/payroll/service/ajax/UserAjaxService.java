/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.ajax;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;
import com.bia.payroll.service.ServiceFactory;
import com.bia.payroll.service.UserService;
import java.util.List;




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

    public List<Users> getAllUsers() {
        String username = AcegiUtil.getUsername(); 
        PagedResult<Users> result = userService.getAllUsers(username);
        return result.getResults();
    }

    public void editUser() {
    }

    public void changePassword(String oldPassword, String newPassword) {
        String username = AcegiUtil.getUsername();        
        userService.changePassword(username, oldPassword, newPassword);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
}
