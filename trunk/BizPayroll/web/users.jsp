<%-- 
    Document   : users
    Created on : 22 May, 2008, 10:40:56 AM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

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
        
        
        
    </head>
    <form action="lform">
        
        <body bgcolor="CCFFFF">
        
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

            function editClicked(eleid) 
            {
                 viewed = eleid.substring(4);
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var user = usersCache[eleid.substring(4)];
                dwr.util.setValues(user);
            }
            function writeUser() {
                var user = { id:viewed, username:null, firstname:null, lastname:null, password:null };
                dwr.util.getValues(user);

               // dwr.engine.beginBatch();
                JUserAjaxService.addUser(user);
                fillTable();
                //dwr.engine.endBatch();
            }

            
            function clearUser() {
                viewed = -1;
                dwr.util.setValues({ id:-1, username:null, firstname:null, lastname:null, password:null });
            }



        </script>
        <p align ="center">
         <center>    
             <h3><u>User Details</u></h3>  
       
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
    </center>
        <br><br>   
        <center>    
             <h3>Edit User Details</h3> 
        <table border="1">
            <thead>
                <tr>
                    
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Username</td>
                    <td><input class='itext'type="text" name="username" value='' id='p10' /></td>
                </tr>
                <tr>
                    <td>Firstname</td>
                    <td><input class='itext'type="text" name="firstname" value='' id='p12' /></td>
                </tr>
                <tr>
                    <td>Lastname</td>
                    <td><input class='itext'type="text" name="lastname" value='' id='p13' /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input class='itext' type="password" name="password" id='p11' /></td>
                </tr>
                <tr>
                    <td> Confirm Password</td>
                    <td><input class='itext' type="password" name="confirmpassword"   id='p14' /></td>
                </tr>
                <tr>
                    <td></td>
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
                            alert("here");              
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
                    
                    <td><input  class='ibutton' type='button'  value=" Save " name="save" onclick='writeUser();' value='Execute'  title='Calls JUserAjaxService.addUser(). View source for details.' /> <input type="reset" value=" Clear " name="clear" onclick="clearUser();" /></td>
                </tr>
            </tbody>
        </table>
    </center>
        <span id='d1' class='reply'></span>
        
        <p align ="center">
    </form>
    </body>
</html>



