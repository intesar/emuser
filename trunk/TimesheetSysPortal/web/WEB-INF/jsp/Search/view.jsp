<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%-- Uncomment below lines to add portlet taglibs to jsp --%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    <input type="hidden" name="generalSearch" value="true" />
    <input type="text" name="search" value="" />
    <input class="portlet-form-button" type="submit" value="Search"> </input>   
</form>

<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    
    <input type="hidden" name="advanceSearch" value="true" />
    
    <select name="user" size="3">
        <c:forEach items="${userList}" var="user">
            <option><c:out value="${user['email']}" /></option>
        </c:forEach>        
    </select>
    
    <select name="status" size="3">
        <c:forEach items="${statusList}" var="status">
            <option><c:out value="${status['statusKey']}" /></option>
        </c:forEach>     
    </select>
    
    <select name="month" size="3">
        <c:forEach items="${monthList}" var="montht">
            <option><c:out value="${month['name']}" /></option>
        </c:forEach>     
    </select>
    
    <input class="portlet-form-button" type="reset" name="Refresh"> </input>   
    <input class="portlet-form-button" type="submit" value="Search"> </input>   
    
</form>