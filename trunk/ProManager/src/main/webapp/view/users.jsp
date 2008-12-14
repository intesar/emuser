<%-- 
    Document   : users
    Created on : Nov 27, 2008, 4:50:06 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>        
        <title>Users - ProManager</title>
        <jsp:include page="include.jsp" />
        <script type="text/javascript" src="../dwr/interface/AjaxUsersService.js"></script>
        <script type="text/javascript" src="../js/lib/users.js"></script>
        
    </head>
    <body id="dt_example" class="example_alt_pagination" style="">
        <jsp:include page="header.jsp" />
        <br>      
        <div id="userTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="right"> 
            <a id="createANewUser" >Create a new user<font size="1"> >> </font></a>
            <br><br>
            <table id="usersTable" cellpadding="0" cellspacing="0" border="0" class="display" align="center">                        
                <thead>
                    <tr>
                        <th>Name</th>                                                            
                        <th>Active</th>
                        <th>Administrator</th>
                        <th>Edit</th>                                
                    </tr>
                </thead>
                <form>
                    <tbody id="userbody">                       
                    </tbody>
                </form>
            </table>    
        </div>
        
        <div id="newUserContainer" style="display:none" align="center">
            <a id="backToUserList"><font size="1"><< </font>Back to user list</a><br><br>
            <table>                
                <tr>
                    <td>First name<br>
                    <input id="firstname" name="firstname" value="" maxlength="40" type="text"></td>                                
                    <td>Last Name<font color="RED">*</font><br>
                    <input id="lastname" name="lastname" value="" maxlength="40" type="text"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td>Email Address<font color="RED">*</font><br>
                    <input id="email" name="email" value="" maxlength="40" type="text"></td>
                    
                    <td>  Administrator 
                    <br><input type="checkbox" id="administrator" value="ON" />
                    <small>(can manage all users and settings)</small></td>
                </tr>           
                <tr>
                    <td></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><input type="button" value="Create new user" onclick="writePerson()"/> </td>
                    
                    <td>
                        <input type="button" value="Cancel" onclick="clearPerson()"/>
                        
                    </td>   
                </tr>                         
            </table>    
        </div>
        
    </body>
</html>

