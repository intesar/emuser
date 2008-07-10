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
            var viewed = -1;
        
            function fillTable() {
                AjaxAdminService.getAllSystems(function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("name1" + id, person.name);
                        dwr.util.setValue("description1" + id, person.description);
                        dwr.util.setValue("minuteRate1" + id, person.minuteRate);
                        dwr.util.setValue("enabled1" + id, person.enabled);
                        dwr.util.setValue("macAddress1" + id, person.macAddress);
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
                var person = { id:viewed, name:null, address:null, salary:null };
                dwr.util.getValues(person);
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveSystem(person);
                fillTable();
                //dwr.engine.endBatch();
            }
        
            function clearPerson() {
                viewed = -1;
                dwr.util.setValues({ id:-1, name:null, description:null, minuteRate:null, enabled:true, macAddress:null });
            }
        </script>
    </head>
    <body>
         <table>            
            <tbody>
                <tr>
                    <td><a href="dashboard.jsp">Dashboard</a></td>
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
                    <td><a href="j_acegi_logout">Logout</a></td>
                </tr>
            </tbody>
        </table>
        <table border="1" class="rowed grey">
            <thead>
                <tr>
                    <th>No</th>
                    <th>MacAddress</th>
                    <th>Description</th>
                    <th>IsWorking</th>
                    <th>Usage Rate</th>
                </tr>
            </thead>
            <tbody id="peoplebody">
                <tr id="pattern" style="display:none;">
                    <td><span id="name1">No</span></td>
                    <td><span id="macAddress1">MacAddress</span></td>
                    <td><span id="description1">Description</span></td>
                    <td><span id="enabled1">IsWorking</span></td>
                    <td><span id="minuteRate1">Usage Rate</span></td>
                    <td>
                        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        <table class="plain">
            <tr>
                <td>No:</td>
                <td><input id="name" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>MacAddress:</td>
                <td><input id="macAddress" type="text" size="20"/></td>
            </tr>
            <tr>
                <td>Descrption:</td>
                <td><input type="text" id="description" size="40"/></td>
            </tr>
            <tr>
                <td>Is Working:</td>
                <td><input type="text" id="enabled" size="40"/></td>
            </tr>
            <tr>
                <td>Rate:</td>
                <td><input type="text" id="minuteRate" size="40"/></td>
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
