package com.abbt.timesheet.portlets;
import abbt.com.paginationframework.PageHandler;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.services.ServiceFactory;
import com.abbt.timesheet.services.TimesheetService;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequestDispatcher;

public class SearchResult extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        
        String isPageNoClicked = request.getParameter("isPageNoClicked");
        if (isPageNoClicked instanceof String  ) {
            PageHandler pageHandler = (PageHandler)request.getPortletSession().getAttribute("pageHandler",1);
            String page = request.getParameter("pageNo");
            int pageNo = 0;
            try {
                pageNo = Integer.parseInt(page);
            } catch ( Exception e) {
                //e.printStackTrace();;
            }
            if ( pageHandler instanceof PageHandler ) {
                //pageHandler.createList(pageNo);
                pageHandler.setCurrentPageNo(pageNo);
            }
        }
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        
        List list = new ArrayList();
        List pageNoList = new ArrayList();
        PageHandler pageHandler = (PageHandler)request.getPortletSession().getAttribute("pageHandler", 1);
        
        if ( pageHandler instanceof PageHandler ) {
            pageHandler.createList(pageHandler.getCurrentPageNo());
            list = pageHandler.getCurrentResultList();
            pageNoList = pageHandler.getCurrentPageNoList();
        }
        
        request.setAttribute("recentTimesheets", list);
        request.setAttribute("pageNoList", pageNoList);
        request.setAttribute("selectedPageNo", pageHandler.getCurrentPageNo());
        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/SearchResult/view.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/SearchResult/edit.jsp");
        dispatcher.include(request, response);        
        
    }
    
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/SearchResult/edit.jsp");
        dispatcher.include(request, response);        
        
    }
    
}


