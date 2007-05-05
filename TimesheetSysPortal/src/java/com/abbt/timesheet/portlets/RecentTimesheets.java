package com.abbt.timesheet.portlets;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This is a RecentTimesheets
*/
public class RecentTimesheets extends GenericPortlet {

    public void init(PortletConfig config) throws PortletException {
        super.init(config);
    }

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");      
        // get service and save timesheet object
        TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");            
        List<Timesheet> list = new ArrayList<Timesheet>();
        try {
            list = timesheetService.findRecentTimesheets(request.getRemoteUser());
        } catch ( Exception e) {
            e.printStackTrace();
        }
        
        System.out.println ( " List : " + list );
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


