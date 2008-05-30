/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.ajax;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Authorities;
import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;
import com.bia.payroll.model.UsersConverter;
import com.bia.payroll.model.UsersDto;
import com.bia.payroll.service.ServiceFactory;
import com.bia.payroll.service.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intesar
 */
public class UserAjaxService {

    public String addUser(UsersDto dto) {
        String username = AcegiUtil.getUsername();
        //Users user = userService.getUser("abc");//AcegiUtil.getUsername());
        Users u = new Users();
        usersConverter.copy(dto, u);
        try {
            userService.addUser(username, u, dto.getIsAdmin(), dto.getIsAdmin());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Account Created Successfully";
    }

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

    public List<UsersDto> getAllUsers() {
        List<UsersDto> dtos = new ArrayList<UsersDto>();
        String username = AcegiUtil.getUsername();
        PagedResult<Users> result = userService.getAllUsers(username);
        for (Users u : result.getResults()) {
            UsersDto dto = new UsersDto();
            Authorities adm = userService.getAuthority(u.getUsername(), "ROLE_ADMIN");
            if (adm != null) {
                dto.setIsAdmin(true);
            }
            Authorities acc = userService.getAuthority(u.getUsername(), "ROLE_ACCOUNTANT");
            if (acc != null) {
                dto.setIsAccountant(true);
            }
            usersConverter.copy(u, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public String getMyUsername() {
        return AcegiUtil.getUsername();
    }

    public String editUser(UsersDto dto) {
        try {
            Users user = new Users();
            usersConverter.copy(dto, user);
            userService.editUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return " User Updated Sucessfully ! ";
    }

    public void changePassword(String oldPassword, String newPassword) {
        String username = AcegiUtil.getUsername();
        userService.changePassword(username, oldPassword, newPassword);
    }

    public String emailPassword(String username) {
        try {
            this.userService.mailPassword(username);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return " Password send to " + username;
    }

    public List<String> getMyFilterList() {
        String username = AcegiUtil.getUsername();
        Authorities admin = userService.getAuthority(username, "ROLE_ADMIN");
        Authorities acc = userService.getAuthority(username, "ROLE_ACCOUNTANT");
        Authorities user = userService.getAuthority(username, "ROLE_USER");

        List<String> list = new ArrayList<String>();
        if (user != null) {
            list.add("My Saved Timesheets");
            list.add("My Submitted Timesheets");
            list.add("My Approved Timesheets");
            list.add("My Rejected Timesheets");
            list.add("My Paid Timesheets");
        }
        if (acc != null) {
            list.add("All Approved Timesheets");
            list.add("All Paid Timesheets");
        }

        if (admin != null) {
            list.add("All Saved Timesheets");
            list.add("All Submitted Timesheets");
            list.add("All Rejected Timesheets");
        }

        if (list.size() <= 0) {
            list.add("No Filter");
        }
        return list;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");
    private UsersConverter usersConverter = new UsersConverter();

    public static void main(String[] args) {
        UserAjaxService u = new UserAjaxService();
//        UsersDto dto = new UsersDto();
//        dto.setFirstname("fn");
//        dto.setLastname("ln");
//        dto.setPassword("ps");
//        dto.setUsername("us");
//        u.addUser(dto);
        //System.out.println(u.getAllUsers());
        u.emailPassword("mdshannan@gmail.com");
    }
}
