<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 
<base href="http://www.bosrup.com/web/overlib/" />      
<script language="JavaScript" src="overlib.js"></script>
<div id="overDiv" style="position:absolute; visibility:hidden; z-index:1000;">          
</div>

<table width="90%" align="center" >
    <%-- Table Headings --%>   
    <tr>
        <th>
            Course
        </th>
        <th>
            Instructor
        </th>
        <th>
            Duration
        </th>
        
    </tr>
    
    <!-- Loop BEGIN -->
        
    <c:forEach items="${courseList}" var="list">       
        
        <%-- Store the JSTL account's ID and selected page number
                 in the page context so that we can use it as a portlet
                 parameter. The portlet tag doesn't evaluate JSTL, so we must
                 use a scriptlet to include the value.
            --%>
        <c:set var="courseName" value="${list.courseName.name}"/>
        <c:set var="instructorName" value="${list.instructorEmail.email}"/>
        
        
        <portlet:actionURL var="actionURL">
            <portlet:param name="cName" value="<%= pageContext.getAttribute("courseName").toString() %>" />                
            <portlet:param name="iName" value="<%= pageContext.getAttribute("instructorName").toString() %>" />                
        </portlet:actionURL>
        
        <tr >
            <td>
                <a href="<%= actionURL %>"
                   onmouseover="return overlib('<c:out value="${list['summary']}" />');" 
                   onmouseout="return nd();">
                    <c:out value="${list.courseName.name}" />                    
                </a>
            </td>
            <td>
                <a href="<%= actionURL %>" 
                    onmouseover="return overlib('<c:out value="${list.instructorEmail.phone}" />, <c:out value="${list.instructorEmail.email}" /> ');" 
                    onmouseout="return nd();">
                    <c:out value="${list.instructorEmail.firstname}" />
                </a>
            </td>                
            <td>
                <a href="<%= actionURL %>">
                    <c:out value="${list['duration']}" />
                </a>
            </td>                                        
            
        </tr>  
    </c:forEach>
    <!-- Loop END -->    
</table>




