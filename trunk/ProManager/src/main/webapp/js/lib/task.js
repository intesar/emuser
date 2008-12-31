// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#taskTable').dataTable( {             
        "sDom": '<"top"i>rt<"bottom"flp<"clear">'
    } );
    
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var tasksCache = {};
    var viewed = null;
    
    
    var taskList = function (tasks) {
        var dArray = new Array();
        // Delete all the rows from table
        oTable.fnClearTable();
        for ( var i = 0 ; i < tasks.length; i++) {             
            // create object
            var project = tasks[i].projectName; if ( project == null) project = "Todo";
            var deadline = tasks[i].deadlineFormat; if (deadline == null ) deadline = "NA";
            var assignedUser = tasks[i].assignedToUsername; if ( assignedUser == null ) assignedUser = "<a id='assignMe"+tasks[i].id + "' class='editTask'>Assign Me</a>";
            var data = [ /*"" + tasks[i].id,*/ "" + tasks[i].title, project,
                /*tasks[i].priority,*/ /*tasks[i].status,*/deadline, /*tasks[i].ownerUsername, */
                ""+assignedUser,/* deadline,*/ "<a id='editProject"+tasks[i].id + "' class='editTask'>Edit</a>-<a id='deleteTask"+tasks[i].id +"' class='deleteTask'>Del</a>"];                                  
            tasksCache[tasks[i].id] = tasks[i];            
            dArray[i] = data;                
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
    }
    // executed onload
    AjaxTaskService.getCurrentTask("Current Task", taskList);
    
    // executed on "create new project" link is clicked
    $('#createANewTask').click(function() {                
        $('#newTaskContainer').modal();
    });

    // executed on "edit" link is clicked
    $('.editTask').livequery('click', function () {                    
        viewed = $(this).attr('id').toString().substring(11);        
        $('#editProjectContainer').modal();
        var project = projectCache[viewed];        
        $('#nameE').val(project.name);
        $('#statusE').val(project.status);
        $('#descriptionE').val(project.description);
    });

    // executed on "delete" link is clicked
    $('.deleteTask').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(11);      
        AjaxProjectService.deleteProject ( viewed, function ( data ) {
            alert (data);
        });
    });
    
    // executed on "click" link is clicked
    $('#clear').click(function() {
        $('#name').val("");        
        $('#description').val("");
    });
    // executed on "create new task" button is clicked
    $('#createNewTask').click(function() {
        var task1 = {id:null, title:null, deadline:null, priority:null, projectName:null, assignedToUsername:null, estimatedHours:null, notificationEmails:null, description:null};
        task1.title = $('#title').val();
        task1.deadline = $('#deadline').val();
        task1.priority = $('#priority').val();
        task1.projectName = $('#project');
        task1.assignedToUsername = $('#assignedTo').val();
        task1.estimatedHours = $('#estimatedHours').val();
        task1.notificationEmails = $('#notificationEmails').val();        
        task1.description = $('#description').val();
        //$('#backToProjectList').trigger("click");
        AjaxProjectService.saveProject ( project1, projectList);
    });
    
    // executed on "save project" button is clicked
    $('#saveProject').click(function() {
        var project = projectCache[viewed];        
        project.status = $('#statusE').val();        
        project.description = $('#descriptionE').val();
        $('#backToProjectListFromEdit').trigger("click");
        AjaxProjectService.saveProject ( project, projectList);
    });
    
    $('#printTaskTable').click(function() {
        $.jPrintArea($('#taskTableContainer'));
    });
    
    $('#projectStatusDropdown').change(function() {
        var selectedStatus = $(this).val();       
        AjaxTaskService.getCurrentTask(selectedStatus, taskList);
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


    
