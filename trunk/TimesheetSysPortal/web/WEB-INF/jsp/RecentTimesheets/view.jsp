<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%-- Uncomment below lines to add portlet taglibs to jsp --%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 

<base href="http://www.bosrup.com/web/overlib/" />      
<script language="JavaScript" src="overlib.js"></script>
<div id="overDiv" style="position:absolute; visibility:hidden; z-index:1000;">          
</div>

<c:if test="${not empty recentTimesheets}" >
    <table width="90%" align="center" >
    <%-- Table Headings --%>   
    <tr>
        <th>
            Timesheet Date
        </th>
        <th>
            Status
        </th>
        <th>
            Days
        </th>
        
    </tr>
    
    <!-- Loop BEGIN -->
        
    <c:forEach items="${recentTimesheets}" var="list">       
        
        <%-- 
            displays timesheets
        --%>
        <c:set var="timesheetDateVar" value="${list.timesheetDate}"/>
        
        
        
        <portlet:actionURL var="actionURL">
            <portlet:param name="timesheetDate" value="<%= pageContext.getAttribute("timesheetDateVar").toString() %>" />                           
        </portlet:actionURL>
        
        <tr >
            <td>
                <a href="<%= actionURL %>"
                   onmouseover="return overlib('<c:out value="${list['createdBy']}" />');" 
                   onmouseout="return nd();">
                    <c:out value="${list.timesheetDate}" />                    
                </a>
            </td>
            <td>
                <a href="<%= actionURL %>" 
                    onmouseover="return overlib('<c:out value="${list.status.statusKey.assignedBy}" />, <c:out value="${list.status.statusKey.comments}" /> ');" 
                    onmouseout="return nd();">
                    <c:out value="${list.status.statusKey}" />
                </a>
            </td>                
            <td>
                <a href="<%= actionURL %>">
                    <c:out value="${list['daysFor']}" />
                </a>
            </td>                                        
            
        </tr>  
    </c:forEach>
    <!-- Loop END -->    
</table>
    
</c:if>

<c:if test="${not empty recentTimesheets}" >
    <span style="color:red">
        No Timesheets Created
    </span>
</c:if>



