
	
$(document).ready(function() {
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
        // Delete all the rows except for the "pattern" row
        oTable.fnClearTable();
        for ( var i = 0 ; i < projects.length; i++ ) {  
            var data = [ ""+projects[i].name, ""+projects[i].status, "<a id='editProject"+projects[i].id + "' class='editProject'>Edit</a> <a id='deleteProject"+projects[i].id +"' class='deleteProject'>Delete</a>"];                                  
            projectCache[projects[i].id] = projects[i];
            dArray[i] = data;                                     
        }                                                         
        oTable.fnAddData( dArray );
        giCount++;
    }
    
    AjaxProjectService.getProjectList(projectList);
    
    $('#createANewProject').click(function() {                
        $('#projectTableContainer').slideUp("fast");
        $('#newProjectContainer').slideDown("fast");
    });

    $('#backToProjectList').click(function() {
        $('#newProjectContainer').slideUp("fast");    
        $('#projectTableContainer').slideDown("fast");
    });
    
    $('#backToProjectListFromEdit').click(function() {
        $('#editProjectContainer').slideUp("fast");
        $('#projectTableContainer').slideDown("fast");
    });
    
    $('.editProject').livequery('click', function () {                
        $('#projectTableContainer').slideUp("fast");        
        viewed = $(this).attr('id').toString().substring(11);        
        $('#editProjectContainer').slideDown("fast");
        var project = projectCache[viewed];        
        $('#nameE').val(project.name);
        $('#statusE').val(project.status);
        $('#descriptionE').val(project.description);
    });

    $('.deleteProject').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(11);      
        AjaxProjectService.deleteProject ( viewed, function ( data ) {
            alert (data);
        });
    });
    
    $('#clear').click(function() {
        $('#name').val("");        
        $('#description').val("");
    });
    
    $('#createNewProject').click(function() {
        var project1 = {id:null, name:null, description:null, status:'In Progress'};
        project1.name = $('#name').val();
        project1.description = $('#description').val();
        $('#backToProjectList').trigger("click");
        AjaxProjectService.saveProject ( project1, projectList);
    });
    
    $('#saveProject').click(function() {
        var project = projectCache[viewed];        
        project.status = $('#statusE').val();        
        project.description = $('#descriptionE').val();
        $('#backToProjectListFromEdit').trigger("click");
        AjaxProjectService.saveProject ( project, projectList);
    });
    
} );


    
