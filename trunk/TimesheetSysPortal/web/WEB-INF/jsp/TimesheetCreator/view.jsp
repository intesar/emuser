<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%-- Uncomment below lines to add portlet taglibs to jsp --%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<span style="color:green">
    <c:out value="${success}" />
</span>

<span style="color:red">
    <c:out value="${error}" />
</span>

<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    <b> Start Date </b>
    <input type="text" name="startDate" value="MM/dd/yyyy" />
    <br>
    <b> Company </b>
    <input type="text" name="clientCompany" value="" />
    <br>
    <input class="portlet-form-button" type="reset" name="Refresh"> </input>   
    <input class="portlet-form-button" type="submit" value="Create"> </input>   
</form>