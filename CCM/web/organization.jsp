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
            function init() {
                fillTable();
            }
        
            var peopleCache = { };
            var viewed = null;
        
            function fillTable() {
                dwr.util.useLoadingMessage();
                AjaxAdminService.getOrganization(function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    // people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("name" + id, person.name);
                        dwr.util.setValue("enabled" + id, person.enabled);
                        dwr.util.setValue("city" + id, person.city);
                        dwr.util.setValue("street" + id, person.street);
                        dwr.util.setValue("contact_name" + id, person.contact_name);
                        dwr.util.setValue("contact_type" + id, person.contact_type);
                        dwr.util.setValue("register_date" + id, person.register_date);
                        dwr.util.setValue("contact_email" + id, person.contact_email);
                        dwr.util.setValue("amount_rate" + id, person.amount_paid);
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
            }
        
            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var person = peopleCache[eleid.substring(4)];
                dwr.util.setValues(person);
            }
        
            
        
            function writePerson() {
                var person = { id:null, name:null, address:null, salary:null };
                dwr.util.getValues(person);
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveOrganization(person);
                fillTable();
                //dwr.engine.endBatch();
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, name:null, enabled:true, city:null, street:null, contact_name:null, contact_type:null, register_date:null, contact_email:null, amount_paid:null,});
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
        <table class="plain" align="center">
            <tr>
                <td>Username:</td>
                <td><input id="name" type="text" size="30"/></td>
            </tr>
            
            <tr>
                <td>Isworking:</td>
                <td><input type="text" id="enabled" size="30"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" id="city" size="30"/></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><input type="text" id="street" size="30"/></td>
            </tr>
            <tr>
                <td>Contact_Name:</td>
                <td><input type="text" id="contact_name" size="30"/></td>
            </tr>
            <tr>
                <td>Contact_Type:</td>
                <td><input type="text" id="contact_type" size="30"/></td>
            </tr>
            <tr>
                <td>Register_Date:</td>
                <td><input type="text" id="register_date" size="30"/></td>
            </tr>
            <tr>
                <td>Contact_Email:</td>
                <td><input type="text" id="contact_email" size="30"/></td>
            </tr>
            <tr>
                <td>Amount_Paid:</td>
                <td><input type="text" id="amount_paid" size="30"/></td>
            </tr>
            
            
            <tr>
                <td colspan="2" align="right">                    
                    <input type="button" value="Save" onclick="writePerson()"/>
                    <input type="button" value="Clear" onclick="clearPerson()"/>
                </td>
            </tr>
        </table>
        <script type="text/javascript">
            onload = fillTable();
        </script>
        
    </body>
</html>
