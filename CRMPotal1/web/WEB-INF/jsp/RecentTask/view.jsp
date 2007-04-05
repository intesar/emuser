<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<table width="90%" align="center" >
    <%-- Table Headings --%>   
    <tr>
        <th>
            Assigned By
        </th>
        <th>
            Description
        </th>
        <th>
            Status
        </th>                
    </tr>
    
    <!-- Recent Accounts Loop BEGIN -->
        
    <c:forEach items="${recentTask}" var="task">
        
        
        
        <%-- Store the JSTL account's ID and selected page number
                 in the page context so that we can use it as a portlet
                 parameter. The portlet tag doesn't evaluate JSTL, so we must
                 use a scriptlet to include the value.
            --%>
        <c:set var="taskID" value="${task['id']}"/>
        
        
        <portlet:actionURL var="actionURL">
            <portlet:param name="taskId" value="<%= pageContext.getAttribute("taskID").toString() %>" />                
        </portlet:actionURL>
        
        <tr >
            <td>
                <a href="<%= actionURL %>">
                    <c:out value="${task['assignedBy']}" />
                </a>
            </td>
            <td>
                <a href="<%= actionURL %>">
                    <c:out value="${task['description']}" />
                </a>
            </td>                
            <td>
                <a href="<%= actionURL %>">
                    <c:out value="${task['status']}" />
                </a>
            </td>                        
        </tr>          
    </c:forEach>
    <!-- Recent Accounts Loop END -->

</table>

<!-- Recent Accounts Results END -->

