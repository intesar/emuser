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
        <script src="../js/transendent-date-range-picker/init.js"  type="text/javascript"></script> 
        <script type="text/javascript" src="../js/transendent-date-range-picker/ui.datepicker.js"></script>
        <link href="../js/transendent-date-range-picker/demoPages.css"  media="screen" rel="Stylesheet" type="text/css" />
        <link type="text/css" href="../js/transendent-date-range-picker/screen.css"  media="screen" rel="Stylesheet" />
        <!-- the following 2 links are for running this demo page -->
        <script type="text/javascript" src="../js/transendent-date-range-picker/demoScripts.js" ></script>
        <style type="text/css">
            div.rangePicker { width: 250px; margin: .5em 0;}
        </style>
        <script type='text/javascript' src='../dwr/interface/AjaxTaskService.js'></script>
        <script type="text/javascript" src="../js/lib/task.js"></script>  
        
    </head>
    <body  id="dt_example" class="example_alt_pagination" style="width:100%; height:100%;">
        <jsp:include page="header.jsp" />        
        <br>   
        <div style="position:absolute; left:5%; top:10%; bottom:5%; width:70%; height:90%; ">
            <div id="taskTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="center" > 
                <div id="container">                    
                    
                    <a id="createANewTask">Create a new task<font size="1"> >> </font></a>
                    <br><br>
                    <div align="left">
                        <a id="advanceSearch" rel="facebox">Advance Search</a>
                    </div>
                    <div style="display:none" id="advanceSearchDiv" align="left">
                        <table>
                            <tr>
                                <td>Projects<br><select name="projectsDropdown">
                                        <option>All</option>
                                        <option>Todo</option>
                                    </select>
                                </td>
                                <td>Users<br><select name="usersDropdown">
                                        <option>Me</option>
                                    </select>
                                </td>                    
                                <td><div class="rangePicker futureRange">            
                                        <input type="text" name="start_date" id="start_date" value="mm/dd/yyyy" />            
                                        <input type="text" name="end_date" id="end_date" value="mm/dd/yyyy" />
                                </div></td>
                                <td>
                                    <input type="button" value="Current Task" id="currentTask" />
                                    <input type="button" value="All Task" id="allTask" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <table   id="taskTable" cellpadding="0" cellspacing="0" border="0" class="display" >                        
                        <thead>
                            <tr>                                                                                                                             
                                <th>Title</th>
                                <th>Project</th>                                
                                <th>End Date</th>                                
                                <th>Assign-To</th>                                
                                <th></th>
                            </tr>
                        </thead>                
                        <tbody> 
                            <!-- this row is required by the datatable plugin to work -->
                            <tr><td></td><td></td><td></td><td></td><td></td></tr>
                        </tbody>                
                    </table>    
                </div>
                <p>
                    <a id="printTaskTable">Print Above List</a>
                </p>
            </div>
            <div id="newTaskContainer" style="display:none" align="center">
                <div id="container">
                    <a  id="backToTaskList"><font size="1"><< </font>Back to task list</a><br><br>
                    <table>
                        <tr>
                            <td valign="top">
                                <table>
                                    <tr>
                                        <td>Description<br>
                                        <textarea name="description" rows="16" cols="50"></textarea></td>
                                    </tr>
                                </table>
                            </td>
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
                                                <option>Todo</option>
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
                                            <option>--NONE--</option>
                                            <option>Me</option>
                                        </select>
                                    </tr>
                                    <tr>
                                        <td><br></td>
                                    </tr> 
                                    <tr>
                                        <td>Estimated Hours <br>
                                            <input id="estimatedHours" name="estimatedHours" value="" maxlength="5" size="5" type="text" /><small> (eg: 0.5, 5, 12)</small>
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td>Finish By <br>
                                            <input id="deadline" name="deadline" value="" type="text" />
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td>Notification Emails<br>
                                            <input id="notificationEmails" name="notificationEmails" value="" size="50" type="text" /><small> (comma seperated)</small>
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td><br></td>
                                    </tr>
                                </table>      
                            </td>
                            
                        </tr>   
                        <tr>        
                            <td></td>
                            <td>
                                <input type="button" value="Create new task" id="createNewTask"/>                                
                                <input type="button" value="Cancel" />
                            </td>   
                        </tr>  
                    </table>
                </div>
            </div>
        </div>
        <div id="pc" style="position:absolute; left:67%; top:20%; bottom:0; width:15%; height:90%; "></div>        
        
    </body>
</html>
