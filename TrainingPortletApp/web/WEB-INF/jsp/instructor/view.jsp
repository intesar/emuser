<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<c:if test="${not empty instructor}" >
    First Name  <c:out value="${instructor.firstname}" />
    <br/>
    Last Name : <c:out value="${instructor.lastname}" />
    <br/>
    Email : <c:out value="${instructor.email}" />
    <br/> 
    Phone : <c:out value="${instructor.phone}" />
    <br/>
    Mobile : <c:out value="${instructor.mobile}" />
    <br/>
    Qualification : <c:out value="${instructor.qualification}" />
    <br/>
    Summary : <c:out value="${instructor.summary}" />
    
</c:if>                    
