<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ page import="java.util.*"%>
<%@ page import="com.abbt.timesheet.entities.TimeheetDetail"%>
<%@page import="com.abbt.timesheet.portlets.TimeSheetDetail"%>
<portlet:defineObjects />


Time sheet detail


<%  System.out.println("reaching in jSP1");%>
<%!

Date detailDate ="";
String regularHours = "";
String overTimeHours = "";
String comments="";


%>
 <%  System.out.println("reaching in jSP1");%>
  <% if(request.getAttribute(TimeSheetDetail.detailList)!=null) {
    System.out.println("reaching in jSP0");%>
<form name="detailForm" method="post" action="<portlet:actionURL/>">
    <table  border=0 width="100%" cellpadding="3" cellspacing="1">
  <%  System.out.println("reaching in jSP1");
    TimeSheetDetail detail = new Detail();
    ArrayList list = (ArrayList)request.getAttribute(TimeSheetDetail.detailList);
    for(int i =0;i<list.size();i++)
                            { 
                            detailDate = (TimesheetDetail)list.get(i).getTimeSheetDate();
                            regularHours = (TimesheetDetail)list.get(i).getRegularHours();
                            overTimeHours =(TimesheetDetail)list.get(i).getOverTimeHours();
                            comments = (TimesheetDetail)list.get(i).getComments();
                            System.out.println("reaching in jSP1");   
                            %>
                            
                           
        <tr>
            
        <td><input type="text" name="date" value="<%=detailDate%>"/>  </td>
        <td><input type="text" name="regHours"value="<%=regularHours%>"/> </td>
        <td><input type="text" name="overTime"value="<%=overTimeHours%>"/> </td>
        <td> <input type="text" name="comment" value="<%=comments%>" />  </td>
  
                
            
        </tr>
        <%
        }
        }%>
      
       
      <input class="portlet-form-button" name="<%=TimeSheetDetail.formSubmit%>"type="submit" value="Submit"/>      
        
        
        
    </table>
</form>     


 




