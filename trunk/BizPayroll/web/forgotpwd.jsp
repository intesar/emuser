<%-- 
    Document   : forgotpwd
    Created on : 27 May, 2008, 6:36:35 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Forgot Password</title>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body background="bg_blue.jpg">
        <center>
                   <p><h3>I Cannot access My Account </h3></p>
            <table border="1">
                <thead>
                    <tr> 
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="tundra">
                    <tr>
                        <td>User Name</td>
                        <td><input class='itext' type="text" name="username" class="small" value='' 
                                       dojoType="dijit.form.ValidationTextBox"
                                       regExp="[\w]+"
                                       required="true"
                                       invalidMessage="Enter Proper Email address Example:abc@domain.com"><!--<input type="text" name="" value="" />--> </td>
                    </tr>
                    
                    <tr>
                        
                        <tr></tr><td></td>
                        <td><input type="submit" value="Submit" name="Submit" /></td>                        
                    </tr><tr></tr><tr></tr><tr></tr><tr></tr>
                    <tr> 
                        <td></td>
                    </tr>
                </tbody>
            </table>
       </center>
    </body>
</html>
