
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>GROW-FAST</title>       
    </head>    
    <body>
        <div align="center" >
            <table align="center" >
                <tr>
                    <td>
                        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Invalid Credentials! </font></b> <% }%> 
                        <form action="../j_acegi_security_check" method="POST" id="login_form" >
                            <table width="188" border="0" rules="none" align="center" >
                                
                                <tr>
                                    <td>Username:</td>
                                    <td>
                                        <input type="text" name='j_username' value="xy" size="30" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td>
                                        <input type="password" name='j_password' size="30" value="xy"/>                                    
                                    </td>
                                </tr>
                                <tr>
                                    <td>Remember-me:</td>
                                    <td><input type="checkbox" name="_acegi_security_remember_me" checked="checked"/></td>
                                </tr>
                                <tr></tr>
                                <tr>                                
                                    <td></td>
                                    <td valign="top" align="justify">
                                        <input type="submit" value="Log In " name="Sign In" />
                                    <a href="../view/signup.jsp"> Sign Up </a> </td>
                                </tr>
                            </table>
                        </form> 
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
