// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#taskTable').dataTable( {             
        "sDom": '<"top"i>rt<"bottom"flp<"clear">',
        "aoData": [null,{"sClass":"action","sType":"html"},null,null,{"sClass":"action","sType":"html"},{"sWidth":"250px"},{"sType":"html"},{"sClass":"action","sType":"html"}]        
    } );
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var tasksCache = {};
    var viewed = null;
    
    // start 
    var x1 = null;
    var x21 = "<option>New</option>";
    var x22 = "<option selected>New</option>";
    var x31 = "<option>In Progress</option>";
    var x32 = "<option selected>In Progress</option>";
    var x41 = "<option>On Hold</option>";
    var x42 = "<option selected>On Hold</option>";
    var x51 = "<option>Completed</option>";
    var x52 = "<option selected>Completed</option>";
    var x6="</select>";        
    function getStatusDD(status, id) {
        x1 = "<select id="+ id +" class='statusDD'>";
        if ( status == 'New') {
            return x1 + x22 + x31 + x41 + x51 + x6;
        }
        else if ( status == 'In Progress') {
            return x1 + x21 + x32 + x41 + x51 + x6;
        }
        else if ( status == 'On Hold') {
            return x1 + x21 + x31 + x42 + x51 + x6;
        }
        else {
            return x1 + x21 + x31 + x41 + x52 + x6;
        }        
    }
    // end
    // start 
    var y1 = null;
    var y21 = "<option>High</option>";
    var y22 = "<option selected>High</option>";
    var y31 = "<option>Medium</option>";
    var y32 = "<option selected>Medium</option>";
    var y41 = "<option>Low</option>";
    var y42 = "<option selected>Low</option>";    
    var y5 = "</select>";        
    function getPriorityDD(priority, id) {
        y1 = "<select id="+ id +"  class='priorityDD'>";
        if ( priority == 'High') {
            return y1 + y22 + y31 + y41 + y5;
        }
        else if ( priority == 'Medium') {
            return y1 + y21 + y32 + y41 + y5;
        }       
        else {
            return y1 + y21 + y31 + y42 + y5;
        }        
    }
    // end
    var taskList = function (tasks) {
        var dArray = new Array();
        // Delete all the rows from table
        oTable.fnClearTable();
        for ( var i = 0 ; i < tasks.length; i++) {             
            // create object            
            var statusRowDD = getStatusDD(tasks[i].status, tasks[i].id);
            var priorityRowDD = getPriorityDD ( tasks[i].priority, tasks[i].id);  
            var project = tasks[i].projectName; if ( project == null) project = "Todo";
            var deadline = tasks[i].deadlineFormat; if (deadline == null ) deadline = "NA";
            var title = "<small>" + tasks[i].title + "<small>";
            var assignedUser = tasks[i].assignedToUsername; if ( assignedUser == null ) assignedUser = "<a id='assignMe"+tasks[i].id + "' class='editTask'>Assign Me</a>";
            var data = [  tasks[i].id, statusRowDD, project, assignedUser, priorityRowDD, title, 
                deadline, "<a id='deleteTask"+tasks[i].id +"' class='deleteTask' href='javascript:void(0);'>Delete</a>"];                                  
            tasksCache[tasks[i].id] = tasks[i];            
            dArray[i] = data;                
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
        $('#taskTable').tableHover()
    }
    // executed onload
    AjaxTaskService.getCurrentTask("Current Task", taskList);
    
    // status change 
    $('.statusDD').livequery ( 'change', function() {
        AjaxTaskService.changeTaskStatus($(this).attr('id'), $(this).val());
    });
    // priority change
    $('.priorityDD').livequery ( 'change', function() {
        AjaxTaskService.changeTaskPriority($(this).attr('id'), $(this).val());        
    });
    // executed on "create new project" link is clicked
    $('#createANewTask').click(function() {    
        $('#clear').trigger('click');
        $('#newTaskContainer').modal();
    });

    // open user in a modal for editing
    $('#taskTable td').livequery( function () { 
        $(this).not('.action').not('a').click(function () { 
            viewed = $(this).parent().children()[7].firstChild.id.toString().substring(10);
            var task = tasksCache[ viewed ];
            $('#title').val(task.title);        
            $('#estimatedHours').val(task.estimatedHours);
            $('#hoursSpend').val(task.spendHours);
            $('#notificationEmails').val(task.notificationEmails);
            $('#description').val(task.description);
            $('#projectDD').val(task.projectName);
            $('#assingDD').val(task.assignedToUsername);
            $('#priority').val(task.priority);
            $('#status').val(task.status);
            $('#deadline').val(task.deadlineFormat);
            if ( task.isOwner == false ) {
                $('#title').attr('disabled', true);
                $('#estimatedHours').attr('disabled', true);                
                $('#notificationEmails').attr('disabled', true);
                $('#description').attr('disabled', true);
                $('#projectDD').attr('disabled', true);
                $('#assingDD').attr('disabled', true);                                
                $('#deadline').attr('disabled', true);
            }
            $('#newTaskContainer').modal();
        });
    });
    

    // executed on "delete" link is clicked
    $('.deleteTask').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(11);      
        AjaxProjectService.deleteProject ( viewed, function ( data ) {
            alert (data);
        });
    });
    
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
        $('#assingDD').attr('disabled', false);                                
        $('#deadline').attr('disabled', false);
    });
    // executed on "create new task" button is clicked
    $('#saveTask').click(function() {
        var task1 = {id:null, title:null, deadline:null, priority:null, projectName:null, assignedToUsername:null, estimatedHours:null, notificationEmails:null, description:null};
        if ( viewed != null ) {
            task1 = tasksCache[viewed];
        }
        if (viewed != null && task1.isOwner == false) {            
            // Admin, Owner, PM can change title, project, status, priority, assignTo, est hours, hours spend, notification, deadline, description
            //assignTo can change status, priority, hoursSpend
            task1.status = $('#status').val();    
            task1.priority = $('#priority').val();
            task1.spendHours = $('#hoursSpend').val();            
        }  else {// user can change everything on new task        
            task1.title = $('#title').val();
            //task1.deadline = Date.parse($('#deadline').val());
            task1.priority = $('#priority').val();
            task1.projectName = $('#projectDD').val();
            task1.status = $('#status').val();            
            task1.spendHours = $('#hoursSpend').val();
            task1.assignedToUsername = $('#assignToDD').val();
            task1.estimatedHours = $('#estimatedHours').val();
            task1.notificationEmails = $('#notificationEmails').val();        
            task1.description = $('#description').val();                
        }
        AjaxTaskService.saveTask(task1, taskList);
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
    
    var projectDDCache = {};
    
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
        alert ( projectId );
        var x = projectDDCache;
        var user = projectDDCache[projectId].users;
        var options = "<option value='None'>None</option>";
        for ( var i = 0; i < i.length; i++ ) {
            options += "<option value='" + user[i].id + "'>" + user[i].firstname + " " + user[i].lastname + "</option>";
        }
        $('#assignToDD').html (options );
    });
    projectDDList = function ( projectDDListData ) {
        displayProjectDDList ( projectDDListData );
    }
    AjaxProjectService.getProjectsForDropdown(projectDDList);
    
    function displayUsersDDList(usersDDList) {
        var options = "<option value='me'>me</option>";
        for ( var i = 0; i < usersDDList.length; i++ ) {
            options += "<option value='"+ usersDDList[i].id+"'>"+usersDDList[i].firstname + " " + usersDDList[i].lastname + "</option>";
            //projectDDCache[projectDDList.projectId] =usersDDList[i];
        }
        $('#assignToDD').html(options);
    }
    usersDDList = function ( usersDDListData ) {
        displayUsersDDList ( usersDDListData );
    }
    AjaxUsersService.getActiveUserList(usersDDList);
    
    $("#deadline").datepicker({ 
        minDate: 0, 
        maxDate: 365 
        //showOn: "both", 
        //buttonImage: "templates/images/calendar.gif", 
        //buttonImageOnly: true 
    });
    
} );


    
