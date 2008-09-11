/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.impl;

import com.bia.ccm.dao.AuthoritiesDao;
import com.bia.ccm.dao.OrganizationDao;
import com.bia.ccm.dao.ServicesDao;
import com.bia.ccm.dao.SystemsDao;
import com.bia.ccm.dao.UsersDao;
import com.bia.ccm.entity.Authorities;
import com.bia.ccm.entity.AuthoritiesPK;
import com.bia.ccm.entity.Organization;
import com.bia.ccm.entity.Services;
import com.bia.ccm.entity.Systems;
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

    public String getUserRole(String username) {
        AuthoritiesPK authPK1 = new AuthoritiesPK(username, "ROLE_ADMIN");
        Authorities authorities1 = this.authoritiesDao.read(authPK1);
        if (authorities1 != null) {
            return "admin";
        } else {
            AuthoritiesPK authPK2 = new AuthoritiesPK(username, "ROLE_USER");
            Authorities authorities2 = this.authoritiesDao.read(authPK2);
            if (authorities2 != null) {
                return "user";
            }
        }

        return "";
    }

    public void forgotPassword(String email) {
        //String username = AcegiUtil.getUsername();
        try {
            Users u = this.usersDao.findByUsername(email);
            this.eMailService.sendEmail(u.getEmail(), "your password : " + u.getPassword());
        } catch (NullPointerException npe) {
            logger.error(npe);
            throw new RuntimeException(" No match found!");
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        

    }

    public void registerNewOrganization(String organizationName, String city,
            String email, String password, Integer minutes, Integer rate, Integer maxSystems) {
        Organization o = new Organization(organizationName, (short) 1, null, city,
                email, city, null, "india", email, "Silver Member", "ccm", 0, new Date(), "self");
        Users u = new Users(null, email, password, true, "admin", organizationName, email);
        Authorities a1 = new Authorities(email, "ROLE_ADMIN");
        Authorities a2 = new Authorities(email, "ROLE_USER");
        Services s = new Services(null, "other", 1.0, organizationName);
        Services s1 = new Services(null, "Print B&W", 3.0, organizationName);
        Services s2 = new Services(null, "Copy B&W", 1.0, organizationName);
        Services s3 = new Services(null, "Print Color", 5.0, organizationName);
        Services s4 = new Services(null, "Scan", 5.0, organizationName);
        Services s5 = new Services(null, "Cool Drink", 10.0, organizationName);
        try {
            this.usersDao.create(u);
            this.authoritiesDao.create(a1);
            this.authoritiesDao.create(a2);
            this.organizationDao.create(o);
            this.servicesDao.create(s);
            this.servicesDao.create(s1);
            this.servicesDao.create(s2);
            this.servicesDao.create(s3);
            this.servicesDao.create(s4);
            this.servicesDao.create(s5);
            //Double minuteRate = Double.parseDouble("" + minutes + "." + rate);
            for (int i = 1; i <= 40; i++) {
                boolean enabled = false;
                if (i <= maxSystems) {
                    enabled = true;
                }
                Systems systems = new Systems(null, i, organizationName, true, null, minutes, rate, enabled);
                this.systemsDao.create(systems);
            }
            
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException( e);
        }
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

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

    public void setSystemsDao(SystemsDao systemsDao) {
        this.systemsDao = systemsDao;
    }

    public void setServicesDao(ServicesDao servicesDao) {
        this.servicesDao = servicesDao;
    }
    private UsersDao usersDao;
    private EMailService eMailService = new EMailServiceImpl();
    private OrganizationDao organizationDao;
    private AuthoritiesDao authoritiesDao;
    private SystemsDao systemsDao;
    private ServicesDao servicesDao;
}


