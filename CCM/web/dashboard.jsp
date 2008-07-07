<%-- 
    Document   : dashboard
    Created on : Jul 7, 2008, 9:05:40 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxWorkService.js'></script>
        
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        <script type='text/javascript' >
            function intialDisplay() {
                AjaxWorkService.getActiveSystems(function(systems) {
                    for ( var i = 0; i < systems.length; i++ ) {
                        enableAndColorButton(systems[i].name, systems[i].isAvailable);                        
                    }
                });
            }
            function enableAndColorButton(systemNo, isAvailable) {         
               
                if ( systemNo == 1 ) {     
                    document.getElementById("btn1").disabled = false;
                    //document.form1.btn1.disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn1").style.color ="GREEN";
                    } else {
                        document.getElementById("btn1").style.color ="RED";
                    }
                } else  if ( systemNo == 2 ) {
                    document.getElementById("btn2").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn2").style.color ="GREEN";
                    } else {
                        document.getElementById("btn2").style.color ="RED";
                    }
                }else  if ( systemNo == 3 ) {                    
                    document.getElementById("btn3").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn3").style.color ="GREEN";
                    } else {
                        document.getElementById("btn3").style.color ="RED";
                    }
                }else  if ( systemNo == 4 ) {
                    document.getElementById("btn4").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn4").style.color ="GREEN";
                    } else {
                        document.getElementById("btn4").style.color ="RED";
                    }
                }else  if ( systemNo == 5 ) {
                    document.getElementById("btn5").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn5").style.color ="GREEN";
                    } else {
                        document.getElementById("btn5").style.color ="RED";
                    }
                }else  if ( systemNo == 6 ) {
                    document.getElementById("btn6").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn6").style.color ="GREEN";
                    } else {
                        document.getElementById("btn6").style.color ="RED";
                    }
                }else  if ( systemNo == 7 ) {
                    document.form1.btn7.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn7.style.color ="GREEN";
                    } else {
                        document.form1.btn7.style.color ="RED";
                    }
                }else  if ( systemNo == 8 ) {
                    document.form1.btn8.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn8.style.color ="GREEN";
                    } else {
                        document.form1.btn8.style.color ="RED";
                    }
                }else  if ( systemNo == 9 ) {
                    document.form1.btn9.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn9.style.color ="GREEN";
                    } else {
                        document.form1.btn9.style.color ="RED";
                    }
                }else  if ( systemNo == 10 ) {
                    document.form1.btn10.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn10.style.color ="GREEN";
                    } else {
                        document.form1.btn10.style.color ="RED";
                    }
                }else  if ( systemNo == 11 ) {
                    document.form1.btn11.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn11.style.color ="GREEN";
                    } else {
                        document.form1.btn11.style.color ="RED";
                    }
                }else  if ( systemNo == 12 ) {
                    document.form1.btn12.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn12.style.color ="GREEN";
                    } else {
                        document.form1.btn12.style.color ="RED";
                    }
                }else  if ( systemNo == 13 ) {
                    document.form1.btn13.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn13.style.color ="GREEN";
                    } else {
                        document.form1.btn13.style.color ="RED";
                    }
                }else  if ( systemNo == 14 ) {
                    document.form1.btn14.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn14.style.color ="GREEN";
                    } else {
                        document.form1.btn14.style.color ="RED";
                    }
                }else  if ( systemNo == 15 ) {
                    document.form1.btn15.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn15.style.color ="GREEN";
                    } else {
                        document.form1.btn15.style.color ="RED";
                    }
                }else  if ( systemNo == 16 ) {
                    document.form1.btn16.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn16.style.color ="GREEN";
                    } else {
                        document.form1.btn16.style.color ="RED";
                    }
                }else  if ( systemNo == 17 ) {
                    document.form1.btn17.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn17.style.color ="GREEN";
                    } else {
                        document.form1.btn17.style.color ="RED";
                    }
                }else  if ( systemNo == 18 ) {
                    document.form1.btn18.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn18.style.color ="GREEN";
                    } else {
                        document.form1.btn18.style.color ="RED";
                    }
                }else  if ( systemNo == 19 ) {
                    document.form1.btn19.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn19.style.color ="GREEN";
                    } else {
                        document.form1.btn19.style.color ="RED";
                    }
                }else  if ( systemNo == 20 ) {
                    document.form1.btn20.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn20.style.color ="GREEN";
                    } else {
                        document.form1.btn20.style.color ="RED";
                    }
                }else  if ( systemNo == 21 ) {
                    document.form1.btn21.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn21.style.color ="GREEN";
                    } else {
                        document.form1.btn21.style.color ="RED";
                    }
                }else  if ( systemNo == 22 ) {
                    document.form1.btn22.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn22.style.color ="GREEN";
                    } else {
                        document.form1.btn22.style.color ="RED";
                    }
                }else  if ( systemNo == 23 ) {
                    document.form1.btn23.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn23.style.color ="GREEN";
                    } else {
                        document.form1.btn23.style.color ="RED";
                    }
                }else  if ( systemNo == 24 ) {
                    document.form1.btn24.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn24.style.color ="GREEN";
                    } else {
                        document.form1.btn24.style.color ="RED";
                    }
                }else  if ( systemNo == 25 ) {
                    document.form1.btn25.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn25.style.color ="GREEN";
                    } else {
                        document.form1.btn25.style.color ="RED";
                    }
                }else  if ( systemNo == 26 ) {
                    document.form1.btn26.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn26.style.color ="GREEN";
                    } else {
                        document.form1.btn26.style.color ="RED";
                    }
                }else  if ( systemNo == 27 ) {
                    document.form1.btn27.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn27.style.color ="GREEN";
                    } else {
                        document.form1.btn27.style.color ="RED";
                    }
                }else  if ( systemNo == 28 ) {
                    document.form1.btn28.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn28.style.color ="GREEN";
                    } else {
                        document.form1.btn28.style.color ="RED";
                    }
                }else  if ( systemNo == 29 ) {
                    document.form1.btn29.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn29.style.color ="GREEN";
                    } else {
                        document.form1.btn29.style.color ="RED";
                    }
                }else  if ( systemNo == 30 ) {
                    document.form1.btn30.disabled =false;
                    if ( isAvailable == true ) {
                        document.form1.btn30.style.color ="GREEN";
                    } else {
                        document.form1.btn30.style.color ="RED";
                    }
                }
            }
        
            function buttonClick(systemNo) {
                //alert ( systemNo );
                AjaxWorkService.getSystemByNameAndOrganization(systemNo, reply1);
            }
            
            var reply1 = function(system) {
                
                if ( system.isAvailable == true)  {
                    if ( confirm("Are you sure your want to lease this Computer? ") ) {
                        AjaxWorkService.leaseSystem(system.id, function(data) {
                           
                            document.getElementById("btn" + system.name).style.color = "RED"; 
                           
                        } );
                        
                    }
                                       
                } else {
                    if ( confirm("Are you sure your want to unlease this Computer? ") ) {
                        var x;
                        AjaxWorkService.getPayableAmount(system.id, function(data) {
                            if ( (x = prompt("Payable Amount : ",data) ) != null ) {
                                AjaxWorkService.unleaseSystem(system.id, x, function(data) {
                                    alert ( data );
                                } );
                                document.getElementById("btn" + system.name).style.color = "GREEN";                    
                            }
                        });
                        
                    }
                }
            }
            
        </script>
        
    </head>
    <body>
        <!--<form id="form1" id="form1"> -->
        <table>            
            <tbody>
                <tr>
                    <td><a href="dashboard.jsp">Dashboard</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="users.jsp">Users</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="systems.jsp">Systems</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="emails.jsp">Emails</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="emailtimings.jsp">Email & SMS Timing</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>    
                    <td><a href="organization.jsp">Organization</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="systemlease.jsp">History</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="report.jsp">Report</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="suggestions.jsp">Suggestions</a></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><a href="j_acegi_logout">Logout</a></td>
                </tr>
            </tbody>
        </table>
        <br/>
        <br/>
        <br/>
        <table border="0" width="5" cellspacing="5" cellpadding="5">
            
            <tbody>
                <tr>
                    <td><input type="submit" id="btn1" value="1" size="40" onclick="buttonClick(1);" disabled /></td>
                    <td><input type="submit" id="btn2" value="2" size="40" onclick="buttonClick(2);" disabled/></td>
                    <td><input type="submit" id="btn3" value="3" size="40"  onclick="buttonClick(3);" disabled/></td>
                    <td><input type="submit" id="btn4" value="4" size="40"  onclick="buttonClick(4);" disabled/></td>
                    <td><input type="submit" id="btn5" value="5" size="40"  onclick="buttonClick(5);" disabled/></td>
                    <td><input type="submit" id="btn6" value="6" size="40"  onclick="buttonClick(6);" disabled/></td>
                    <td><input type="submit" id="btn7" value="7" size="40"  onclick="buttonClick(7);" disabled /></td>
                    <td><input type="submit" id="btn8" value="8" size="40"  onclick="buttonClick(8);" disabled/></td>
                    <td><input type="submit" id="btn9" value="9" size="40"  onclick="buttonClick(9);" disabled/></td>
                    <td><input type="submit" id="btn10" value="10" size="40"  onclick="buttonClick(10);" disabled/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="btn11" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="btn19" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                    <td><input type="submit" id="1" value="1" size="40" disabled/></td>
                </tr>
            </tbody>
        </table>
        <!-- </form> -->
        <script type="text/javascript">
            onload = intialDisplay();
        </script>
    </body>
    
</html>
