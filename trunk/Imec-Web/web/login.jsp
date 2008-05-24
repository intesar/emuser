<html>
    <head>
        <title>Login</title>
    </head>
    
    <body>
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% }%>
        
        <form action="j_acegi_security_check" method="POST">
            
            <table>
                <tr><td>User:</td><td><input type='text' name='j_username'> </td></tr>
                <tr><td>Password:</td><td><input type='password' name='j_password'> </td></tr>
                
                <tr>
                    <td><input type="reset" value="Clear" /> </td>
                <td colspan='2'><input name="submit" type="submit" value="Sign In" title="Sign In"></td></tr>
            </table>
            
        </form>
        
    </body>
</html>
