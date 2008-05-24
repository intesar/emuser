/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.service.ajax.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import net.sf.acegisecurity.context.security.SecureContext;

import net.sf.acegisecurity.context.security.SecureContextUtils;









import net.sf.acegisecurity.providers.dao.User;

/**
 *
 * @author intesar.mohammed
 */
public class AcegiUtil {

    /*
     *  returns logged in user
     */
    public static final String getUsername() {
        SecureContext ctx = SecureContextUtils.getSecureContext();
        User u = (User) ctx.getAuthentication().getPrincipal();
        return u.getUsername();
    }
}

