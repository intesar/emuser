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
        <script type="text/javascript" src="email_validation.js"></script>
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
                        $("pattern" + id).style.display = "";
                        peopleCache[id] = person;
                    }
                });
                //dwr.util.setValues(person);
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
                }   else {
                    person = peopleCache[viewed];
                }
                
                dwr.util.getValues(person);
        
                if ( validateEmail(person.emailOrPhone, false, false) || person.emailOrPhone.length >= 10 ) {
                          
                    AjaxAdminService.saveEmailPreference(person, function(data) {                        
                        fillTable();   
                        alert ( data );
                    });
                    
                } else {
                    alert ( " not a valid phone no.")
                }
                   
                
                
            
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, username:null, emailOrPhone:null, serviceProvider:null });
            }
            function deletePerson() {
                //alert ( 'hi');
                var x = viewed;
                AjaxAdminService.deleteEmail(viewed, function(data) {
                        //alert ( data );
                        fillTable();    
                        clearPerson();
                    });
            }
        </script>
        
        <jsp:include page="table_style.jsp" ></jsp:include>
    </head>
    <body>
        
        <jsp:include page="include.jsp" />
        <h2 align="center"> Email/Phone For Daily Reports </h2> 
        <table align="center">
            <tr>
                <td>
                    
                    <table>
                        <thead>
                            <tr>
                                <th> Name  </th>
                                <th> Email/Phone </th>
                                <th></th>
                            </tr>
                        </thead>
                        <form>
                            <tbody id="peoplebody">
                                <tr id="pattern" style="display:none;">
                                    <td><span id="username1">Username</span></td>
                                    <td><span id="email_or_phone">emailOrPhone</span></td>
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
                                    Email/Phone For Sending Reports
                                </th>
                            </tr>
                        </thead>
                        
                        <tr>
                            <td> Service: </td>
                            <td><select name="serviceProvider">
                                    <option>email</option>
                                    <option>airtel</option>
                                    <option>bsnl</option>
                                    <option>idea</option>                        
                            </select></td>
                        </tr>
                        
                        <tr>
                            <td> Email/Phone:* </td>
                            
                            <td><input id="emailOrPhone" type="text" size="30"/></td>
                        </tr> 
                        <tr>
                            <td> Name: </td>
                            <td><input id="username" type="text" size="30"/></td>
                        </tr> 
                        <tr>
                            <td> 
                            </td>
                            <td>
                                <input type="button" value="Save" onclick="writePerson()"/>  
                                <input type="button" value="Delete" onclick="deletePerson()"/>                                  
                                <input type="button" value="Clear" onclick="clearPerson()"/>
                            </td>
                        </tr>             
                        
                    </table>
                    
                </td>
            </tr>
        </table>
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        <br>
        <br>
        <br>
        <jsp:include page="emails_help.jsp" />
        <jsp:include page="copyright.jsp" />
    </body>
    
</html>
