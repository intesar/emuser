package com.abbt.timesheet.portlets.timesheetCreator;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.entities.TimesheetDetail;
import com.abbt.timesheet.entities.User;
import com.abbt.timesheet.exceptions.EntityExistsException;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.portlet.PortletRequestDispatcher;

public class TimesheetCreator extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        
        String startDate = request.getParameter("startDate");
        String clientCompany = request.getParameter("clientCompany");
        // Add your date format here.
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date sqlDate = null;
        Calendar timesheetDate = Calendar.getInstance();
        try {
            Date utilDate = new Date( sdf.parse(startDate).getTime() );
            DateValidator.validate( utilDate );
            timesheetDate.setTime(utilDate);
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            response.setRenderParameter("error", " Invalid Date, Day should be 1 or 16");
            ex.printStackTrace();
        }
        
        // create timesheet
        if ( sqlDate instanceof java.sql.Date ) {
            
            Timesheet timesheet = new Timesheet();
            //UserCompany userCompany = new UserCompany();
            //userCompany.setCompanyName(clientCompany);
            //timesheet.setClientCompany(userCompany);
            timesheet.setCreatedBy(request.getRemoteUser());
            java.sql.Date todaysDate = new java.sql.Date( new Date().getTime() );
            timesheet.setCreatedDate(todaysDate);
            timesheet.setDaysFor(15);
            timesheet.setLastUpdatedBy(request.getRemoteUser());
            timesheet.setLastUpdatedDate(todaysDate);
            timesheet.setTimesheetDate(sqlDate);
            User user = new User();
            user.setEmail(request.getRemoteUser());
            timesheet.setUserEmail(user);
            Collection<TimesheetDetail> timesheetDetailCollection = new ArrayList<TimesheetDetail>();
            
            // creating timesheet details objects
            int startIndex = 1;
            int max = 15;
            if ( timesheetDate.get(Calendar.DAY_OF_MONTH) == 16 ) {
                startIndex = 16;
                max = timesheetDate.getMaximum(Calendar.DAY_OF_MONTH);
            }
            for ( int i = startIndex; i <= max; i++ ) {
                TimesheetDetail timesheetDetail = new TimesheetDetail();
                timesheetDetail.setComments("");
                timesheetDetail.setCreatedBy(request.getRemoteUser());
                timesheetDetail.setCreatedDate(todaysDate);
                timesheetDetail.setDay("");
                timesheetDetail.setEnabled(true);
                timesheetDetail.setLastUpdatedBy(request.getRemoteUser());
                timesheetDetail.setLastUpdatedDate(todaysDate);
                timesheetDate.add(Calendar.DAY_OF_MONTH, 1);
                java.sql.Date dt = new java.sql.Date(timesheetDate.getTimeInMillis());
                timesheetDetail.setTimesheetDetailDate(dt);
                if ( timesheetDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    timesheetDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                    timesheetDetail.setRegularHours(0.0);
                } else {
                    timesheetDetail.setRegularHours(8.0);
                }    
                
                // logic goes here for entering some no.
                timesheetDetail.setOverTimeHours(0.0);                
                timesheetDetail.setTimesheetDate(sqlDate);                
                timesheetDetail.setTimesheetUser(request.getRemoteUser());
                // add to collection
                timesheetDetailCollection.add(timesheetDetail);
            }
            
            timesheet.setTimesheetDetailCollection(timesheetDetailCollection);
            // get service and save timesheet object
            TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");
            response.setRenderParameter("success", " Save Successful");
            try {
                timesheetService.save(timesheet);
            } catch (EntityExistsException ex) {
                response.setRenderParameter("error", " Timesheet Already Exists ");
                ex.printStackTrace();
            } catch ( IllegalArgumentException iae) {
                response.setRenderParameter("error", " Invalid Data");
                iae.printStackTrace();
            } catch ( Exception e) {
                response.setRenderParameter("error", " Error Saving Timesheet");
                e.printStackTrace();
            }
        }
        
        
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/TimesheetCreator/view.jsp");
        dispatcher.include(request, response);
    }
    
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/TimesheetCreator/edit.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/TimesheetCreator/help.jsp");
        dispatcher.include(request, response);
        
    }
    
}


