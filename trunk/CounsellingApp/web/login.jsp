<html>
    <head>
        <title>Counselling Engine Secure Login System</title>
    </head>
    
    <body>
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% }%>
        
        <form action="j_acegi_security_check" method="POST">
            <h3>
            <p>Counselling Engine Secure Login System</p>
            </h3>
            <table>
                <tr><td>User:</td><td><input type='text' name='j_username'> </td></tr>
                <tr><td>Password:</td><td><input type='password' name='j_password'> </td></tr>
                
                <tr><td></td><td colspan='2'><input name="submit"  value="Sign In" type="submit" ></td></tr>
            </table>
            
        </form>
        
    </body>
</html>
