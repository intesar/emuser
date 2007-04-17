package com.abbt.training.portlets;
import com.abbt.training.persistence.ContactedUs;
import com.abbt.training.services.IContactedUsService;
import com.abbt.training.services.ServiceFactory;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.sql.Date;
import javax.portlet.PortletRequestDispatcher;

public class ContactedUsP extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String comments = request.getParameter("comments");
        ContactedUs contactedUs = new ContactedUs();
        contactedUs.setFirstname(fName);
        contactedUs.setLastname(lName);
        contactedUs.setPhone(phone);
        contactedUs.setEmail(email);
        contactedUs.setSummary(comments);
        contactedUs.setLocation(location);
        Date dt = new Date( new java.util.Date().getTime());
        contactedUs.setContactedDate(dt);
        IContactedUsService iContactedUsService =  (IContactedUsService) ServiceFactory.getInstance().getService("IContactedUsService");
        try {
            iContactedUsService.save(contactedUs);
            response.setRenderParameter("successMsg", "Thanks, We will get back to you as soon as possible");
        } catch (Exception ex) {
            response.setRenderParameter("errorMsg", "We have a problem taking your request please check your input");
            ex.printStackTrace();
        }
    }
    

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        String successMsg = (String) request.getParameter("successMsg");
        String errorMsg = (String) request.getParameter("errorMsg");
        
        request.setAttribute("successMsg", successMsg);
        request.setAttribute("errorMsg", errorMsg);

        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/contacted_us/view.jsp");
        dispatcher.include(request, response);

    }

     public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/contacted_us/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/contacted_us/help.jsp");
        dispatcher.include(request, response);
    }

}


