<html>
    <head>
        <title>Login</title>
        <!-- <style type="text/css">
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
        -->
    </head>
    
    <body class="tundra">
        <table cellspacing="0" cellpadding="0" border="0" align="center" width="95%">
            
            <tbody>
                <tr valign="top">
                    
                    <td width="1%">
                    
                    <img height="45" border="0" align="left" width="175" vspace="15" alt="Imec" src="images/imec.gif"/>
                    <!-- <h1><b><i><font color="Green">IMEC&nbsp;</font></i></b></h1>-->
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
                                                    <br>                                                    <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                        <b>&nbsp;&nbsp;&nbsp;
                                                        Welcome to Intelligent Marketing Email Client </b>
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
        
        
        
        
        
        
        
        <table border="1" align="right" hspace="30" vspace="10" rules="none">
            <thead>
                <tr>
                    <th>  
                        <table border="0" bgcolor="#e8eecc" >
                            <thead>
                                <tr>
                                    <th><center><% if (request.getParameter("login_error") != null) {%> <h6><font color=RED > Sorry, but either the username or <br>password is incorrect.
                                            </font></h6> <% }%><h5>Sign in to IMEC with your</h5><h3><b><i><font color="Green">IMEC</font></i></b>&nbsp;Account</h3><!--<img src="images/bizpayrol.bmp" width="145" height="28" align="center" alt="login_icon"<h4>Account</h4>--> 
                                        </center>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> 
                                        <form action="j_acegi_security_check" method="POST">
                                            <center>
                                                <table>
                                                    <br>
                                                    
                                                    <tr><td><img src="images/users.gif" width="20" height="20" alt="user"/>
                                                        User:</td><td><!--<input type='text' name='j_username'>(sapient)</td></tr>-->
                
                                                            <input type="text" name="j_username" class="small"
                                                                   dojoType="dijit.form.ValidationTextBox"
                                                                   regExp="[\w]+"
                                                                   required="true"
                                                           invalidMessage="Invalid Non-Space Text."></td></tr>
                                                    
                                                    <tr><td><img src="images/pwd.gif" width="20" height="20" alt="pwd"/>
                                                        Password:</td><td><!--<input type='password' name='j_password'> (password)</td></tr>-->
                
                                                            <input type="password" name="j_password" class="small"
                                                                   dojoType="dijit.form.ValidationTextBox"
                                                                   regExp="[\w]+"
                                                                   required="true"
                                                           invalidMessage="Enter Password."></td></tr>
                                                    <tr>
                                                        <td>Remember me:</td>
                                                        <td><input type="checkbox" name="_acegi_security_remember_me"/></td>
                                                    </tr>
                                                    
                                                    
                                                    
                                                    <tr><tr></tr><tr></tr><td colspan='2'><p align="right"><input name="submit" value="Sign in" type="submit" ></p>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <a href="forgotpwd.jsp"><h5><font color="red"> Forget your ID or password?</font></h5> </a>
                                                
                                                
                                                
                                            </center>
                                            
                                    </form></td>
                                </tr>
                                
                                
                            </tbody>
                    </table></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                </tr>
            </tbody>
        </table>
        
        
        
        <table cellspacing="0" cellpadding="3" bgcolor="#c3d9cc" vspace="50" align="center" width="95%" height="30" style="margin-bottom: 5px;">
            <tbody>
                <tr>
                    <td class="bubble tl" align="left" valign="top">
                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                    </td>
                    <td class="bubble" style="text-align: left;" rowspan="2">
                        <div align="center">
                            <font color="#666666" size="-1">
                                � Copyrights Bizintelapps 2008 All Rights Reserved. 
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

