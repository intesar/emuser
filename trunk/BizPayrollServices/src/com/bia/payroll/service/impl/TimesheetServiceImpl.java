/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service.impl;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.dao.AuthoritiesDao;
import com.bia.payroll.dao.TimesheetDao;
import com.bia.payroll.dao.TimesheetDetailDao;
import com.bia.payroll.dao.UsersDao;
import com.bia.payroll.entity.Authorities;
import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.entity.TimesheetDetail;
import com.bia.payroll.entity.Users;
import com.bia.payroll.service.TimesheetService;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author intesar
 */
public class TimesheetServiceImpl implements TimesheetService {

    public void createTimesheet(Timesheet timesheet) {
        timesheetDao.create(timesheet);
    }

    public Timesheet createTimesheet(String username) {
        Users u = usersDao.findByUsername(username);
        Date lastStartDate = timesheetDao.findMaxStartDate(u.getId());
        Date userStartDate = null;
       
        if (lastStartDate == null) {
            userStartDate = u.getStartDate();
        } else {
            Calendar c2 = new GregorianCalendar();
            c2.setTime(lastStartDate);
            c2.add(Calendar.DAY_OF_MONTH, 7);
            userStartDate = c2.getTime();
        }


        Calendar c = new GregorianCalendar();
        c.setTime(userStartDate);
        int day = c.get(Calendar.DAY_OF_WEEK);
        c.add(Calendar.DAY_OF_MONTH, -(day - 1));
        Date newStartDate = c.getTime();
        Timesheet t = new Timesheet(timesheetDao.findMaxOfId()+1);
        t.setStartDate(newStartDate);
        t.setStatus("saved");
        t.setStatusDate(new Date());
        t.setUser(u);
        c.add(Calendar.DAY_OF_MONTH, 6);
        t.setEndDate(c.getTime());
        t.setLastUser(username);
        t.setLastAction("create");

        timesheetDao.create(t);
        //t = timesheetDao.findByStartDateAndUserId(newStartDate, u.getId());
        
        System.out.println ( " timesheet ID : " + t.getId() );
        
        // create seven days timesheet detail objects 
        TimesheetDetail td1 = new TimesheetDetail(null, newStartDate, 0, 0, "mon", username, "create");
        td1.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td1);
        
        Calendar c1 = new GregorianCalendar();
        c1.setTime(newStartDate);
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td2 = new TimesheetDetail(null, c1.getTime(), 0, 0, "tue", username, "create");
        td2.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td2);
        
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td3 = new TimesheetDetail(null, c1.getTime(), 0, 0, "wed", username, "create");
        td3.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td3);
        
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td4 = new TimesheetDetail(null, c1.getTime(), 0, 0, "thu", username, "create");
        td4.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td4);
        
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td5 = new TimesheetDetail(null, c1.getTime(), 0, 0, "fri", username, "create");
        td5.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td5);
        
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td6 = new TimesheetDetail(null, c1.getTime(), 0, 0, "sat", username, "create");
        td6.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td6);
        
        c1.add(Calendar.DAY_OF_MONTH, 1);
        TimesheetDetail td7 = new TimesheetDetail(null, c1.getTime(), 0, 0, "sun", username, "create");
        td7.setTimesheet(t);
        //t.getTimesheetDetailCollection().add(td7);
        
        
        timesheetDetailDao.create(td1);
        timesheetDetailDao.create(td2);
        timesheetDetailDao.create(td3);
        timesheetDetailDao.create(td4);
        timesheetDetailDao.create(td5);
        timesheetDetailDao.create(td6);
        timesheetDetailDao.create(td7);
        
        t.getTimesheetDetailCollection();
        
        return t;

        
    }

    /**
     * three types of users admin, accountant, general_user
     * admin's rights  approve, reject, view All, view approved, view saved, 
     *      view rejected, view submitted, View My Approved, view my saved, view my rejected,
     *      view my submitted, view my saved etc
     * general_user rights will only see his timesheets view my All, view my approved, view my saved, 
     *      view my rejected, view my submitted
     * accountant's rights view approved, create check and mark paid
     * @param username
     * @param status
     * @return
     */
    public PagedResult<Timesheet> getAllTimesheetsByStatus(String username, String status) {
        Users user = usersDao.findByUsername(username);
        List<Authorities> list = authoritiesDao.findByUsername(user.getUsername());
        boolean isAdmin = false;
        boolean isAccountant = false;

        for (Authorities authorities : list) {
            if (authorities.getAuthority().equalsIgnoreCase("role_admin")) {
                isAdmin = true;
            } else if (authorities.getAuthority().equalsIgnoreCase("role_accountant") &&
                    status.equalsIgnoreCase("approved")) {
                isAccountant = true;
            }
        }

        if (isAdmin || isAccountant) {
            return timesheetDao.findByStatus(status);
        } else {
            return timesheetDao.findByUserIdAndStatus(user.getId(), status);
        }
    }

    public PagedResult<Timesheet> getAllMyTimesheetsByStatus(String username, String status) {
        Users user = usersDao.findByUsername(username);
        return timesheetDao.findByUserIdAndStatus(user.getId(), status);
    }

    public Timesheet getTimesheet(Integer timesheetId) {
        return timesheetDao.read(timesheetId);
    }

    public void updateTimesheet(Timesheet timeSheet) {
        timesheetDao.update(timeSheet);
    }

    public TimesheetDetail getTimesheetDetail(Integer timesheetId, Date timesheetDetailDate) {
        return timesheetDetailDao.findByTimesheetIdAndDate(timesheetId, timesheetDetailDate);
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

    public void setTimesheetDao(TimesheetDao timesheetDao) {
        this.timesheetDao = timesheetDao;
    }

    public void setTimesheetDetailDao(TimesheetDetailDao timesheetDetailDao) {
        this.timesheetDetailDao = timesheetDetailDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    private TimesheetDao timesheetDao;
    private UsersDao usersDao;
    private AuthoritiesDao authoritiesDao;
    private TimesheetDetailDao timesheetDetailDao;
}
