
/* Global variable for the DataTables object */
var oTable;
			
/* Global var for counter */
var giCount = 2;
			
$(document).ready(function() {
    oTable = $('#usersTable').dataTable( {
        "sPaginationType": "full_numbers",
        "iDisplayLength"  : "5"
    } );
    
    $('#createANewUser').click(function() {        
        $('#newUserContainer').slideDown("fast");
        $('#tableContainer').slideUp("fast");
    });

    $('#backToUserList').click(function() {
        $('#newUserContainer').slideUp("fast");
        $('#tableContainer').slideDown("fast");
    });
} );



function fnClickAddRow() {
    oTable.fnAddData( [
        giCount+".1",
        giCount+".2",
        giCount+".3",
        giCount+".4" ] );
				
    giCount++;
}
		
var userCache = { };
var viewed = null;
var user = null;
    
        
function fillTable() {
    dwr.util.useLoadingMessage("Please wait, loading user information");
    AjaxUsersService.getUserList(usersList);                
}
        
var usersList = function (users) {
    
    // Delete all the rows except for the "pattern" row
    dwr.util.removeAllRows("userbody", { filter:function(tr) {
            return (tr.id != "userRow");
        }});
    // Create a new set cloned from the pattern row
    var _user, id;
    //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
    for (var i = 0; i < users.length; i++) {
        _user = users[i];
        id = _user.id;
        dwr.util.cloneNode("userRow", { idSuffix:id });
        dwr.util.setValue("username1" + id, _user.username); 
        dwr.util.setValue("name" + id, _user.firstname +" " + _user.lastname);
        if ( _user.enabled == true  ) {
            dwr.util.setValue("enabled1" + id, 'yes');
        } else {
            dwr.util.setValue("enabled1" + id, 'no');
        }
        if ( _user.administrator == true  ) {
            dwr.util.setValue("role1" + id, 'yes');
        } else {
            dwr.util.setValue("role1" + id, 'no');
        }                        
        document.getElementById("userRow" + id).style.display = "";
        userCache[id] = _user;
        user = _user;
    }
    document.getElementById("username").disabled=true;
}
function editClicked(eleid) {
    // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
    var person = userCache[eleid.substring(4)];
    viewed = person.id;
    dwr.util.setValues(person);
    document.getElementById("username").disabled=true;
}
        
            
        
function writePerson() {
    dwr.util.useLoadingMessage("Please Wait, Loading");    
    function errh(msg) {
        alert(msg);
    }
    dwr.engine.setErrorHandler(errh);
    var usersDto = null
    if ( viewed != null ) {
        usersDto = userCache[viewed];
        dwr.util.getValues(usersDto);
    } else {
        usersDto = {id:null, firstname:null, lastname:null, username:null, 
            email:null, enabled:null, administrator:null};
        dwr.util.getValues(usersDto);
    }    
    AjaxUsersService.saveUser(usersDto, usersList);     
                
}
            
var reply1 = function (data) {
    clearMessages();
    if ( data == 'Operation succesful!') {
        writeMessage ("successReply", " Saved/Updated User at " + new Date().toLocaleString() );
        fillTable();
    } else {
        writeMessage ("failureReply", data );
    }
}
        
function clearPerson() {
    viewed = null;
    dwr.util.setValues( {id:null, firstname:null, lastname:null, username:null, 
        email:null, enabled:'no', administrator:'no'});
    document.getElementById("username").disabled=false;
}
