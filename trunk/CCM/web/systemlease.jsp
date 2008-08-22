<%-- 
    Document   : systemlease
    Created on : Jul 7, 2008, 5:44:17 AM
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
        <title>JSP Page</title>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <script type="text/javascript" src="/CCM/datepickercontrol.js"></script>
        <link type="text/css" rel="stylesheet" href="/CCM/datepickercontrol.css"> 
        
        <script type="text/javascript">
            function execute() {
                dwr.util.useLoadingMessage();
                //alert ( document.getElementById("startDate").value);
                AjaxAdminService.getSystemLease(document.getElementById("DPC_startDate_YYYY-MM-DD").value,
                document.getElementById("DPC_endDate_YYYY-MM-DD").value, reply1 );
            }
            
            
            var peopleCache = { };
            var viewed = null;
        
            var reply1 = function(people) {
                // Delete all the rows except for the "pattern" row
                dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                        return (tr.id != "pattern");
                    }});
                // Create a new set cloned from the pattern row
                var person, id;
                //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                for (var i = 0; i < people.length; i++) {
                    person = people[i];
                    id = person.id;
                    dwr.util.cloneNode("pattern", { idSuffix:id });
                    dwr.util.setValue("leaseHolderName" + id, person.leaseHolderName);
                    dwr.util.setValue("system" + id, person.system);
                    dwr.util.setValue("startTimeString" + id, person.startTimeString);
                    dwr.util.setValue("endTimeString" + id, person.endTimeString);
                    dwr.util.setValue("totalMinutesUsed" + id, person.totalMinutesUsed);
                    dwr.util.setValue("payableAmount" + id, person.payableAmount);
                    dwr.util.setValue("amountPaid" + id, person.amountPaid);
                    dwr.util.setValue("issueAgent" + id, person.issueAgent);
                    dwr.util.setValue("returnAgent" + id, person.returnAgent);
                    $("pattern" + id).style.display = "table-row";
                    peopleCache[id] = person;
                }
             
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
                <td><a href="customer.jsp">Customer</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="suggestions.jsp">Suggestions</a></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><a href="j_acegi_logout">Logout &nbsp;&nbsp;</a></td> 
            </tr>
        </table> 
        
        
        <br/>
        <br/>
        <br/>
        
        <table align="center">
            <tr>
                <td>
                    
                    <input type="hidden" id="DPC_TODAY_TEXT" value="today">
                    <input type="hidden" id="DPC_BUTTON_TITLE" value="Open calendar...">
                    <input type="hidden" id="DPC_MONTH_NAMES" value="['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']">
                    <input type="hidden" id="DPC_DAY_NAMES" value="['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']">
                    
                    
                    
                    <input type="text" name="startDate" id="DPC_startDate_YYYY-MM-DD"> 
                    
                    <input type="text" name="endDate" id="DPC_endDate_YYYY-MM-DD" > 
                    
                    <input type="submit" value="Go" onclick="execute();"/>
                </td>
            </tr>
        </table>
        
        <br>
        
        <table border="1" class="rowed grey" align="center">
            <thead>
                <tr>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; System &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Start Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; End Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Minutes Used &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Payable Amount &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Paid Amount &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Issue By &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Returned To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>                    
                </tr>
            </thead>
            <form>
                <tbody id="peoplebody">
                    <tr id="pattern" style="display:none;">
                        <td><span id="leaseHolderName">Username</span></td>
                        <td><span id="system">System</span></td>
                        <td><span id="startTimeString">Start Time</span></td>
                        <td><span id="endTimeString">End Time</span></td>
                        <td><span id="totalMinutesUsed">Total Minutes</span></td>
                        <td><span id="payableAmount">Payable Amount</span></td>
                        <td><span id="amountPaid">Paid Amount</span></td>
                        <td><span id="issueAgent">Issue By</span></td>
                        <td><span id="returnAgent">Returned To</span></td>
                                        
                    </tr>
                </tbody>
            </form>
        </table>
         <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>

        <p align="center">
            <font size="2"> &copy; Copyrights BizIntelApps 2008 All Rights Reserved. <a href="http://bizintelapps.net/"><font color="blue">BizIntelApps</font></a> </font>
        </p>
        
        
    </body>
</html>
