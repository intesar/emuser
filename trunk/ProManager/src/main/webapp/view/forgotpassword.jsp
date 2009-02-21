<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Grow-Fast</title>
        <!-- table style -->
        <title>Manage-Easy</title>
        <script type="text/javascript" src="../dwr/interface/AjaxUsersService.js"></script>
        <script type="text/javascript" src="../dwr/engine.js"></script>
        <script type="text/javascript" src="../dwr/util.js"></script>
        <script type="text/javascript">

            function recoverPassword() {
                dwr.util.useLoadingMessage("Please Wait, Loading...");
                var email = null;
                email = dwr.util.getValue("email");
                if ( email != null && email.length > 0 ) {
                    AjaxUsersService.requestPasswordKeySendToEmail(email);
                }
            }
            function resetPassword() {
                dwr.util.useLoadingMessage("Please Wait, Loading...");
                var e = dwr.util.getValue("email1");
                var a = dwr.util.getValue("activationCode");
                var p = dwr.util.getValue("password");
                var cp = dwr.util.getValue("confirmPassword");
                if ( p != null && p.length > 0 && cp != null && p == cp && a != null & a.length > 0 ) {
                    AjaxUsersService.resetPasswordWithKey(e,a,p, function(data) {
                        if ( data == "successful") {
                            location.href="../login.jsp";
                        } else {
                            alert ( data ) ;
                        }
                    });
                }


            }
        </script>
    </head><body>

        <div style="position:absolute; left:30%; top:10%; border:1px solid #BBC1B4; border-width:thin; border-style:solid" align="center" >
            <div style="left:20%; top:10%; right:10%;" align="center">
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Step 1. Get activation code.</th>
                        </tr>
                    </thead>
                    <tbody><tr>
                            <td>Email:</td>
                            <td><input name="email" value="" type="text" size="40"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input value="Send activation code to my email" onclick="recoverPassword();" type="submit"></td>
                        </tr>
                </tbody></table>
            </div>
        </div>

        <div  style="position:absolute; left:30%; top:30%; border:1px solid #BBC1B4; border-width:thin; border-style:solid" align="left">
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th>Step 2. Have activation code</th>
                    </tr>
                </thead>
                <tbody><tr>
                        <td>Email:</td>
                        <td><input name="email1" value="" type="text" size="40"></td>
                    </tr>
                    <tr>
                        <td>Activation code:</td>
                        <td><input name="activationCode" value="" type="text" size="40"></td>
                    </tr>
                    <tr>
                        <td>New password:</td>
                        <td><input name="password" value="" type="password" size="40"></td>
                    </tr>
                    <tr>
                        <td>Re-type new password</td>
                        <td><input name="confirmPassword" value="" type="password" size="40"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input value="Reset My Password" onclick="resetPassword();" type="submit"></td>
                    </tr>
                    <br><br>
            </tbody></table>
        </div>

        <div style="position:absolute; left:30%; top:80%;" align="center">
            <tr>
                <td>
                    <a href="../view/login.jsp">Back to login page</a>
                </td>
            </tr>
        </div>
</body></html>