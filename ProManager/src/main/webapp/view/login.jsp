<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Pro Accounting</title>       
    </head>
    
    <body>
        
        <div align="center" >
            
            <table width="800" height="554" border="0" align="center" >
                <tr>
                    <td width="100" height="550" valign="top">
                    <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Invalid Credentials! </font></b> <% }%> 
                    <form action="/ProManager/j_acegi_security_check" method="POST" id="login_form" >
                        <table width="188" border="0" rules="none" align="center" >
                            
                            <tr>
                                <td width="185" valign="top"><span class="style28">Username:</span></td>
                                <td valign="top">
                                    <label>
                                        <span class="style28"></span>
                                        <input type="text" name='j_username' size="30" />
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top" class="style28">Password:</td>
                                <td valign="top">
                                    <label>                                        
                                        <input type="password" name='j_password' size="30" />
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td valign="top" align="justify">
                                    <input type="submit" value="Sign In " name="Sign In" />
                                </td>                                
                            </tr>
                            
                        </table>
                    </form>                    
                    
                    
                </tr>
            </table>
        </div>
    </body>
</html>
