
var projectCache = { };
var viewed = null;
var project = null;
    
        
function fillTable() {
    dwr.util.useLoadingMessage("Please Wait, Loading");
    AjaxProjectService.getProjectList(projectList);                
}
        
var projectList = function (projects) {
    
    // Delete all the rows except for the "pattern" row
    dwr.util.removeAllRows("projectbody", { filter:function(tr) {
            return (tr.id != "projectRow");
        }});
    // Create a new set cloned from the pattern row
    var _project, id;
    //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
    for (var i = 0; i < projects.length; i++) {
        _project = projects[i];
        id = _project.id;
        dwr.util.cloneNode("projectRow", { idSuffix:id });
        dwr.util.setValue("name1" + id, _project.name); 
        dwr.util.setValue("status1" + id, _project.status);
        document.getElementById("projectRow" + id).style.display = "";
        projectCache[id] = _project;
        project = _project;
    }
    document.getElementById("name").disabled=true;
}
function editClicked(eleid) {
    // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
    project = projectCache[eleid.substring(4)];
    viewed = project.id;
    dwr.util.setValues(project);
    document.getElementById("name").disabled=true;
}
        
            
        
function writePerson() {
    dwr.util.useLoadingMessage("Please Wait, Loading");    
    function errh(msg) {
        alert(msg);
    }
    dwr.engine.setErrorHandler(errh);
    var projectDto = null
    if ( viewed != null ) {
        projectDto = projectCache[viewed];
        dwr.util.getValues(projectDto);
    } else {
        projectDto = {id:null, name:null, status:null, description:null};
        dwr.util.getValues(projectDto);
    }    
    AjaxProjectService.saveProject(projectDto, projectList);     
                
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
    dwr.util.setValues( {id:null, name:null, status:null, description:null});
    document.getElementById("name").disabled=false;
}
