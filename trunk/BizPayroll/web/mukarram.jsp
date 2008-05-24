<%-- 
    Document   : mukarram
    Created on : 24 May, 2008, 8:43:01 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Login</title>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/Tundra/Tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            function call_function() {
                console.debug("Button was clicked.");
            }
        </script>
        
        <script type="text/javascript">
            function update() {
                var name = dwr.util.getValue("demoName");
                Demo.sayHello(name, function(data) {
                    dwr.util.setValue("demoReply", data);
                });
            }
        </script>
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.ValidationTextBox");
        </script>
        
    </head>
    
    <body class="Tundra">
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% }%>
        <h1>Login Details</h1>
        <form action="j_acegi_security_check" method="POST">
            <h4>Welcome to all Users</h4>
            <p>Please login to obtain the secret account of BizPayroll.</p>
            
            <table>
                <tr><td>User:</td><td><!--<input type='text' name='j_username'>(sapient)</td></tr>-->
                
                        <input type="text" name="j_username" class="small"
                               dojoType="dijit.form.ValidationTextBox"
                               regExp="[\w]+"
                               required="true"
                       invalidMessage="Invalid Non-Space Text."></td></tr>
                
                <tr><td>Password:</td><td><!--<input type='password' name='j_password'> (password)</td></tr>-->
                
                        <input type="password" name="j_password" class="small"
                               dojoType="dijit.form.ValidationTextBox"
                               regExp="[\w]+"
                               required="true"
                       invalidMessage="Enter Password."></td></tr>
                <tr></tr>
                <tr><td colspan='2'><input name="submit" type="submit"></td>
                 : <span id="submit"></span>
                </tr>
            </table>
           <!-- <p>
                Name:
                <input type="text" id="demoName"/>
                <input value="Send" type="button" onclick="update()"/>
                <br/>
                Reply: <span id="demoReply"></span>
            </p> -->
            
            <a href="Forgot Password.html">Forgot Password</a>
        </form>
    </body>
</html>

