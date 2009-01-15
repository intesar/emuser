// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#taskTable').dataTable( {             
        "sDom": '<"top"i>rt<"bottom"flp<"clear">',
        "aoData": [null,null,null,null,null,{"sWidth":"250px"},null]        
    } );
    
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var tasksCache = {};
    var viewed = null;
    var projectDDCache = {};
    var usersDDCache = {};
   
    var taskList = function (tasks) {        
        var dArray = new Array();
        // Delete all the rows from table
        oTable.fnClearTable();
        for ( var i = 0 ; i < tasks.length; i++) {             
            // create object                        
            var project = tasks[i].projectName; if ( project == null) project = "<img src='../images/todo.png' title='Todo' />";            
            var deadline = tasks[i].deadlineFormat; if (deadline == null ) {deadline = "NA"} else {deadline = deadline.substr(0, 6);};
            var title = tasks[i].title ;
            var assignedUser = tasks[i].assignedToName; 
            if ( assignedUser == 'me') {assignedUser = "<img src='../images/user.png' title='Me' />";}
            else if ( assignedUser == '') {assignedUser = "<img src='../images/add-user.png' title='None' />";}
            var status = tasks[i].status;
            if ( status == 'In Progress') {status = "<img src='../images/in_progress.png' title='In Progress' />";}
            else if ( status == 'Completed') {status = "<img src='../images/completed.png' title='Completed' />";}
            var priority = tasks[i].priority;        
            if ( priority == "High") { priority = "<img src='../images/high_priority.png' title='High' />";}
            var data = [ tasks[i].id , status, project, assignedUser, priority, title, deadline];                                  
            tasksCache[tasks[i].id] = tasks[i];            
            dArray[i] = data;                
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
        
    }
    // executed onload returns current task
    AjaxTaskService.getCurrentTask("Current Task", taskList);
    
    // priority change 
    function changeTaskPriorityToHigh ( taskId) {
        var task = tasksCache[taskId];
        if ( task.priority != 'High') {
            AjaxTaskService.changeTaskPriority(taskId, 'High', function() {                
                $.jGrowl( "Task # " + taskId + " is marked High Priority!");
            });
        } else {
            $.jGrowl( "Task # " + taskId + " is already has a High Priority!");
        }
    }
    // status change 
    function changeTaskStatus ( taskId, status) {
        var task = tasksCache[taskId];
        if ( task.status != status) {
            AjaxTaskService.changeTaskStatus(taskId, status, function() {                
                $.jGrowl( "Task # " + taskId + " is marked " + status + " !");
            });
        } else {
            $.jGrowl( "Task # " + taskId + " is already " + status + " !");
        }
    }
    
    function deleteTask ( taskId ) {
        var task = tasksCache[taskId];
        if (task.isOwner == true ) {
            AjaxTaskService.deleteTask ( taskId, function(data) {            
                $.jGrowl( "Task # " + taskId + " deleted successfully!");
                taskList(data);
            });
        }else {
            $.jGrowl( 'Only Admin, Project Manager or Owner can delete task');
            alert ('Only Admin, Project Manager or Owner can delete task');
        }
    }
    function assignMe ( taskId ) {                
        AjaxTaskService.assignTaskUser ( taskId, null, function() {            
            $.jGrowl( "Task # " + taskId + " assigned successfully!");
        });
        
    }
    
    // executed on "create new project" link is clicked
    $('.workspaceDiv').livequery ("click", function() {
        $('#taskTableContainer').slideDown('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideUp('fast');
    });
    $('.ReportsDiv').livequery ("click", function() {
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideDown('fast');
        $('#newTaskContainer').slideUp('fast');
    });
    
    $('.taskEditDiv').click(function() {    
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideDown('fast');
    });
    
    $('#taskTable tbody tr').livequery(function() {
        $(this).parent().parent().tableHover();
    });
    
    $("#deadline").date_input();

    // Show menu when a list item is clicked
    $("#taskTable td").livequery(function() {
        $(this).contextMenu({
            menu: 'myMenu'
        }, function(action, el, pos) {
            if ( action == 'edit') { var taskId = $(el).parent().children()[0].firstChild.data; showTaskForEdit(taskId);}
            if ( action == 'new') { $('.taskEditDiv').trigger('click');}
            else if ( action == 'high') { var taskId = $(el).parent().children()[0].firstChild.data; changeTaskPriorityToHigh(taskId);}
            else if ( action == 'inprogress') { var taskId = $(el).parent().children()[0].firstChild.data; changeTaskStatus(taskId, 'In Progress');}
            else if ( action == 'completed') { var taskId = $(el).parent().children()[0].firstChild.data; changeTaskStatus(taskId, 'Completed');}
            else if ( action == 'assignme') { var taskId = $(el).parent().children()[0].firstChild.data; assignMe(taskId);}
            else if ( action == 'delete') { var taskId = $(el).parent().children()[0].firstChild.data; deleteTask(taskId);}
        });
    });
    
    // open user in a modal for editinga
    $('#taskTable td').livequery( function () { 
        $(this).click(function () {             
            var taskId = $(this).parent().children()[0].firstChild.data;            
            showTaskForEdit( taskId );
        });
    });
    
    function showTaskForEdit( taskId) {        
        $('#clear').trigger('click');        
        var task = tasksCache[ taskId ];
        $('#title').val(task.title);        
        $('#estimatedHours').val(task.estimatedHours);
        $('#hoursSpend').val(task.spendHours);
        $('#notificationEmails').val(task.notificationEmails);
        $('#description').val(task.description);
        $('#projectDD').val(task.projectName);
        $('#assignToDD').val(task.assignedToUsername);
        $('#priority').val(task.priority);
        $('#status').val(task.status);
        $('#deadline').val(task.deadlineFormat);
        if ( task.isOwner == false ) {
            $('#title').attr('disabled', true);
            $('#estimatedHours').attr('disabled', true);                
            $('#notificationEmails').attr('disabled', true);
            $('#description').attr('disabled', true);
            $('#projectDD').attr('disabled', true);
            $('#assignToDD').attr('disabled', true);                                
            $('#deadline').attr('disabled', true);
        }            
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideDown('fast');
        viewed = taskId;
    }

    
    // executed on "clear" button is clicked
    $('#clear').click(function() {
        viewed = null;
        $('#title').val("");        
        $('#estimatedHours').val("");
        $('#hoursSpend').val("");
        $('#notificationEmails').val("");
        $('#description').val("");
        $('#title').attr('disabled', false);
        $('#estimatedHours').attr('disabled', false);                
        $('#notificationEmails').attr('disabled', false);
        $('#description').attr('disabled', false);
        $('#projectDD').attr('disabled', false);
        $('#assignToDD').attr('disabled', false);                                
        $('#deadline').attr('disabled', false);
    });
    // executed on "create new task" button is clicked
    $('#saveTask').click(function() {        
        var task1 = null;
        if ( viewed != null ) {
            task1 = tasksCache[viewed];
        }
        if ( task1 == null) {
            task1 = {id:null, title:null, deadline:null, deadlineFormat:null, priority:null, projectName:null, assignedToUsername:null, estimatedHours:null, notificationEmails:null, description:null};            
        }
        task1.title = $('#title').val();
        //task1.deadline = Date.parse($('#deadline').val());
        task1.priority = $('#priority').val();
        var proj = $('#projectDD').val();
        if ( "Todo" != proj ) {
            task1.projectId = proj;
            task1.projectName = projectDDCache[task1.projectId].projectName;
        }  else {
            task1.projectId = null;
            task1.projectName = null;
        }  
        task1.status = $('#status').val();            
        task1.spendHours = $('#hoursSpend').val();
        var u = $('#assignToDD').val();
        if ( u != "None") {
            task1.assignedToId = u;
            task1.assignedToUsername = usersDDCache[task1.assignedTo];
        }else {
            task1.assignedToId = null;
            task1.assignedToUsername = null;
        }  
        task1.estimatedHours = $('#estimatedHours').val();
        task1.deadlineFormat = $('#deadline').val();
        task1.notificationEmails = $('#notificationEmails').val();        
        task1.description = $('#description').val();        
        AjaxTaskService.saveTask(task1, function (tasks) {
            $.jGrowl( "Task saved successfully!");
            viewed = null;
            taskList(tasks);
        });
        //$('#clear').trigger("click");
    });
         
    $('#printTaskTable').click(function() {
        $.jPrintArea($('#taskTableContainer'));
    });
    
    $('#projectStatusDropdown').change(function() {
        var selectedStatus = $(this).val();       
        if ( selectedStatus == 'Find by Task ID') {
            var taskId = prompt("Enter Task ID : ", "");
            AjaxTaskService.getCurrentTask(taskId, taskList);
        } else {
            AjaxTaskService.getCurrentTask(selectedStatus, taskList);
        }
    });
    $('#advanceSearch').click(function() {
        $('#advanceSearchDiv').slideToggle('fast');
    });
    
    
    
    function displayProjectDDList(projectDDList) {        
        var options = "<option value='Todo'>Todo</option>";
        for ( var i = 0; i < projectDDList.length; i++ ) {
            options += "<option value='"+ projectDDList[i].projectId+"'>"+projectDDList[i].projectName + "</option>";
            projectDDCache[projectDDList[i].projectId] = projectDDList[i];
        }
        $('#projectDD').html(options);
    }
    $('#projectDD').livequery ('change', function() {
        var projectId =$(this).val();
        var _users = projectDDCache[projectId];
        var users = _users.users;
        var options = "<option value='None'>None</option>";
        for ( var i = 0; i < users.length; i++ ) {
            options += "<option value='" + users[i].id + "'>" + users[i].firstname + " " + users[i].lastname + "</option>";
        }
        $('#assignToDD').html (options );
    });
    
    projectDDList = function ( projectDDListData ) {
        displayProjectDDList ( projectDDListData );
    }
        
    AjaxProjectService.getProjectsForDropdown(projectDDList);
    
    function displayUsersDDList(usersDDList) {
        var options = "<option value='None'>None</option><option value='None'>me</option>";
        for ( var i = 0; i < usersDDList.length; i++ ) {
            options += "<option value='"+ usersDDList[i].id+"'>"+usersDDList[i].firstname + " " + usersDDList[i].lastname + "</option>";
            usersDDCache[usersDDList.id] = usersDDList[i];
        }
        $('#assignToDD').html(options);
    }
    usersDDList = function ( usersDDListData ) {
        displayUsersDDList ( usersDDListData );
    }
    AjaxUsersService.getActiveUserList(usersDDList);
    
    

    
    
    // --------------- reporting -----------------------------------//
    
    
    
    function displayReportFunction (data, divId) {
        $('#' + divId).empty();
        for ( var i = 0; i < data.length; i++ ) {
            var title = data[i].reportDate;
            var tasksAssigned = data[i].totalAssigned;
            var tasksCompleted = data[i].totalCompleted;
            var hoursAssigned = data[i].estimatedHours;
            var hoursDone = data[i].hoursSpend;
            var myCreatedTask = data[i].totalCreated;
            var api = new jGCharts.Api();             
            jQuery('<img>') 
            .attr('src', api.make({
                title       : title, 
                grid        : true,
                data : [[tasksAssigned, tasksCompleted, hoursAssigned, hoursDone, myCreatedTask]],
                axis_labels : [''],
                legend : ['Tasks Assigned '+tasksAssigned, 'Tasks Completed '+tasksCompleted,'Hours Assigned '+hoursAssigned,'Hours Done '+hoursDone,'My Created Tasks '+myCreatedTask]
            })).appendTo("#" + divId);	
        }
    }
    
    displayReport = function( data) {
        displayReportFunction(data, "reportDiv");
    }
    
    AjaxReportService.getUserReports(0, 2, displayReport);
    //AjaxReportService.getUserReportSummary(0, displaySummaryReport);
    $('.refreshReport').click(function() {        
        $.jGrowl( "Report refreshed successfully!");
        AjaxReportService.getUserReports(0, 2, displayReport);
        //AjaxReportService.getUserReportSummary(0, displaySummaryReport);
    })
    
});


    
