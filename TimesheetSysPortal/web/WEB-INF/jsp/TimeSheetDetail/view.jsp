<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.abbt.timesheet.entities.TimeheetDetail"%>
<%@page import="com.abbt.timesheet.portlets.TimeSheetDetail"%>
<portlet:defineObjects />

Testing
<c:if test="${not empty detailList}">
    <form name="<%TimeSheetDetail.formSubmit%>" method=post action="<portlet:actionURL/>">
<table width="100%">
    <tr>
        <th>TimeSheetDate</th>
        <th>RegularHours</th>
        <th>OverTimeHours</th> 
        <th>Comments</th>
    </tr>
    
    <c:forEach items="${detailList}" var="list">
        
    <tr>
        <td><c:out value="${list.timesheetDetailDate}"/></td>
        <td><c:out value="${list.regularHours}"/></td>
        <td><c:out value="${list.overTimeHours}"/></td>
        <td><c:out value="${list.comments}"/></td>
        
    </tr>
        
    </c:forEach>
    
       </table>
    </form>    
</c:if>
