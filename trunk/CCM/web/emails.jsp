<%-- 
    Document   : systems
    Created on : Jul 7, 2008, 5:43:08 AM
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
            function init() {
                fillTable();
            }
        
            var peopleCache = { };
            var viewed = null;
        
            function fillTable() {
                dwr.util.useLoadingMessage();
                AjaxAdminService.getAllEmailPreference(function(people) {
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
                        dwr.util.setValue("username1" + id, person.username);
                        dwr.util.setValue("email_or_phone" + id, person.emailOrPhone);
                        dwr.util.setValue("service_provider" + id, person.serviceProvider);                        
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
            }
        
            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var person = peopleCache[eleid.substring(4)];
                viewed = person.id;
                dwr.util.setValues(person);
            }
        
            
        
            function writePerson() {
                var person;
                if ( viewed == null ) {
                    person = { id:viewed, username:null, emailOrPhone:null, serviceProvider:null };
                } else {
                    person = peopleCache[viewed];
                }
                
                dwr.util.getValues(person);
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveEmailPreference(person);
                fillTable();
                //dwr.engine.endBatch();
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, username:null, emailOrPhone:null, serviceProvider:null });
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
        <table border="2" class="rowed grey" align="center"  bordercolor="#EDDA74">
            <thead>
                <tr>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Username &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email_or_Phone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Service_Provider &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    
                    <th>Action</th>
                </tr>
            </thead>
            <form>
                <tbody id="peoplebody">
                    <tr id="pattern" style="display:none;">
                        <td><span id="username1">Username</span></td>
                        <td><span id="email_or_phone">emailOrPhone</span></td>
                        <td><span id="service_provider">serviceProvider</span></td>
                        
                        
                        <td>
                            <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                        </td>
                    </tr>
                </tbody>
            </form>
        </table>
        
        
        <table class="plain" align="center">
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Username: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input id="username" type="text" size="30"/></td>
            </tr>
            <br>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email_or_Phone: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input id="emailOrPhone" type="text" size="30"/></td>
            </tr> 
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Service_Provider &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input id="serviceProvider" type="text" size="30"/></td>
            </tr>
            
            <tr>
                <td colspan="2" align="right">                    
                    <input type="button" value="Save" onclick="writePerson()"/>
                    <input type="button" value="Clear" onclick="clearPerson()"/>
                </td>
            </tr>             
            
        </table>
        
        <table witdth="80%" align="center">
            <tr>
                
                <td width="15%" align="center"> Owner can save the email adresses of the customers who has already visited the Cybercafe.</td>
                <td width="85%" align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                
            </tr>
        </table>
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        <br>
        <br>
        <br>
        <p align="center">
            <font size="2"> &copy; Copyrights BizIntelApps 2008 All Rights Reserved. <a href="http://bizintelapps.net/"><font color="blue">BizIntelApps</font></a> </font>
        </p>
    </body>
    
</html>
