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
        
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            function call_function() {
                console.debug("Button was clicked.");
            }
        </script>
        
        <!-- <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.ValidationTextBox");
        </script>-->
        
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
        <body  class="tundra">
        
        <table cellspacing="0" cellpadding="0" border="0" align="center" width="95%">
            <tbody>
                <tr valign="top">
                    <td width="1%">
                        
                        <img height="45" border="0" align="left" width="175" vspace="15" alt="Imec" src="images/imec.bmp"/>
                    </td>
                    <td bgcolor="#ffffff" width="99%" valign="top">
                        <table cellpadding="1" width="100%">
                            <tbody>
                                <tr valign="bottom">
                                    <td>
                                        <div align="right"> </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td nowrap="nowrap">
                                        <table cellspacing="0" cellpadding="0" bgcolor="#c3d9cc" align="center" width="100%" style="margin-bottom: 5px;">
                                            <tbody>
                                                <tr>
                                                    <td class="bubble tl" align="left" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                                                    </td>
                                                    <br>                                                     <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                    <b>&nbsp;&nbsp;<img src="images/users.gif" width="23" height="23" alt="users"/>

                                                        Mail Server Details </b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                         <a href="users.jsp">View Users</a>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <a href="j_acegi_logout">logout</a>
                                                        
                                                    </td>
                                                    <td class="bubble tr" align="right" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tr.gif"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="bubble bl" align="left" valign="bottom">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_bl.gif"/>
                                                    </td>
                                                    <td class="bubble br" align="right" valign="bottom">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_br.gif"/>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        
        
        
        
        
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
                    users.sort(function(p1, p2) { return p1.hostname.localeCompare(p2.hostname); });
                    for (var i = 0; i < users.length; i++) {
                        user = users[i];
                        id = user.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("tableName" + id, user.hostname );                        
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
                var user = { id:viewed, username:null, hostname:null };
                dwr.util.getValues(user);

                // dwr.engine.beginBatch();
                JUserAjaxService.addUser(user, reply1);
                fillTable();
                //dwr.engine.endBatch();
            }

            
            function clearUser() {
                viewed = -1;
                dwr.util.setValues({ id:-1, username:null, hostname:null });
            }
            
            var reply1 = function(data)
            {
                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                else dwr.util.setValue('d1', dwr.util.toDescriptiveString(data, 1));
            }



        </script>
        
        <center>
            <p align ="center">
            <table border="0">
                
                <thead>
                    <tr>
                        <th><center><h2>Mail Server Details</h2></center><br> 
                            <div align="center"style="border:1px black solid; width:415px; height:210px; overflow:auto;">
                                
                                <table border="1" width=400px; height=200px; id="userTable">
                                    <thead>
                                        <tr>
                                            <th><center><h2> <b>Hostname</b></h2></center></th>
                                            <th><center><h2><b> Username</b></h2></center> </th>            
                                            <th><center> <h2><b>Actions</b></h2></center> </th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody id="usersbody">    
                                        
                                        <tr id="pattern"  style="display:none;">
                                            <td>
                                                <span id="tableName">Name</span><br/> 
                                            </td>                        
                                            <td><span id="tableUsername">Username</span></td>
                                            <td>
                                                <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
                                                <!--<button id="edit" value="Edit"dojoType="dijit.form.Button" onclick="editClicked(this.id)" >                                
                                Edit
                            </button>-->
                            
                                            </td>
                                        </tr>            
                                        
                                    </tbody>
                                </table>
                            </div>
                        </th><td></td>
                        <td></td><td></td>
                        <td></td><td></td>
                        
                        
                        <th>            <center><h2>Edit User Details</h2> </center><br><br><br>
                            <table border="0">
                                <thead>
                                    <tr>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Username</td>
                                        <td><!--<input class='itext' type="text" name="username" class="small" value='' id='p10'
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                       invalidMessage="Enter Username.">-->
                    
                                            <input class='itext'type="text" name="username" value='' id='p10' />
                                    </td></tr>
                                    <tr>
                                        <td>hostname</td>
                                        <td>
                                            <input class='itext'type="text" name="hostname" value='' id='p12' />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <script type='text/javascript'>
                                            function addUserFunction() {
                        
                                                var username = '"' + $("p10").value + '"';
                                                username = objectEval(username);
                                       
                                                var hostname  = '"' + $("p12").value + '"';
                                                hostname = objectEval(hostname);
                            
                                                
                            
                            
                                            }
                                            var reply1 = function(data)
                                            {
                                                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                                else dwr.util.setValue('d1', dwr.util.toDescriptiveString(data, 1));
                                            }
                                        </script>
                                        
                                        <td><button dojoType="dijit.form.Button" onclick="writeUser();">
                                                Save
                                            </button> <button dojoType="dijit.form.Button" onclick="clearUser();">
                                                Clear
                                        </button></td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                            <span id='d1' class='reply'></span>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            
            
            <br><br>   
            
            <span id='d1' class='reply'></span>
            
            <p align ="center">
        </center>
    </form>
    
    
    
    <br><br><br><br><br>
    
    <table cellspacing="0" cellpadding="3" bgcolor="#c3d9cc" align="center" width="95%" style="margin-bottom: 5px;">
        <tbody>
            <tr>
                <td class="bubble tl" align="left" valign="top">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                </td>
                <td class="bubble" style="text-align: left;" rowspan="2">
                    <div align="center">
                        <font color="#666666" size="-1">
                            © Copyrights Bizintelapps 2008 All Rights Reserved. 
                            <a href="http://www.bizintelapps.com">BizIntelApps</a>
                            
                        </font>
                    </div>
                </td>
                <td class="bubble tr" align="right" valign="top">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tr.gif"/>
                </td>
            </tr>
            <tr>
                <td class="bubble bl" align="left" valign="bottom">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_bl.gif"/>
                </td>
                <td class="bubble br" align="right" valign="bottom">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_br.gif"/>
                </td>
            </tr>
        </tbody>
    </table>
    
    
    
    
    
    </body>
</html>



