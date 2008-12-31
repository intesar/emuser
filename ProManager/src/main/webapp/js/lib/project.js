//$(document).ready(function() {
//    $("#pc").gchart({width:'450', height:'200', type: 'pie', 
//        dataLabels: ['New', 'In-Progress', 'Completed'], legend: 'right', 
//        series: [$.gchart.series([88.16, 1.61, 8.13], $.gchart.color(0, 128, 0))] 
//    }); 
//});
   
// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#projectTable').dataTable( {               
        "sDom": '<"top"i>rt<"bottom"flp<"clear">'
    } );
    
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var projectCache = {};
    var viewed = null;
    var _project = null;
    
    function displayProjects(projects) {
        var dArray = new Array();
        // Delete all the rows from table
        oTable.fnClearTable();
        for ( var i = 0 ; i < projects.length; i++ ) {  
            // create object
            var data = [ ""+projects[i].name, ""+projects[i].status, "<a id='editProject"+projects[i].id + "' class='editProject'>Edit</a>-"+
                    "<a id='deleteProject"+projects[i].id +"' class='deleteProject'>Del</a>--<a id='projectUsers"+projects[i].id +"' class='projectUsers'>Users</a>"];                                  
            projectCache[projects[i].id] = projects[i];
            dArray[i] = data;                                     
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
    }
    
    var projectList = function (projects) {
        displayProjects( projects );
    }
    
   
    // executed onload
    AjaxProjectService.getProjectList(projectList);
    
    // executed on "create new project" link is clicked
    $('#createANewProject').click(function() {                
        $('#newProjectContainer').modal();        
    });
    // executed on "edit" link is clicked
    $('.editProject').livequery('click', function () {                    
        viewed = $(this).attr('id').toString().substring(11);        
        $('#editProjectContainer').modal();
        var project = projectCache[viewed];        
        $('#nameE').val(project.name);
        $('#statusE').val(project.status);
        $('#descriptionE').val(project.description);
    });

    // executed on "delete" link is clicked
    $('.deleteProject').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(13);      
        AjaxProjectService.deleteProject ( viewed, function ( data ) {
            displayProjects (data);
            $.modal("<h3> Project deleted successfully! </h3>");
        });
    });
    
    // executed on "delete" link is clicked
    $('.projectUsers').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(12);      
        _project = projectCache[viewed];    
        AjaxProjectService.getProjectUsers(viewed, projectUsersList);
        //$('.projectUsersDiv').modal();
        //$('#container').modal();
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
        AjaxProjectService.saveProject ( project1, projectList);
    });
    
    // executed on "save project" button is clicked
    $('#saveProject').click(function() {
        var project = projectCache[viewed];        
        project.status = $('#statusE').val();        
        project.description = $('#descriptionE').val();        
        AjaxProjectService.saveProject ( project, projectList);
    });
        
    $('#printProjectTable').click(function() {
        $.jPrintArea($('#projectTableContainer'));
    })
    
    // ------------ project users --------------//
    
    /* Global variable for the DataTables object */
    var puTable;	
    /* Global var for counter */
    var puCount = 2;  
    puTable = $('#projectUsersTable').dataTable( {               
        "sDom": '<"top"i>rt<"bottom"flp<"clear">'
    });
    
    var projectUsersCache = {};
    var viewedUser = null;
    
    function displayProjectUsers(projectUsers) {
        var dArray = new Array();
        // Delete all the rows from table
        puTable.fnClearTable();
        for ( var i = 0 ; i < projectUsers.users.length; i++ ) {  
            // create object
            var manager = 'N';
            var managerAction = "<a id='projectUserAsManager"+projectUsers.users[i].id + "' class='addUserAsManager'>Make Manager</a>";
            if ( projectUsers.users[i].manager == true ) {  
                manager = 'Y';
                managerAction = "<a id='projectUserAsManager" + projectUsers.users[i].id + "' class='removeUserAsManager'>Remove As Manager</a>";
            }
            
            var data = [ "" + projectUsers.users[i].firstname + " " + projectUsers.users[i].lastname, 
                manager,  managerAction + "-"+
                    "<a id='deleteProjectUser"+projectUsers.users[i].id +"' class='deleteProjectUser'>Del</a>"];                                              
            dArray[i] = data;                                     
        }                   
        //projectUsersCache[projectUsers.users[i].id] = projectUsers;
        // adds object array to table and displays
        puTable.fnAddData( dArray );
        // required by daatable plugin
        puCount++;
    }
    
    var projectUsersList = function ( projectUsers ) {
        displayProjectUsers ( projectUsers );
    }
    
    $('.addUserAsManager').livequery('click', function () { 
        viewedUser = $(this).attr('id').toString().substring(20);    
        AjaxProjectService.saveUserToProject (viewed, viewedUser, true, projectUsersList);
    });
    
    $('.removeUserAsManager').livequery('click', function () { 
        viewedUser = $(this).attr('id').toString().substring(20);                
        AjaxProjectService.saveUserToProject (viewed, viewedUser, false, projectUsersList);
    });
    
    $('.deleteProjectUser').livequery('click', function () { 
        viewedUser = $(this).attr('id').toString().substring(17);
        AjaxProjectService.deleteUserFromProject(viewed, viewedUser, projectUsersList);
    });
    
    $('displayAddUserToProject').livequery('click', function () { 
        $('#projectUsersSaveDiv').modal();
    });
    
    $('#saveProjectUsersLink').click (function() {
        $('#projectName').val(_project.name);
      $('#projectUsersSaveDiv').modal();
    });
    
    $('#addUserToProjectBtn').livequery('click', function () { 
        viewedUser = $('#projectUserAdd').val();
        var username= $('#projectUsername').val();
        AjaxProjectService.saveUserToProject (viewed, username, true, projectUsersList); 
    });
    
});