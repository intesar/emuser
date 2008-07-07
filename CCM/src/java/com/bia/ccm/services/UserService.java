/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.services;

/**
 *
 * @author intesar
 */
public interface UserService {
    public String forgotPassword(String email);
    public String registerNewOrganization(String organizationName, String city, String email, String password);

}
