/*
 * TimesheetService.java
 *
 * Created on May 3, 2007, 11:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.exceptions.EntityExistsException;
import java.util.Date;

/**
 *
 * @author shannan
 */
public interface TimesheetService {
    
    void save(Timesheet timesheet) throws EntityExistsException;
    
    void createTimesheetAndTimesheetDetails( String loggedUser, Date startDate, String company ) throws EntityExistsException, Exception;
    
}
