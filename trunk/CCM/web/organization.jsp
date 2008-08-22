<%-- 
    Document   : organization
    Created on : Jul 7, 2008, 5:44:10 AM
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
        <style type="text/css">
            @import "dojo/dijit/themes/tundra/tundra.css";
            @import "dojo/dojo/resources/dojo.css"
        </style>
        <script type="text/javascript" src="dojo/dojo/dojo.js" 
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
        </script>
        <script type="text/javascript">
           
           
            var org;
            function fillTable() {
                dwr.util.useLoadingMessage();
                AjaxAdminService.getOrganization(function(people) {
                    org = people;
                    dwr.util.setValues(people);
                });
            }
        
        
            function writePerson() {
                
                dwr.util.getValues(org);
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveOrganization(org);
                fillTable();
                //dwr.engine.endBatch();
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
        <table class="plain" align="center">
            <tr>
                <td>Organization:</td>
                <td><input id="name" type="text" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Active:</td>
                <td><input id="enabled" type="text" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><input type="text" id="street" size="30"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" id="city" size="30"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" id="state" size="30"/></td>
            </tr>
            <tr>
                <td>Zipcode:</td>
                <td><input type="text" id="zipcode" size="30"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" id="country" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Person</td>
                <td><input type="text" id="contactName" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Phone</td>
                <td><input type="text" id="phone" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Email</td>
                <td><input type="text" id="contactEmail" size="30"/></td>
            </tr>
            <tr>
                <td>License</td>
                <td><input type="text" id="licenceKey" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Expiration Date</td>
                <td><input type="text" id="expirationDate" size="30" disabled="disabled" /></td>
            </tr>
            
            
            
            <tr>
                <td colspan="2" align="right">                    
                    <input type="button" value="Save" onclick="writePerson()"/>                    
                </td>
            </tr>
        </table>
        
        <table witdth="80%" align="center">
            <tr>
                
                <td width="20%" align="center"><marquee > Your CyberCafe details </marquee></td>
                <td width="80%" align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                
            </tr>
        </table>
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        
        <br>
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
