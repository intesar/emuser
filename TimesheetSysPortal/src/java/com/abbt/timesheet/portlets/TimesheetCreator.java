package com.abbt.timesheet.portlets;
import com.abbt.timesheet.exceptions.EntityExistsException;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import com.abbt.timesheet.util.DateUtil;


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
        String loggedUser = request.getRemoteUser();
        // Add your date format here.
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println( " Logged User " + loggedUser );
        System.out.println( " Start Date :" + startDate );
        try {
            
            Date utilDate = new Date( sdf.parse(startDate).getTime() );
            DateUtil.isDateStartsWith1or16( utilDate );
            System.out.println( " validated :" + startDate );
            // get service and save timesheet object
            TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");            
            timesheetService.createTimesheetAndTimesheetDetails(loggedUser, utilDate, clientCompany);
            System.out.println( " Saved Successfully :" + startDate );
            response.setRenderParameter("success", " Save Successful");
            
        } catch (ParseException ex) {            
            ex.printStackTrace();    
            response.setRenderParameter("error", " Invalid Date, Day should be 1 or 16");
        } catch (EntityExistsException ex) {
            ex.printStackTrace();
            response.setRenderParameter("error", " Timesheet Already Exists");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setRenderParameter("error", " Error Please Try again!");
        }
        
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        // setting confirmation or error msg
        request.setAttribute("success", request.getParameter("success"));
        request.setAttribute("error", request.getParameter("error"));
        
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


