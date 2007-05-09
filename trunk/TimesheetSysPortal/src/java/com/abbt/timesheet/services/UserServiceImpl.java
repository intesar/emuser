/*
 * UserServiceImpl.java
 *
 * Created on May 5, 2007, 8:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import abbt.com.paginationframework.PageHandlerDao;
import com.abbt.timesheet.daos.TimesheetDBDao;
import com.abbt.timesheet.entities.User;
//import com.abbt.timesheet.entities.UserRole;
import com.abbt.timesheet.exceptions.UserNotAdminException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shannan
 */
public class UserServiceImpl implements UserService {
    
    /** Creates a new instance of UserServiceImpl */
    public UserServiceImpl() {
    }
    
    public void isAdmin(String userEmail) throws UserNotAdminException {
//        UserRole userRole = null;
//        try {
//            userRole = (UserRole) this.getTimesheetDBDao().
//                    findResultListByNamedQuery("UserRole.findByUserAndRole", userEmail, "ADMIN");
//        } catch ( Exception e) {
//            // log here
//        }
//        if ( userRole instanceof UserRole ) {
//            throw new UserNotAdminException();
//        }
    }
    /*
     * returns all User objects with just emails in it
     */
    public List<User> findAllUserEmails() {
        
        List<User> list = this.getTimesheetDBDao().findResultListByNamedQuery("User.findAllEmails");
        if ( ! (list instanceof List) ) {
            list = new ArrayList<User>();
        }
        return list;
    }
    
    
    public TimesheetDBDao getTimesheetDBDao() {
        return timesheetDBDao;
    }
    
    public void setTimesheetDBDao(TimesheetDBDao timesheetDBDao) {
        this.timesheetDBDao = timesheetDBDao;
    }
    
    public PageHandlerDao getPageHandlerDao() {
        return pageHandlerDao;
    }
    
    public void setPageHandlerDao(PageHandlerDao pageHandlerDao) {
        this.pageHandlerDao = pageHandlerDao;
    }
    
    
    
    private PageHandlerDao pageHandlerDao;
    private TimesheetDBDao timesheetDBDao;
    
//    public static void main ( String [] args) {
//
//        UserService us = (UserService) ServiceFactory.getService("UserService");
//        List<User> list = us.findAllUserEmails();
//        System.out.println ( " list size " + list.get(0) );
//        for ( User u : list ) {
//            System.out.println (" Email " + u.getEmail() );
//        }
//    }
}
