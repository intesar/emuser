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
    <title>Grow-Fast - Projectr</title>
    <jsp:include page="include.jsp" />
    <script type="text/javascript" src="../dwr/interface/AjaxProjectService.js"></script>
    <script type="text/javascript" src="../js/local/project.js"></script>
</head>
<body  id="dt_example" class="example_alt_pagination">
<jsp:include page="header_2.jsp" />
<jsp:include page="banner.jsp" /> 
<br>      
<div id="leftDiv">
<div id="projectTableContainer"  align="center"> 
<div id="container">
<div align="right"><img alt="Add" src="../images/add.gif" class="createANewProject" /><a id="createANewProject" class="createANewProject" href="javascript:void(0)">New project</a></div>
<table id="projectTable"  cellpadding="0" cellspacing="0" border="0" class="display" >                        
    <thead>
        <tr>
            <th>Name</th>                                                            
            <th>Status</th>   
            <th>Action</th>
        </tr>
    </thead>                
    <!-- required by plugin-->
    <tr><td></td><td></td><td></td></tr>
    </tbody>                
</table>                    
</div>

<div id="newProjectContainer" style="display:none" align="center">
    <div id="container">        
        <table>
            <thead>
                <tr>
                    <th></th>                    
                </tr>
            </thead>
            <tr>
                <td><b>Name <font color="RED">*</font></b><br>
                <input id="name" name="name" value="" maxlength="40" type="text"></td>                                
            </tr>
            <tr>
                <td></td>                
            </tr>
            <tr>                
                <td><b>Status</b><br>
                    <select name="status" id="status">
                        <option value="In Progress">In Progress</option>
                        <option value="On Hold">On Hold</option>
                        <option value="Completed">Completed</option>
                </select></td>
            </tr>
            <tr>
                <td></td>                
            </tr>
            <tr>
                <td><b>Description</b><br>
                <textarea name="description" rows="8" cols="40"></textarea></td>
            </tr>       
            <tr>
                <td></td>                
            </tr>
            <tr>
                <td>
                    <input type="button" value="Cancel" id="clear"/>
                    <input type="button" value="Save & Close" class='simplemodal-close' id="saveProject"/>                                                    
                </td>   
            </tr>                         
        </table>            
    </div>
</div>        
</div>
<div id="projectUsersDiv" align="center" style="left:5%;display:none">
<div id="container">
<div align="right">
    <img alt="Project List" src="../images/projectList.png" class="backToProjectList" ><a href="javascript:void(0);" class="backToProjectList">Back to Project List</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <img alt="Add" src="../images/add.gif" class="saveProjectUsersLink" />
    <a id="saveProjectUsersLink" class="saveProjectUsersLink" href="javascript:void(0);">Add a User to member</a>
</div>
<table id="projectUsersTable"  cellpadding="0" cellspacing="0" border="0" class="display" >                        
    <thead>
        <tr>
            <th>Project</th>
            <th>User</th>                                                            
            <th>Role</th>   
            <th>Action</th>
        </tr>
    </thead>                
    <!-- required by plugin-->
    <tr><td></td><td></td><td></td><td></td></tr>
    </tbody>                
</table>  
</div>
</div>
<br>
<div id="projectUsersSaveDiv" style="display:none" align="center">
    <table>
        <thead>
            <tr>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tr>
            <td><b>Project<font color="RED">*</font></b><br>
            <input id="projectName" name="name" value="" maxlength="40" disabled type="text"></td>                                
        </tr>
        <tr>
            <td></td>                
        </tr>
        <tr>
            <td><b>Username<font color="RED">*</font></b><br>
            <input id="projectUsername" name="name" value="" maxlength="40" type="text"></td>                                
        </tr>
        <tr>
            <td></td>                
        </tr>
        <tr>
            <td><b>Project Manager</b><br>
                <input type="checkbox" id="manager" value="ON" /> <small>(moniters project activity & reports)</small>
            </td>
        </tr>
        <tr>
            <td></td>                
        </tr>
        <tr>
            <td>                    
                <input type="button" value="Create new project" class='simplemodal-close' id="addUserToProjectBtn"/>                                                
            </td>   
        </tr>                         
    </table>    
</div>
</div>


<div id="rightDiv" ></div>
</body>
</html>
