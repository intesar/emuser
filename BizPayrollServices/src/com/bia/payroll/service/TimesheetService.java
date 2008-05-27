/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.payroll.service;

import com.abbhsoft.jpadaoframework.dao.PagedResult;
import com.bia.payroll.entity.Timesheet;
import com.bia.payroll.entity.TimesheetDetail;
import java.util.Date;

/**
 *
 * @author intesar
 */
public interface TimesheetService {

    public void createTimesheet(Timesheet timesheet);

    public void createTimesheet(String username);

    public PagedResult<Timesheet> getAllMyTimesheetsByStatus(String username, String status);

    public PagedResult<Timesheet> getAllTimesheetsByStatus(String username, String status);

    public Timesheet getTimesheet(Integer timesheetId);

    public void updateTimesheet(Timesheet timeSheet);

    public TimesheetDetail getTimesheetDetail(Integer timesheetId, Date timesheetDetailDate);
}
