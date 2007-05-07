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
    <input type="text" name="key" value="" />
    <input class="portlet-form-button" type="submit" value="Search"> </input>   
</form>

<br/>
<br/>

<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    
    <input type="hidden" name="advanceSearch" value="true" />
    <table border="0">
        
        <tr>
            <td> 
                <select name="user" >
                    <c:forEach items="${userList}" var="user">
                        <option><c:out value="${user['email']}" /></option>
                    </c:forEach>        
                </select>
            </td>
        </tr>
        
        
        <tr>
            <td>
                <select name="status" >
                    <c:forEach items="${statusList}" var="status">
                        <option><c:out value="${status['statusKey']}" /></option>
                    </c:forEach>     
                </select>
            </td>
        </tr>
        
        <tr>
            <td> 
                <input type="text" name="startDate" />
                <input type="text" name="endDate" />
            </td>
        </tr>
        
        <tr>
            <td>
                <input class="portlet-form-button" type="reset" name="Refresh"> </input>   
                <input class="portlet-form-button" type="submit" value="Search"> </input>
            </td>
        </tr>
        
        
    </table>  
    
    
</form>