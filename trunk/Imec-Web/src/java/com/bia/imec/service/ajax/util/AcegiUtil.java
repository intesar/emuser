/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */










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
       return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

