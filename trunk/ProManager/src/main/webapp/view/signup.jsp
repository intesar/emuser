
<html>
    <head>
        <script type="text/javascript" src="../js/lib/jquery-1.2.6.min.js" ></script>
        <script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>
        <script type='text/javascript' src='../dwr/engine.js'></script>
        <script type='text/javascript' src='../js/local/signup.js'></script>
    </head>
    <body>


        <div style="position:absolute; left:15%; top:10%; width:60%; border:1px solid #BBC1B4; border-width:thin; border-style:solid" align="center" >
            <h3><em>Sign up for free new Account</em></h3>
            <table>
                <tbody>
                    <tr>
                        <td>Name<font color="RED">*</font></td>
                        <td><input class="" id="firstname" name="firstname" value="" size="40" maxlength="40" type="text" title="firstname">
                        </td><td>
                        <input class="" id="lastname" name="lastname" value="" size="40" maxlength="100" type="text" title="lastname"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><font face="Arial, sans-serif" color="#6f6f6f" size="-1">  Firstname</font></td>
                        <td><font face="Arial, sans-serif" color="#6f6f6f" size="-1">  Lastname </font></td>
                    </tr>
                    <tr>
                        <td>Email<font color="RED">*</font></td>
                        <td><input class="" id="username" name="username" value="" size="40" maxlength="50" type="text" title="email is use for login"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password<font color="RED">*</font></td>
                        <td><input id="password" name="password" size="40" maxlength="50" value="" type="password"> </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Re-type password<font color="RED">*</font></td>
                        <td><input class="" id="password_confirm" name="password_confirm" size="40" maxlength="50" value="" type="password"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Company</td>
                        <td><input id="organization" name="organization" value="" size="40" maxlength="150" type="text" title="enterprise accounts have many more features compare to personal accounts">
                        </td><td>
                        <input type="checkbox" id="personal" title="check this if you are signing by yourself">Personal account</td>
                    </tr>

                    <tr>
                        <td></td>
                        <td> <input id="resetForm" name="resetForm" value="Reset" type="button" title="clears all fields">
                            <input id="signup" name="signup" value="Signup" type="button" title="saves information and creates you virtual account">
                            <td></td>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div style="position:absolute; left:15%; top:70%;" align="center">
            <tr>
                <td>
                    <a href="../view/login.jsp">Back to login page</a>
                </td>
            </tr>
        </div>
    </body>
</html>