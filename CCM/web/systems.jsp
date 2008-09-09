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
            dwr.util.useLoadingMessage();
            AjaxAdminService.getAllSystems(function(people) {
                // Delete all the rows except for the "pattern" row
                dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                        return (tr.id != "pattern");
                    }});
                // Create a new set cloned from the pattern row
                var person, id;
                people.sort(function(p1, p2) {
                    return p1.name - p2.name;
                });
                for (var i = 0; i < people.length; i++) {
                    person = people[i];
                    id = person.id;
                    dwr.util.cloneNode("pattern", { idSuffix:id });
                    dwr.util.setValue("name1" + id, person.name);
                    dwr.util.setValue("description1" + id, person.description);
                    $("pattern" + id).style.display = "table-row";
                    peopleCache[id] = person;
                }
                //person = peopleCache[0];
                //viewed = person.id;            
                //dwr.util.setValues(person);
            });
            
            
        }
        
        function editClicked(eleid) {
            // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
            var person = peopleCache[eleid.substring(4)];
            viewed = person.id;
            //alert ( person.enabled);
            //person = {enabled_:false};
            dwr.util.setValues(person);
        }
        
            
        
        function writePerson() {
            var person;
            if ( viewed == null ) {
                alert ( 'Please refresh your page!' );
                //person = { id:null, name:null, description:null, minuteRate:null, enabled:true, enabledString:null, macAddress:null };
            } else {
                person = peopleCache[viewed];
                dwr.util.getValues(person);        
                AjaxAdminService.saveSystems(person, function(data) {
                    clearMessages();
                    if ( data == "Operation succesful!") {
                        dwr.util.setValue ("successReply", "Updated System at " + new Date().toLocaleString());
                        fillTable();
                    } else {
                        dwr.util.setValue ("failureReply", data );
                    }
                    
                });
                
            }
            
            
        }
        
               
        function updatePrice() {
            var mm = dwr.util.getValue("minimumMinutes");
            var r = dwr.util.getValue("minuteRate");
            var lmm = dwr.util.getValue("lowerMinimumMinutes");
            var lr = dwr.util.getValue("lowerMinuteRate");
            
            if ( mm != null && mm != "" && r != null && r != "" ) {
                AjaxAdminService.updateRentalPrice ( mm, r, lmm, lr, function(data) {
                    clearMessages();
                    if ( data == "Price Updated Successful!") {
                        dwr.util.setValue ("successReply", data + " at " + new Date().toLocaleString());
                        fillTable();
                    } else {
                        dwr.util.setValue ("failureReply", data );
                    }
                    
                    //alert ( data );
                });
            }
        }
        
    </script>
    
    <jsp:include page="table_style.jsp" ></jsp:include>
</head>
<body>
    <jsp:include page="include.jsp" />
    <!-- <h2 align="center"> System Information  </h2> -->
    
    
    <table align="center">
        <tr align="center">
            <td align="center">
                <div style="height:370px; width:470px; overflow:auto;">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Description</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="peoplebody">
                            <tr id="pattern" style="display:none;">
                                <td><span id="name1">No</span></td>
                                <td><span id="description1">Description</span></td>
                                <td>
                                    <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>                        
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </td>
            <td align="center">
                
                <table align="center">
                    <thead>
                        <tr>
                            <th></th>
                            <th>
                                Update System Information
                            </th>
                        </tr>
                    </thead>
                    <tr>
                        <td>No:</td>
                        <td><input type="text" name="name" value="" size="30" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>MacAddress:</td>
                        <td><input id="macAddress" type="text" size="30"/></td>
                    </tr>
                    <tr>
                        <td>Descrption:</td>
                        <td><textarea name="description" rows="5" cols="23">
                        </textarea>
                    </tr>
                    <tr>
                        <td>Is Working:</td>
                        <td><select name="enabledString" >
                                <option>yes</option>
                                <option>no</option>
                            </select>
                        <input type="button" value="Save" onclick="writePerson()"/></td>
                    </tr>
                </table>
                <table>
                <thead>
                    <tr>
                        <th></th>
                        <th>
                            Pricing
                        </th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tr>
                    <td>Lower Minimum Minutes:*</td>
                    <td><input type="text" id="lowerMinimumMinutes" size="4"/></td>
                    <td>Lower Rate:*</td>
                    <td><input type="text" id="lowerMinuteRate" size="4"/></td>
                </tr>
                <tr>
                    <td>Minimum Minutes:*</td>
                    <td><input type="text" id="minimumMinutes" size="4"/></td>
                    <td>Rate:*</td>
                    <td><input type="text" id="minuteRate" size="4"/></td>
                </tr>
                
                <tr>
                <td></td>
                <td>
                <input type="button" value="Save" onclick="updatePrice()"/></td>
            </td>
        </tr>
    </table>
    </td>
    </tr>
    </table>
    
    
    
    
    <script type="text/javascript">
        onload = fillTable();
    </script>
</body>
<jsp:include page="systems_help.jsp" />
<jsp:include page="copyright.jsp" />

</html>
