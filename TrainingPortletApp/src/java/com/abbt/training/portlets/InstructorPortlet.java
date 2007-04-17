package com.abbt.training.portlets;
import com.abbt.training.persistence.Instructor;
import com.abbt.training.services.IInstructorService;
import com.abbt.training.services.ServiceFactory;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import javax.portlet.PortletRequestDispatcher;

public class InstructorPortlet extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
          
        Instructor instructor = null;
        IInstructorService iInstructorService = (IInstructorService) ServiceFactory.getInstance()
            .getService("IInstructorService");
        String email = (String) request.getPortletSession().getAttribute("instructorName" , 1);
        System.out.println(email);
        try {
            instructor = iInstructorService.findByEmail(email);
        } catch (Exception e){}
        
        request.setAttribute("instructor", instructor);
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/instructor/view.jsp");
        dispatcher.include(request, response);


    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/instructor/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/instructor/help.jsp");
        dispatcher.include(request, response);
    }

}


