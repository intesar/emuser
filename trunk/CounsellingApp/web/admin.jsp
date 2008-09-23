<%-- 
    Document   : admin
    Created on : Jul 1, 2008, 5:11:03 PM
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
        <script type ='text/javascript' >
            function process() {
                AjaxApplicationService.processAdmissions (
                dwr.util.getValue("startRank"),
                dwr.util.getValue('endRank'), reply1);
            }
            var reply1 = function(data) {
                alert (data);
            }
        </script>
    </head>
    <body>
    <body>
        <table>            
            <tbody>
                <tr>
                    <td><a href="main.jsp">Dashboard</a></td>
                    <td><a href="users.jsp">Users</a></td>
                    <td><a href="collegedepartments.jsp">College Department</a></td>
                    <td><a href="collegeseats.jsp">Reservation Details</a></td>
                    <td><a href="admin.jsp">Admin</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="j_acegi_logout">Logout</a></td>
                </tr>
            </tbody>
        </table>
        
        <br/>
        <br/>
        
        <input type="submit" value="Generate College Seat Quota" /> This should be done only once!<br/>
        Start Rank<input type="text" name="startRank" value="" /> End Rank<input type="text" name="endRank" value="" />
        <input type="submit" value="process" onclick="process();" />
    </body>
</html>
