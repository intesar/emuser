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
    <body  id="" class="example_alt_pagination" style="width:100%; height:100%;">
        <jsp:include page="header.jsp" />
        <jsp:include page="banner.jsp" />
        <div id='leftDiv' >
            <div align="left" >
                <select name="projectStatusDropdown" id="projectStatusDropdown" title="Task Search by status">
                    <option>Current Task</option>
                    <option>Completed Task</option>
                    <option>All Task</option>
                    <option>Find by Task ID</option>
                </select>&nbsp;
                <img id='refreshTask' title='Refresh' src='../images/refresh.png' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="Task Area" title="Displays Tasks" src="../images/task.png" class="workspaceDiv"></img><a class="workspaceDiv" id="workspaceDivId">Task Area</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="Report Area" title="Displays Reports" src="../images/graph.png" class="ReportsDiv"></img><a class="ReportsDiv" id="reportsDivId" href='javascript:void(0);'>Report Area</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="New Task" title="Create new Task" src="../images/add.png" class="taskEditDiv"></img><a class="taskEditDiv" id="taskEditDivId" href='javascript:void(0);'>New task</a>
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
                                <th>End By </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- this row is required by the datatable plugin to work -->
                            <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                        </tbody>
                    </table>
                </div>
                <a href="javascript:void(0);" id="abbrevationsId">Abbrevations</a>
                <div id="abbrevations" style="display:none" align="center">
                    <table>
                        <tr>
                            <td><img src="../images/in_progress.png" ></td>
                            <td>Task status : In Progress</td>
                        </tr>
                        <tr>
                            <td><img src="../images/completed.png" ></td>
                            <td>Task status : Completed</td>
                        </tr>
                        <tr>
                            <td><img src="../images/todo.png" ></td>
                            <td>Todo</td>
                        </tr>
                        <tr>
                            <td><img src="../images/user.png" ></td>
                            <td>Task assigned to you</td>
                        </tr>
                        <tr>
                            <td><img src="../images/add-user.png" ></td>
                            <td>Task is not assigned</td>
                        </tr>
                        <tr>
                            <td><img src="../images/high_priority.png" ></td>
                            <td>Task Priority : High</td>
                        </tr>
                        <tr>
                            <td><img src="../images/empty-calendar.png" ></td>
                            <td>Task End Date : None</td>
                        </tr>
                        <tr>
                            <td><img src="../images/refresh.png" ></td>
                            <td>Refresh</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="detailReports" align="center" style="display:none">
                <br><br>
                <b>Users </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Projects</b><br>
                <select id="usersDDReports"></select><img id='refreshUserReport' title='Refresh' src='../images/refresh.png' />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select id="projectDDReports"></select><img id='refreshProjectReport' title='Refresh' src='../images/refresh.png' />
                <div id="reportsArea"></div>
            </div>

            <div id="newTaskContainer" style="display:none" align="center">
                <div id="container">
                    <table>
                        <tr>
                            <td> <b>Title <font color="RED">*</font> </b><br>
                            <input id="title" name="title" value="" maxlength="90" size="80" type="text" title="Task summary"/>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <table>
                                <tr><td><b>Project</b></td><td><b>Priority</b></td><td><b>Status</b></td><td><b>Assign-To</b></td><td><b>Assign Many</b></td></tr>
                                <tr valign="top"><td>
                                        <select name="projectDD" id="projectDD" title="projects">
                                        </select>
                                    </td>
                                    <td>
                                        <select name="priority" id="priority" title="priority">
                                            <option>Low</option>
                                            <option selected>Medium</option>
                                            <option>High</option>
                                        </select>
                                    </td>
                                    <td><select name="status" id="status" title="status">
                                            <option>New</option>
                                            <option>In Progress</option>
                                            <option>On Hold</option>
                                            <option>Completed</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="assignToDD" id="assignToDD" title="users">
                                        </select>
                                    </td>
                                    <td>
                                        <input type="checkbox" id="copyTask" title="Copy Task to other users">
                                    </td>
                                </tr>
                            </table>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <table>
                                <tr><td><b>Est Hours</b></td><td><b>Hours Spend</b></td><td><b>Finish By</b></td></tr>
                                <tr>
                                    <td> <input id="estimatedHours" name="estimatedHours" value="" maxlength="4" size="4" type="text" title="estimated hours to finish task"/>
                                    <td> <input id="hoursSpend" name="hoursSpend" value="" maxlength="4" size="4" type="text" title="actual time spend on task"/>
                                    <td><input id="deadline" name="deadline" value="" type="text" size="10" maxlength="10" title="last date to finish task"/><small>(dd Mon yyyy)</small></td>
                                </tr>
                            </table>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <td align="left"> <b>Notification Emails</b><small> (abc@example.com, ..)</small> <br>
                            <td><input id="notificationEmails" name="notificationEmails" value="" size="80" type="text" title="email will be send to all addresses mentioned hear on this task progress"/></td>
                        </tr>
                        <tr><td><br></td></tr>
                        <tr>
                            <br>
                            <td><b>Description</b><br>
                                <textarea id="description" rows="5" cols="70" title="detail description and comments on this task"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <br>
                            <td align="right">
                                <input type="button" value="Clear" id="clear" title="clear all fields"/>
                                <input type="button" value="Save" id="saveTask" title="saves task information to database"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <div id="rightDiv">
            <div id="reportDiv" title="Randomly displays User Report">
                <pre>Loading User|Project Reports ...</pre>
                <pre>Automatically updates</pre>
            </div>
        </div>

        <div id="rightBottomDiv" title="Recently Completed Task">
            <pre>Loading recent completed Task ...</pre>
            <pre>Automatically updates</pre>
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
