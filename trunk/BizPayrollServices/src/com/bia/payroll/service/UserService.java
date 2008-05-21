/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;

/**
 *
 * @author intesar
 */
public interface UserService {

    public void createUser(Oraganization organization, Users user);

    public void addUser ( Users user );
    
    public PagedResult<Users> getAllUsers(String userId);

    public void editUser(Users user);

    public void changePassword(String username, String oldPassword, String newPassword);
    
    public Users getUser( String username );
}
