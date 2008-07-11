/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.ccm.services.ajax;

import com.bia.ccm.entity.EmailPreference;
import com.bia.ccm.entity.EmailTimePreference;
import com.bia.ccm.entity.Organization;
import com.bia.ccm.entity.SystemLease;
import com.bia.ccm.entity.Systems;
import com.bia.ccm.entity.Users;
import com.bia.ccm.services.AdminService;
import com.bia.ccm.util.AcegiUtil;
import com.bia.ccm.util.ServiceFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author intesar
 */
public class AdminAjaxService {

    public List<Systems> getAllSystems() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getAllSystems(username);
    }

    public String saveSystems(Systems systems) {
        String username = AcegiUtil.getUsername();
        return this.adminService.saveSystem(systems, username);
    }

    public List<Users> getAllUsers() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getAllUsers(username);
    }

    public String saveUsers(Users users) {
        String username = AcegiUtil.getUsername();
        return this.adminService.saveUser(users, username);
    }

    public List<EmailPreference> getAllEmailPreference() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getAllEmailPreference(username);
    }

    public String saveEmailPreference(EmailPreference emailPreference) {
        String username = AcegiUtil.getUsername();
        return this.adminService.saveEmailPreference(emailPreference, username);
    }

    public List<EmailTimePreference> getAllEmailTimePreference() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getAllEmailTimePreference(username);
    }

    public String saveEmailTimePreference(EmailTimePreference emailTimePreference) {
        String username = AcegiUtil.getUsername();
        return this.adminService.saveEmailTimePreference(emailTimePreference, username);
    }

    public List<SystemLease> getAllSystemLease() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getAllSystemLease(username);
    }

    public Organization getOrganization() {
        String username = AcegiUtil.getUsername();
        return this.adminService.getOrganization(username);
    }

    public String saveOrganization(Organization organization) {
        String username = AcegiUtil.getUsername();
        return this.adminService.saveOrganization(organization, username);
    }

    public List<SystemLease> getSystemLease(String startDateString, String endDateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        String username = AcegiUtil.getUsername();
        Users u = this.adminService.getUserByUsername(username);

        try {
            startDate = sdf.parse(startDateString);
            endDate = sdf.parse(endDateString);
            return this.adminService.getSystemLease(startDate, endDate, u.getOrganization());
        } catch (ParseException ex) {
            Logger.getLogger(AdminAjaxService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List getReport(String startDateString, String endDateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateString);
            Date endDate = sdf.parse(endDateString);
            logger.debug(startDate + " " + endDate);
            String username = AcegiUtil.getUsername();
            Users u = this.adminService.getUserByUsername(username);
            return this.adminService.getReport(startDate, endDate, u.getOrganization());
        } catch (ParseException ex) {
            Logger.getLogger(AdminAjaxService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    protected final Log logger = LogFactory.getLog(getClass());
    private AdminService adminService = (AdminService) ServiceFactory.getService("adminServiceImpl");

    public static void main(String[] args) {
        AdminAjaxService aas = new AdminAjaxService();
//        EmailPreference ep = new EmailPreference(null, "test", "mohdshannan@yahoo.com", "bia");
//        aas.saveEmailPreference(ep);
//        short s = (short) 500;
//        EmailTimePreference etp = new EmailTimePreference(null, s, "bia");
//        aas.saveEmailTimePreference(etp);
//        Systems s1 = new Systems(null, 2, "bia", true, null, 20.8, true);
//        aas.saveSystems(s1);
//        Users u = new Users(null, "shannan", "shannan", true, "admin", "bia", "shannan");
//        aas.saveUsers(u);
//        
//        System.out.println(aas.getAllEmailPreference());
//        System.out.println(aas.getAllEmailTimePreference());
//        System.out.println(aas.getAllSystemLease());
//        System.out.println(aas.getAllSystems());
//        System.out.println(aas.getAllUsers());
//        System.out.println(aas.getOrganization());
        Date dt1 = new Date(107, 7, 7);
        Date dt2 = new Date(110, 11, 11);
        System.out.println ( aas.getSystemLease("2007-07-07", "2008-10-10").size() );
        //System.out.println(aas.getReport("2007-07-07", "2008-10-10"));
    }
}
