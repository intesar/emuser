<%-- 
    Document   : apply
    Created on : Jul 5, 2008, 2:50:21 PM
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
            
            function executeFunction() {
                AjaxApplicationService.applyRegistration(
                dwr.util.getValue("ids"), dwr.util.getValue("hallTicketNo"), reply3);
            }
            
            var reply3 = function(data) {
                alert ( data);
            }
        </script>
    </head>
    <body>
        <table border="0">
            
            <tbody>
                <tr>
                    <td>Hall Ticket No.</td>
                    <td><input type="text" name="hallTicketNo" value="" /></td>
                </tr>
                <tr>
                    <td>Student Email</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td>College Nos Seperated By Comma</td>
                    <td><textarea name="ids" rows="4" cols="20">
                    </textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Apply" onclick="executeFunction();"/></td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>
