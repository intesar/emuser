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
        <title>Dashboard</title>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxWorkService.js'></script>
        
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        <script type='text/javascript' >
            function intialDisplay() {
                dwr.util.useLoadingMessage();

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
                    document.getElementById("btn7").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn7").style.color ="GREEN";
                    } else {
                        document.getElementById("btn7").style.color ="RED";
                    }
                }else  if ( systemNo == 8 ) {
                    document.getElementById("btn8").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn8").style.color ="GREEN";
                    } else {
                        document.getElementById("btn8").style.color ="RED";
                    }
                }else  if ( systemNo == 9 ) {
                    document.getElementById("btn9").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn9").style.color ="GREEN";
                    } else {
                        document.getElementById("btn9").style.color ="RED";
                    }
                }else  if ( systemNo == 10 ) {
                    document.getElementById("btn10").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn10").style.color ="GREEN";
                    } else {
                        document.getElementById("btn10").style.color ="RED";
                    }
                }else  if ( systemNo == 11 ) {
                    document.getElementById("btn11").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn11").style.color ="GREEN";
                    } else {
                        document.getElementById("btn11").style.color ="RED";
                    }
               }else  if ( systemNo == 12 ) {
                    document.getElementById("btn12").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn12").style.color ="GREEN";
                    } else {
                        document.getElementById("btn12").style.color ="RED";
                    }
                }else  if ( systemNo == 13 ) {
                    document.getElementById("btn13").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn13").style.color ="GREEN";
                    } else {
                        document.getElementById("btn13").style.color ="RED";
                    }
                }else  if ( systemNo == 14 ) {
                    document.getElementById("btn14").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn14").style.color ="GREEN";
                    } else {
                        document.getElementById("btn14").style.color ="RED";
                    }
                }else  if ( systemNo == 15 ) {
                    document.getElementById("btn15").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn15").style.color ="GREEN";
                    } else {
                        document.getElementById("btn15").style.color ="RED";
                    }
                }else  if ( systemNo == 16 ) {
                    document.getElementById("btn16").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn16").style.color ="GREEN";
                    } else {
                        document.getElementById("btn16").style.color ="RED";
                    }
                }else  if ( systemNo == 17 ) {
                    document.getElementById("btn17").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn17").style.color ="GREEN";
                    } else {
                        document.getElementById("btn17").style.color ="RED";
                    }
                }else  if ( systemNo == 18 ) {
                    document.getElementById("btn18").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn18").style.color ="GREEN";
                    } else {
                        document.getElementById("btn18").style.color ="RED";
                    }
                }else  if ( systemNo == 19 ) {
                    document.getElementById("btn19").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn19").style.color ="GREEN";
                    } else {
                        document.getElementById("btn19").style.color ="RED";
                    }
               }else  if ( systemNo == 20 ) {
                    document.getElementById("btn20").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn20").style.color ="GREEN";
                    } else {
                        document.getElementById("btn20").style.color ="RED";
                    }
                }else  if ( systemNo == 21 ) {
                    document.getElementById("btn21").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn21").style.color ="GREEN";
                    } else {
                        document.getElementById("btn21").style.color ="RED";
                    }
                }else  if ( systemNo == 22 ) {
                    document.getElementById("btn22").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn22").style.color ="GREEN";
                    } else {
                        document.getElementById("btn22").style.color ="RED";
                    }
               }else  if ( systemNo == 23 ) {
                    document.getElementById("btn23").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn23").style.color ="GREEN";
                    } else {
                        document.getElementById("btn23").style.color ="RED";
                    }
                }else  if ( systemNo == 24 ) {
                    document.getElementById("btn24").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn24").style.color ="GREEN";
                    } else {
                        document.getElementById("btn24").style.color ="RED";
                    }
                }else  if ( systemNo == 25 ) {
                    document.getElementById("btn25").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn25").style.color ="GREEN";
                    } else {
                        document.getElementById("btn25").style.color ="RED";
                    }
                }else  if ( systemNo == 26 ) {
                    document.getElementById("btn26").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn26").style.color ="GREEN";
                    } else {
                        document.getElementById("btn26").style.color ="RED";
                    }
                }else  if ( systemNo == 27 ) {
                    document.getElementById("btn27").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn27").style.color ="GREEN";
                    } else {
                        document.getElementById("btn27").style.color ="RED";
                    }
                }else  if ( systemNo == 28 ) {
                    document.getElementById("btn28").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn28").style.color ="GREEN";
                    } else {
                        document.getElementById("btn28").style.color ="RED";
                    }
                }else  if ( systemNo == 29 ) {
                    document.getElementById("btn29").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn29").style.color ="GREEN";
                    } else {
                        document.getElementById("btn29").style.color ="RED";
                    }
                }else  if ( systemNo == 30 ) {
                    document.getElementById("btn30").disabled =false;
                    if ( isAvailable == true ) {
                        document.getElementById("btn30").style.color ="GREEN";
                    } else {
                        document.getElementById("btn30").style.color ="RED";
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
        <style>
            input.itext { font-size: smaller; background: #E4E4E4; border: 0; }
            input.ibutton { font-size: xx-small; border: 1px outset; margin: 0px; padding: 0px; }
            span.reply { background: #ffffdd; white-space: pre; }
            span.warning { font-size: smaller; color: red; }
        </style>
    </head>
    <body onload='dwr.util.useLoadingMessage()'>
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
        <table border="0" width="5" cellspacing="5" cellpadding="5" align="center">
            
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
                    <td><input type="submit" id="btn11" value="11" size="40" onclick="buttonClick(11);" disabled /></td>
                    <td><input type="submit" id="btn12" value="12" size="40" onclick="buttonClick(12);" disabled/></td>
                    <td><input type="submit" id="btn13" value="13" size="40"  onclick="buttonClick(13);" disabled/></td>
                    <td><input type="submit" id="btn14" value="14" size="40"  onclick="buttonClick(14);" disabled/></td>
                    <td><input type="submit" id="btn15" value="15" size="40"  onclick="buttonClick(15);" disabled/></td>
                    <td><input type="submit" id="btn16" value="16" size="40"  onclick="buttonClick(16);" disabled/></td>
                    <td><input type="submit" id="btn17" value="17" size="40"  onclick="buttonClick(17);" disabled /></td>
                    <td><input type="submit" id="btn18" value="18" size="40"  onclick="buttonClick(18);" disabled/></td>
                    <td><input type="submit" id="btn19" value="19" size="40"  onclick="buttonClick(19);" disabled/></td>
                    <td><input type="submit" id="btn20" value="20" size="40"  onclick="buttonClick(20);" disabled/></td>
                </tr>
                 <tr>
                    <td><input type="submit" id="btn21" value="21" size="40" onclick="buttonClick(21);" disabled /></td>
                    <td><input type="submit" id="btn22" value="22" size="40" onclick="buttonClick(22);" disabled/></td>
                    <td><input type="submit" id="btn23" value="23" size="40"  onclick="buttonClick(23);" disabled/></td>
                    <td><input type="submit" id="btn24" value="24" size="40"  onclick="buttonClick(24);" disabled/></td>
                    <td><input type="submit" id="btn25" value="25" size="40"  onclick="buttonClick(25);" disabled/></td>
                    <td><input type="submit" id="btn26" value="26" size="40"  onclick="buttonClick(26);" disabled/></td>
                    <td><input type="submit" id="btn27" value="27" size="40"  onclick="buttonClick(27);" disabled /></td>
                    <td><input type="submit" id="btn28" value="28" size="40"  onclick="buttonClick(28);" disabled/></td>
                    <td><input type="submit" id="btn29" value="29" size="40"  onclick="buttonClick(29);" disabled/></td>
                    <td><input type="submit" id="btn30" value="30" size="40"  onclick="buttonClick(30);" disabled/></td>
                </tr>
            </tbody>
        </table>
        
        
        <!-- </form> -->
        <script type="text/javascript">
            onload = intialDisplay();
        </script>
    </body>
    
</html>
