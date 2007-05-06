<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="java.util.*"%>


<portlet:defineObjects />

<c:if test="${not empty detailList}">
    <form  method=post action="<portlet:actionURL/>">
<table width="100%">
    <tr>
        <th>TimeSheetDate</th>
        <th>RegularHours</th>
        <th>OverTimeHours</th> 
        <th>Comments</th>
    </tr>
    
    <c:forEach items="${detailList}" var="list">
        
    <tr>
        <td><input type="text" name="date_<c:out value="${list.id}"/>"       value="<c:out value="<%=new Date()%>"/>" /></td>
        <td><input type="text" name="regHours_<c:out value="${list.id}"/>"   value="<c:out value="${list.regularHours}"/>" /> </td>
        <td><input type="text" name="overTime_<c:out value="${list.id}"/>"   value="<c:out value="${list.overTimeHours}"/>" /></td>
        <td><input type="text" name="comment_<c:out value="${list.id}"/>"    value="<c:out  value="${list.comments}"/>" /> </td>
        
    </tr>
        
    </c:forEach>
     
               <input  type="submit" name="formSubmit" value="Submit"/>
          
       </table>
    </form>    
</c:if>
