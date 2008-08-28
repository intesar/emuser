<%-- 
    Document   : dashboard1
    Created on : Aug 26, 2008, 9:52:43 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <jsp:include page="dhtml_goodies_include.jsp" />
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxWorkService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        <script type="text/javascript" src="email_validation.js"></script>
        <script type="text/javascript" src="util-functions.js"></script>
        <script type="text/javascript" src="clear-default-text.js"></script>
        <script type="text/javascript">
            function search() {
                if ( validateEmail(dwr.util.getValue("key"), true, true) ) 
                {
                    AjaxWorkService.getCustomer(dwr.util.getValue("key"), reply2);
                }
            }
            var reply2 = function(customer) {
                dwr.util.setValues(customer);
            }
            function addToMemberList() {
                
            }
            var reply3 = function (data) {
                alert ( data );
                // write to span if successful else alert if error
                //if ( data.toString().startsWidth)
            }
            
            var peopleCache = { };
            var viewed = null;
            var systems1 = { };
            var systemLength = null;
            function fillTable() {
                document.getElementById('geta').disabled=true;
                document.getElementById('deta').disabled=true;
                dwr.util.useLoadingMessage();
                AjaxWorkService.getActiveSystems(function(people) {
                   
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    
                    //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                    systemLength = people.length;
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        
                        id = person.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("name" + id, person.name);
                        dwr.util.setValue("currentUserEmail" + id, person.currentUserEmail);     
                        dwr.util.setValue("startTimeString" + id, person.startTimeString);
                        $("pattern" + id).style.display = "";
                        peopleCache[id] = person;
                        systems1[i] = person;
                        if(person.isAvailable == true){
                            document.getElementById('edit'+id).disabled=false;
                            document.getElementById('geta'+id).disabled=true;
                            document.getElementById('deta'+id).disabled=true;
                        } else {
                            document.getElementById('edit'+id).disabled=true;
                            document.getElementById('geta'+id).disabled=false;
                            document.getElementById('deta'+id).disabled=false;
                        }
                    }
                });
                //document.getElementById('deta5').style.visibility='hidden';
            }
            
            function assignSystem(eleid) {  
               
                var system = peopleCache[eleid.substring(4)];                
                var leaseHolder = dwr.util.getValue("key");
           
                if ( validateEmail(leaseHolder, true, true) ) 
                {
                    AjaxWorkService.leaseSystem(system.id, leaseHolder, function(data) {
                          
                        fillTable();
                      
                        alert ( data );
                    } ); 
                
                }
            }
            function fetchDetail(eleid) {
                var system = peopleCache[eleid.substring(4)];
                //alert ( system.id );
                AjaxWorkService.getSystemLease(system.id, function(lease){
                    document.getElementById("paidAmount").disabled = false;
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("detailbody", { filter:function(tr) {
                            return (tr.id != "detail");
                        }});
                    //alert ( 'l');
                    // Create a new set cloned from the pattern row
                    //var person, id;
                    //people.sort(function(p1, p2) { return p1.macAddress.localeCompare(p2.macAddress); });
                    var total = 0;
                    for (var i = 0; i < lease.length; i++) {
                        systemLease = lease[i];
                        //person = people[i];
                        //id = person.id;
                        //alert ( lease.id);
                        id = systemLease.id;
                        dwr.util.cloneNode("detail", { idSuffix:id });
                        dwr.util.setValue("service" + id, systemLease.service);
                        dwr.util.setValue("startTimeString" + id, systemLease.startTimeString);                             
                        dwr.util.setValue("totalMinutesUsed" + id, systemLease.totalMinutesUsed);
                        dwr.util.setValue("payableAmount" + id, systemLease.payableAmount);
                        dwr.util.setValue("paidAmount"+id, systemLease.payableAmount);
                        $("detail" + id).style.display = "";
                        total += systemLease.payableAmount;
                        //peopleCache[id] = person;
                    }
                    dwr.util.setValue("paidAmount", total);
                    document.getElementById("paidAmount").disabled = true;
                });
            }
            function addService() {
                var s = dwr.util.getValue ("services");
                var u = dwr.util.getValue ("units");
                var e = dwr.util.getValue ("email");
                var p = dwr.util.getValue ("payableAmount1");
                var a = p;//dwr.util.getValue ("paid");
                var flag = false;
                if ( validateEmail(e, true, false) ) 
                {
                    flag = true;
                }
                if (!isNaN(e)) {
                    alert ( 'e');
                    for ( var i = 0; i < systemLength; i++ ) {
                        var p1 = systems1[i];
                        var name = p1.name;
                        if ( e == name && p1.isAvailable == false ) {
                            flag = true;
                        }
                    }
                    
                }
                if ( flag ) {
                    AjaxWorkService.addService(s,u,e,p,'',a, replyService);
                } else {
                    alert ( ' please provide an Email or a System No.');
                }
                  
            }
            var replyService = function (data) {
                alert ( data );
            }
            function paid (eleid) {
                var system = peopleCache[eleid.substring(4)];
                AjaxWorkService.chargePayment(system.id, function(data) {
                    alert ( data );
                    fillTable();
                   
                   
                } );
            }
            function clearPerson() {
                viewed = null;
                dwr.util.setValues({ id:null, services:null, units:null, email:null, payableAmount1:null });
            }
 
            function isInteger(s)
            {
                var i;
                s = s.toString();
                for (i = 0; i < s.length; i++)
                {
                    var c = s.charAt(i);
                    if (isNaN(c)) 
                    {
                        alert("This field Should contain Only number");
                        return false;
                    }
                }
                return true;
            }
            
        </script>
        <jsp:include page="table_style.jsp" ></jsp:include>
        
    </head>
    <body>
        <jsp:include page="include.jsp" />
        
        <table align="center">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <h2>Customer Look Up</h2>
                        <table title="Hello">
                            
                            <tr>
                                <td>
                                    <input type="text"  id="key" value="Enter Valid Email..." class="cleardefault" />
                                    <input type="submit" value="Search" onclick="search();"/>          
                                    <input type="submit" value="Add To Member List" onclick="addToMemberList();"/>
                                    <img id="image" src="javascript:void(0);"/>
                                    <br>
                                </td>
                            </tr>
                        </table>
                        <h2>System Details</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        System
                                    </th>
                                    <th>
                                        Customer
                                    </th>
                                    <th>
                                        Start Time
                                    </th>
                                    <th>
                                        
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody  id="peoplebody" >
                                <tr id="pattern" style="display:none;">
                                    <td><span id="name"></span></td>
                                    <td><span id="currentUserEmail"></span></td>
                                    <td><span id="startTimeString"></span></td>
                                    <td>
                                        <!-- <input type="button" id="edit" value="Assign" onclick="assignSystem(this.id);" /> 
                                        <input type="button" id="deta" value="Detail" onclick="fetchDetail(this.id);" />
                                        <input type="button" id="geta" value="Paid"  onclick="paid(this.id);" />-->
                                        <button value="New" onclick="assignSystem(this.id);"  id="edit">Assign</button>
                                        <button value="New" onclick="fetchDetail(this.id);"  id="deta">m</button>
                                        <button value="New" onclick="paid(this.id);"  id="geta">Paid</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        
                        
                        
                    </td>
                    
                    
                    <td>
                        <h2>Customer's Accounts Details</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        Resource
                                    </th>
                                    <th>
                                        Start Time
                                    </th>
                                    
                                    <th>
                                        Mins/Units
                                    </th>
                                    <th>
                                        Payable
                                    </th>
                                    
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody  id="detailbody" >
                                <tr id="detail" >
                                    <td><span id="service"></span></td>
                                    <td><span id="startTimeString"></span></td>                    
                                    <td><span id="totalMinutesUsed">Total</span></td>
                                    <td><span id="payableAmount"><input type="text" id="paidAmount" value="" disabled="disabled" size="4" /></span></td>
                                    <td>
                                </tr>
                            </tbody>
                        </table>
                        <h2>  Extra Sales  </h2>
                        <table title="Extra Sale">
                            
                            <tr>
                                <td>Service</td>
                                <td><select name="services">
                                        <option>B/W Print</option>
                                        <option>Color Print</option>
                                        <option>Scan</option>
                                        <option>DVD Burn</option>
                                        <option>CD Burn</option>
                                        <option>B/W Copy</option>
                                        <option>Color Copy</option>
                                        <option>other</option>
                                </select></td>
                                <td>Units*</td>
                                <td>
                                    <!--   <input type="text" name="units" value="1" size="4" class="cleardefault"> -->
                                    <input type=text name="units" value="1" size="4" class="cleardefault" onKeyup="isInteger(this.value)">
                                    
                                    
                                </td>
                            </tr>
                            <tr>
                                <td>Add To System/Emails*</td>
                                <td><input type="text" name="email" value="enter email or system no..." class="cleardefault"/></td>
                                <td>Payable Amount*</td>
                                <td><input type=text name="payableAmount1" value="10" size="4" class="cleardefault" onKeyup="isInteger(this.value)"></td>
                            </tr>
                            
                            <tr>
                                <td></td>
                                <td></td>
                                <td><input type="submit" value="Save" onclick="addService();" /></td>
                                <td><input type="submit" value="Clear" onclick="clearPerson();" /></td>
                            </tr>
                        </table>
                        
                        
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        <br>
        <br>
        <br>
        
        <jsp:include page="copyright.jsp" />
    </body>
</html>
