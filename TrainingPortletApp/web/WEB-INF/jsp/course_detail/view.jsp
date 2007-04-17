<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 

<c:if test="${not empty courseDetailList}" >
    
    <table width="90%" align="center" >
        <%-- Table Headings --%>   
        <tr>
            <th>
                Detail
            </th>
            <th>
                Duration
            </th>
            <th>
                Summary
            </th>
            
        </tr>
        
        <!-- Recent Accounts Loop BEGIN -->
        
        <c:forEach items="${courseDetailList}" var="list">
            
            
            
            <%-- Store the JSTL account's ID and selected page number
                 in the page context so that we can use it as a portlet
                 parameter. The portlet tag doesn't evaluate JSTL, so we must
                 use a scriptlet to include the value.
            --%>
        
        
            <tr >
                <td>
                    <c:out value="${list['detail']}" />                
                </td>
                <td>
                    <c:out value="${list['duration']}" />                
                </td>                
                <td>
                    <c:out value="${list['summary']}" />
                </td>                        
            </tr>          
            
            
        </c:forEach>
        <!-- Recent Accounts Loop END -->
        
    </table>
    
    
    
</c:if>

<!-- Recent Accounts Results END -->

