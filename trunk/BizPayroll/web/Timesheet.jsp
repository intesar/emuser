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
    
    <body class="tundra">
        
        <form>
            <center><h1>TimeSheet Details</h1></center>
            <br>
            <br>
            <center><table border="1" id="timesheetTable">
                    <thead>
                        <th>&nbsp;DATE&nbsp;</th>
                        <th>&nbsp;STATUS&nbsp;</th>
                        <th>&nbsp;ACTION&nbsp;</th>  
                        <th> <select name="Status Filter">
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
            </center>
            <br>
            <br>
            
            <center>    
                <table border="1" cellpadding="5">
                    
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
                            <td><input class="itext" id="mondayDate"/></td>
                            <td><input type="text" name="tuesdayDate" value="" /> </td>
                            <td><input type="text" name="wednesdayDate" value="" /></td>
                            <td><input type="text" name="thursdayDate" value="" /></td>
                            <td><input type="text" name="fridayDate" value="" /></td>
                            <td><input type="text" name="saturdayDate" value="" /></td>
                            <td><input type="text" name="sundayDate" value="" /></td>
                            
                        </tr>
                        <tr>
                            <td>Regular Hours</td>
                            <td><input type="text" name="mondayRegularHours" value="" /></td>
                            <td><input type="text" name="tuesdayRegularHours" value="" /></td>
                            <td><input type="text" name="wednesdayRegularHours" value="" /></td>
                            <td><input type="text" name="thursdayRegularHours" value="" /></td>
                            <td><input type="text" name="fridayRegularHours" value="" /></td>
                            <td><input type="text" name="saturdayRegularHours" value="" /></td>
                            <td><input type="text" name="sundayRegularHours" value="" /></td>
                        </tr>
                        <tr>
                            <td>OverTime Hours</td>
                            <td><input type="text" name="mondayOverTimeHours" value="" /></td>
                            <td><input type="text" name="tuesdayOverTimeHours" value="" /></td>
                            <td><input type="text" name="wednesdayOverTimeHours" value="" /></td>
                            <td><input type="text" name="thursdayOverTimeHours" value="" /></td>
                            <td><input type="text" name="fridayOverTimeHours" value="" /></td>
                            <td><input type="text" name="saturdayOverTimeHours" value="" /></td>
                            <td><input type="text" name="sundayOverTimeHours" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                
                <br>
                
                <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                    Save
                </button>
                <button dojoType="dijit.form.Button" onclick="updateTimesheet();">
                    Submit
                </button>
                <button dojoType="dijit.form.Button" onclick="JTimesheetAjaxService.createTimesheet(reply0);">
                    Create TimeSheet
                </button>
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
            </center>
        </form>
    </body>
</html>
