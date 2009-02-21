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
    <body class="example_alt_pagination" style="width:100%; height:100%;">
        <jsp:include page="header.jsp" />
        <jsp:include page="banner.jsp" />
        <div id='leftDiv'>
            <div id="searchDiv" align="right" >
                <select name="projectStatusDropdown" id="projectStatusDropdown" title="Task Search by status" style="width:180px">
                    <option>Current Task</option>
                    <option>Completed Task</option>
                    <option>All Task</option>
                    <option>Find by Task ID</option>
                </select>&nbsp;
                <img id='refreshTask' title='Refresh' src='../images/reset.gif' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="taskEditDiv" id="taskEditDivId" href='javascript:void(0);'>New task</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <!--<a class="ReportsDiv" id="reportsDivId" href='javascript:void(0);'>Reports</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
            </div>
            <div id="taskTableContainer" align="left" >
                <div id="container">
                    <table   id="taskTable" cellpadding="0" cellspacing="0" border="0" class="display" >
                        <thead>
                            <tr>
                                <th>Task</th>
                                <th>Status</th>
                                <th>Project</th>
                                <th>Assign-To</th>
                                <th>Priority</th>
                                <th>Summary</th>
                                <th>Comp Dt </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- this row is required by the datatable plugin to work -->
                            <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                        </tbody>
                    </table>
                </div>

                <jsp:include page="abbrevations.jsp" />
            </div>
            <div id="detailReports" align="center" style="display:none; border-width:thin; border-style:solid">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <img alt="Task Area" title="Displays Tasks" src="../images/back.png" class="workspaceDiv"></img><a class="workspaceDiv" href="javascript:void(0);"> Close </a>
                </div>
                <br>
                <table>
                    <tr><td>Users</td><td><select id="usersDDReports" style="width:180px"></select></td><td><img id='refreshUserReport' title='Refresh' src='../images/refresh.png' /></td></tr>
                    <tr><td>Projects</td><td><select id="projectDDReports" style="width:180px"></select></td><td><img id='refreshProjectReport' title='Refresh' src='../images/refresh.png' /></td></tr>
                </table>

                <div id="reportsArea"></div>
                <br>
            </div>

            <br>
            <div id="taskViewContainer" style="display:none; border-width:thin; border-style:solid; border:1px solid #BBC1B4;" align="center">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <a href="javascript:void();" id="editMode">  Edit </a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="workspaceDiv" href="javascript:void(0);"> Close </a>
                </div>
                <br>
                <div id="taskViewDiv"></div>
            </div>
            <div id="newTaskContainer" style="display:none; border-width:thin; border-style:solid; border:1px solid #BBC1B4;" align="center">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <a class="workspaceDiv" href="javascript:void(0);"> Close </a>
                </div>
                <form class="taskForm" method="post">
                    <table style="width:90%" cellspacing="6">
                        <thead><tr><td style="width:15%"></td><td style="width:50%"></td><td style="width:10%"></td><td style="width:35%"></td></tr></thead>
                        <tr><td class="taskLabel">ID</td><td colspan="3">
                                <span id="id"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class="taskLabel"> Summary <font color="RED">*</font> </td><td colspan="3">
                                <input id="title" name="title" value="" maxlength="90" size="80" type="text" title="Task summary" style="width:100%"/>
                            </td>
                        </tr>
                        <tr><td class="taskLabel">Project</td>
                        <td><select name="projectDD" id="projectDD" title="projects" style="width:180px">
                            </select>
                        </td>
                        <td class="taskLabel">Priority</td><td>
                            <select name="priority" id="priority" title="priority" style="width:180px">
                                <option>Low</option>
                                <option selected>Medium</option>
                                <option>High</option>
                            </select>
                        </td>
                        <tr class="taskLabel">
                            <td class="taskLabel"> Assign-To</td><td>
                                <select name="assignToDD" id="assignToDD" title="users" style="width:180px">
                                </select>&nbsp;&nbsp;
                                <input type="checkbox" id="copyTask" title="Copy Task to other users"> <small>&nbsp; (Copy Many) </small>
                            </td>
                            <td> Status </td><td>
                                <select name="status" id="status" title="status" style="width:180px">
                                    <option>New</option>
                                    <option>In Progress</option>
                                    <option>On Hold</option>
                                    <option>Completed</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td class="taskLabel">Add estimated time </td><td>
                                <input id="estimatedHours" name="estimatedHours" value="" maxlength="4" size="4" type="text" title="estimated hours to finish task"  style="width:75px"/> &nbsp;&nbsp;&nbsp;
                                <span id="totalEstimatedHours" name="totalEstimatedHours" > </span>
                            </td>
                            <td class="taskLabel">Add effort</td><td>
                                <input id="hoursSpend" name="hoursSpend" value="" maxlength="4" size="4" type="text" title="add time spend on task"  style="width:75px"/> &nbsp;&nbsp;&nbsp;
                                <span id="totalHoursSpend" name="totalHoursSpend" > </span>
                        </td></tr>
                        <tr><td class="taskLabel">Complete by</td><td colspan="3">
                                <input id="deadline" name="deadline" value="" type="text" size="10" maxlength="10" title="last date to finish task"  style="width:175px"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="taskLabel">Email cc </td><td colspan="3">
                                <input id="notificationEmails" name="notificationEmails" value="" maxlength="90" size="80" type="text" title="email will be send to all addresses mentioned hear on this task progress" style="width:100%"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="taskLabel">Description</td><td colspan="3">
                                <textarea id="description" rows="5" cols="70" title="detail description and comments on this task" style="width:100%"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="taskLabel">Comment</td><td colspan="3">
                                <input id="comment" name="comment" value="" maxlength="90" size="80" type="text" title="Comments" style="width:100%"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td align="right" colspan="3">
                                <a href="javascript:void(0);" id="delete" title="deletes task">Delete Task</a>&nbsp;&nbsp;
                                <input type="button" value="Clear" id="clear" title="clear all fields"/>&nbsp;&nbsp;
                                <input type="submit" value="Save" class="saveTask" title="saves task information to database" style="width:100px" />
                            </td>
                        </tr>
                    </table>
                </form>
                <br>
            </div>
        </div>

        <div id="rightDiv">
            <select id="reportsSelect" style="width:180px"></select>&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="randomReports" id="randomReports" value="ON" checked="checked" /><font face="Arial, sans-serif" color="#6f6f6f" size="-1"> random</font>
            <div id="graphDiv">
                <div id="reportDiv" title="Random User & Project Report, changes every 30 secs">
                    <pre>Loading User|Project Reports ...</pre>
                    <pre>Automatically updates</pre>
                </div>
            </div>
            <br>
            <font face="Arial, sans-serif" color="#6f6f6f" size="-1"> Recent Completed</font>
            <div id="newsDiv" title="Recent completed task">
                <pre>Loading recent completed Task ...</pre>
                <pre>Automatically updates</pre>
            </div>
        </div>
        <ul id="myMenu" class="contextMenu">
            <li class="edit"><a href="#edit">Edit</a></li>
            <li class="view"><a href="#view">View Details</a></li>
            <li class="high separator"><a href="#high">High</a></li>
            <li class="inprogress separator"><a href="#inprogress">In-Progress</a></li>
            <li class="completed"><a href="#completed">Completed</a></li>
            <li class="assignme separator"><a href="#assignme">Assign Me</a></li>
            <li class="delete separator"><a href="#delete">Delete</a></li>
        </ul>
    </body>
</html>
