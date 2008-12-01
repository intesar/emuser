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
        <link rel="stylesheet" type="text/css" media="screen" href="../css/table.css">
        <script type="text/javascript" src="../dwr/interface/AjaxUsersService.js"></script>
        <script type="text/javascript" src="../dwr/engine.js"></script>
        <script type="text/javascript" src="../dwr/util.js"></script>
        <script type="text/javascript" src="../js/lib/users.js"></script>
        <style type="text/css">
            pre { text-align: left; }
        </style>        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <table align="center">         
            <tr>
                <td valign="top">
                    <table>                        
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
                </td>
                <td>
                    
                    <table>
                        <thead>
                            <tr>
                                <th></th>
                                <th>Create | Update User</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>First Name</td>
                            <td><input id="firstname" name="firstname" value="" maxlength="40" type="text"></td>                                
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td><input id="lastname" name="lastname" value="" maxlength="40" type="text"></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><input class="" id="username" name="username" value="" maxlength="50" type="text"></td>
                        </tr>
                        <tr>
                            <td>Email Address</td>
                            <td><input id="email" name="email" value="" maxlength="40" type="text"></td>
                        </tr>               
                        <tr>
                            <td> Active </td>
                            <td>
                                <input type="checkbox" id="enabled" value="ON" />
                            </td>
                        </tr>
                        <tr>
                            <td>  Administrator </td>
                            <td><input type="checkbox" id="administrator" value="ON" /></td>
                        </tr>                        
                        <tr>
                            <td></td>
                            
                            <td>
                                <input type="button" value="New" onclick="clearPerson()"/>
                                <input type="button" value="Save" onclick="writePerson()"/>                                
                            </td>   
                        </tr>                         
                    </table>    
                </td>
            </tr>
        </table>
        <script type="text/javascript">
            window.onload = fillTable();             
        </script>
    </body>
</html>

