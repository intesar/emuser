package com.abbt.timesheet.portlets;
import java.util.ArrayList;
import java.util.Date;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequestDispatcher;
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
import com.abbt.timesheet.entities.TimesheetDetail;

public class TimeSheetDetail extends GenericPortlet {

    
    public static  String detailList = "list";
    public static  String formSubmit ="SUBMIT";
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        
        if(request.getParameter(formSubmit)!=null)
            
        {
            request.getParameter("");
        }

    }
    

    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
          ArrayList list = new ArrayList();
          
          TimesheetDetail detail1 =  new TimesheetDetail();
           
           TimesheetDetail detail2 = new TimesheetDetail();
          
          TimesheetDetail detail3 = new TimesheetDetail();
          System.out.println("Reaching here");
          detail1.setTimesheetDate(new Date());
          detail1.setOverTimeHours(10.0);
          detail1.setComments("Hello");
          detail2.setRegularHours(10.11);
          detail2.setTimesheetDate(new Date());
          detail2.setOverTimeHours(10.0);
          detail2.setComments("Hello");
          detail3.setRegularHours(10.11);
          detail3.setTimesheetDate(new Date());
          detail3.setOverTimeHours(10.0);
          detail3.setComments("Hello");
          detail3.setRegularHours(10.11);
          
          list.add(detail1);
          list.add(detail2);
          list.add(detail3);
           System.out.println("Reaching here");
          request.setAttribute(detailList,list);
          
             System.out.println("Reaching here2");
            //Uncomment below lines to see the output
            //response.setContentType("text/html");
            //PrintWriter writer = response.getWriter(); 
            //writer.println("View Mode");
          PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher("/WEB-INF/jsp/TimeSheetDetail/view.jsp");
            rd.include(request,response);
           // System.out.println("Reaching here2");
    }

    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
    
            //Uncomment below lines to see the output
            //response.setContentType("text/html");
            //PrintWriter writer = response.getWriter(); 
            //writer.println("Edit Mode");

    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {

            //Uncomment below lines to see the output
            //response.setContentType("text/html");
            //PrintWriter writer = response.getWriter(); 
            //writer.println("Help Mode");
        
        

    }

}
