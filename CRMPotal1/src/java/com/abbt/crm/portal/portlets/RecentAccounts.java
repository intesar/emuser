package com.abbt.crm.portal.portlets;
import com.abbt.crm.base.services.AccountService;
import com.abbt.crm.base.services.AccountServiceImpl;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RecentAccounts extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {

    }
    

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
          
         try{           
        response.setContentType("text/html");        
        AccountService As = new AccountServiceImpl();
        List list = As.findRecentEmployeeAccounts();
        
        System.out.println(request.getRemoteUser() + "  " + list );
        if ( list == null ) {
            list = new ArrayList();
        }
        
        request.setAttribute("RecentAccount", list);
        PortletRequestDispatcher dispatcher =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentAccountFolder/RecentAccount.jsp");
        dispatcher.include(request, response);
         }catch(Exception e){e.printStackTrace();}
    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
    
            //Uncomment below lines to see the output
            //response.setContentType("text/html");
            //PrintWriter writer = response.getWriter(); 
            //writer.println("Edit Mode");
        response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentAccountFolder/edit.jsp");
        dispatcher.include(request, response);


    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {

            response.setContentType("text/html");        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/RecentAccountFolder/help.jsp");
        dispatcher.include(request, response);

    }

}


