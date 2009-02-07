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
                <img alt="New Task" title="Create new Task" src="../images/add.png" class="taskEditDiv"></img><a class="taskEditDiv" id="taskEditDivId" href='javascript:void(0);'>New task</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="Help" title="Help" src="../images/info.png" class=""></img><a href="javascript:void(0);" id="abbrevationsId">Abbrevations</a>
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
                
                <jsp:include page="abbrevations.jsp" />
            </div>
            <div id="detailReports" align="center" style="display:none">
                <br><br>
                <b>Users </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Projects</b><br>
                <select id="usersDDReports"></select>&nbsp;<img id='refreshUserReport' title='Refresh' src='../images/refresh.png' />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select id="projectDDReports"></select>&nbsp;<img id='refreshProjectReport' title='Refresh' src='../images/refresh.png' />
                <div id="reportsArea"></div>
            </div>

            <br>
            <div id="newTaskContainer" style="display:none; border-width:thin; border-style:solid" align="center">
                <div id="container">
                    <table>
                        <tr>
                            <td> <b>Title <font color="RED">*</font> </b></td><td>
                                <input id="title" name="title" value="" maxlength="90" size="80" type="text" title="Task summary"/>
                            </td>
                        </tr>

                        <tr><td><b>Project</b> </td>
                                <td><select name="projectDD" id="projectDD" title="projects">
                                </select>
                            </td>
                        </tr>
                        <tr>
                        <td> <b>Priority</b> </td><td>
                            <select name="priority" id="priority" title="priority">
                                <option>Low</option>
                                <option selected>Medium</option>
                                <option>High</option>
                            </select>
                        </td>
                        <tr> <td> <b> Status </b> </td><td>
                            <select name="status" id="status" title="status">
                                <option>New</option>
                                <option>In Progress</option>
                                <option>On Hold</option>
                                <option>Completed</option>
                            </select>
                        </td>
                        <tr>
                            <td> <b> Assign-To</b></td><td>
                                <select name="assignToDD" id="assignToDD" title="users">
                                </select>
                                <input type="checkbox" id="copyTask" title="Copy Task to other users"> <small> Copy Many </small>
                            </td>
                        </tr>
                        <tr><td><b> Estimated Hours </b> </td><td>
                                <input id="estimatedHours" name="estimatedHours" value="" maxlength="4" size="4" type="text" title="estimated hours to finish task"/> &nbsp;&nbsp;&nbsp; 
                                <input id="totalEstimatedHours" name="totalEstimatedHours" value="" maxlength="4" size="4" type="text" title="total Estimaged Hours" disabled/> <small>Total Estimated Hours</small>
                            </td>
                        </tr>

                        <tr><td><b>Hours Spend</b></td><td>
                                <input id="hoursSpend" name="hoursSpend" value="" maxlength="4" size="4" type="text" title="add time spend on task"/> &nbsp;&nbsp;&nbsp;
                                <input id="totalHoursSpend" name="totalHoursSpend" value="" maxlength="4" size="4" type="text" title="total time spend on task" disabled/> <small>Total Hours spend</small>
                        </td></tr>

                        <tr><td><b>Finish By</b></td><td>
                                <input id="deadline" name="deadline" value="" type="text" size="10" maxlength="10" title="last date to finish task" /><small>(dd Mon yyyy)</small>
                            </td>
                        </tr>
                        <tr>
                            <td> <b>cc </b></td><td>
                            <input id="notificationEmails" name="notificationEmails" value="" maxlength="90" size="80" type="text" title="email will be send to all addresses mentioned hear on this task progress"/>
                            <small> (abc@example.com, ..)</small></td>
                        </tr>
                        
                        <tr>
                            <br>
                            <td><b>Description</b></td><td>
                                <textarea id="description" rows="5" cols="70" title="detail description and comments on this task"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <br>
                            <td><b></b> <img src="../images/comment.JPG" align="Comment" title="comment"/></td><td>
                                <input id="comment" name="comment" value="" maxlength="90" size="80" type="text" title="Comments"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td align="right">
                                <input type="button" value="Clear" id="clear" title="clear all fields"/>&nbsp;
                                <input type="button" value="Delete" id="delete" title="deletes task"/>&nbsp;
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
