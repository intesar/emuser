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
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class TimesheetServiceImpl implements TimesheetService {

    public void createTimesheet(Timesheet timesheet) {
        timesheetDao.create(timesheet);
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
    
    public TimesheetDetail getTimesheetDetail ( Integer timesheetId, Date timesheetDetailDate) {
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
