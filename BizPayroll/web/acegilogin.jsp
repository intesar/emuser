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
                    
                    <td width="1%"> <vspace ="10"> <h1><b><i><font color="3399ff">BizPayroll&nbsp;</font></i></b></h1>
                    <!-- <img height="53" border="0" align="left" width="175" vspace="15" alt="BizIntelapps" src="images/logo1.bmp"/> </td> -->
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
                                                    <br>                                                    <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                        <b>&nbsp;&nbsp;&nbsp;
                                                        Welcome to BizPayroll </b>
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
        
        
        
        
        
        
        
        <table border="1" align="right" hspace="30" vspace="10">
            <thead>
                <tr>
                    <th>  
                        <table border="0" bgcolor="#e8eefa" >
                            <thead>
                                <tr>
                                    <th><center><% if (request.getParameter("login_error") != null) {%> <h6><font color=RED > Sorry, but either the username or <br>password is incorrect.
                                            </font></h6> <% }%><h5>Sign in to BizPayroll with your</h5><h3><b><i><font color="3399ff">BizPayroll</font></i></b>&nbsp;Account</h3><!--<img src="images/bizpayrol.bmp" width="145" height="28" align="center" alt="login_icon"<h4>Account</h4>--> 
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
                                                    
                                                    <tr><td><img src="images/icon2-normal.gif" width="20" height="20" alt="icon2-normal"/>
                                                        User:</td><td><!--<input type='text' name='j_username'>(sapient)</td></tr>-->
                
                                                            <input type="text" name="j_username" class="small"
                                                                   dojoType="dijit.form.ValidationTextBox"
                                                                   regExp="[\w]+"
                                                                   required="true"
                                                           invalidMessage="Invalid Non-Space Text."></td></tr>
                                                    
                                                    <tr><td><img src="images/icon4-normal.gif" width="20" height="20" alt="icon4-normal"/>
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
                                                <a href="forgotpwd.jsp"><h5>Forget your ID or password?</h5> </a>
                                                
                                                
                                                <hr>
                                                <h5><p align="left">Not Registered Yet ?</p></h5>
                                                <p align="right"><a href="http://localhost:8084/BizPayroll/registration.jsp">Sign Up !</a></p> 
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
        
        
        
        <table cellspacing="0" cellpadding="3" bgcolor="#c3d9ff" vspace="15" align="center" width="95%" style="margin-bottom: 5px;">
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

