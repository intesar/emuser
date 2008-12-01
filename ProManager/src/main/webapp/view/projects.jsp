<%-- 
    Document   : projects
    Created on : Nov 27, 2008, 4:50:17 PM
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
        <script type="text/javascript" src="../dwr/interface/AjaxProjectService.js"></script>
        <script type="text/javascript" src="../dwr/engine.js"></script>
        <script type="text/javascript" src="../dwr/util.js"></script>
        <script type="text/javascript" src="../js/lib/project.js"></script>
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
                                <th>Status</th>   
                                <th>Action</th>
                            </tr>
                        </thead>
                        <form>
                            <tbody id="projectbody">
                                <tr id="projectRow" style="display:none;">
                                    <td><span id="name1">name</span></td>  
                                    <td><span id="status1">Active</span></td>
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
                                <th>Create | Update Project</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>Name</td>
                            <td><input id="name" name="name" value="" maxlength="40" type="text"></td>                                
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td><select name="status" id="status">
                                    <option value="In Progess">In Progess</option>
                                    <option value="On Hold">On Hold</option>
                                    <option value="Completed">Completed</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td><textarea name="description" rows="8" cols="40"></textarea></td>
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
