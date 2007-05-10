package com.abbt.timesheet.portlets;
import abbt.com.paginationframework.PageHandler;
import com.abbt.timesheet.entities.Company;
import com.abbt.timesheet.services.CompanyService;
import com.abbt.timesheet.services.ServiceFactory;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;
import javax.portlet.PortletRequestDispatcher;

public class CompanySearch extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException,IOException {
        
        String key = request.getParameter("key");
        String pageNo = request.getParameter("pageNo");
        String name = request.getParameter("companyName");
        PageHandler companyPageHandler = null;
        Company company = null;
        
        if ( key != null && key.length() > 0 ) {
            
            CompanyService companyService = (CompanyService) ServiceFactory.getService("CompanyService");
            companyPageHandler = companyService.search(key);
            companyPageHandler.createList(1);
            
        } else if ( pageNo != null && pageNo.length() > 0 ) {
            
            int page = Integer.parseInt(pageNo);
            companyPageHandler = (PageHandler) request.getPortletSession().getAttribute("companyPageHandler", 1);
            companyPageHandler.createList(page);
            
        } else if ( name != null && name.length() > 0 ) {
            
            CompanyService companyService = (CompanyService) ServiceFactory.getService("CompanyService");
            company = companyService.findByName(name);            
        }
        
        request.getPortletSession().setAttribute("companyPageHandler", companyPageHandler, 1);
        request.getPortletSession().setAttribute("company", company, 1);
    }
    
    
    public void doView(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        // find if any errors
        String error = request.getParameter("error");
        request.setAttribute("error", error);
        
        // find recent companies
        CompanyService companyService = (CompanyService) ServiceFactory.getService("CompanyService");
        PageHandler companyPageHandler = companyService.findRecent();
        companyPageHandler.createList(1);
        List recentCompanies = companyPageHandler.getCurrentResultList();
        request.setAttribute("recentCompanies", recentCompanies);
        
        PageHandler pg = (PageHandler) request.getPortletSession().getAttribute("companyPageHandler");
        if ( pg != null) {
            List searchCompanies = companyPageHandler.getCurrentResultList();
            List pageNoList = companyPageHandler.getCurrentPageNoList();
            request.setAttribute("searchCompanies", searchCompanies);
            request.setAttribute("pageNoList", pageNoList);
        }
        
        
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Search/view.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doEdit(RenderRequest request,RenderResponse response) throws PortletException,IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/CompanySearch/edit.jsp");
        dispatcher.include(request, response);
        
    }
    
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException,IOException {
        
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/CompanySearch/help.jsp");
        dispatcher.include(request, response);
        
    }
    
    
}


