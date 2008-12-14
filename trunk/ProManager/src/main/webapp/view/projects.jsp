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
    <title>Project - ProManager</title>
    <jsp:include page="include.jsp" />
    <script type="text/javascript" src="../dwr/interface/AjaxProjectService.js"></script>
    <script type="text/javascript" src="../js/lib/project.js"></script>
</head>
<body  id="dt_example" class="example_alt_pagination">
<jsp:include page="header.jsp" />
<br>      
<div id="projectTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="center"> 
<div id="container">
<a id="createANewProject">Create a new project<font size="1"> >> </font></a>
<br><br>
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
</div>
<div id="newProjectContainer" style="display:none" align="center">
    <div id="container">
        <a id="backToProjectList"><font size="1"><< </font>Back to project list</a><br><br>
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tr>
                <td>Name <font color="RED">*</font><br>
                <input id="name" name="name" value="" maxlength="40" type="text"></td>                                
            </tr>
            <tr>
                <td><br>Description<br>
                <textarea name="description" rows="8" cols="40"></textarea></td>
            </tr>                       
            <tr>
                <td>                    
                    <input type="button" value="Create new project" id="createNewProject"/>                                
                    <input type="button" value="Cancel" id="clear"/>
                </td>   
            </tr>                         
        </table>    
    </div>
</div>        

<div id="editProjectContainer" style="display:none" align="center">
    <div id="container">
        <a id="backToProjectListFromEdit"><font size="1"><< </font>Back to project list</a><br><br>
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tr>
                <td>Name <font color="RED">*</font><br>
                <input id="nameE" name="nameE" value="" maxlength="40" type="text" disabled></td>                                
            </tr>
            <tr>
                
                <td><br>Status<br>
                    <select name="statusE" id="statusE">
                        <option value="In Progess">In Progess</option>
                        <option value="On Hold">On Hold</option>
                        <option value="Completed">Completed</option>
                </select></td>
            </tr>
            <tr>
                <td><br>Description<br>
                <textarea id="descriptionE"  name="descriptionE" rows="8" cols="40"></textarea></td>
            </tr>                       
            <tr>
                <td>                    
                    <input type="button" value="Save" id="saveProject"/>
                </td>   
            </tr>                         
        </table>   
    </div>
</div>        
</body>
</html>
