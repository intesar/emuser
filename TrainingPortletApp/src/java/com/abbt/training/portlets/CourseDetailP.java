package com.abbt.training.portlets;
import com.abbt.training.persistence.CourseDetail;
import com.abbt.training.services.ICourseService;
import com.abbt.training.services.ServiceFactory;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;
import javax.portlet.PortletRequestDispatcher;

public class CourseDetailP extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
          
        List<CourseDetail> list = null;
        ICourseService iCourseService = (ICourseService) ServiceFactory.getInstance()
            .getService("ICourseService");
        String courseName = (String) request.getPortletSession().getAttribute("courseName", 1);
        System.out.println("... " + courseName);
        try { 
            list = iCourseService.findByCourseName(courseName);
            System.out.println("size.." + list.size());
        } catch (Exception e){e.printStackTrace();}
        request.setAttribute("courseDetailList", list);
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course_detail/view.jsp");
        dispatcher.include(request, response);


    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course_detail/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/course_detail/help.jsp");
        dispatcher.include(request, response);
    }

}


