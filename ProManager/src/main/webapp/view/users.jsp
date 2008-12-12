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
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Users - ProManager</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- <link rel="stylesheet" type="text/css" media="screen" href="../css/table.css">-->
        <link rel="stylesheet" type="text/css" media="screen" href="../css/demos.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="../css/jq.css" />        
        <script type="text/javascript" src="../dwr/interface/AjaxUsersService.js"></script>
        <script type="text/javascript" src="../dwr/engine.js"></script>
        <script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
        <script type="text/javascript" src="../js/jquery.livequery.min.js"></script>
        <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>        
        <!-- <script type="text/javascript" src="../dwr/util.js"></script> -->
        <script type="text/javascript" src="../js/lib/users.js"></script>
        
    </head>
    <body id="dt_example" class="example_alt_pagination">
        <jsp:include page="header.jsp" />
        <br>      
        <div id="userTableContainer" align="center" > 
            <a id="createANewUser">Create a new user</a>
            <br><br>
            <table id="usersTable" cellpadding="0" cellspacing="0" border="0" class="display" >                        
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
                        <tr id="userRow" style="display:none;">
                            <td><span id="name">name</span></td>  
                            <td><span id="enabled1">Active</span></td>
                            <td><span id="role1">Administrator</span></td> 
                            <td>
                                <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                            </td>
                        </tr>
                    </tbody>
                </form>
            </table>    
        </div>
        
        <div id="newUserContainer" style="display:none" align="center">
            <a href="" id="backToUserList"><font size="1"><< </font>Back to user list</a><br><br>
            <table>                
                <tr>
                    <td>First name<br>
                    <input id="firstname" name="firstname" value="" maxlength="40" type="text"></td>                                
                    <td>Last Name<font color="RED">*</font><br>
                    <input id="lastname" name="lastname" value="" maxlength="40" type="text"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><br><br></td>
                </tr>
                <tr>
                    <td>Username<font color="RED">*</font><br>
                    <input class="" id="username" name="username" value="" maxlength="50" type="text"></td>
                    <td>Email Address<font color="RED">*</font><br>
                    <input id="email" name="email" value="" maxlength="40" type="text"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><br><br></td>
                </tr>
                <tr>
                    <td>Password<br>
                    <input class="" id="username" name="username" value="" maxlength="50" type="text"></td>
                    <td>Re-enter password<br>
                    <input id="email" name="email" value="" maxlength="40" type="text"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><br><br></td>
                </tr>
                <tr>
                    <td>  <input type="checkbox" id="enabled" value="ON" /> Active </td>                    
                    <td>  <input type="checkbox" id="administrator" value="ON" />Administrator</td>
                </tr>
                <tr>
                    <td></td>
                    <td><br><br></td>
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

