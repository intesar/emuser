package com.abbt.timesheet.portlets;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import java.text.ParseException;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * This is a RecentTimesheets
 */
public class RecentTimesheets extends GenericPortlet {
    
    public void init(PortletConfig config) throws PortletException {
        super.init(config);
    }
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        String dt = request.getParameter("timesheetDate");
        System.out.println( "date : " + dt);
        String user = request.getRemoteUser();
        Date date = new Date();
        // convert to util.Date
        // call TimesheetService to fetch all timesheetDetails for this startDate
        // get service and save timesheet object
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = new Date( sdf.parse(dt).getTime() );
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");
        List list = timesheetService.findTimesheetDetailsByStartDate(user, date);
        request.getPortletSession().setAttribute("timesheetDetailList", list, 1);
    }
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");
        // get service and save timesheet object
        TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");
        List<Timesheet> list = new ArrayList<Timesheet>();
        System.out.println( "Inside DoView..");
        try {
            list = timesheetService.findRecentTimesheets(request.getRemoteUser());
        } catch ( Exception e) {
            e.printStackTrace();
        }
        
        System.out.println( " List : " + list );
        request.setAttribute("recentTimesheets", list);
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentTimesheets/view.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentTimesheets/edit.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
            getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentTimesheets/help.jsp");
        dispatcher.include(request, response);
    }
    
}


