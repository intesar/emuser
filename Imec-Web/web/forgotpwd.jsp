<%-- 
    Document   : forgotpwd
    Created on : 27 May, 2008, 6:36:35 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Forgot Password</title>
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
        
        <script type='text/javascript' src='/Imec-Web/dwr/interface/JUserAjaxService.js'></script>
        <script type='text/javascript' src='/Imec-Web/dwr/engine.js'></script>
        <script type='text/javascript' src='/Imec-Web/dwr/util.js'></script>
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
        
        
        
        
        
        
        <script type ="text/javascript">


            function emailPassword(){}
  
            var reply2 = function(data)
            {
                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                else dwr.util.setValue('d2', dwr.util.toDescriptiveString(data, 1));
            }
        </script>
        <span id='d2' class='reply2'></span>
        
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        
        
        <table cellspacing="0" cellpadding="0" border="0" align="center" width="95%">
            <tbody>
                <tr valign="top">
                    <td width="1%">
                        
                        <img height="45" border="0" align="left" width="175" vspace="15" alt="Imec" src="images/imec.gif"/>
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
                                        <table cellspacing="0" cellpadding="0" bgcolor="#c3d9cc" align="center" height="40" width="100%" style="margin-bottom: 5px;">
                                            <tbody>
                                                <tr>
                                                    <td class="bubble tl" align="left" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                                                    </td>
                                                    <br>                                                     <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                        <b>&nbsp;&nbsp;
                                                        Forgot Password </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        
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
        
        
        <br><br><br><br><br><br>
        
        
        <center>
            <p><h2>I Cannot access My Account </h2></p>
            <table border="1" rules="none">
                <thead>
                </thead>
                <tbody class="tundra">
                    <tr>
                        <td>&nbsp;&nbsp;User Email&nbsp;&nbsp;</td>
                        <td>
                            <input class='itext' type='text' size='30' value='' id='useremail' /> 
                            
                            
                            
                        </td>
                    </tr>
                    
                    <tr>
                        
                        <tr></tr><td></td>
                        <td>
                            
                          
                            <input class='ibutton' type='button' onclick='JUserAjaxService.emailPassword(objectEval($("useremail").value), reply2);' value='Submit' size="25"/>  
                        </td>                        
                  
                    
                </tbody>
            </table>
        </center>
        
        
        
        
        
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        
        <table cellspacing="0" cellpadding="3" bgcolor="#c3d9cc" align="center" width="95%" height="30" style="margin-bottom: 5px;">
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
