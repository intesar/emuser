<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Counselling Engine Secure Login System</title>
    </head>
    
    <style>
        a:link    {color:black; text-decoration:none; font-size:8.5pt}
        a:hover   {color:black; text-decoration:none;
            font-size:8.5pt}
        a:active  {color:black; text-decoration:none; font-size:8.5pt}
        a:visited {color:black; text-decoration:none; font-size:8.5pt}
    </style>
    <style>
        a:link    {color:black; text-decoration:none; font-size:8.5pt}
        a:hover   {color:black; text-decoration:none;
            font-size:8.5pt}
        a:active  {color:black; text-decoration:none; font-size:8.5pt}
        a:visited {color:black; text-decoration:none; font-size:8.5pt}
        .style16 {color: #FFFFFF}
    </style>
    
    
    
    <body>
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        
        <form action="j_acegi_security_check" method="POST" id="login_form">
            <table align="center" width="85%">
                <tr>
                    <td width="33%" align="left"><a href="http://www.bizintelapps.net/" target="_blank"><img src="dash/logo.jpg" alt="logo" width="290" height="74" border="0"/></a></td>
                    <td width="4%"><img src="dash/line2.JPG" alt="line2" width="11" height="214" />&nbsp;&nbsp;</td>
                    <td width="28%" align="center"><p><img src="dash/network.jpg" alt="net" height="217" /></p>
                    </td>
                    <td width="4%">&nbsp;&nbsp;&nbsp; <img src="dash/line.JPG" alt="line" width="14" height="316" /></td>
                    <td width="31%" align="right">
                        <table align="right">
                            <tr><td width="71">&nbsp;</td></tr>
                            <tr><td></td></tr>
                            <tr><td></td></tr>
                            <tr>
                                <td>   <font face="Arial, Helvetica, sans-serif" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email:</font></td>
                            <td width="198"><input type='text' name='j_username' size="33"> </td></tr>
                            <tr><td></td><td><font size="-1" color="#999999">(example555@abc.com)</font></td></tr>
                            <tr><td></td><td></td></tr>
                            <tr><td></td><td></td></tr>
                            <tr>
                            <td>&nbsp; &nbsp; <font face="Arial, Helvetica, sans-serif">Password: </font></td><td><input type='password' name='j_password' size="33"> </td></tr>
                            <tr><td></td><td><a href="forgotpassword.jsp"><font size="-1" color="blue"> Forgot Username or Password?</font></a></td></tr>
                            <tr><td></td><td colspan='2'>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--<img src="dash/sign in.JPG" alt="sign in" border="0" onclick="window.document['login_form'].submit();"/>-->
                                 <input type="submit" value="submit" />
                                <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Sorry, but either the username or password is incorrect.
                                </font></b> <% }%> 
                            </td>      
                            
                            <tr>
                                <td><font size="10">
                                    <a href="registration.jsp"><img src="dash/Sign up.JPG" alt="sign up" border="0"/></a> </font> <br>
                                </td>
                            </tr>
                        </table>                
                    </td>
                </tr>
            </table>
            
        </form>
        
        <p align="center">&nbsp;        </p>
        <p align="center">&nbsp;</p>
        <p align="center">&nbsp;</p>
        <p align="center"><font size="2">&copy; Copyrights BizIntelApps 2008 All Rights Reserved. <a href="http://bizintelapps.net/" target="_blank"><font color="blue">BizIntelApps</font></a> </font>
        </p>
    </body>
</html>
