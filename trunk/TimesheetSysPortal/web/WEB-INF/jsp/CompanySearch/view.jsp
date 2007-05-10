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

<form method="post" action="<portlet:actionURL></portlet:actionURL>" >
    <input type="hidden" name="generalSearch" value="true" />
    <input type="text" name="key" value="" />
    <input class="portlet-form-button" type="submit" value="Search"> </input>   
</form>

<c:if test="${not empty searchCompanies}" >
    <table width="90%" align="center" >
        <%-- Table Headings --%>   
        <tr>
            <th>
                Name
            </th>
            <th>
                City
            </th>       
        </tr>
        
        <!-- Loop BEGIN -->
        
        <c:forEach items="${searchCompanies}" var="list">       
            
            <%-- 
            displays timesheets
        --%>
            <c:set var="companyNameVar" value="${list.name}"/>
            
            
            
            <portlet:actionURL var="actionURL">
                <portlet:param name="companyName" value="<%= pageContext.getAttribute("companyNameVar").toString() %>" />                           
            </portlet:actionURL>
            
            <tr >
                <td>
                    <a href="<%= actionURL %>"
                       onmouseover="return overlib('<c:out value="${list['name']}" />');" 
                       onmouseout="return nd();">
                        <c:out value="${list.name}" />                    
                    </a>
                </td>
                <td>
                    <a href="<%= actionURL %>" 
                       onmouseover="return overlib('<c:out value="${list.billingAddress.city}" />, <c:out value="${list.billingAddress.city}" /> ');" 
                       onmouseout="return nd();">
                        <c:out value="${list.billingAddress.city}" />
                    </a>
                </td>                            
            </tr>  
        </c:forEach>
        <!-- Loop END -->    
    </table>
    
    <!-- Page Numbers BEGIN --> 
    <div style="text-align:center">
        
        <c:if test="${not empty pageNoList}"> 
            
            <%-- Loop through the [List] containing the current page numbers --%> 
            <c:forEach items="${pageNoList}" var="pageNumber">            
                
                <c:set var="pageNo" value="${pageNumber}" />
                
                <c:choose>
                    
                    <%-- Make the page number a hyperlink if it is not the currently viewed page --%>
                    <c:when test="${pageNumber ne selectedPageNo}"> 
                        
                        <portlet:actionURL var="pageURL">
                            <portlet:param name="isPageNoClicked" value='isPageNoClicked' /> 
                            <portlet:param name="pageNo" value='<%= pageContext.getAttribute("pageNo").toString() %>' /> 
                        </portlet:actionURL>
                        
                        <a href="<%= pageURL %>">
                            <c:out value="${pageNumber}" />
                        </a>
                        
                    </c:when>
                    <%-- Simply print the page number if it is the currently viewed page --%>
                    <c:otherwise>
                        
                        <c:out value="${pageNumber}" />
                        
                    </c:otherwise>
                </c:choose>
                
                &nbsp;
                
            </c:forEach>
            
            <%-- Allow the user to enter a page number --%>    
            <form style="display:inline" method="POST" action="<portlet:actionURL />"> 
                <input type="hidden" name="isPageNoClicked" value="isPageNoClicked" />
                <input type="text" name="pageNo" size="4" />
                <input class="portlet-form-button" type="submit" value="Go" /> 
            </form>
            
        </c:if>
        
    </div>
    <!-- Page Numbers END -->


    
</c:if>

<c:if test="${empty searchCompanies}" >
    
    <c:if test="${not empty recentCompanies}" >
        <table width="90%" align="center" >
            <%-- Table Headings --%>   
            <tr>
                <th>
                    Name
                </th>
                <th>
                    City
                </th>       
            </tr>
            
            <!-- Loop BEGIN -->
        
            <c:forEach items="${recentCompanies}" var="list">       
                
                <%-- 
            displays timesheets
        --%>
                <c:set var="companyNameVar" value="${list.name}"/>
                
                
                
                <portlet:actionURL var="actionURL">
                    <portlet:param name="companyName" value="<%= pageContext.getAttribute("companyNameVar").toString() %>" />                           
                </portlet:actionURL>
                
                <tr >
                    <td>
                        <a href="<%= actionURL %>"
                           onmouseover="return overlib('<c:out value="${list['name']}" />');" 
                           onmouseout="return nd();">
                            <c:out value="${list.name}" />                    
                        </a>
                    </td>
                    <td>
                        <a href="<%= actionURL %>" 
                           onmouseover="return overlib('<c:out value="${list.billingAddress.city}" />, <c:out value="${list.billingAddress.city}" /> ');" 
                           onmouseout="return nd();">
                            <c:out value="${list.billingAddress.city}" />
                        </a>
                    </td>                            
                </tr>  
            </c:forEach>
            <!-- Loop END -->    
        </table>       
    </c:if>
</c:if>

<c:if test="${not empty company}" >
    
    Name : <c:out value="${company.name}" /> <br>    
    Description :<c:out value="${company.description}" /><br>
    City : <c:out value="${company.billingAddress.city}" /><br>
    State :<c:out value="${company.billingAddress.state}" />   <br>
    Country :<c:out value="${company.billingAddress.country}" /><br>
    Phone :<c:out value="${company.phone1}" />
    
</c:if>




