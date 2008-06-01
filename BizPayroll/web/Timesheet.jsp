<!-- 
    Document   : Timesheet
    Created on : 22 May, 2008, 10:45:12 AM
    Author     : imran
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User TimeSheet</title>
        <script type='text/javascript' src='/BizPayroll/dwr/interface/JTimesheetAjaxService.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/engine.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/util.js'></script>
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            function call_function() {
                console.debug("Button was clicked.");
            }
        </script>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.ValidationTextBox");
        </script>
        <script type="text/javascript"> 
            function objectEval(text)
            {
                // eval() breaks when we use it to get an object using the { a:42, b:'x' }
                // syntax because it thinks that { and } surround a block and not an object
                // So we wrap it in an array and extract the first element to get around
                // this.
                // This code is only needed for interpreting the parameter input fields,
                // so you can ignore this for normal use.
                // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
                text = text.replace(/\n/g, ' ');
                text = text.replace(/\r/g, ' ');
                if (text.match(/^\s*\{.*\}\s*$/))
                {
                    text = '[' + text + '][0]';
                }
                return eval(text);
            }
        </script>
        
    </head>
    <form>
        
        <body class="tundra">
        <table cellspacing="0" cellpadding="0" border="0" align="center" width="95%">
            <tbody>
                <tr valign="top">
                    <td width="1%">
                        <img height="45" border="0" align="left" width="175" vspace="10" alt="Gmail" src="images/biz2.bmp"/>
                    </td>
                    <td bgcolor="#ffffff" width="99%" valign="top">
                        <table cellpadding="1" width="100%">
                            <tbody>
                                <tr valign="bottom">
                                    <td>
                                        <div align="right"> </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td nowrap="nowrap">
                                        <table cellspacing="0" cellpadding="0" bgcolor="#c3d9ff" align="center" width="100%" style="margin-bottom: 5px;">
                                            <tbody>
                                                <tr>
                                                    <td class="bubble tl" align="left" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                                                    </td>
                                                    <br> 
                                                    <td class="bubble" style="padding: 5px 0pt; font-family: arial; text-align: left; font-weight: bold;" rowspan="2">
                                                        <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <img src="images/icon3-normal.gif" width="20" height="20" alt="icon3-normal"/>
                                                            TimeSheet Details
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            
                                                            
                                                            <a href="users.jsp">View User Details</a>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../BizPayroll/j_acegi_logout">Logout</a> </b>
                                                    </td>
                                                    <td class="bubble tr" align="right" valign="top">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tr.gif"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="bubble bl" align="left" valign="bottom">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_bl.gif"/>
                                                    </td>
                                                    <td class="bubble br" align="right" valign="bottom">
                                                        <img class="c" alt="" src="https://mail.google.com/mail/images/corner_br.gif"/>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        
        <table border="0">
            <thead>
                <tr>
                    <th> 
                        <table hspace="35"><tr>
                             <th>
                                 <select name="StatusFilter" onchange="init(this.value)">
                                        <option>Select</option>
                                        <option value="val1">saved</option>
                                        <option value="val2">submit</option>
                                        <option value="val3">Approved</option>
                                        <option value="val4">Rejected</option>
                                        <option value="val5">Paid</option>
                                </select>
                                </th>
                                <br>
                                    
                        </tr></table>
                        
                        <table align="left" hspace="40" border="1" id="timesheetTable" rules="null">
                            <thead>
                                <th>&nbsp;DATE&nbsp;</th>
                                <th>&nbsp;STATUS&nbsp;</th>
                                <th>&nbsp;ACTION&nbsp;</th>  
                                <th></th>
                                <th></th>
                                <th></th>
                               
                            </thead> 
                            
                            
                            
                            <tbody id="timesheetsbody">    
                                <tr id="pattern"  style="display:none;">
                                    <td>
						
                                        <span id="tableStartdate">DATE</span><br/> 
                                    </td>                        
                                    <td><span id="tableStatus">STATUS</span></td>
                                    
                                    <td> <input id="edit" type="button" value="Edit" onclick="editClicked(this.id)"/>
                                    </td>
                                </tr>            
                            </tbody>
                        </table>
                    </th>
                    
                    <td></td><td></td>
                    <td></td><td></td>
                    
                    <th>
                        
                        <table hspace="20" border="1" cellpadding="5" align="right">
                            
                            <br>
                            <br> 
                            <tbody >
                                <tr>
                                    <th>Working Hours</th>
                                    <th>Sunday</th>
                                    <th>Monday</th>
                                    <th>Tuesday</th>
                                    <th>Wednesday</th>
                                    <th>Thusday</th>
                                    <th>Friday</th>
                                    <th>Saturday</th>
                                    
                                    
                                </tr>
                            </tbody>
                            
                            <tbody >
                                <tr>
                                    <td></td>
                                    <td> <span name="sundayDateString"></span></td>
                                    <td><span name="mondayDateString"></span></td>
                                    <td><span name="tuesdayDateString"></span> </td>
                                    <td><span name="wednesdayDateString"></span></td>
                                    <td><span name="thursdayDateString"></span></td>
                                    <td><span name="fridayDateString"></span></td>
                                    <td><span name="saturdayDateString"></span></td>
                                    
                                    
                                </tr>
                                <tr>
                                    <td>Regular Hours</td>
                                     <td><input type="text" size="14" name="sundayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="mondayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="tuesdayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="wednesdayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="thursdayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="fridayRegularHours" value="" /></td>
                                    <td><input type="text" size="14" name="saturdayRegularHours" value="" /></td>
                                   
                                </tr>
                                <tr>
                                    <td>OverTime Hours</td>
                                    <td><input type="text" size="14" name="sundayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="mondayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="tuesdayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="wednesdayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="thursdayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="fridayOverTimeHours" value="" /></td>
                                    <td><input type="text" size="14" name="saturdayOverTimeHours" value="" /></td>
                                    
                                </tr>
                            </tbody>
                        </table>
                        
                        <br>
                        <center>
                            <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                                Save
                            </button>
                            <button dojoType="dijit.form.Button"  onclick="updateTimesheet();">
                                Submit
                            </button>
                            <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                                Approved
                            </button>
                            <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                                Reject
                            </button>
                            <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                                Paid
                            </button>
                            <button dojoType="dijit.form.Button" onclick="JTimesheetAjaxService.createTimesheet(reply0);">
                                Create TimeSheet
                        </button></center>
                        <script type='text/javascript'>
                            function createTimesheet( )
                            {
               
                            }
           
                            var reply0 = function(data)
                            {
                                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
                            }
                        </script>
                    <!--    <script type='text/javascript'>
                           function Select(val)
                             {
                                 if(val=="val1")
                                 {                                                              
                                 filltable();
                                 }
                                 if(val=="val2"){
                                     filltable();
                                 }
                          //  val = this.value;
                           // var value = "saved";
                            //var value = "submit";
                           // var val3 = "approved";
                           // var val4 = "paid";
                           // var val5 = "rejected";
                             }  
                             
                        </script> -->
                        
                        <script type='text/javascript'>
                              var val = "saved";
                            function init()
                            {   
                            fillTable();
                            }
                            window.onload=init;

                            var timesheetCache = { };
                            var viewed = -1;
                            
                             
                            
                            function fillTable() {
                             
                                JTimesheetAjaxService.getTimesheetsByStatus(val, function(timesheets) {
                                    // Delete all the rows except for the "pattern" row
                                    dwr.util.removeAllRows("timesheetsbody", { filter:function(tr) {
                                            return (tr.id != "pattern");
                                        }});
                            
                                    // Create a new set cloned from the pattern row
                                    var timesheet, id;
                                    //timesheets.sort(function(p1, p2) { return p1.mondayDate.localeCompare(p2.mondayDate); });
                                    for (var i = 0; i < timesheets.length; i++) {
                                        timesheet = timesheets[i];
                                        id = timesheet.id;
                                       // alert(timesheets.length);
                                        dwr.util.cloneNode("pattern", { idSuffix:id });
                                        dwr.util.setValue("tableStartdate" + id, timesheet.sundayDateString);                        
                                        dwr.util.setValue("tableStatus" + id, timesheet.status);
                                        $("pattern" + id).style.display = "table-row";
                                        timesheetCache[id] = timesheet;
                                    }
                                });
                            }
                             
                            function editClicked(eleid) 
                            {
                                  
                                viewed = eleid.substring(4);
                                // we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
                                var timesheet = timesheetCache[eleid.substring(4)];
                                dwr.util.setValues(timesheet);
                            }
                        </script>
                        <span id='d0' class='reply'></span>
                        <span id='d2' class='reply'></span>
                    </th>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
        
        
    </form>
    
    
    
    
    
    
    
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
    
    <table cellspacing="0" cellpadding="3" bgcolor="#c3d9ff" align="center" width="95%" style="margin-bottom: 5px;">
        <tbody>
            <tr>
                <td class="bubble tl" align="left" valign="top">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tl.gif"/>
                </td>
                <td class="bubble" style="text-align: left;" rowspan="2">
                    <div align="center">
                        <font color="#666666" size="-1">
                            © Copyrights Bizintelapps 2008 All Rights Reserved. 
                            <a href="http://www.bizintelapps.com">BizIntelApps</a>
                            
                        </font>
                    </div>
                </td>
                <td class="bubble tr" align="right" valign="top">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_tr.gif"/>
                </td>
            </tr>
            <tr>
                <td class="bubble bl" align="left" valign="bottom">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_bl.gif"/>
                </td>
                <td class="bubble br" align="right" valign="bottom">
                    <img class="c" alt="" src="https://mail.google.com/mail/images/corner_br.gif"/>
                </td>
            </tr>
        </tbody>
    </table>
    
    </body>
</html>
