<%-- 
    Document   : main
    Created on : Jun 28, 2008, 6:50:21 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Counselling Application</title>
        <script type='text/javascript' src='/CounsellingApp/dwr/interface/AjaxApplicationService.js'></script>
        <script type='text/javascript' src='/CounsellingApp/dwr/engine.js'></script>       
        <script type='text/javascript' src='/CounsellingApp/dwr/util.js'></script>
        <script type="text/javascript">
            //onload = doThis();
            
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

            function init() {
                doThis();
                thisAlso();
            }

            function populateColleges() {
                //alert ( " helo ");            
                AjaxApplicationService.getCollegeNames(reply0);
                //populateDepartments();
                //alert ( 'bye');
            }
            
            function populateDepartments() {
                //alert ( " helo ");        
                var box = document.forms['applicationForm'].college;
                var number = box.options[box.selectedIndex].value;
                
                //alert ( number);
                AjaxApplicationService.getDepartmentNames(number, reply1);
                //alert ( 'bye');
            }
        
            function apply() {
                var collegeSelect = document.forms['applicationForm'].college;
                var college = collegeSelect.options[collegeSelect.selectedIndex].value;
                var departmentSelect = document.forms['applicationForm'].department;
                var department = departmentSelect.options[departmentSelect.selectedIndex].value;
                //var priority = document.forms['applicationForm'].priority.value;
                AjaxApplicationService.apply ( college, department, null, reply2);
                
            }
            var peopleCache = { };
            var viewed = -1;

            function fillTable() {
                AjaxApplicationService.getAppliedDetails(function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.priorityString.localeCompare(p2.priorityString); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = person.id;
                        //alert ( person.department + " " + id);
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("tableName" + id, person.college);
                        dwr.util.setValue("tableSalary" + id, person.department);                        
                        $("pattern" + id).style.display = "table-row";
                        peopleCache[id] = person;
                    }
                });
            }

            function deleteClicked(eleid) {                
                var person = peopleCache[eleid.substring(6)];
                AjaxApplicationService.deleteApplication(person.id, reply3);
                
            }

            
            var reply0 = function(data)
            {
                //alert ( 'hello ');
                //alert ( data );
                for ( var i = 0; i < data.length; i++ ) {
                    // alert ( data[i]);
                    document.forms['applicationForm'].college.options[i] = new Option(data[i], data[i]);

                }                
            }
            
            var reply1 = function(data)
            {
                //alert ( 'hello ');
                
                for ( var i = 0; i < data.length; i++ ) {
                    // alert ( data[i]);
                    document.forms['applicationForm'].department.options[i] = new Option(data[i], data[i]);

                }
                
            }
            
            var reply2 = function(data)
            {
                //alert ( 'hello ');
                //alert ( data );
                fillTable();
                
                
            }
            var reply3 = function(data)
            {
                //alert ( 'hello ');
                //alert ( data );
                fillTable();
                
                
            }
            
        </script>
    </head>
    <body>
        <table>            
            <tbody>
                <tr>
                <td><a href="main.jsp">Dashboard</a></td>
                    <td><a href="users.jsp">Users</a></td>
                    <td><a href="collegedepartments.jsp">College Department</a></td>
                    <td><a href="collegeseats.jsp">Reservation Details</a></td>
                    <td><a href="admin.jsp">Admin</a></td>
                </tr>
            </tbody>
        </table>
        
        <br/>
        <br/>
        <input type="submit" value="<" onclick="previous();"/><input type="submit" value=">" onclick="next();"/>
        <table border="0">
            
            <tbody>
                <tr>
                    <td><table border="1" class="rowed grey">
                            <thead>
                                <tr>
                                    <th>College</th>
                                    <th>Department</th>   
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="peoplebody">
                                <tr id="pattern" style="display:none;">
                                    <td>
                                        <span id="tableName">College</span><br/>                                        
                                    </td>
                                    <td>$<span id="tableSalary">Department</span></td>
                                    <td>                                        
                                        <input id="delete" type="button" value="-" onclick="deleteClicked(this.id)"/>
                                        <input id="up" type="button" value="/\" onclick="editClicked(this.id)"/>
                                        <input id="down" type="button" value="\/" onclick="editClicked(this.id)"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
                        <table border="0">
                            <tbody>
                                <form name="applicationForm">
                                    <tr>
                                        <td>College</td>
                                        <td><select name="college" onclick="populateDepartments();">
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>Department</td>
                                        <td><select name="department">
                                        </select></td>
                                    </tr>
                                    
                                    
                                </form>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="ADD"  
                                               onclick="apply()" /></td>
                                </tr>
                            </tbody>
                        </table>
                        
                    </td>
                </tr>
            </tbody>
        </table>
        <script type="text/javascript">
            onload = populateColleges();
            onload = fillTable();
        </script>
    </body>
</html>
