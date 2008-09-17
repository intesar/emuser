<%-- 
    Document   : forgotpassword
    Created on : Jul 7, 2008, 1:37:24 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="table_style.jsp" ></jsp:include>

<html>
    <head>
        <title>FaceGuard</title>
        <style>
            a:link    {color:black; text-decoration:none; font-size:8.5pt}
            a:hover   {color:black; text-decoration:none;
                font-size:8.5pt}
            a:active  {color:black; text-decoration:none; font-size:8.5pt}
            a:visited {color:black; text-decoration:none; font-size:8.5pt}
        </style>
        <style>
            a:link    {color:black; text-decoration:none; font-size:8.5pt}
            a:hover   {color:black; text-decoration:none;
                font-size:8.5pt}
            a:active  {color:black; text-decoration:none; font-size:8.5pt}
            a:visited {color:black; text-decoration:none; font-size:8.5pt}
            .style16 {color: #FFFFFF}
        </style>
        
        
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>
        <script type="text/javascript" src="email_validation.js"></script>
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <script type="text/javascript"> 
            
            function recoverPassword() {
                var email = null;
                email = dwr.util.getValue("email");
                if ( validateEmail(email, true, true) ) {
                    AjaxUserService.forgotPassword(email, function(data) {
                        alert ( data ) ;
                    });
                }
            }
        </script>
    </head>
    <body>
        <table align="center" border="0" width="50%" bgcolor="#C00" style="color:#FFF;
        background:#C00;
        border-collapse:collapse;
        width:370px;        
        border:5px solid #900;" >
            <thead>
                <tr>
                    <th></th>
                    <th>Password Recovery</th>
                </tr>
            </thead>
            <tr>
                <td>Username/Email :</td>
                <td><input type="text" name="email" value="" /></td>                
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Send to My Email" onclick="recoverPassword();"/></td>
            </tr>
            <tr>
                <td>
                    <a href="login.jsp">Login Page</a>
                </td>
            </tr>
        </table>
    </body>
</html>
