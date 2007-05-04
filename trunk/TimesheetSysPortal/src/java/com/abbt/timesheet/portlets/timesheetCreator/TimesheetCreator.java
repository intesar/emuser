package com.abbt.timesheet.portlets.timesheetCreator;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.entities.TimesheetDetail;
import com.abbt.timesheet.entities.User;
import java.text.ParseException;
import java.util.Date;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.portlet.PortletRequestDispatcher;

public class TimesheetCreator extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        
        String startDate = request.getParameter("startDate");
        String clientCompany = request.getParameter("clientCompany");
        // Add your date format here.
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date sqlDate = null;
        try {
            Date utilDate = new Date( sdf.parse(startDate).getTime() );
            DateValidator.validate( utilDate );
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            response.setRenderParameter("error", " Invalid Date Please Enter date starts with 1 or 16");
            ex.printStackTrace();
        }
        
        // create timesheet
        if ( sqlDate instanceof java.sql.Date ) {
            
            Timesheet timesheet = new Timesheet();
            //timesheet.setClientCompany(clientCompany);
            timesheet.setCreatedBy(request.getRemoteUser());
            java.sql.Date todaysDate = new java.sql.Date ( new Date().getTime() );
            timesheet.setCreatedDate(todaysDate);
            timesheet.setDaysFor(15);
            timesheet.setLastUpdatedBy(request.getRemoteUser());
            timesheet.setLastUpdatedDate(todaysDate);
            timesheet.setTimesheetDate(sqlDate);
            User user = new User();
            //timesheet.setUserEmail(user);
            
            // creating timesheet details objects
            
            TimesheetDetail timesheetDetail = new TimesheetDetail();
            timesheetDetail.setComments("");
            timesheetDetail.setCreatedBy(request.getRemoteUser());
            timesheetDetail.setCreatedDate(todaysDate);
            timesheetDetail.setDay("");
            timesheetDetail.setEnabled(true);
            timesheetDetail.setLastUpdatedBy(request.getRemoteUser());
            timesheetDetail.setLastUpdatedDate(todaysDate);
            timesheetDetail.setOverTimeHours(0.0);
            // logic goes here for entering some no.
            
            timesheetDetail.setRegularHours(0.0);
            timesheetDetail.setTimesheetDate(sqlDate);
            timesheetDetail.setTimesheetDetailDate(sqlDate);//todo//)
            timesheetDetail.setTimesheetUser(request.getRemoteUser());
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


