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
        
        <script type='text/javascript' src='/MailClient/dwr/interface/AjaxEmailsService.js'></script>
        <script type='text/javascript' src='/MailClient/dwr/engine.js'></script>
        <script type='text/javascript' src='/MailClient/dwr/util.js'></script>
        <script type='text/javascript'>
            window.onload=fillTable();
            var peopleCache = { };
            var viewed = -1;
        
            function fillTable() {
                AjaxEmailsService.getAllEmails("unread", function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.from.localeCompare(p2.from); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("_from" + id, person.from);
                        dwr.util.setValue("_subject" + id, person.subject);                        
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
                var person = { id:viewed, contextText:null };
                dwr.util.getValues(person);
        
                dwr.engine.beginBatch();
                AjaxEmailsService.updateEmails(person);
                fillTable();
                dwr.engine.endBatch();
            }
        
           
        </script>
    </head>
    <body>
        
        <table border="1" class="rowed grey">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody id="peoplebody">
                <tr id="pattern" style="display:none;">
                    <td>
                        <span id="_from">From</span><br/>
                        
                    </td>
                    <td><span id="_subject">Subject</span></td>
                    <td>
                        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
                        <input id="delete" type="button" value="Delete" onclick="deleteClicked(this.id)"/>
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        <table class="plain">
            <tr>
                <td>Name:</td>
                <td><textarea id="contextText"></textarea>></td>
            </tr>
            
            <tr>
                <td colspan="2" align="right">
                    
                    <input type="button" value="Save" onclick="writePerson()"/>
                    
                </td>
            </tr>
        </table>
    </body>
</html>
