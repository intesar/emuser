/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.services.UserService;
import com.bia.ccm.util.ServiceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class UserAjaxService {

    public String forgotPassword(String email) {
        //String username = AcegiUtil.getUsername();
        return this.userService.forgotPassword(email);

    }

    public String registerNewOrganization(String organizationName, String city, String email, String password) {
        logger.debug("error");
        System.out.println ("inside register organization");
        try {
            String str = this.userService.registerNewOrganization(organizationName, city, email, password);
            System.out.println ("inside register organization1");
            return str;
        } catch (Exception e) {
            System.out.println ("inside register organization3");
            logger.debug("error");
            e.printStackTrace();
            return "Error creating new organization";
        }
    }
    protected final Log logger = LogFactory.getLog(getClass());
    private UserService userService = (UserService) ServiceFactory.getService("userServiceImpl");

    public static void main(String[] args) {
        UserAjaxService uas = new UserAjaxService();
        System.out.println(uas.registerNewOrganization("apolo12", "hyd", "apollo13", "apollo13"));

    }
}
