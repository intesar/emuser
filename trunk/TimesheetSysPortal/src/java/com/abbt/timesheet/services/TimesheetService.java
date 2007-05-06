/*
 * TimesheetService.java
 *
 * Created on May 3, 2007, 11:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import abbt.com.paginationframework.PageHandler;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.entities.TimesheetDetail;
import com.abbt.timesheet.entities.TimesheetStatus;
import com.abbt.timesheet.exceptions.AccessDeniedException;
import com.abbt.timesheet.exceptions.EntityExistsException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author shannan
 */
public interface TimesheetService {
    
    void save(Timesheet timesheet) throws EntityExistsException;
    
    void createTimesheetAndTimesheetDetails( String loggedUser, Date startDate, String company ) throws EntityExistsException, Exception;
    
    PageHandler findRecentTimesheets ( String loggedUser );
    
    List<TimesheetDetail> findTimesheetDetailsByStartDate ( String loggedUser, Date sDate);
    
    List<TimesheetStatus> findAllStatuses();
    
    PageHandler advanceSearch (String loggedUser, String userEmail, String timesheetStatu, Date startDate, Date endDate)  throws AccessDeniedException ;
    
    PageHandler advanceSearch (String loggedUser, String userEmail, String timesheetStatu)  throws AccessDeniedException ;
    
}
