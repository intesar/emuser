/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services;

/**
 *
 * @author intesar
 */
public interface UserServices {
    void getUsers();
    void createUsers(String usersu);
    void changePassword(String username,String newpassword); 
    void deactivateUser(String username);
    void activateUser(String username);
    void createOrganisation(String organisationname,String usersu);
}
