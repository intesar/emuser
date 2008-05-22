<%-- 
    Document   : Timesheet
    Created on : 21 May, 2008, 6:19:19 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TimeSheet</title>
        <style type="text/css">
        @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
        @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css"
    </style>
    <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
        djConfig="parseOnLoad: true"></script>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
        djConfig="parseOnLoad: true"></script>
    <script type="text/javascript">
        dojo.require("dojo.parser");
        dojo.require("dijit.form.DateTextBox");
    </script>
    </head>
    <body>
    <table border="0">
<thead>
<tr>
<th>Current Date</th>

</tr>
</thead>
<tbody>
<tr>
<td><input type="text" name="date1" value="2005-12-30"
                dojoType="dijit.form.DateTextBox"
                required="true" /></td>
<td></td>
</tr>
</tbody>
</table>
          
        
    </body>
</html>
