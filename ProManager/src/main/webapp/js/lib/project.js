$(document).ready(function() {
    $("#pc").gchart({width:'450', height:'200', type: 'pie', 
        dataLabels: ['New', 'In-Progress', 'Completed'], legend: 'right', 
        series: [$.gchart.series([88.16, 1.61, 8.13], $.gchart.color(0, 128, 0))] 
    }); 
});
   
// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#projectTable').dataTable( {
        "sPaginationType": "full_numbers"        
    } );
    
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var projectCache = {};
    var viewed = null;
    
    
    var projectList = function (projects) {
        var dArray = new Array();
        // Delete all the rows from table
        oTable.fnClearTable();
        for ( var i = 0 ; i < projects.length; i++ ) {  
            // create object
            var data = [ ""+projects[i].name, ""+projects[i].status, "<a id='editProject"+projects[i].id + "' class='editProject'>Edit</a>-<a id='deleteProject"+projects[i].id +"' class='deleteProject'>Del</a>"];                                  
            projectCache[projects[i].id] = projects[i];
            dArray[i] = data;                                     
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
    }
    // executed onload
    AjaxProjectService.getProjectList(projectList);
    
    // executed on "create new project" link is clicked
    $('#createANewProject').click(function() {                
        $('#projectTableContainer').slideUp("fast");
        $('#newProjectContainer').slideDown("fast");
    });
    // executed on "back to project" link is clicked
    $('#backToProjectList').click(function() {
        $('#newProjectContainer').slideUp("fast");    
        $('#projectTableContainer').slideDown("fast");
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


    
