<%-- 
    Document   : users
    Created on : 22 May, 2008, 10:40:56 AM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>User Information</title>
        <script type='text/javascript' src='/BizPayroll/dwr/interface/JUserAjaxService.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/engine.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/util.js'></script>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type='text/javascript'>
            function objectEval(text)
            {
                // eval() breaks when we use it to get an object using the { a:42, b:'x' }
                // syntax because it thinks that { and } surround a block and not an object
                // So we wrap it in an array and extract the first element to get around
                // this.
                // This code is only needed for interpreting the parameter input fields,
                // so you can ignore this for normal use.
                // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
                text = text.replace(/\n/g, ' ');
                text = text.replace(/\r/g, ' ');
                if (text.match(/^\s*\{.*\}\s*$/))
                {
                    text = '[' + text + '][0]';
                }
                return eval(text);
            }
            
            
        </script>
        
        <style>
            input.itext { font-size: smaller; background: #E4E4E4; border: 0; }
            input.ibutton { font-size: xx-small; border: 1px outset; margin: 0px; padding: 0px; }
            span.reply { background: #ffffdd; white-space: pre; }
            span.warning { font-size: smaller; color: red; }
        </style>
        
    </head>
    <form action="lform">
        
        <body>
        
        <script type="text/javascript">
            function init() {                
                fillTable();
            }
            window.onload=init;

            var usersCache = { };
            var viewed = -1;

            function fillTable() {
                JUserAjaxService.getAllUsers(function(users) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("usersbody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var user, id;
                    users.sort(function(p1, p2) { return p1.firstname.localeCompare(p2.firstname); });
                    for (var i = 0; i < users.length; i++) {
                        user = users[i];
                        id = user.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("tableName" + id, user.firstname + " " + user.lastname);                        
                        dwr.util.setValue("tableUsername" + id, user.username);
                        $("pattern" + id).style.display = "table-row";
                        usersCache[id] = user;
                    }
                });
            }

            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var user = peopleCache[eleid.substring(4)];
                dwr.util.setValues(user);
            }

        </script>
        <p align ="center">
        <h3>User Details</h3>  
        <table border="1">
            <thead>
                <tr>
                    <th>&nbsp;Name&nbsp;</th>
                    <th>&nbsp;Username&nbsp;</th>            
                    <th>&nbsp;Actions&nbsp;</th>
                    
                </tr>
            </thead>
            <tbody id="usersbody">    
                
                <tr id="pattern" style="display:none;">
                    <td>
                        <span id="tableName">Name</span><br/>                        
                    </td>
                    <td><span id="tableUsername">Username</span></td>
                    <td>
                        <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
                        <input id="delete" type="button" value="Delete" onclick="deleteClicked(this.id)"/>
                    </td>
                </tr>            
                
            </tbody>
        </table>
        <br><br>   
        
        <table border="0">
            <thead>
                <tr>
                    <th>Edit User Details</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Username</td>
                    <td><input class='itext'type="text" name="Username" value='' id='p10' /></td>
                </tr>
                <tr>
                    <td>Firstname</td>
                    <td><input class='itext'type="text" name="Firstname" value='' id='p12' /></td>
                </tr>
                <tr>
                    <td>Lastname</td>
                    <td><input class='itext'type="text" name="Lastname" value='' id='p13' /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input class='itext' type="password" name="Password" id='p11' /></td>
                </tr>
                <tr>
                    <td> Confirm Password</td>
                    <td><input class='itext' type="password" name="confirmPassword"   id='p14' /></td>
                </tr>
                <tr>
                    <td><input  class='ibutton' type='button' value="save" name="save" onclick='addUserFunction();' value='Execute'  title='Calls JUserAjaxService.addUser(). View source for details.' /></td>
                    <script type='text/javascript'>
                        function addUserFunction() {
                            
                            var username = '"' + $("p10").value + '"';
                            username = objectEval(username);
                            
                            var firstname  = '"' + $("p12").value + '"';
                            firstname = objectEval(firstname);
                            
                            var lastname  = '"' + $("p13").value + '"';
                            lastname = objectEval(lastname);
                            
                            var password  = '"' + $("p11").value + '"';
                            password = objectEval(password);
                            
                            var confirmPassword  = '"' + $("p14").value  + '"';
                            confirmPassword = objectEval(confirmPassword);
                            
                            
                            if ( password == confirmPassword )  {
                                JUserAjaxService.addUser(username, firstname, lastname, password, reply1);
                            } else {
                                alert ( " Password & Confirm Password Do Not match !");
                            }
                            
                            
                        }
                        var reply1 = function(data)
                        {
                            if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                            else dwr.util.setValue('d1', dwr.util.toDescriptiveString(data, 1));
                        }
                    </script>
                    <td> <input type="reset" value="clear" name="clear" /></td>
                </tr>
            </tbody>
        </table>
        <span id='d1' class='reply'></span>
        
        <p align ="center">
    </form>
    
    </body>
</html>

