/*
 * TimesheetServiceImpl.java
 *
 * Created on May 3, 2007, 10:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;

import abbt.com.paginationframework.PageHandler;
import abbt.com.paginationframework.PageHandlerDao;
import abbt.com.paginationframework.PageHandlerFactory;
import com.abbt.timesheet.daos.TimesheetDBDao;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.entities.TimesheetDetail;
import com.abbt.timesheet.entities.TimesheetStatus;
import com.abbt.timesheet.entities.User;
import com.abbt.timesheet.exceptions.EntityExistsException;
import com.abbt.timesheet.util.DateUtil;
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
            timesheetDetail.setEnabled(true);
            timesheetDetail.setLastUpdatedBy(loggedUser);
            timesheetDetail.setLastUpdatedDate(todaysDate);
            calendarStartDate.add(Calendar.DAY_OF_MONTH, 1);
            java.sql.Date dt = new java.sql.Date(calendarStartDate.getTimeInMillis());
            timesheetDetail.setTimesheetDetailDate(dt);
            // finding day
            if ( calendarStartDate.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY )
                // finds day then finds String representation of day and assignes it
                timesheetDetail.setDay(DateUtil.getDay(calendarStartDate.get(Calendar.DAY_OF_WEEK)));
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
    
    public PageHandler findRecentTimesheets(String loggedUser) {
        
        return PageHandlerFactory.getInstance(this.getPageHandlerDao(), "Timesheet.findCountByUserEmail", "Timesheet.findByUserEmail", loggedUser);
        
    }
    
    public List<TimesheetDetail> findTimesheetDetailsByStartDate(String loggedUser, Date sDate) {
        List<TimesheetDetail> list = this.getTimesheetDBDao().findResultListByNamedQuery("TimesheetDetail.findByUserAndStartDate", loggedUser, sDate);
        return list;
    }
    
    public List<TimesheetStatus> findAllStatuses() {
        
        List<TimesheetStatus> list = this.getTimesheetDBDao().findResultListByNamedQuery("TimesheetStatus.findAllStatuses");
        if ( ! (list instanceof List) ) {
            list = new ArrayList<TimesheetStatus>();
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
    
    private TimesheetDBDao timesheetDBDao;
    
    private PageHandlerDao pageHandlerDao;
    
    
//    public static void main(String []args) {
//        String loggedUser = "mohdshannan@yahoo.com";
//        Date startDate = new Date();
//        String company = "UROOJ";
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.DAY_OF_MONTH, 1);
//        c.set(Calendar.MONTH, 1);
//        c.set(Calendar.YEAR, 2006);
//        //Date dt = new Date ()
//        TimesheetService instance = (TimesheetService) ServiceFactory.getService("TimesheetService");
//        List<TimesheetStatus> i = instance.findAllStatuses();
//        System.out.println ( i.get(0));
////        try {
//        List list = instance.findTimesheetDetailsByStartDate("liferay.com.1", c.getTime());//findRecentTimesheets("liferay.com.1");
//        System.out.println( " List : " + list.size() );
//        //instance.createTimesheetAndTimesheetDetails(loggedUser, startDate, company);
////        } catch (EntityExistsException ex) {
////            ex.printStackTrace();
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////
//        //Calendar c = Calendar.getInstance();
////        c.setTime(new Date());
////        String dtStr = "";
////        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
////
////        dtStr += c.get(Calendar.MONTH) + "/";
////        dtStr += c.get(Calendar.DAY_OF_MONTH) + "/";
////        dtStr += c.get(Calendar.YEAR);
////        System.out.println( c.get(Calendar.DAY_OF_MONTH));
////        System.out.println( c.get(Calendar.MONTH));
////        System.out.println( c.get(Calendar.YEAR));
////        System.out.println( dtStr );
////        try {
////            Date utilDate = new Date( sdf.parse(dtStr).getTime() );
////            System.out.println( utilDate );
////        } catch (ParseException ex) {
////            ex.printStackTrace();
////        }
//    }
//

   public static void main(String []args) {
       TimesheetService instance = (TimesheetService) ServiceFactory.getService("TimesheetService");
       PageHandler p = instance.findRecentTimesheets("liferay.com.1");
       System.out.println ( " P : " + p );
       p.createList(1);
       List<Timesheet> list = p.getCurrentResultList();
       for ( Timesheet t : list ) {
           System.out.println ( t.getUserEmail() );
           System.out.println ( t.getTimesheetDate() );
       }
       
   }
    
    
}
