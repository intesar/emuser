package com.abbt.crm.portal.portlets;
import com.abbt.crm.base.services.TaskService;
import com.abbt.crm.base.services.TaskServiceImpl;
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
* This is a RecentTasks
*/
public class RecentTasks extends GenericPortlet {

    public void init(PortletConfig config) throws PortletException {
        super.init(config);
    }

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        TaskService ts = new TaskServiceImpl();
        List list = ts.findRecentEmployeeTask(request.getRemoteUser());
        System.out.println(request.getRemoteUser() + "  " + list );
        if ( list == null ) {
            list = new ArrayList();
        }
        
        request.setAttribute("recentAccount", list);
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/view.jsp");
        dispatcher.include(request, response);

    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/help.jsp");
        dispatcher.include(request, response);
    }

}


