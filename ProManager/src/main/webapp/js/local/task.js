// this function is executed on load 	
$(document).ready(function() {
    $('#abbrevationsId').click(function() { 
        $('#abbrevations').modal();
    });
    // checkout datatable plugin to understand below code
    oTable = $('#taskTable').dataTable( {             
        "sDom": '<"top"i>rt<"bottom"flp<"clear">',
        "aoData": [null,null,null,null,null,{
            "sWidth":"250px"
        },null]
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
            var deadline = tasks[i].deadlineFormat; if (deadline == null ) {
                deadline = "";//<img src='../images/empty-calendar.png' title='None' />"
            } else {
                deadline = deadline.substr(0, 6);
            }
            var title = tasks[i].title ;
            title += ' (' + tasks[i].estimatedHours + ')';
            var assignedUser = tasks[i].assignedToName; 
            if ( assignedUser == 'me') {
                assignedUser = "<img src='../images/user.png' title='Me' />";
            }
            else if ( assignedUser == '') {
                assignedUser = "<img src='../images/add-user.png' title='None' />";
            }
            var status = tasks[i].status;
            if ( status == 'In Progress') {
                status = "<img src='../images/in_progress.png' title='In Progress' />";
            }
            else if ( status == 'Completed') {
                status = "<img src='../images/completed.png' title='Completed' />";
            } else if ( status == 'On Hold') {
                status = "<img src='../images/on-hold.png' title='On Hold' />";
            }
            var priority = tasks[i].priority;        
            if ( priority == "High") { 
                priority = "<img src='../images/high_priority.png' title='High' />";
            }
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
                $('#clear').trigger('click');
                taskList(data);
            });
        }else {
            $.jGrowl( 'Only Admin, Project Manager or Owner can delete task');
            alert ('Only Admin, Project Manager or Owner can delete task');
        }
    }

    var taskIdViewed = null;

    $('#delete').livequery('click', function() {
        deleteTask(taskIdViewed);
        taskIdViewed = null;
    })
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
        $('#taskViewContainer').slideUp('fast');        
    });
    $('.ReportsDiv').livequery ("click", function() {
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideDown('fast');
        $('#newTaskContainer').slideUp('fast');
        $('#taskViewContainer').slideUp('fast');                
    });
    
    $('.taskEditDiv').click(function() {    
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideDown('fast');
        $('#taskViewContainer').slideUp('fast');
        $('#clear').trigger('click');
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
            var taskId = null;
            if ( action == 'edit') { 
                taskId = $(el).parent().children()[0].firstChild.data; taskIdViewed = taskId; showTaskForEdit(taskId);
            }
            if ( action == 'new') { 
                $('.taskEditDiv').trigger('click');
            }
            else if ( action == 'high') { 
                taskId = $(el).parent().children()[0].firstChild.data; changeTaskPriorityToHigh(taskId);
            }
            else if ( action == 'inprogress') { 
                taskId = $(el).parent().children()[0].firstChild.data; changeTaskStatus(taskId, 'In Progress');
            }
            else if ( action == 'completed') { 
                taskId = $(el).parent().children()[0].firstChild.data; changeTaskStatus(taskId, 'Completed');
            }
            else if ( action == 'assignme') { 
                taskId = $(el).parent().children()[0].firstChild.data; assignMe(taskId);
            }
            else if ( action == 'delete') { 
                taskId = $(el).parent().children()[0].firstChild.data; deleteTask(taskId);
            }
        });
    });
    
    // open user in a modal for editinga
    $('#taskTable td').livequery( function () { 
        $(this).click(function () {             
            var taskId = $(this).parent().children()[0].firstChild.data;            
            showTaskForView( taskId );
            taskIdViewed = taskId;
        });
    });

    function showTaskForView( taskId) {
        $('#clear').trigger('click');
        var task = tasksCache[ taskId ];
        var dynamicTable = "<table class='taskTable' style='width:80%'><tr><th></th><th></th></tr><tbody>";
        dynamicTable += "<tr><td class='taskLabel'>ID</td><td>" + task.id + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Summary</td><td>" + task.title + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Status</td><td>" + task.status + "</td></tr>";
        var projectName = (task.projectName!=null)? task.projectName : "Todo";
        dynamicTable += "<tr><td class='taskLabel'>Project</td><td>" + projectName + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Priority</td><td>" + task.priority + "</td></tr>";
        var assignedToName = (task.assignedToName!=null)?task.assignedToName : "";
        dynamicTable += "<tr><td class='taskLabel'>Assign-To</td><td>" + assignedToName + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Estimated Hours</td><td>" + task.estimatedHours + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Hours Spend</td><td>" + task.spendHours + "</td></tr>";
        var endBy = (task.deadlineFormat!=null)?task.deadlineFormat:"";
        dynamicTable += "<tr><td class='taskLabel'>End By</td><td>" + endBy + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Create By</td><td>" + task.ownerName + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Create Date</td><td>" + task.createDateFormat + "</td></tr>";
        var completedDate = (task.completedDate!=null)?task.completedDate:"";
        dynamicTable += "<tr><td class='taskLabel'>Completed Date</td><td>" + completedDate + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Email cc</td><td>" + task.notificationEmails + "</td></tr>";
        dynamicTable += "<tr><td class='taskLabel'>Description</td><td>" + task.description + "</td></tr>";
        dynamicTable += "</tbody></table> <br><br>"
        $('#taskViewDiv').html(dynamicTable);
        viewed = taskId;
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideUp('fast');
        $('#taskViewContainer').slideDown('fast');
    }
    $('#editMode').livequery("click", function() {
        showTaskForEdit(viewed);
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#newTaskContainer').slideDown('fast');
        $('#taskViewContainer').slideUp('fast');
    })
    function showTaskForEdit( taskId) {        
        $('#clear').trigger('click');        
        var task = tasksCache[ taskId ];
        $('#id').val(task.id);
        $('#title').val(task.title);        
        $('#totalEstimatedHours').val(task.estimatedHours);
        $('#totalHoursSpend').val(task.spendHours);
        $('#notificationEmails').val(task.notificationEmails);
        $('#description').val(task.description);
        $('#projectDD').val(task.projectName);
        $('#assignToDD').val(task.assignedToId);
        $('#priority').val(task.priority);
        $('#status').val(task.status);
        $('#deadline').val(task.deadlineFormat);
        if ( task.isOwner == false ) {
            setEnabled(true);
        }
        $('#comment').attr('disabled', false);
        $('#taskTableContainer').slideUp('fast');
        $('#detailReports').slideUp('fast');
        $('#taskViewContainer').slideUp('fast');
        $('#newTaskContainer').slideDown('fast');
        viewed = taskId;
    }

    
    // executed on "clear" button is clicked
    $('#clear').click(function() {
        viewed = null;
        $('#id').val("");
        $('#title').val("");        
        $('#estimatedHours').val("");
        $('#totalEstimatedHours').val("");
        $('#hoursSpend').val("");
        $('#totalHoursSpend').val("");
        $('#notificationEmails').val("");
        $('#description').val("");        
        $('#projectDD').val("Todo");
        $('#assignToDD').val("None");
        $('#priority').val("Medium");
        $('#status').val("New");
        $('#deadline').val("");
        $('#comment').val("");
        setEnabled(false);
    });

    function setEnabled(flag) {
        $('#title').attr('disabled', flag);
        $('#projectDD').attr('disabled', flag);
        $('#assignToDD').attr('disabled', flag);
        $('#estimatedHours').attr('disabled', flag);
        $('#notificationEmails').attr('disabled', flag);
        $('#description').attr('disabled', flag);
        $('#deadline').attr('disabled', flag);
        $('#copyTask').attr('disabled', flag);
        $('#comment').attr('disabled', !flag);
    }
    // executed on "create new task" button is clicked
    $('.saveTask').click(function() {
        var task1 = null;
        if ( viewed != null ) {
            task1 = tasksCache[viewed];
        }
        if ( task1 == null) {
            task1 = {
                id:null,
                title:null,
                deadline:null,
                deadlineFormat:null,
                priority:null,
                projectName:null,
                assignedToUsername:null,
                estimatedHours:null,
                notificationEmails:null,
                description:null,
                comment:null
            };
        }
        task1.title = $.trim( $('#title').val() );
        if ( task1.title.length < 1 ) {
            alert ( " Summary cannot be empty! ");
            return;
        }
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
        task1.estimatedHours = $('#estimatedHours').val();
        task1.deadlineFormat = $('#deadline').val();
        task1.notificationEmails = $.trim ( $('#notificationEmails').val() );
        task1.description = $.trim ( $('#description').val() );
        task1.comment = $.trim ( $('#comment').val() );
        if ( $('#copyTask').is(":checked") ) {
            var u1 = $('#assignToDD').val();
            var userIds = u1.toString().split(",");
            for ( var i = 0; i < userIds.length; i++ ) {                                
                if ( userIds[i] > 0 ) {
                    task1.assignedToId = userIds[i];                
                    task1.assignedToUsername = usersDDCache[task1.assignedTo];
                    AjaxTaskService.saveTask(task1, function() {
                        $('#clear').trigger("click");
                        $('.workspaceDiv').trigger("click");
                        $('#refreshTask').trigger('click');
                        $.jGrowl( "Task saved successfully!");
                        viewed = null;
                    });                                             
                }                                                   
            }            
        } else {
            var u = $('#assignToDD').val();
            if ( u != "0") {
                task1.assignedToId = u;
                task1.assignedToUsername = usersDDCache[task1.assignedTo];
            }else {
                task1.assignedToId = null;
                task1.assignedToUsername = null;
            }  
            AjaxTaskService.saveTask(task1, function() {
                $('#clear').trigger("click");
                $('.workspaceDiv').trigger("click");
                $('#refreshTask').trigger('click');
                $.jGrowl( "Task saved successfully!");
            });
            
        }    
    });  
    
    $('#refreshTask').click(function() {
        $(this).attr("src", "../images/animated_reset.gif")
        var selectedStatus = $('#projectStatusDropdown').val();
        $('')
        if ( selectedStatus == 'Find by Task ID') {
            var taskId = prompt("Enter Task ID : ", "");
            AjaxTaskService.getCurrentTask(taskId, function (data) {
                $('#refreshTask').attr("src", "../images/reset.gif")
                $.jGrowl( "Refreshed successfully!");
                taskList(data);
            });
        } else {
            AjaxTaskService.getCurrentTask(selectedStatus, function (data) {
                $('#refreshTask').attr("src", "../images/reset.gif")
                $.jGrowl( "Refreshed successfully!");
                taskList(data);
            });
        }
    });
    setInterval(function() {
        var selectedStatus = $('#projectStatusDropdown').val();       
        if ( selectedStatus == 'Find by Task ID') {
        } else {
            AjaxTaskService.getCurrentTask(selectedStatus, taskList);
        }
    },300000);
    
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
        var options = "<option value='0'></option>";
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
        var options = "<option value='0'></option>";
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
    
    $('#copyTask').click ( function() {
        if ($(this).is(":checked")) {
            $('#assignToDD').attr('multiple', 'multiple');
            $('#assignToDD').attr('size', '3');
        } else {
            $('#assignToDD').removeAttr('multiple', 'multiple');
            $('#assignToDD').removeAttr('size', '3');
        }
    })
   
    // --------------- reporting -----------------------------------//
    
    var displayReportId = 1; // 1 is user, 2 is project

    function displayUserReportFunction (data, divId) {
        $('#' + divId).empty();
        for ( var i = 0; i < data.length; i++ ) {
            var title = data[i].name + " " + data[i].reportDate;
            var tasksAssigned = data[i].totalAssigned;
            var tasksCompleted = data[i].totalCompleted;
            var hoursAssigned = data[i].estimatedHours;
            var hoursDone = data[i].hoursSpend;
            var myCreatedTask = data[i].totalCreated;
            var api = new jGCharts.Api();             
            jQuery('<img>') 
            .attr('src', api.make({
                title       : title, 
                data : [[tasksAssigned, tasksCompleted, hoursAssigned, hoursDone, myCreatedTask]],
                axis_labels : [''],
                legend : ['Tasks Assigned '+tasksAssigned, 'Tasks Completed '+tasksCompleted,'Hours Assigned '+hoursAssigned,'Hours Done '+hoursDone,'My Created Tasks '+myCreatedTask]
            })).appendTo("#" + divId);	
        }
    }

    function displayProjectReportFunction (data, divId) {
        $('#' + divId).empty();
        for ( var i = 0; i < data.length; i++ ) {
            var title = data[i].projectName + " " + data[i].reportDate;
            var tasksAssigned = data[i].taskCreated;
            var tasksCompleted = data[i].taskFinished;
            var hoursAssigned = data[i].estimatedTime;
            var hoursDone = data[i].timeSpend;
            var api = new jGCharts.Api();
            jQuery('<img>')
            .attr('src', api.make({
                title       : title,
                data : [[tasksAssigned, tasksCompleted, hoursAssigned, hoursDone]],
                axis_labels : [''],
                legend : ['Tasks Assigned '+tasksAssigned, 'Tasks Completed '+tasksCompleted,'Hours Assigned '+hoursAssigned,'Hours Done '+hoursDone]
            })).appendTo("#" + divId);
        }
    }
    
    displayUserReport = function( data) {
        displayUserReportFunction(data, "graphDiv");
    }
    displayProjectReport = function( data) {
        displayProjectReportFunction(data, "graphDiv");
    }
    var loadUserReport = function() {       
        AjaxReportService.getUserReports(-1, 1, displayUserReport);  // get random user report
    }    
    var loadProjectReport = function() {       
        AjaxReportService.getProjectReports(-1, 1, displayProjectReport);  // get radmon project report belonging to user
    }
    var loadUserOrProjectReport = function() {
        if ( displayReportId == 1 ) { //
            loadUserReport();
            displayReportId = 2;
        } else {
            loadProjectReport();
            displayReportId = 1;
        }
    }
    setInterval(function() {
        loadUserOrProjectReport();
    },30000);
    
    // set timer for 30secs  
    function loadNews() {
        AjaxTaskService.getRecentCompletedTask ( 5, displayNews);
    }
    var displayNews = function(tasks) {
        var content = "";
        for ( var i = 0; i < tasks.length; i++ )  {
            tasksCache[tasks[i].id] = tasks[i];
            content += "<p>"
            + "<a id='news" + tasks[i].id + "'  class='newsClass' href='javascript:void(0);'>" + tasks[i].title + " </a> <br> "
            + tasks[i].assignedToName + ", "
            + tasks[i].priority + ", Completed, # " + tasks[i].id
            + "</p>";
        }
        $('#newsDiv').html( content );
        
    }
    setInterval(function() {
        loadNews();
    },30000);
    
    $('.newsClass').livequery('click', function() {
        var taskId = $(this).attr('id').substr(4);
        showTaskForView(taskId);
    })
    


    // ------------------------------------ logged in name -----------------------
    AjaxUsersService.getUserDetails(function (name){    
        $('#welcomeDiv').html("<p>Welcome " + name.firstname + " " +name.lastname + "</p>");
    });

});
    
