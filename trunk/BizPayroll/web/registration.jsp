<%-- 
    Document   : registration
    Created on : May 20, 2008, 5:11:48 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type='text/javascript' src='/BizPayroll/dwr/interface/JUserAjaxService.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/engine.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/util.js'></script>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/Tundra/Tundra.css";
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
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.ValidationTextBox");
        </script>
        
        <script type='text/javascript'>
            function objectEval(text)
            {
                //text = '"' + text + '"';
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
    <body  class="Tundra">
        
        
        
        <table cellspacing="0" cellpadding="0" border="0" align="center" width="95%">
            <tbody>
                <tr valign="top">
                    <td width="1%">
                        
                        <img height="45" border="0" align="left" width="175" vspace="20" alt="Bizpayroll" src="images/biz2.bmp"/>
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
                                        <table cellspacing="0" cellpadding="0" bgcolor="#c3d9ff" align="center" width="100%" style="margin-bottom: 5px;">
                                            <tbody>
                                                <tr>
                                                    <td class="bubble tl" align="left" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                                                    </td>
                                                    <br>                                                     <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                        <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/check.jpg" width="23" height="23" alt="check"/>
                                                        Register Your Organization </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        
                                                        
                                                        <a href="acegilogin.jsp"><font color="red" size="3">Sign in</font></a>
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
        
        
        
        
        
        
        
        
        <p align="center">
        
        <form>  <center>      
                <table border="0">
                    <p align="center">
                    <tbody>
                        <tr>
                            <td>Organization Name</td>
                            <td>
                                <input class='itext' type="text"   class="small" value='' id='org_name'
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                       invalidMessage="Enter Organization Name.">
                                <!--<input class='itext' type='text' size='10' value='' id='org_name' title='Enter organization name' />-->
                            </td>
                            
                        </tr>
                        <tr>
                            
                            <td>Organization Type</td>
                            <td>
                                <select class='itext' value='' id='org_type' title='Select your Category'>
                                    <option>Select</option>
                                    <option>Education</option>
                                    <option>Computers & IT</option>
                                    <option>Medicals</option>
                                    <option>General</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td><textarea class='itext' type='text' size='10' value='' id='org_description' title='Enter your Organization Description'>
                            </textarea></td>
                        </tr>
                        <tr>
                            <td>First Name</td>
                            <td><input class='itext' type="text" name="firstname" class="small" value='' id='firstname'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Firstname.">
                            <!--<input class='itext' type='text' size='10' value='' id='firstname' title='Enter first name'/>--></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td>
                                <input class='itext' type="text" name="lastname" class="small" value='' id='lastname'
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                       invalidMessage="Enter Lastname.">
                            <!--<input class='itext' type='text' size='10' value='' id='lastname' title='Enter Last Name'/>--></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><input class='itext' type="text" name="username" class="small" value='' id='username'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Username.">
                            <!--<input class='itext' type='text' size='10' value='' id='username' title='Enter User Name'/>--></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <input class='itext' type="password" name="password" class="small" value='' id='password'
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                       invalidMessage="Enter Password.">
                            <!--<input class='itext' type='password' size='10' value='' id='password' title='Enter Password'/>--></td>
                            
                        </tr>
                        <tr>
                            <td>Confirm Password</td>
                            <td><input class='itext' type="password" name="confrimpassword" class="small" value='' id='confirm_password'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Confirm Password.">
                            <!--<input class='itext' type='password' size='10' value='' id='confirm_password' title='Confirm password'/>--></td>
                        </tr>
                        <tr>
                            <td><input type="reset" value="Clear" />
                                
                            </td>
                            <td>
                                <button dojoType="dijit.form.Button" onclick="createUserFunction();"> 
                                    Execute   
                                </button>
                                
                            </td>
                            <script type='text/javascript'>
                                function createUserFunction() {
                      
                                    var organizationName = '"' + $("org_name").value + '"';
                                    var organizationType = '"' + $("org_type").value + '"';
                                    var organizationDesc = '"' + $("org_description") + '"';
                                    var FirstName = '"' + $("firstname").value + '"';
                                    var LastName = '"' + $("lastname").value + '"';
                                    var UserName = '"' + $("username").value + '"';
                                    var Password = '"' + $("password").value + '"';
                                    var confirmpassword = '"' + $("confirm_password").value + '"';
                              
                                    organizationName = objectEval( organizationName );
                                    organizationType = objectEval( organizationType );
                                    organizationDesc = objectEval( organizationDesc );
                                    FirstName = objectEval( FirstName );
                                    LastName = objectEval( LastName );
                                    UserName = objectEval( UserName );
                                    Password = objectEval( Password );
                                    confirmpassword = objectEval( confirmpassword );
                                    if ( Password == confirmpassword )
                                    {
                                        JUserAjaxService.createUser(organizationName, organizationType, organizationDesc, FirstName, LastName, UserName, Password, reply0);
                                    } else {
                                        alert("Password & confirm Password are not matching");
                                    }
                                                               
                                }
                                var reply0 = function(data)
                                {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
                                 
                                }
                            </script>
                            <span id='d0' class='reply'></span>
                            
                        </tr>
                    </tbody>
                </table>
            </center>
            
        </form>
        
        
        <br><br><br><br><br><br><br><br><br>
        
        <table cellspacing="0" cellpadding="3" bgcolor="#c3d9ff" align="center" width="95%" style="margin-bottom: 5px;">
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
