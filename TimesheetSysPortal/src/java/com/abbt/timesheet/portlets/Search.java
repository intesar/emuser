package com.abbt.timesheet.portlets;
import com.abbt.timesheet.entities.TimesheetStatus;
import com.abbt.timesheet.entities.User;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import com.abbt.timesheet.services.UserService;
import com.abbt.timesheet.util.DateUtil;
import com.abbt.timesheet.util.Month;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;
import javax.portlet.PortletRequestDispatcher;

public class Search extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        String user = request.getParameter("user");
        String status = request.getParameter("status");
        String month = request.getParameter("month");
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        // find all users
        UserService userService = (UserService) ServiceFactory.getService("UserService");
        List<User> userList = userService.findAllUserEmails();
        User u = new User("All");
        userList.add(0, u);
        request.setAttribute("userList", userList);
        
        // find all Statuses
        TimesheetService timesheetService = (TimesheetService) ServiceFactory.getService("TimesheetService");
        List<TimesheetStatus> statusList = timesheetService.findAllStatuses();
        TimesheetStatus ts = new TimesheetStatus();
        ts.setStatusKey("All");
        statusList.add(0, ts);
        request.setAttribute("statusList", statusList);
        
        // find all Months
        List<Month> monthList = DateUtil.findAllMonths();
        Month m = new Month();
        m.setName("All");
        monthList.add(0, m);
        request.setAttribute("monthList", monthList);
        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Search/view.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Search/edit.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Search/help.jsp");
        dispatcher.include(request, response);
        
    }
    
}


