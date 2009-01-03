// this function is executed on load 	
$(document).ready(function() {
    // checkout datatable plugin to understand below code
    oTable = $('#projectTable').dataTable( {               
        "sDom": '<"top"i>rt<"bottom"flp<"clear">',
        "aoData": [null,null,{"sClass":"action"}]
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
            var data = [ ""+projects[i].name, ""+projects[i].status, 
                "<a id='deleteProject"+projects[i].id +"' class='deleteProject' href='javascript:void(0);'>Delete Project</a>--<a id='projectUsers"+projects[i].id +"' class='projectUsers' href='javascript:void(0);'>Members</a>"];                                  
            projectCache[projects[i].id] = projects[i];
            dArray[i] = data;                                     
        }                   
        // adds object array to table and displays
        oTable.fnAddData( dArray );
        // required by daatable plugin
        giCount++;
        $('#projectTable').tableHover()
    }
    
    var projectList = function (projects) {
        displayProjects( projects );
    }
    
   
    // executed onload
    AjaxProjectService.getProjectList(projectList);
    
    // executed on "create new project" link is clicked
    $('#createANewProject').click(function() {                
        $('#newProjectContainer').modal();        
        $('#clear').trigger('click');        
    });
   
    // executed on "delete" link is clicked
    $('.deleteProject').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(13);
        var proj = projectCache[viewed];
        if ( confirm("Are you sure you want to delete " + proj.name + "?") ) {
            AjaxProjectService.deleteProject ( viewed, function ( data ) {
                displayProjects (data);
                alert("Project deleted successfully!");
            });
        }
    });
    
      
    // executed on "click" link is clicked
    $('#clear').click(function() {
        $('#name').val("");        
        $('#description').val("");
        $('#name').attr('disabled', false);
        viewed = null;
    });
    // executed on on Save & Close button is clicked, creates and saves a project
    $('#saveProject').click(function() {
        var project1 = null;
        if ( viewed == null ) {
            project1 = {id:null, name:null, description:null, status:null};
            project1.name = $('#name').val();        
        } else {
            project1 = projectCache[viewed];
        }
        project1.description = $('#description').val();        
        project1.status = $('#status').val();
        AjaxProjectService.saveProject ( project1, projectList);
    });
    
    // open user in a modal for editing
    $('#projectTable td').livequery( function () { 
        $(this).not('.action').click(function () { 
            viewed = $(this).parent().children()[2].firstChild.id.toString().substring(13);            
            $('#newProjectContainer').modal();
            var project = projectCache[viewed]; 
            $('#name').attr('disabled', true);
            $('#name').val(project.name);
            $('#status').val(project.status);
            $('#description').val(project.description);            
        });
    });
    
     
    // ------------ project users --------------//
    
    // executed on "delete" link is clicked
    $('.projectUsers').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(12);      
        _project = projectCache[viewed];    
        AjaxProjectService.getProjectUsers(viewed, projectUsersList);
    });
    
    /* Global variable for the DataTables object */
    var puTable;	
    /* Global var for counter */
    var puCount = 2;  
    puTable = $('#projectUsersTable').dataTable( {               
        "sDom": '<"top"i>rt<"bottom"flp<"clear">'
    });
    
    var projectUsersArray = {};
    var viewedUser = null;
    
    function displayProjectUsers(projectUsers) {
        var dArray = new Array();
        // Delete all the rows from table
        puTable.fnClearTable();
        for ( var i = 0 ; i < projectUsers.users.length; i++ ) {  
            // create object
            var manager = '<b>Member</b>';
            var managerAction = "<a id='projectUserAsManager"+projectUsers.users[i].id + "' class='addUserAsManager' href='javascript:void(0);'>(Make-Manager)</a>";
            if ( projectUsers.users[i].manager == true ) {  
                manager = '<b>Manager</b>';
                managerAction = "<a id='projectUserAsManager" + projectUsers.users[i].id + "' class='removeUserAsManager'  href='javascript:void(0);'>(Remove-As-Manager)</a>";
            }            
            var data = [ projectUsers.projectName, "" + projectUsers.users[i].firstname + " " + projectUsers.users[i].lastname, 
                manager + "  " +  managerAction, 
                    "<a id='deleteProjectUser"+projectUsers.users[i].id +"' class='deleteProjectUser'  href='javascript:void(0);'>Remove User from Project</a>"];                                              
            dArray[i] = data;         
            projectUsersArray[projectUsers.users[i].id] = projectUsers.users[i];
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
        var username = projectUsersArray[viewedUser];
        AjaxProjectService.saveUserToProject (viewed, username.username, true, projectUsersList);
    });
    
    $('.removeUserAsManager').livequery('click', function () { 
        var viewedUser1 = $(this).attr('id').toString().substring(20);        
        var username1 = projectUsersArray[viewedUser1];
        AjaxProjectService.saveUserToProject (viewed, username1.username, false, projectUsersList);
    });
    
    $('.deleteProjectUser').livequery('click', function () { 
        var viewedUser1 = $(this).attr('id').toString().substring(17);
        var username1 = projectUsersArray[viewedUser1];
        AjaxProjectService.deleteUserFromProject(viewed, username1.id, projectUsersList);
    });
    
    $('displayAddUserToProject').livequery('click', function () { 
        $('#projectUsersSaveDiv').modal();
    });
    
    // add projectUsers clicked
    $('#saveProjectUsersLink').click (function() {
        if ( _project != null ) {
            $('#projectName').val(_project.name);
            $('#projectUsersSaveDiv').modal();
        }else {
            alert ("Select project from above list");
        }        
    });
    
    $('#addUserToProjectBtn').livequery('click', function () {         
        var username= $('#projectUsername').val();
        var manager = $('#manager').attr('checked');
        AjaxProjectService.saveUserToProject (viewed, username, manager, projectUsersList); 
    });
    
});