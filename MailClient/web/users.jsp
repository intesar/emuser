<%-- 
    Document   : users
    Created on : Jun 7, 2008, 4:59:12 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type='text/javascript' src='/MailClient/dwr/interface/AjaxUsersService.js'></script>
        <script type='text/javascript' src='/MailClient/dwr/engine.js'></script>
        <script type='text/javascript' src='/MailClient/dwr/util.js'></script>
        <script type='text/javascript'>
            window.onload=fillTable();
            var peopleCache = { };
            var viewed = -1;
        
            function fillTable() {
                AjaxUsersService.getAllUsers(function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.username.localeCompare(p2.username); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("_username" + id, person.username);
                        dwr.util.setValue("_name" + id, person.firstname + " " + person.lastname);           
                        dwr.util.setValue("_enabled" +id, person.enabled);
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
            }
        
            var person;
            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                person = peopleCache[eleid.substring(4)];
                dwr.util.setValues(person);
            }
        
            function deleteClicked(eleid) {
                // we were an id of the form "delete{id}", eg "delete42". We lookup the "42"
                person = peopleCache[eleid.substring(7)];
                if (confirm("Are you sure you want to Disable " + person.firstname + " " + person.lastname + "?")) {
                    //dwr.engine.beginBatch();
                    AjaxUsersService.disableUsers({ id:person.id });
                    fillTable();
                    //dwr.engine.endBatch();
                }
            }
        
            function writePerson() {
                //var person = null;
                if ( viewed == null ) {
                    person = { id:viewed, username:null, firstname:null, lastname:null, password:null };
                } 
                dwr.util.getValues(person);
        
                //dwr.engine.beginBatch();
                if ( person.id > 0 )
                    AjaxUsersService.saveUsers ( person);
                else {
                    AjaxUsersService.createUsers ( person);
                }
                //People.setPerson(person);
                fillTable();
                //dwr.engine.endBatch();
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:viewed, username:null, firstname:null, lastname:null, password:null });
            }
        </script>
    </head>
    <body>
        
        <table border="1" class="rowed grey">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Active</th>
                </tr>
            </thead>
            <tbody id="peoplebody">
                <tr id="pattern" style="display:none;">
                    <td>
                        <span id="_username">Username</span><br/>
                        
                    </td>
                    <td><span id="_name">Name</span></td>
                    <td><span id="_enabled">Active</span></td>
                    <td>
                        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
                        <input id="_delete" type="button" value="Activate/DeActivate" onclick="deleteClicked(this.id)"/>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <h3>Edit User</h3>
        <table class="plain">
            <tr>
                <td>Name:</td>
                <td><input id="username" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Firstname:</td>
                <td><input id="firstname" type="text" size="20"/></td>
            </tr>
            <tr>
                <td>Lastname:</td>
                <td><input type="text" id="lastname" size="40"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" id="password" size="40"/></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    
                    <input type="button" value="Save" onclick="writePerson()"/>
                    <input type="button" value="Clear" onclick="clearPerson()"/>
                </td>
            </tr>
        </table>
    </body>
</html>
