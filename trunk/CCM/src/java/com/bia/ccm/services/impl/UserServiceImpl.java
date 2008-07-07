/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.bia.ccm.dao.OrganizationDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.Organization;
import com.bia.ccm.entity.Users;
import com.bia.ccm.services.EMailService;
import com.bia.ccm.services.UserService;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class UserServiceImpl implements UserService {

    protected final Log logger = LogFactory.getLog(getClass());

    public String forgotPassword(String email) {
        //String username = AcegiUtil.getUsername();
        try {
            Users u = this.usersDao.findByUsername(email);
            this.eMailService.sendEmail(u.getEmail(), u.getPassword());
        } catch (NullPointerException npe) {
            return " No match found!";
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Please check your email";

    }

    public String registerNewOrganization(String organizationName, String city, String email, String password) {
        Organization o = new Organization(organizationName, (short) 1, null, city,
                email, city, null, "india", email, "trial", "ccm", 0, new Date(), "self");
        Users u = new Users(null, email, password, true, "admin", organizationName, email);
        this.usersDao.create(u);
        this.organizationDao.create(o);
        return "Please login with your email and password";
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setEMailService(EMailService eMailService) {
        this.eMailService = eMailService;
    }

    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }
    private UsersDao usersDao;
    private EMailService eMailService;
    private OrganizationDao organizationDao;
}
