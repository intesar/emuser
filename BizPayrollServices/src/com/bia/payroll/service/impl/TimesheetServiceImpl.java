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
import com.bia.payroll.entity.Users;
import com.bia.payroll.service.TimesheetService;
import java.util.List;

/**
 *
 * @author intesar
 */
public class TimesheetServiceImpl implements TimesheetService {

    public void createTimesheet(Timesheet timesheet) {
        timesheetDao.create(timesheet);
    }

    public PagedResult<Timesheet> getAllTimesheetsByStatus(Integer userId, String status) {
        Users user = usersDao.read(userId);
        List<Authorities> list = authoritiesDao.findByUsername(user.getUsername());
        for (Authorities authorities : list) {
            if (authorities.getAuthority().equalsIgnoreCase("role_admin")) {
                return timesheetDao.findByStatus(status);
            } else {
                return timesheetDao.findByUserIdAndStatus(userId, status);
            }
        }
        return null;


    }

    public Timesheet getTimesheet(Integer timesheetId) {
        return timesheetDao.read(timesheetId);
    }

    public void updateTimesheet(Timesheet timeSheet) {
        timesheetDao.update(timeSheet);
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
