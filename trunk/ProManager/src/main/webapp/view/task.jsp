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
        <title>Tasks - ProManager</title>
        <jsp:include page="include.jsp" />
        <script type="text/javascript" src="../dwr/interface/AjaxProjectService.js"></script>
        <script type="text/javascript" src="../js/lib/task.js"></script>             
    </head>
    <body  id="dt_example" class="example_alt_pagination">
        <jsp:include page="header.jsp" />        
        <br>      
        <div id="taskTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="right" > 
            <a id="createANewTask">Create a new task<font size="1"> >> </font></a>
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
                   
                </tbody>                
            </table>    
        </div>
        <div id="newTaskContainer" style="display:none" align="center">
            <a  id="backToTaskList"><font size="1"><< </font>Back to task list</a><br><br>
            <table>
                <tr>
                    <td>
                        <table>
                            <tr>
                                <td> Title <font color="RED">*</font> <br>
                                <input id="title" name="title" value="" maxlength="40" size="50" type="text"/>
                            </tr>
                            <tr>
                                <td><br></td>
                            </tr>
                            <tr>
                                <td>Project <br>
                                    <select name="project" id="project">
                                        <option value="In Progess">Todo</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><br></td>
                            </tr>
                            <tr>
                                <td>Priority <br>                    
                                    <input type="radio" name="priority" value="High"  /> High
                                    <input type="radio" name="priority" value="Medium" checked="checked"/> Medium
                                    <input type="radio" name="priority" value="Low"  /> Low
                                </td>
                            </tr>
                            <tr>
                                <td><br></td>
                            </tr>                        
                            
                            <tr>
                                <td>Assign-To <br>
                                <select name="assignTo" id="assignTo">                        
                                </select>
                            </tr>
                            <tr>
                                <td><br></td>
                            </tr> 
                            <tr>
                                <td>End Time       Estimated time<br>
                                    <input id="deadline" name="deadline" value="" maxlength="3" size="3" type="text" /><small>mins (eg: 10, 120)</small>
                                </td>
                            </tr> 
                        </table>      
                    </td>
                    <td valign="top">
                        <table>
                            <tr>
                                <td>Description<br>
                                <textarea name="description" rows="16" cols="50"></textarea></td>
                            </tr>
                        </table>
                    </td>
                </tr>   
                <tr>                    
                    <td>
                        <input type="button" value="Create new task" onclick="writePerson()"/>                                
                        <input type="button" value="Cancel" onclick="clearPerson()"/>
                    </td>   
                </tr>  
            </table>
        </div>
    </body>
</html>
