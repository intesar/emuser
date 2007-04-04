<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Uncomment below lines to add portlet taglibs to jsp
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 
--%>




<%    
    try {
        
        java.util.List list = (java.util.List) request.getAttribute("recentTask");
        java.util.Iterator iter = list.iterator();
        while ( iter.hasNext() ) {
            com.abbt.crm.base.entity.Tasks task = (com.abbt.crm.base.entity.Tasks) iter.next();
            out.print(task.getAssignedBy() + "  ");
            out.println(task.getStatus()+" ");
            out.println(task.getDescription());
            
        }
        
    } catch ( Exception e) {
        e.printStackTrace();
    }
%>