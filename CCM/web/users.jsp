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
        <jsp:include page="dhtml_goodies_include.jsp" />
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
       
        <script type="text/javascript">
            function init() {
                fillTable();
            }
        
            var peopleCache = { };
            var viewed = null;
        
            function fillTable() {
                dwr.util.useLoadingMessage();
                AjaxAdminService.getAllUsers(function(people) {
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
                        dwr.util.setValue("enabled1" + id, person.enabled);
                        dwr.util.setValue("role1" + id, person.role); 
                        
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
                document.getElementById("username").disabled=true;
            }
        
            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var person = peopleCache[eleid.substring(4)];
                viewed = person.id;
                dwr.util.setValues(person);
                document.getElementById("username").disabled=true;
            }
        
            
        
            function writePerson() {
                var person;
                if ( viewed == null ) {
                    person = { id:viewed, username:null, name:null, password:null, enabled:null, role:null, phone:null };
                } else {
                    person = peopleCache[viewed];
                }
                dwr.util.getValues(person);
                
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveUsers(person, reply1);
                fillTable();
                //dwr.engine.endBatch();
            }
            
            var reply1 = function (data) {
                alert ( data );
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, username:null, name:null, password:null, enabled:null, role:null, phone:null });
                document.getElementById("username").disabled=false;

            }
        </script>
        
      <jsp:include page="table_style.jsp" ></jsp:include>
    </head>
    <body>
        
        <jsp:include page="include.jsp" />
        
        <table align="center">
            
            
            <tr>
                <td>
                    <table>
                        
                        <thead>
                            <tr>
                                <th>Email</th>
                                <th>Active</th>
                                <th>Role</th>
                                
                                
                            </tr>
                        </thead>
                        <form>
                            <tbody id="peoplebody">
                                <tr id="pattern" style="display:none;">
                                    <td><span id="username1">username</span></td>  
                                    <td><span id="enabled1">enabled</span></td>
                                    <td><span id="role1">role</span></td> 
                                    
                                    
                                    <td>
                                        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                                    </td>
                                </tr>
                            </tbody>
                        </form>
                    </table>
                    
                </td>
                <td>
                    <table>
                        <thead>
                            <tr>
                                <th></th>
                                <th>
                                    User
                                </th>
                            </tr>
                        </thead>
                        <tr>
                            <td> Email: </td>
                            <td><input id="username" type="text" size="30" disabled="disabled"/></td>
                        </tr>
                        <tr>
                            <td>  Name:  </td>
                            <td><input id="name" type="text" size="30"/></td>
                        </tr>
                        
                        <tr>
                            <td> Password </td>
                            <td><input id="password" type="password" size="30"/></td>
                        </tr> 
                        <tr>
                            <td> Enabled </td>
                            <td><select name="enabledString">
                                    <option>yes</option>
                                    <option>no</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td>  Role </td>
                            <td><select name="role">
                                    <option>admin</option>
                                    <option>employee</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td> Phone </td>
                            <td><input id="phone" type="text" size="30"/></td>
                        </tr>          
                        <tr>
                        <td></td>
                        <td>
                                <input type="button" value="Save" onclick="writePerson()"/>
                                <input type="button" value="New" onclick="clearPerson()"/>
                            </td>
                        </tr> 
                        
                        
                        
                    </table>
                    
                </td>
            </tr>
        </table>
        
        
        
        
        
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
    </body>
    
    <jsp:include page="users_help.jsp" />
    <jsp:include page="copyright.jsp" />
</html>
