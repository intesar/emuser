
<html>
    <head>        
        <script type="text/javascript" src="../js/lib/jquery-1.2.6.min.js" ></script>                
        <script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>        
        <script type='text/javascript' src='../dwr/engine.js'></script>
        <script type='text/javascript' src='../js/local/signup.js'></script>
    </head>
    <body>
        
        
        <div style="position:absolute; left:45%; top:10%; bottom:5%; width:70%; height:90%;">
            <h3>Sign Up new Account</h3>
            <table>
                <tbody>
                    <tr>
                        <td>First Name<font color="RED">*</font><br>
                        <input class="" id="firstname" name="firstname" value="" maxlength="40" type="text"></td>
                    </tr>
                    <tr>
                        <td>Last Name<font color="RED">*</font><br>
                        <input class="" id="lastname" name="lastname" value="" maxlength="100" type="text"></td>
                    </tr>
                    <tr>
                        <td>Email<font color="RED">*</font><br>
                        <input class="" id="username" name="username" value="" maxlength="50" type="text"></td>
                    </tr>
                    <tr>
                        <td>Password<font color="RED">*</font><br>
                        <input id="password" name="password" maxlength="50" value="" type="password"></td>
                    </tr>
                    <tr>
                        <td>Confirm Password<font color="RED">*</font><br>
                        <input class="" id="password_confirm" name="password_confirm" maxlength="50" value="" type="password"></td>
                    </tr>                    
                    <tr>
                        <td>Company Name<font color="RED">*</font><br>
                        <input id="organization" name="organization" value="" maxlength="150" type="text"></td>
                    </tr>
                    <tr>                    
                        <td colspan="2">
                            <input id="signup" name="signup" value="Signup" type="button" ">
                        </td>
                    </tr>
                </tbody>
            </table>
            <a href="login.jsp">Log In </a>
        </div>
    </body>
</html>