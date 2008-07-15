<%-- 
    Document   : report
    Created on : Jul 7, 2008, 1:30:33 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        <script type="text/javascript" src="/CCM/datepickercontrol.js"></script>
        <link type="text/css" rel="stylesheet" href="/CCM/datepickercontrol.css"> 
        
        <script type="text/javascript">
            function execute() {
                //alert ( document.getElementById("startDate").value);
                AjaxAdminService.getReport(document.getElementById("DPC_startDate_YYYY-MM-DD").value,
                document.getElementById("DPC_endDate_YYYY-MM-DD").value, reply1 );
            }
            
            var reply1 = function(data) {
                alert (data);
            
            }
        </script>
        
    </head>
    <body>
        <br><br>
        <table width="85%"  height="30" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#EDDA74">
            <tr> 
                <td><a href="dashboard.jsp">&nbsp;&nbsp;Dashboard</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="users.jsp">Users</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="systems.jsp">Systems</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="emails.jsp">Emails</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="emailtimings.jsp">Email & SMS Timing</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>    
                <td><a href="organization.jsp">Organization</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="systemlease.jsp">History</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="report.jsp">Report</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="suggestions.jsp">Suggestions</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="j_acegi_logout">Logout &nbsp;&nbsp;</a></td> 
            </tr>
        </table>    
        
        
        <br/>
        <br/>
        <br/>
        
        <input type="hidden" id="DPC_TODAY_TEXT" value="today">
        <input type="hidden" id="DPC_BUTTON_TITLE" value="Open calendar...">
        <input type="hidden" id="DPC_MONTH_NAMES" value="['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']">
        <input type="hidden" id="DPC_DAY_NAMES" value="['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']">
        
        
        
        <input type="text" name="startDate" id="DPC_startDate_YYYY-MM-DD"> 
        
        <input type="text" name="endDate" id="DPC_endDate_YYYY-MM-DD"> 
        
        <input type="submit" value="Go" onclick="execute();"/>
        
    </body>
</html>
