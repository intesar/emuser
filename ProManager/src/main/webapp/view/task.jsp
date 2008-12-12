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
        <title>Tasks - ProManager</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- <link rel="stylesheet" type="text/css" media="screen" href="../css/table.css"> -->
        <link rel="stylesheet" type="text/css" media="screen" href="../css/demos.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="../css/jq.css" />   
        <script type="text/javascript" src="../dwr/interface/AjaxProjectService.js"></script>
        <script type="text/javascript" src="../dwr/engine.js"></script>
        <!-- <script type="text/javascript" src="../dwr/util.js"></script> -->
        <script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
        <script type="text/javascript" src="../js/jquery.livequery.min.js"></script>
        <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>                 
        <script type="text/javascript" src="../js/lib/task.js"></script>             
    </head>
    <body  id="dt_example" class="example_alt_pagination">
        <jsp:include page="header.jsp" />        
        <br>      
        <div id="taskTableContainer" align="center" > 
            <a id="createANewTask">Create a new Task<font size="1"> >> </font></a>
            <br><br>
            <table   id="taskTable" cellpadding="0" cellspacing="0" border="0" class="display" >                        
                <thead>
                    <tr>
                        <th>ID</th>                                                                                             
                        <th>Title</th>
                        <th>Project</th>
                        <th>Priority</th>
                        <th>Status</th>
                        <th>Deadline</th>
                        <th>Assign-To</th>
                        <th>Owner</th>
                        <th></th>
                    </tr>
                </thead>                
                <tbody id="projectbody">
                    <tr id="projectRow" style="display:none;">
                        <td><span id="id1">ID</span></td>                                      
                        <td><span id="title1">Title</span></td>  
                        <td><span id="project1">Project</span></td>
                        <td><span id="priority1">Priority</span></td>
                        <td><span id="status1">Status</span></td>  
                        <td><span id="deadline1">Deadline</span></td>
                        <td><span id="owner1">Owner</span></td>
                        <td><span id="assign-to1">Assige-To</span></td>                                    
                        <td>
                            <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                        </td>
                    </tr>
                </tbody>                
            </table>    
        </div>
        <div id="newTaskContainer" style="display:none" align="center">
            <a href="" id="backToTaskList"><font size="1"><< </font>Back to task list</a><br><br>
            <table style="width:200px;">
                <tr>
                    <td>Priority</td>
                    <td></td>
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
                    <td>Assign-To</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Deadline</td>
                    <td></td>
                </tr>                                               
                <tr>
                    <td></td>                            
                    <td>
                        <input type="button" value="New" onclick="clearPerson()"/>
                        <input type="button" value="Save" onclick="writePerson()"/>                                
                    </td>   
                </tr>                         
            </table>                
            <table>
                <tr>
                    <td>Description</td>
                    <td><textarea name="description" rows="8" cols="40"></textarea></td>
                </tr>
            </table>
        </div>
    </body>
</html>
