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
        <div id='leftDiv' >
            <div align="right" >
                <select name="projectStatusDropdown" id="projectStatusDropdown" title="Task Search by status" style="width:180px">
                    <option>Current Task</option>
                    <option>Completed Task</option>
                    <option>All Task</option>
                    <option>Find by Task ID</option>
                </select>&nbsp;
                <img id='refreshTask' title='Refresh' src='../images/refresh.png' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="taskEditDiv" id="taskEditDivId" href='javascript:void(0);'>New task</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="ReportsDiv" id="reportsDivId" href='javascript:void(0);'>Reports</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            </div>
            <div id="taskTableContainer" align="left" >
                <div id="container">
                    <table   id="taskTable" cellpadding="0" cellspacing="0" border="0" class="display" >
                        <thead>
                            <tr>
                                <th>Task ID</th>
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

                <jsp:include page="abbrevations.jsp" />
            </div>
            <div id="detailReports" align="center" style="display:none; border-width:thin; border-style:solid">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <img alt="Task Area" title="Displays Tasks" src="../images/back.png" class="workspaceDiv"></img><a class="workspaceDiv" href="javascript:void(0);">Back</a>
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
            <div id="taskViewContainer" style="display:none; border-width:thin; border-style:solid" align="center">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <a href="javascript:void();" id="editMode">Edit</a>&nbsp;&nbsp;
                    <img alt="Task Area" title="Displays Tasks" src="../images/back.png" class="workspaceDiv"></img><a class="workspaceDiv" href="javascript:void(0);">Back</a>
                </div>
                <table>
                    <tr>
                        <td> Title </td><td>
                            <label id="titleV">Hello</label>
                        </td>
                    </tr>

                </table>
                <br>
            </div>
            <div id="newTaskContainer" style="display:none; border-width:thin; border-style:solid" align="center">
                <div align="right" style="position:relative; right:2%; top:2%; height:5%;">
                    <img alt="Task Area" title="Displays Tasks" src="../images/back.png" class="workspaceDiv"></img><a class="workspaceDiv" href="javascript:void(0);">Back</a>
                </div>
                <table>
                    <tr>
                        <td></td>
                        <td align="right">
                        <input type="button" value="Save" class="saveTask" title="saves task information to database"/> </td>
                    </tr>
                    <tr>
                        <td> Title <font color="RED">*</font> </td><td>
                            <input id="title" name="title" value="" maxlength="90" size="80" type="text" title="Task summary" style="width:600px"/>
                        </td>
                    </tr>
                    <tr><td>Project</td>
                        <td><select name="projectDD" id="projectDD" title="projects" style="width:180px">
                            </select>
                        </td>
                    </tr>
                    <tr>
                    <td>Priority</td><td>
                        <select name="priority" id="priority" title="priority" style="width:180px">
                            <option>Low</option>
                            <option selected>Medium</option>
                            <option>High</option>
                        </select>
                    </td>
                    <tr> <td> Status </td><td>
                        <select name="status" id="status" title="status" style="width:180px">
                            <option>New</option>
                            <option>In Progress</option>
                            <option>On Hold</option>
                            <option>Completed</option>
                        </select>
                    </td>
                    <tr>
                        <td> Assign-To</td><td>
                            <select name="assignToDD" id="assignToDD" title="users" style="width:180px">
                            </select>&nbsp;&nbsp;
                            <input type="checkbox" id="copyTask" title="Copy Task to other users"> <small>&nbsp; (Copy Many) </small>
                        </td>
                    </tr>
                    <tr><td>Estimated Hours </td><td>
                            <input id="estimatedHours" name="estimatedHours" value="" maxlength="4" size="4" type="text" title="estimated hours to finish task"  style="width:75px"/> &nbsp;&nbsp;&nbsp;
                            <input id="totalEstimatedHours" name="totalEstimatedHours" value="" maxlength="4" size="4" type="text" title="total Estimaged Hours" disabled  style="width:75px"/> <small>&nbsp; (Total Estimated Hours)</small>
                        </td>
                    </tr>

                    <tr><td>Hours Spend</td><td>
                            <input id="hoursSpend" name="hoursSpend" value="" maxlength="4" size="4" type="text" title="add time spend on task"  style="width:75px"/> &nbsp;&nbsp;&nbsp;
                            <input id="totalHoursSpend" name="totalHoursSpend" value="" maxlength="4" size="4" type="text" title="total time spend on task" disabled  style="width:75px"/> <small>&nbsp; (Total Hours spend)</small>
                    </td></tr>

                    <tr><td>Finish By</td><td>
                            <input id="deadline" name="deadline" value="" type="text" size="10" maxlength="10" title="last date to finish task"  style="width:175px"/><small>&nbsp; (dd Mon yyyy)</small>
                        </td>
                    </tr>
                    <tr>
                        <td>Email cc </td><td>
                            <input id="notificationEmails" name="notificationEmails" value="" maxlength="90" size="80" type="text" title="email will be send to all addresses mentioned hear on this task progress" style="width:600px"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Description</td><td>
                            <textarea id="description" rows="5" cols="70" title="detail description and comments on this task" style="width:600px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>Add comment</td><td>
                            <input id="comment" name="comment" value="" maxlength="90" size="80" type="text" title="Comments" style="width:600px"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="right">
                            <input type="button" value="Clear" id="clear" title="clear all fields"/>&nbsp;
                            <input type="button" value="Delete" id="delete" title="deletes task"/>&nbsp;
                            <input type="button" value="Save" class="saveTask" title="saves task information to database"/>
                        </td>
                    </tr>
                </table>
                <br>
            </div>
        </div>

        <div id="rightDiv">
            <div id="reportDiv" title="Random User & Project Report, changes every 30 secs">
                <pre>Loading User|Project Reports ...</pre>
                <pre>Automatically updates</pre>
            </div>
        </div>
        <br>
        <div id="rightBottomDiv" title="Recent completed task">
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
