/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.ajax.service;

import org.acegisecurity.context.SecurityContextHolder;

/**
 *
 * @author intesar.mohammed
 */
public class AcegiUtil {

    /*
     *  returns logged in user
     */
    public static final String getUsername() {
        String username = "a";
        try {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException ex) {
        }
        return username;
        
    }
}
