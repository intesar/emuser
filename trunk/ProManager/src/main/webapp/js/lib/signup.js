
function signupClicked() {
    //dwr.util.useLoadingMessage("Please Wait, Loading");    
    function errh(msg) {
        alert(msg);
    }
    //dwr.engine.setErrorHandler(errh);
    var usersDto = {id:null, firstname:null, lastname:null, username:null, password:null, 
        email:null, organization:null, city:null, country:null};
    dwr.util.getValues(usersDto);
    AjaxUsersService.signUp(usersDto, function(result) {
        alert ( result );
    });   
}