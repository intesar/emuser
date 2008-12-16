
$(document).ready(function() {
    $("#pc").gchart({width:'450', height:'200', type: 'pie', 
        dataLabels: ['New', 'In-Progress', 'Completed'], legend: 'right', 
        series: [$.gchart.series([88.16, 1.61, 8.13], $.gchart.color(0, 128, 0))] 
    });   
});
// this function is executed on load 	
$(document).ready(function() {
   
    
    // checkout datatable plugin to understand below code
    oTable = $('#taskTable').dataTable();
    
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
            var project = tasks[i].projectName; //if ( project == null) project = "NONE";
            var deadline = tasks[i].deadlineFormat; //if (deadline == null ) deadline = "NONE";
            var data = [ "" + tasks[i].id, "" + tasks[i].title, project,
                tasks[i].priority, tasks[i].status, tasks[i].ownerUsername, 
                ""+tasks[i].assignedToUsername, deadline, "<a id='editProject"+tasks[i].id + "' class='editTask'>Edit</a>-<a id='deleteTask"+tasks[i].id +"' class='deleteTask'>Del</a>"];                                  
            tasksCache[tasks[i].id] = tasks[i];            
            dArray[i] = data;    
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
    }
    // executed onload
    AjaxTaskService.getCurrentTask(taskList);
    
    // executed on "create new project" link is clicked
    $('#createANewTask').click(function() {                
        $('#taskTableContainer').slideUp("fast");
        $('#newTaskContainer').slideDown("fast");
    });
    // executed on "back to project" link is clicked
    $('#backToTaskList').click(function() {
        $('#newTaskContainer').slideUp("fast");    
        $('#taskTableContainer').slideDown("fast");
    });
    // executed on "back to project" link is clicked
    $('#backToProjectListFromEdit').click(function() {
        $('#editProjectContainer').slideUp("fast");
        $('#projectTableContainer').slideDown("fast");
    });
    // executed on "edit" link is clicked
    $('.editProject').livequery('click', function () {                
        $('#projectTableContainer').slideUp("fast");        
        viewed = $(this).attr('id').toString().substring(11);        
        $('#editProjectContainer').slideDown("fast");
        var project = projectCache[viewed];        
        $('#nameE').val(project.name);
        $('#statusE').val(project.status);
        $('#descriptionE').val(project.description);
    });

    // executed on "delete" link is clicked
    $('.deleteProject').livequery('click', function () {                                
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
    // executed on "create new project" button is clicked
    $('#createNewProject').click(function() {
        var project1 = {id:null, name:null, description:null, status:'In Progress'};
        project1.name = $('#name').val();
        project1.description = $('#description').val();
        $('#backToProjectList').trigger("click");
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
    
} );


    
