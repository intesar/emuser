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
                                                        <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    TimeSheet Details
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            
                                                            
                                                            <a href="Timesheet.jsp">View Timesheet</a>
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
            <br>
            <br>
               
            <table align="left" hspace="40" border="1" id="timesheetTable">
                    <thead>
                        <th>&nbsp;DATE&nbsp;</th>
                        <th>&nbsp;STATUS&nbsp;</th>
                        <th>&nbsp;ACTION&nbsp;</th>  
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>
                            <select name="Status Filter">
                                <option>Saved</option>
                                <option>Submit</option>
                                <option>Approved</option>
                                <option>Rejected</option>
                                <option>Paid</option>
                        </select></th>
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
    
    <table hspace="80" border="1" cellpadding="5" align="right">
                    
                    <br>
                    <br> 
                    <tbody >
                        <tr>
                            <th>Working Hours</th>
                            <th>Monday</th>
                            <th>Tuesday</th>
                            <th>Wednesday</th>
                            <th>Thusday</th>
                            <th>Friday</th>
                            <th>Saturday</th>
                            <th>Sunday</th>
                            
                        </tr>
                    </tbody>
           
                    <tbody >
                        <tr>
                            <td></td>
                            <td><input type="text" size="10" id="mondayDate"/></td>
                            <td><input type="text" size="10" name="tuesdayDate" value="" /> </td>
                            <td><input type="text" size="10" name="wednesdayDate" value="" /></td>
                            <td><input type="text" size="10" name="thursdayDate" value="" /></td>
                            <td><input type="text" size="10" name="fridayDate" value="" /></td>
                            <td><input type="text" size="10" name="saturdayDate" value="" /></td>
                            <td><input type="text" size="10" name="sundayDate" value="" /></td>
                            
                        </tr>
                        <tr>
                            <td>Regular Hours</td>
                            <td><input type="text" size="10" name="mondayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="tuesdayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="wednesdayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="thursdayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="fridayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="saturdayRegularHours" value="" /></td>
                            <td><input type="text" size="10" name="sundayRegularHours" value="" /></td>
                        </tr>
                        <tr>
                            <td>OverTime Hours</td>
                            <td><input type="text" size="10" name="mondayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="tuesdayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="wednesdayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="thursdayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="fridayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="saturdayOverTimeHours" value="" /></td>
                            <td><input type="text" size="10" name="sundayOverTimeHours" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                
                <br>
                <center>
                <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                    Save
                </button>
                <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                    Submit
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
                <script type='text/javascript'>
                    function init() {                
                        fillTable();
                    }
                    window.onload=init;

                    var timesheetCache = { };
                    var viewed = -1;
                    var selectedStatus = "saved";
                  // var selectedStatus = "submit";
                   // var selectedStatus = "approved";
                   // var selectedStatus = "paid";
                   // var selectedStatus = "rejected";
                   // function Select()
                   // {
                    
                   // }
    
                    function fillTable() {
                        JTimesheetAjaxService.getTimesheetsByStatus(selectedStatus, function(timesheets) {
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
                                alert(timesheets.length);
                                dwr.util.cloneNode("pattern", { idSuffix:id });
                                dwr.util.setValue("tableStartdate" + id, timesheet.mondayDateString);                        
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
        
        
        
        
        
        
        
         <br><br><br>
    
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
