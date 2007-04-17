package com.abbt.training.portlets;
import com.abbt.training.services.ICourseService;
import com.abbt.training.services.ServiceFactory;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
* This is a Courses
*/
public class Courses extends GenericPortlet {

    public void init(PortletConfig config) throws PortletException {
        super.init(config);
    }

     public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        String cName = request.getParameter("cName");
        String iName = request.getParameter("iName");
        
        request.getPortletSession().setAttribute("courseName", cName, 1);
        request.getPortletSession().setAttribute("instructorName", iName, 1);
    }
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        ICourseService iCourseService = (ICourseService) ServiceFactory.getInstance()
            .getService("ICourseService");
        List list = iCourseService.getAllCourses();
        request.setAttribute("courseList", list);
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course/view.jsp");
        dispatcher.include(request, response);

    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course/help.jsp");
        dispatcher.include(request, response);
    }

}


