$(document).ready(function() {
    $("#pc").gchart({width:'450', height:'200', type: 'pie', 
        dataLabels: ['User', 'Admins', 'Active'], legend: 'right', 
        series: [$.gchart.series([88.16, 1.61, 8.13], $.gchart.color(0, 128, 0))] 
    }); 
});
   
	
// this function is executed on load 	
$(document).ready(function() {
    oTable = $('#usersTable').dataTable( {
        //"sPaginationType": "full_numbers"  
        "sDom": '<"top"i>rt<"bottom"flp<"clear">'        
    } );
    
    /* Global variable for the DataTables object */
    var oTable;	
    /* Global var for counter */
    var giCount = 2;    
    var usersCache = {};
    var viewed = null;
    
    
    var usersList = function (users) {
        var dArray = new Array();
        // Delete all the rows except for the "pattern" row
        oTable.fnClearTable();
        for ( var i = 0 ; i < users.length; i++ ) {  
            var active = "N";
            if ( users[i].enabled ) {
                active = "Y";
            }
            var administrator = "N";
            if ( users[i].administrator ) {
                administrator = "Y";
            }
            var data = [ users[i].firstname + " " + users[i].lastname, "" + active, administrator, "<a id='editUser" + users[i].id + "' class='editUser'>Edit</a>-<a id='deleteUser" + users[i].id + "' class='deleteUser'>Del</a>"];                                              
            usersCache[users[i].id] = users[i];
            dArray[i] = data;                                     
        }                                                         
        oTable.fnAddData( dArray );
        giCount++;
    }
    // executed onload
    AjaxUsersService.getUserList(usersList);
    // executed on "create new project" link is clicked
    $('#createANewUser').click(function() {                
        $('#userTableContainer').slideUp("fast");
        $('#newUserContainer').slideDown("fast");
    });
    // executed on "back to project" link is clicked
    $('#backToUserList').click(function() {
        $('#newUserContainer').slideUp("fast");    
        $('#userTableContainer').slideDown("fast");
    });
    // executed on "back to project" link is clicked
    $('#backToUserListFromEdit').click(function() {
        $('#editUserContainer').slideUp("fast");
        $('#userTableContainer').slideDown("fast");
    });
    // executed on "edit" link is clicked
    $('.editUser').livequery('click', function () {                
        $('#userTableContainer').slideUp("fast");        
        viewed = $(this).attr('id').toString().substring(8);        
        $('#editUserContainer').slideDown("fast");
        var user = usersCache[viewed];        
        $('#firstnameE').val(user.firstname);
        $('#lastnameE').val(user.lastname);
        $('#enabledE').val(user.enabled);
        $('#administratorE').val(user.administrator);
    });
    // executed on "delete" link is clicked
    $('.deleteUser').livequery('click', function () {                                
        viewed = $(this).attr('id').toString().substring(8);      
        AjaxUsersService.deleteUser ( viewed, function ( data ) {
            alert (data);
        });
    });
    // executed on "click" link is clicked
    $('#clear').click(function() {
        $('#firstname').val("");        
        $('#lastname').val("");        
        $('#email').val("");        
        $('#administrator').val("");        
    });
    // executed on "create new project" button is clicked
    $('#createNewUser').click(function() {
        var user1 = {id:null, firstname:null, lastname:null, password:null, username:null, email:null, 
            enabled:'true', dministrator:null};
        user1.firstname = $('#firstname').val();
        user1.lastname = $('#lastname').val();        
        user1.username = $('#email').val();
        user1.email = user1.username;
        
        AjaxUsersService.saveUser ( user1, usersList);
        $('#backToUserList').trigger("click");
        
    });
    // executed on "save project" button is clicked
    $('#saveUser').click(function() {
        var user1 = usersCache[viewed];        
        user1.firstname = $('#firstname').val();
        user1.lastname = $('#lastname').val();
        $('#backToUserListFromEdit').trigger("click");
        AjaxUsersService.saveUser ( user, usersList);
    });
    
} );


    


