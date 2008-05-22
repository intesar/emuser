<html>
  <head>
    <title>Login</title>
  </head>

  <body>
    <% if ( request.getParameter("login_error") != null ) { %> <b> <font color=RED> Sorry, but either the username or password is incorrect.
 </font></b> <% } %>
    <h1>Login</h1>
    <form action="j_acegi_security_check" method="POST">
	<h4>Hello</h4>
		<p>Please login to obtain the secret of becoming a Java Guru.</p>

      <table>
        <tr><td>User:</td><td><input type='text' name='j_username'> (sapient)</td></tr>
        <tr><td>Password:</td><td><input type='password' name='j_password'> (password)</td></tr>

        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
      </table>

    </form>

  </body>
</html>
