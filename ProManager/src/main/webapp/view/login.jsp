<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Pro Accounting</title>       
    </head>
    
    <body>
        
        <div align="center" >
            
            <table width="800" height="554" border="1" align="center" >
                <tr>
                    <td>
                    <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Invalid Credentials! </font></b> <% }%> 
                    <form action="../j_acegi_security_check" method="POST" id="login_form" >
                        <table width="188" border="0" rules="none" align="center" >
                            
                            <tr>
                                <td>Username:</td>
                                <td>
                                    <input type="text" name='j_username' size="30" />
                                </td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td>
                                    <input type="password" name='j_password' size="30" />                                    
                                </td>
                            </tr>
                            <tr>
                                <td>Remember-me:</td>
                                <td><input type="checkbox" name="_acegi_security_remember_me"/></td>
                            </tr>
                            <tr></tr>
                            <tr>                                
                                <td></td>
                                <td valign="top" align="justify">
                                    <input type="submit" value="Sign In " name="Sign In" />
                                <a href="../view/signup.jsp"> Sign Up </a> </td>
                            </tr>
                        </table>
                    </form>    
                </tr>
                
            </table>
        </div>
    </body>
</html>
