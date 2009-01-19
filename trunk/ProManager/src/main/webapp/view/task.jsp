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
        <title>Grow-Fast Dashboard</title>   
        <jsp:include page="include.jsp" />   
        <script type='text/javascript' src='../dwr/interface/AjaxTaskService.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxProjectService.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxReportService.js'></script>
        <script type='text/javascript' src='../js/lib/jgcharts.js'></script>
        <script type='text/javascript' src='../js/local/task.js'></script>  
        <script type='text/javascript' src='../js/local/report.js'></script>        
    </head>
    <body  id="dt_example" class="example_alt_pagination" style="width:100%; height:100%;">
        <jsp:include page="header.jsp" />                
        <jsp:include page="banner.jsp" />       
        <div id='leftDiv' >
            <div align="center" >                         
                <select name="projectStatusDropdown" id="projectStatusDropdown">
                    <option>Current Task</option>
                    <option>Completed Task</option>
                    <option>All Task</option>
                    <option>Find by Task ID</option>
                </select>&nbsp;
                <img id='refreshTask' title='Refresh' src='../images/refresh.png' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="Task Area" src="../images/task.png" class="workspaceDiv"></img><a class="workspaceDiv" href='javascript:void(0);'>Task Area</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="Report Area" src="../images/graph.png" class="ReportsDiv"></img><a class="ReportsDiv" href='javascript:void(0);'>Report Area</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="New Task" src="../images/add.png" class="taskEditDiv"></img><a class="taskEditDiv" href='javascript:void(0);'>New task</a>                        
            </div>   
            <div id="taskTableContainer" align="left" > 
                <div id="container">                                               
                    <table   id="taskTable" cellpadding="0" cellspacing="0" border="0" class="display" >                        
                        <thead>
                            <tr>    
                                <th>#</th>
                                <th>Status</th>
                                <th>Project</th>
                                <th>Assign-To</th>                                
                                <th>Priority</th>
                                <th>Title</th>                                                                                                                              
                                <th>End By</th>
                            </tr>
                        </thead>                
                        <tbody> 
                            <!-- this row is required by the datatable plugin to work -->
                            <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                        </tbody>                
                    </table>   
                </div>
            </div>
            <div id="detailReports" align="center" style="display:none">   
                <br><br>
                <b>Users</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Projects</b><br>
                <select id="usersDDReports"></select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select id="projectDDReports"></select>
                <div id="reportsArea"></div>
            </div>
            
            <div id="newTaskContainer" style="display:none" align="center">
                <div id="container">                    
                    <table>
                        <tr>
                            <td> <b>Title <font color="RED">*</font> </b><br>
                            <input id="title" name="title" value="" maxlength="90" size="80" type="text"/>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <table>
                                <tr><td><b>Project</b></td><td><b>Status</b></td><td><b>Priority</b></td><td><b>Assign-To</b></td><td><b>Assign Many</b></td></tr>
                                <tr valign="top"><td>
                                        <select name="projectDD" id="projectDD">
                                        </select>
                                    </td>                                    
                                    <td>
                                        <select name="priority" id="priority">
                                            <option>Low</option>
                                            <option selected>Medium</option>
                                            <option>High</option>
                                        </select>
                                    </td>
                                    <td><select name="status" id="status">
                                            <option>New</option>
                                            <option>In Progress</option>
                                            <option>On Hold</option>
                                            <option>Completed</option>
                                        </select>
                                    </td>
                                    <td>                                         
                                        <select name="assignToDD" id="assignToDD" >                                          
                                        </select>
                                    </td>
                                    <td>
                                        <input type="checkbox" id="copyTask" title="Copy Task">
                                    </td>
                                </tr>
                            </table>
                        </tr>             
                        <tr><td><br></td></tr>
                        <tr>
                            <table>
                                <tr><td><b>Est Hours</b></td><td><b>Hours Spend</b></td><td><b>Finish By</b></td></tr>
                                <tr>
                                    <td> <input id="estimatedHours" name="estimatedHours" value="" maxlength="5" size="5" type="text" />
                                    <td> <input id="hoursSpend" name="hoursSpend" value="" maxlength="5" size="5" type="text" />
                                    <td><input id="deadline" name="deadline" value="" type="text" size="10" maxlength="10" /><small>(dd Mon yyyy)</small></td>
                                </tr>
                            </table>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <td align="left"> <b>Notification Emails</b><small> (abc@example.com, ..)</small> <br> 
                            <td><input id="notificationEmails" name="notificationEmails" value="" size="80" type="text" /></td>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <br>
                            <td><b>Description</b><br>
                                <textarea id="description" rows="5" cols="70"></textarea>
                            </td>
                        </tr>
                        <tr>                  
                            <br>
                            <td align="right">
                                <input type="button" value="Clear" id="clear"/>                                
                                <input type="button" value="Save" id="saveTask"/>                                
                            </td>   
                        </tr>  
                    </table>
                </div>            
            </div>
        </div>
        
        <div id="rightDiv">
            <!--<img src="../images/refresh.png" class="refreshReport" />
            <a class="refreshReport" href="javascript:void(0);">Refresh</a> -->
            <div id="reportDiv"></div>
            <div id="reportSummaryDiv"></div>            
        </div>        
        
        <div id="rightBottomDiv" title="Recently Completed Task">
            
        </div>
        <ul id="myMenu" class="contextMenu">
            <li class="edit"><a href="#edit">Edit</a></li>
            <li class="new"><a href="#new">New</a></li>
            <li class="high separator"><a href="#high">High Priority</a></li>
            <li class="inprogress separator"><a href="#inprogress">In Progress</a></li>
            <li class="completed"><a href="#completed">Completed</a></li>
            <li class="assignme separator"><a href="#assignme">Assign Me</a></li>
            <li class="delete separator"><a href="#delete">Delete</a></li>            
        </ul>
    </body>
</html>
