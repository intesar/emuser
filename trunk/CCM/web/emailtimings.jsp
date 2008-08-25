<%-- 
    Document   : systems
    Created on : Jul 7, 2008, 5:43:08 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="dhtml_goodies_include.jsp" />
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <script type="text/javascript">
            function init() {
                fillTable();
            }
        
            var peopleCache = { };
            var viewed = null;
        
            function fillTable() {
                AjaxAdminService.getAllEmailTimePreference(function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("reporttime" + id, person.reportTime);
                        
                        
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
            }
        
            function editClicked(eleid) {
                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                var person = peopleCache[eleid.substring(4)];
                dwr.util.setValues(person);
            }
        
            
        
            function writePerson() {
                var person = { id:viewed, reportTime:null, organization:null};
                dwr.util.getValues(person);
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                AjaxAdminService.saveSystems(person);
                fillTable();
                //dwr.engine.endBatch();
            }
        
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, reportTime:null, organization:null});
            }
        </script>
        
       <jsp:include page="table_style.jsp" ></jsp:include>
    </head>
    <body>
        
        <jsp:include page="include.jsp" />
        
        
      
        <table align="center">
            <thead>
                <tr>
                    <th>  Report Time </th>
                </tr>
            </thead>
            <tbody id="peoplebody">
                <tr id="pattern" style="display:none;">
                    <td><span id="reporttime">reportTime</span></td>
                    
                </tr>
            </tbody>
        </table>
        
        
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        
        
        <jsp:include page="emailtimings_help.jsp" />
        <jsp:include page="copyright.jsp" />
        
    </body>
    
</html>
