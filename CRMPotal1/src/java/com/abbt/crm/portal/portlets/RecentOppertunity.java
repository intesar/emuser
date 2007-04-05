package com.abbt.crm.portal.portlets;
import com.abbt.crm.base.services.Oppertunity;
import com.abbt.crm.base.services.OppertunityImpl;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.WindowState;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.portlet.PortletRequestDispatcher;

public class RecentOppertunity extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
          
            try{           
        response.setContentType("text/html");        
        Oppertunity oppertunity = new OppertunityImpl();
        java.util.List list = oppertunity.findRecentOppertunity();
        
        System.out.println(request.getRemoteUser() + "  " + list );
        if ( list == null ) {
            list = new ArrayList();
        }
        
        request.setAttribute("RecentOppertunity", list);
        PortletRequestDispatcher dispatcher =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentOppertunity/RecentOppertunity.jsp");
        dispatcher.include(request, response);
         }catch(Exception e){e.printStackTrace();}


    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
    
            response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentOppertunity/edit.jsp");
        dispatcher.include(request, response);

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {

            response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentOppertunity/help.jsp");
        dispatcher.include(request, response);
    }

}


