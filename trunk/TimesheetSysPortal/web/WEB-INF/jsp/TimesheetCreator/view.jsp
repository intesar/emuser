<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Uncomment below lines to add portlet taglibs to jsp
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 
--%>

<form>
    <b> Start Date </b>
    <input type="text" name="startDate" value="<%= new java.util.Date () %>"> </input>
    <input type="button" name="Create"> </input>    
</form>