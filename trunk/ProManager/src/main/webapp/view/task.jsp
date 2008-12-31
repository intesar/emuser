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
        <!--
        <script src="../js/transendent-date-range-picker/init.js"  type="text/javascript"></script> 
    <script type="text/javascript" src="../js/transendent-date-range-picker/ui.datepicker.js"></script>
    <link href="../js/transendent-date-range-picker/demoPages.css"  media="screen" rel="Stylesheet" type="text/css" />
    <link type="text/css" href="../js/transendent-date-range-picker/screen.css"  media="screen" rel="Stylesheet" />
    -->
    <!-- the following 2 links are for running this demo page -->
    <!--
    <script type="text/javascript" src="../js/transendent-date-range-picker/demoScripts.js" ></script>
    <style type="text/css">
        div.rangePicker { width: 250px; margin: .5em 0;}
    </style>
        -->
        <script type='text/javascript' src='../dwr/interface/AjaxTaskService.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxProjectService.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>
        <script type="text/javascript" src="../js/lib/task.js"></script>  
        
    </head>
    <body  id="dt_example" class="example_alt_pagination" style="width:100%; height:100%;">
        <jsp:include page="header.jsp" />        
        <br>   
        <div style="position:absolute; left:5%; top:10%; bottom:5%; width:70%; height:90%; ">
            <div id="taskTableContainer" style="width:90%; height:90%; border: 0px solid #000; padding: 5px; " align="center" > 
                <div id="container">    
                    <div>
                        <div align="left" > 
                            <!--<a id="advanceSearch">Advance Search</a>-->
                            <select name="projectStatusDropdown" id="projectStatusDropdown">
                                <option>Current Task</option>
                                <option>Completed Task</option>
                                <option>All Task</option>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a id="createANewTask">Create a new task<font size="1"> >> </font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a id="printTaskTable">Print</a>
                        </div>
                    </div>
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
            
        </div>
        <div id="newTaskContainer" style="display:none" align="left">
            <div id="container">                    
                <table>
                    <tr>
                        <td> Title <font color="RED">*</font> <br>
                        <input id="title" name="title" value="" maxlength="60" size="60" type="text"/>
                    </tr>
                    <tr>
                        <table>
                            <tr><td>Project </td><td>Assign-To</td><td>Priority </td><td>Status</td></tr>
                            <tr><td>
                                    <select name="projectDD" id="projectDD">
                                    </select>
                                </td>
                                <td> 
                                    <select name="assignToDD" id="assignToDD">     
                                    </select>
                                </td>
                                <td>
                                    <select name="priority" id="priority">
                                        <option>Low</option>
                                        <option selected>Medium</option>
                                        <option>High</option>
                                    </select>
                                </td>
                                <td>       <select name="status" id="status">
                                        <option>New</option>
                                        <option>In Progress</option>
                                        <option>On Hold</option>
                                        <option>Completed</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </tr>                        
                    <tr>
                        <table>
                            <tr><td>Estimated Hours</td><td>Hours Spend</td><td>Finish By</td></tr>
                            <tr>
                                <td> <input id="estimatedHours" name="estimatedHours" value="" maxlength="5" size="5" type="text" />
                                <td> <input id="estimatedHours" name="estimatedHours" value="" maxlength="5" size="5" type="text" />
                                <td> <div id="calendarDiv"><input id="deadline" name="deadline" value="" type="text" class="calendarSelectDate" /></div></td>
                            </tr>
                        </table>
                    </tr>
                    <tr>
                        <td> Notification Emails<br>
                            <input id="notificationEmails" name="notificationEmails" value="" size="50" type="text" /><small> (abc@example.com, ..)</small>                                
                        </td>
                    </tr>
                    <tr>
                        <br>
                        <td>Description<br>
                            <textarea id="description" rows="5" cols="50"></textarea>
                        </td>
                    </tr>
                    <tr>                  
                        <br>
                        <td>
                            <input type="button" value="Refresh" />
                            <input type="button" value="Save & Close" id="createNewTask"/>                                
                            <a href="javascript(0);">Add Comment</a>
                        </td>   
                    </tr>  
                </table>
            </div>
        </div>
        
        <div id="pc" style="position:absolute; left:67%; top:20%; bottom:0; width:15%; height:90%; "></div>        
        
    </body>
</html>
