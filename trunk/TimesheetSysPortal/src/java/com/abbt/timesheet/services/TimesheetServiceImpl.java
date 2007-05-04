/*
 * TimesheetServiceImpl.java
 *
 * Created on May 3, 2007, 10:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import com.abbt.timesheet.daos.TimesheetDBDao;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.exceptions.EntityExistsException;

/**
 *
 * @author shannan
 */
public class TimesheetServiceImpl implements TimesheetService {
    
    /**
     * Creates a new instance of TimesheetServiceImpl
     */
    public TimesheetServiceImpl() {
    }
    
    public void save( Timesheet timesheet ) throws EntityExistsException {
        
        this.getTimesheetDBDao().save(timesheet);
        
    }
    
    public TimesheetDBDao getTimesheetDBDao() {
        return timesheetDBDao;
    }
    
    public void setTimesheetDBDao(TimesheetDBDao timesheetDBDao) {
        this.timesheetDBDao = timesheetDBDao;
    }
    
    private TimesheetDBDao timesheetDBDao;
}
