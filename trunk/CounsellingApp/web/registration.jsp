<%-- 
    Document   : index
    Created on : Jun 28, 2008, 5:35:23 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type='text/javascript' src='/CounsellingApp/dwr/interface/AjaxApplicationService.js'></script>
        <script type='text/javascript' src='/CounsellingApp/dwr/engine.js'></script>       
        <script type='text/javascript' src='/CounsellingApp/dwr/util.js'></script>
        <script type="text/javascript">
            //onload = doThis();
            
            function objectEval(text)
            {
                // eval() breaks when we use it to get an object using the { a:42, b:'x' }
                // syntax because it thinks that { and } surround a block and not an object
                // So we wrap it in an array and extract the first element to get around
                // this.
                // This code is only needed for interpreting the parameter input fields,
                // so you can ignore this for normal use.
                // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
                text = text.replace(/\n/g, ' ');
                text = text.replace(/\r/g, ' ');
                if (text.match(/^\s*\{.*\}\s*$/))
                {
                    text = '[' + text + '][0]';
                }
                return eval(text);
            }

            function addUser() {
                //AjaxApplicationService
            }
        </script>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th><center><h3>Registration</h3></center></th>
                    <th></th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Username/Email</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td>Student Name</td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                <tr>
                    <td>Father's Name</td>
                    <td><input type="text" name="fathername" value="" /></td>
                </tr>
                <tr>
                    <td>Hall Ticket Number</td>
                    <td><input type="text" name="hallticket" value="" /></td>
                </tr>
                <tr>
                    <td>Rank</td>
                    <td><input type="text" name="rank" value="" /></td>
                </tr>
                <tr>
                <td><input type="submit" value="Submit" onclick="addUser();"/></td>
                <td><input type="reset" value="Clear" /></td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>
