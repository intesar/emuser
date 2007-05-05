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
import com.abbt.timesheet.entities.TimesheetDetail;
import com.abbt.timesheet.entities.TimesheetStatus;
import com.abbt.timesheet.entities.User;
import com.abbt.timesheet.exceptions.EntityExistsException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    
    public void createTimesheetAndTimesheetDetails( String loggedUser, Date startDate, String company ) throws EntityExistsException, Exception {
        Timesheet timesheet = new Timesheet();
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        //java.sql.Date sqlStartDates = new java.sql.Date(startDate.getTime());
        //UserCompany userCompany = new UserCompany();
        //userCompany.setCompanyName(clientCompany);
        //timesheet.setClientCompany(userCompany);
        timesheet.setCreatedBy(loggedUser);
        java.sql.Date todaysDate = new java.sql.Date( new Date().getTime() );
        timesheet.setCreatedDate(startDate);
        timesheet.setDaysFor(15);
        timesheet.setLastUpdatedBy(loggedUser);
        timesheet.setLastUpdatedDate(todaysDate);
        timesheet.setTimesheetDate(startDate);
        User user = new User();
        user.setEmail(loggedUser);
        timesheet.setUserEmail(user);
        TimesheetStatus timesheetStatus = new TimesheetStatus();
        timesheetStatus.setId(1);
        timesheet.setStatus(timesheetStatus);
        Collection<TimesheetDetail> timesheetDetailCollection = new ArrayList<TimesheetDetail>();
        
        // creating timesheet details objects
        int startIndex = 1;
        int max = 15;
        if ( calendarStartDate.get(Calendar.DAY_OF_MONTH) == 16 ) {
            startIndex = 16;
            max = calendarStartDate.getMaximum(Calendar.DAY_OF_MONTH);
        }
        for ( int i = startIndex; i <= max; i++ ) {
            System.out.println( " Timesheet Detail :" + i);
            TimesheetDetail timesheetDetail = new TimesheetDetail();
            timesheetDetail.setComments("");
            timesheetDetail.setCreatedBy(loggedUser);
            timesheetDetail.setCreatedDate(todaysDate);
            timesheetDetail.setDay("");
            timesheetDetail.setEnabled(true);
            timesheetDetail.setLastUpdatedBy(loggedUser);
            timesheetDetail.setLastUpdatedDate(todaysDate);
            calendarStartDate.add(Calendar.DAY_OF_MONTH, 1);
            java.sql.Date dt = new java.sql.Date(calendarStartDate.getTimeInMillis());
            timesheetDetail.setTimesheetDetailDate(dt);
            timesheetDetail.setDay(calendarStartDate.get(Calendar.DAY_OF_WEEK)+"");
            if ( calendarStartDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                calendarStartDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                timesheetDetail.setRegularHours(0.0);
            } else {
                timesheetDetail.setRegularHours(8.0);
            }
            
            // logic goes here for entering some no.
            timesheetDetail.setOverTimeHours(0.0);
            timesheetDetail.setTimesheetDate(startDate);
            timesheetDetail.setTimesheetUser(loggedUser);
            timesheetDetail.setTimesheetId(timesheet);
            // add to collection
            timesheetDetailCollection.add(timesheetDetail);
        }
        
        timesheet.setTimesheetDetailCollection(timesheetDetailCollection);
        
        try {
            this.getTimesheetDBDao().save(timesheet);
        } catch (EntityExistsException ex) {
            //response.setRenderParameter("error", " Timesheet Already Exists ");
            ex.printStackTrace();
            throw ex;
        } catch ( IllegalArgumentException iae) {
            //response.setRenderParameter("error", " Invalid Data");
            iae.printStackTrace();
            throw iae;
        } catch ( Exception e) {
            //response.setRenderParameter("error", " Error Saving Timesheet");
            e.printStackTrace();
            throw e;
        }
    }
    
    public List<Timesheet> findRecentTimesheets(String loggedUser) {
        List<Timesheet> list = this.getTimesheetDBDao().findResultListByNamedQuery("Timesheet.findByUserEmail", loggedUser);
        return list;
    }
    
    public TimesheetDBDao getTimesheetDBDao() {
        return timesheetDBDao;
    }
    
    public void setTimesheetDBDao(TimesheetDBDao timesheetDBDao) {
        this.timesheetDBDao = timesheetDBDao;
    }
    
    private TimesheetDBDao timesheetDBDao;
    
    public static void main(String []args) {
        String loggedUser = "mohdshannan@yahoo.com";
        Date startDate = new Date();
        String company = "UROOJ";
        TimesheetService instance = (TimesheetService) ServiceFactory.getService("TimesheetService");
//        try {
            List list = instance.findRecentTimesheets("liferay.com.1");
            System.out.println ( " List : " + list );
            //instance.createTimesheetAndTimesheetDetails(loggedUser, startDate, company);
//        } catch (EntityExistsException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
    }

    
    
}
