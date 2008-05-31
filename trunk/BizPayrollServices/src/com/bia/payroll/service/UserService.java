/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Authorities;
import com.bia.payroll.entity.Oraganization;
import com.bia.payroll.entity.Users;

/**
 *
 * @author intesar
 */
public interface UserService {

    public void createUser(Oraganization organization, Users user);

    public void addUser ( String username, Users user, boolean userIsAdmin, boolean userIsAccountant );
    
    public PagedResult<Users> getAllUsers(String userId);

    public void editUser(Users user);

    public void mailPassword ( String username );
    
    public void changePassword(String username, String oldPassword, String newPassword);
    
    public Users getUser( String username );
    
    public Authorities getAuthority ( String username, String authority);
}
