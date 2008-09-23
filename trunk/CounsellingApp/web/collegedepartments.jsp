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
                var peopleCache = { };
                var viewed = -1;

                function fillTable() {
                    AjaxApplicationService.getCollegeDepartments(dwr.util.getValue("hallTicketNos"),function(people) {
                        // Delete all the rows except for the "pattern" row
                        dwr.util.removeAllRows("peoplebody", { filter:function(tr) {
                                return (tr.id != "pattern");
                            }});
                        // Create a new set cloned from the pattern row
                        var person, id;
                        people.sort(function(p1, p2) { return p1.collegeDepartmentPK.college.localeCompare(p2.collegeDepartmentPK.college); });
                        for (var i = 0; i < people.length; i++) {
                            person = people[i];
                            id = i+1;//person.id;
                            //alert ( person.department + " " + id);
                            dwr.util.cloneNode("pattern", { idSuffix:id });
                            dwr.util.setValue("college" + id, person.collegeDepartmentPK.college);
                            dwr.util.setValue("department" + id, person.collegeDepartmentPK.department);
                            dwr.util.setValue("maxSeats" + id, person.maxSeats);
                            dwr.util.setValue("filledSeats" + id, person.filledSeats);
                            $("pattern" + id).style.display = "table-row";
                            peopleCache[id] = person;
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
        <input type="text" id="hallTicketNos" value="" /><input type="submit" value="Search" onclick="fillTable();"/>
        <input type="submit" value="<" onclick="previous();"/><input type="submit" value=">" onclick="next();"/>
            <table border="0" class="rowed grey">
                <thead>
                    <tr>
                        <th>College</th>
                        <th>Department</th>   
                        <th>Max Seats</th>
                        <th>Filled Seats</th>
                    </tr>
                </thead>
                <tbody id="peoplebody">
                    <tr id="pattern" style="display:none;">
                        <td><span id="college"></span><br/></td>
                        <td><span id="department"></span></td>
                        <td><span id="maxSeats"></span></td>
                        <td><span id="filledSeats"></span></td>
                    </tr>
                </tbody>
            </table>
            <script type="text/javascript">            
                onload = fillTable();
            </script>
        </body>
    </html>
