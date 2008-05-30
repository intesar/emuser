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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        
        
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
                                                        <b>&nbsp;&nbsp;<img src="images/mark.gif" width="23" height="23" alt="icon2-normal"/>
                                                        Forgot Password </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        
                                                        <a href="acegilogin.jsp">logout</a>
                                                        
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
        
        
        
        
        
        <center>
            <p><h3>I Cannot access My Account </h3></p>
            <table border="1">
                <thead>
                </thead>
                <tbody class="tundra">
                    <tr>
                        <td>User Email</td>
                        <td><input class='itext' type="text" name="username" class="small" value='' 
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                   invalidMessage="Enter Proper Email address Example:abc@domain.com"><!--<input type="text" name="" value="" />--> </td>
                    </tr>
                    
                    <tr>
                        
                        <tr></tr><td></td>
                        <td>&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" name="Submit" /></td>                        
                    </tr><tr></tr><tr></tr><tr></tr><tr></tr>
                    
                </tbody>
            </table>
        </center>
        
        
        
        
        
        <br><br><br>
        
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
