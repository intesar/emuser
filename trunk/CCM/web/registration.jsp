<%-- 
    Document   : registration
    Created on : Jul 7, 2008, 1:36:50 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>
        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function createAccount() {
                var c = dwr.util.getValue("companyName");
                var u = dwr.util.getValue("email");
                var p = dwr.util.getValue("password");
                var cp = dwr.util.getValue("confirmPassword");
                //alert ( c + u + p + cp);
                if ( p == cp) {
                    AjaxUserService.registerNewOrganization ( c, "hyd", u, p, reply1);
                } else {
                    alert ( " Password & ConfirmPassword donot match");
                }
            }
            
            var reply1 = function ( data ) {
                alert ( data );
            }
            
        </script>
    </head>
    <body>
        <table border="0">
            
            <tbody>
                <tr>
                    <td>Company Name</td>
                    <td><input type="text" name="companyName" value="" /></td>
                </tr>
                <tr>
                    <td>Username/Email</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmPassword" value="" /></td>
                </tr>
                <tr>
                <td></td>
                    <td><input type="reset" value="Clear" />
                        <input type="submit" value="Create" onclick="createAccount();"/></td>
                </tr>
            </tbody>
        </table>
        Click here to<a href="login.jsp"> Sign in</a>
    </body>
</html>
