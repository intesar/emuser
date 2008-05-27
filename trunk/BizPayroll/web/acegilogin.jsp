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
    <center>
        <body background="bg_blue.jpg" class="Tundra">
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% }%>
        <br><br><br><br>
        <table border="1">
            <thead>
                <tr>
                    <th><center><h2>Welcome to all Users</h2><img src="login_icon.jpg" width="133" height="135" alt="login_icon"/>
                        </center>
                    </th>
                </tr>
            </thead>
            <tbody background="login.jpg">
                <tr>
                    <td> 
                        <form action="j_acegi_security_check" method="POST">
                            <center>
                                <table>
                                    <br><br><br><br><br>                                    
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
                                    <tr><td colspan='2'><a href="Forgot Password.html">Forgot Password ?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="submit" type="submit"></td>
                                    </tr>
                                </table>
                            </center>
                    </form></td>
                </tr>
                
                <tr>
                    <td></td>
                </tr>
            </tbody>
    </table></center>
    
    
    </body>
</html>

