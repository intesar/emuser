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
        <div style="position:absolute; left:5%; top:10%; bottom:5%; width:70%; height:90%; ">
            <div id="userTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="center"> 
                <div id="container">
                    <div align="right">
                        <a id="createANewUser" href="javascript:void(0)">Create a new user</a>                    
                    </div>
                    <table id="usersTable" cellpadding="0" cellspacing="0" border="0" class="display render" align="center">                        
                        <thead class="render">
                            <tr class="render">
                                <th class="render">ID</th>
                                <th class="render">Name</th>                                                            
                                <th class="render">Active</th>
                                <th class="render">Administrator</th>
                                <th class="render">Edit</th>                                
                            </tr>
                        </thead>                        
                        <tbody>                       
                            <!-- required by plugin-->
                            <tr><td></td><td></td><td></td><td></td><td></td></tr>
                        </tbody>                        
                    </table>    
                </div>
            </div>
            
            <div id="newEditContainer" style="display:none" align="center">
                <div id="container" align="center" >
                    <!--<a id="backToUserList"><font size="1"><< </font>Back to user list</a><br><br>-->
                    <table>                
                        <tr>
                            <td><b>Firstname<font color="RED">*</font></b><br>
                            <input id="firstname" name="firstname" value="" maxlength="40" type="text"></td>                                
                            <td><b>Lastname<font color="RED">*</font></b><br>
                            <input id="lastname" name="lastname" value="" maxlength="40" type="text"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>
                            <td><b>Email<font color="RED">*</font></b><small>(email is username)</small><br>
                            <input id="email" name="email" value="" maxlength="40" type="text"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>
                            <td>  <b>Enabled</b>
                                <br><input type="checkbox" id="enabled" value="ON" />
                            <small>(User cannot login if disabled)</small></td>
                            <td>  <b>Admin</b>
                                <br><input type="checkbox" id="administrator" value="ON" />
                            <small>(manages all users and settings)</small></td>                            
                        </tr>           
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>
                            <td><input type="button" value="Save User" id="saveUser"/> </td>
                            
                            <td>
                                <input type="button" value="Cancel" id="clear"/>
                                
                            </td>   
                        </tr>                         
                    </table>    
                </div>
            </div>
        </div>
        <div id="pc" style="position:absolute; left:67%; top:20%; bottom:0; width:15%; height:90%; "></div>
    </body>
</html>

