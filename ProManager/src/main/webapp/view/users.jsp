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
                            <tbody>                       
                                <!-- required by plugin-->
                                <tr><td></td><td></td><td></td><td></td></tr>
                            </tbody>
                        </form>
                    </table>    
                </div>
            </div>
            
            <div id="newUserContainer" style="display:none" align="center">
                <div id="container" align="center" >
                    <!--<a id="backToUserList"><font size="1"><< </font>Back to user list</a><br><br>-->
                    <table>                
                        <tr>
                            <td>Firstname<br>
                            <input id="firstname" name="firstname" value="" maxlength="40" type="text"></td>                                
                            <td>Lastname<font color="RED">*</font><br>
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
                            <td><input type="button" value="Create new user" id="createNewUser"/> </td>
                            
                            <td>
                                <input type="button" value="Cancel" id="clear"/>
                                
                            </td>   
                        </tr>                         
                    </table>    
                </div>
            </div>
            
            <div id="editUserContainer" style="display:none" align="center">
                <div id="container">
                    <!--<a id="backToUserListFromEdit"><font size="1"><< </font>Back to user list</a><br><br>-->
                    <table>                
                        <tr>
                            <td>Email Address<font color="RED">*</font><br>
                            <input id="emailE" name="emailE" value="" maxlength="40" type="text" disabled></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>
                            <td>First name<br>
                            <input id="firstnameE" name="firstnameE" value="" maxlength="40" type="text"></td>                                
                            <td>Last Name<font color="RED">*</font><br>
                            <input id="lastnameE" name="lastnameE" value="" maxlength="40" type="text"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>                        
                            <td>  Enabled 
                                <br><input type="checkbox" id="enabledE" value="ON" />
                            <small>(User cannot login if disabled)</small></td>
                            <td>  Administrator 
                                <br><input type="checkbox" id="administratorE" value="ON" />
                            <small>(can manage all users and settings)</small></td>
                        </tr>           
                        <tr>
                            <td></td>
                            <td><br></td>
                        </tr>
                        <tr>
                            <td><input type="button" value="Save user" id="saveUser"/> </td>
                        </tr>                         
                    </table>    
                </div>
            </div>
        </div>
        <div id="pc" style="position:absolute; left:67%; top:20%; bottom:0; width:15%; height:90%; "></div>
    </body>
</html>

