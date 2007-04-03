<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Uncomment below lines to add portlet taglibs to jsp
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 
--%>

<b>No. of recent task </b>

<%
java.util.List list = (java.util.List) request.getAttribute("recentTask");
try {
    System.out.println( "Size : " + list.size() );
} catch ( Exception e) {
    e.printStackTrace();
}
%>