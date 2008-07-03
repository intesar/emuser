/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.util;

import org.acegisecurity.context.SecurityContextHolder;

/**
 *
 * @author intesar
 */
public class AcegiUtil {

    /*
     *  returns logged in user
     */
    public static final String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
        
    }
}
