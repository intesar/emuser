package com.abbt.timesheet.portlets;
import abbt.com.paginationframework.PageHandler;
import com.abbt.timesheet.entities.TimesheetStatus;
import com.abbt.timesheet.entities.User;
import com.abbt.timesheet.exceptions.AccessDeniedException;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import com.abbt.timesheet.services.UserService;
import com.abbt.timesheet.util.DateUtil;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.portlet.PortletRequestDispatcher;

public class Search extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        String generalSearch = request.getParameter("generalSearch");
        String advanceSearch = request.getParameter("advanceSearch");
        String loggedUser = request.getRemoteUser();
        TimesheetService ts = (TimesheetService) ServiceFactory.getService("TimesheetService");
        PageHandler pageHandler = null;
        String error = null;
        
        if ( generalSearch != null && generalSearch.length() > 0 ) {
            String key = request.getParameter("key");
            try {
                pageHandler = ts.generalSearch(loggedUser, key );
            } catch (AccessDeniedException ex) {
                ex.printStackTrace();
                error = " Your not Assigned As an Admin";
            }
        } else  if ( advanceSearch != null && advanceSearch.length() > 0 ) {
            
            
            String user = request.getParameter("user");
            String status = request.getParameter("status");
            String sDate = request.getParameter("startDate");
            String eDate = request.getParameter("endDate");
            Date startDate = DateUtil.convert(sDate);
            Date endDate = DateUtil.convert(eDate);
            
            
            
            
            // if dates are valid
            if ( sDate != null && eDate != null ) {
                try {
                    pageHandler = ts.advanceSearch(loggedUser, user, status, startDate, endDate);
                } catch (AccessDeniedException ex) {
                    ex.printStackTrace();
                    error = " Your not Assigned As an Admin";
                }
            } else {
                try {
                    pageHandler = ts.advanceSearch(loggedUser, user, status);
                } catch (AccessDeniedException ex) {
                    ex.printStackTrace();
                    error = " Your not Assigned As an Admin";
                }
            }
            
            if ( error != null ) {
                response.setRenderParameter("error", error);
            } else if ( pageHandler != null ) {
                request.getPortletSession().setAttribute("searchPageHandler", pageHandler, 1);
            }
        }
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        // find if any errors
        String error = request.getParameter("error");
        request.setAttribute("error", error);
        
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


