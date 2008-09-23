<%-- 
        Document   : users
        Created on : Jul 1, 2008, 2:06:28 PM
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
            function previous() {
                    
            }
            function next() {
                    
            }
            var peopleCache = { };
            var viewed = -1;
            var hallTicketNo ;
                
            function search() {
                    
                //hallTicketNo = dwr.util.getValue("hallTicketNos");                    
                fillTable();
            }

            function fillTable() {
                AjaxApplicationService.getUserApplicationStatus(dwr.util.getValue("hallTicketNos"), function(people) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var person, id;
                    people.sort(function(p1, p2) { return p1.name.localeCompare(p2.name); });
                    for (var i = 0; i < people.length; i++) {
                        person = people[i];
                        id = i+1;//person.id;
                        //alert ( person.department + " " + id);
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("name" + id, person.name);
                        dwr.util.setValue("hallTicketNo" + id, person.hallTicketNo);
                        dwr.util.setValue("rank" + id, person.rank);
                        dwr.util.setValue("admitted" + id, person.admitted);
                        dwr.util.setValue("college" + id, person.college);
                        dwr.util.setValue("department" + id, person.department);
                        dwr.util.setValue("admissionCriteria" + id, person.admissionCriteria);                            
                        $("pattern" + id).style.display = "table-row";
                        //peopleCache[id] = person;
                    }
                });
            }
        </script>
    </head>
    <body>
       <table>            
            <tbody>
                <tr>
                <td><a href="main.jsp">Dashboard</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="users.jsp">Users</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="collegedepartments.jsp">College Department</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="collegeseats.jsp">Reservation Details</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="admin.jsp">Admin</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="j_acegi_logout">Logout</a></td>
                </tr>
            </tbody>
        </table>
        
        <br/>
        <br/>
        <input type="radio" name="filter" value="Rank" />Rank
        <input type="radio" name="filter" value="HallTicket" />HallTicket
        <input type="radio" name="filter" value="College" />College
        <br/>
        <input type="text" id="hallTicketNos" value="" /><input type="submit" value="Search" onclick="search();"/>
        
        <input type="submit" value="<" onclick="previous();"/><input type="submit" value=">" onclick="next();"/>
        <table border="0" class="rowed grey">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Hall Ticket No</th>   
                    <th>Rank</th>
                    <th>Admitted</th>
                    <th>College</th>
                    <th>Department</th>
                    <th>Criteria</th>
                </tr>
            </thead>
            <tbody id="peoplebody">
                <tr id="pattern" style="display:none;">
                    <td><span id="name"></span><br/></td>
                    <td><span id="hallTicketNo"></span></td>
                    <td><span id="rank"></span></td>
                    <td><span id="admitted"></span></td>
                    <td><span id="college"></span></td>
                    <td><span id="department"></span></td>
                    <td><span id="admissionCriteria"></span></td>
                </tr>
            </tbody>
        </table>
        <script type="text/javascript">            
            onload = fillTable();
        </script>
    </body>
</html>
