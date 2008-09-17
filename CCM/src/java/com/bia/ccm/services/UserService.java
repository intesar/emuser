/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.services;

import com.bia.ccm.entity.Users;

/**
 *
 * @author intesar
 */
public interface UserService {
    public Users getUser(Integer id);
    public String getUserRole(String username);
    public void forgotPassword(String email);
    public void registerNewOrganization(String organizationName, String city, 
            String email, String password, Integer minutes, Integer rate, Integer maxSystems);

}
