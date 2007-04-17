<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 

<span style="color:green">
    <c:out value="${successMsg}" />
</span>

<span style="color:red">
    <c:out value="${errorMsg}" />
</span>

<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    <table width="90%" align="center" >
        <%-- Table Headings --%>   
          
        
        
        <%-- Store the JSTL account's ID and selected page number
                 in the page context so that we can use it as a portlet
                 parameter. The portlet tag doesn't evaluate JSTL, so we must
                 use a scriptlet to include the value.
            --%>
        
        
        <tr >
            <td>
                First Name
            </td>
            <td>
                <input type="text" name="firstname">               
            </td>                                             
        </tr>          
        <tr >
            <td>
                Last Name
            </td>
            <td>
                <input type="text" name="lastname">               
            </td>                                             
        </tr>   
        <tr >
            <td>
                Email
            </td>
            <td>
                <input type="text" name="email">               
            </td>                                             
        </tr>   
        <tr >
            <td>
                Phone
            </td>
            <td>
                <input type="text" name="phone">               
            </td>                                             
        </tr>   
        <tr >
            <td>
                city
            </td>
            <td>
                <input name="location">               
            </td>                                             
        </tr> 
    </table>
    
    <TEXTAREA NAME="comments" COLS=60 ROWS=3></TEXTAREA>                         
    
    <br/>
    <input type="submit" name="Ok" value="Ok"/>
    
</form>