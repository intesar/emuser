
$(document).ready(function () {
    $('#signup').click(function () {
        var usersDto = {id:null, firstname:null, lastname:null, username:null, password:null, 
            email:null, organization:null, city:null, country:null};
            
        usersDto.firstname=$('#firstname').val();
        usersDto.lastname = $('#lastname').val();
        usersDto.username = $('#username').val();
        usersDto.email = usersDto.username;
        usersDto.password = $('#password').val();
        usersDto.organization = $('#organization').val();     
        var cf = $('#password_confirm').val();
        if ( usersDto.firstname.length < 2 || usersDto.lastname.length < 2 || usersDto.username.length < 5 ||
            usersDto.organization.length < 2) {
            alert ( "All field required!");
            return;
        }
        if ( cf != null && cf.length > 4 && cf == usersDto.password) {
                       
            AjaxUsersService.signUp(usersDto, function(result) {
                alert ( result );
            });   
        } else { alert ("password & confirm password do not match!");}        
    });

});
