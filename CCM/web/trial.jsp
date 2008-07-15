<%-- 
    Document   : trial
    Created on : 15 Jul, 2008, 1:15:41 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<title>Counselling Engine Secure Login System</title></head></html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<style>
    a:link    {color:black; text-decoration:none; font-size:10pt}
    a:hover   {color:black; text-decoration:none; 
        font-size:8.5pt}
    a:active  {color:black; text-decoration:none; font-size:10pt}
    a:visited {color:black; text-decoration:none; font-size:10pt}
</style>
<style>
    a:link    {color:black; text-decoration:none; font-size:10pt}
    a:hover   {color:black; text-decoration:none; 
        font-size:8.5pt}
    a:active  {color:black; text-decoration:none; font-size:10pt}
    a:visited {color:black; text-decoration:none; font-size:10pt}
</style>


<!-- This is to display the time -->
<script  language="javascript"  type="text/javascript">
    
    <!-- Begin
    function MakeArrayday(size) {
        this.length = size;
        for(var i = 1; i <= size; i++) {
            this[i] = "";
        }
        return this;
    }
    function MakeArraymonth(size) {
        this.length = size;
        for(var i = 1; i <= size; i++) {
            this[i] = "";
        }
        return this;
    }
    function funClock() {

        var runTime = new Date();
        var hours = runTime.getHours();
        var minutes = runTime.getMinutes();
        var seconds = runTime.getSeconds();
        var dn = "AM";
        if (hours >= 12) {
            dn = "PM";
            hours = hours - 12;
        }
        if (hours == 0) {
            hours = 12;
        }
        if (minutes <= 9) {
            minutes = "0" + minutes;
        }
        if (seconds <= 9) {
            seconds = "0" + seconds;
        }
        movingtime = "<b>"+ hours + ":" + minutes + ":" + seconds + " " + dn + "</b>";
        document.getElementById('clock').innerHTML = movingtime;
        setTimeout("funClock()", 1000)
    }
    window.onload = funClock;
    //  End -->
</script>

<!-- display time ends here -->



<link href="CMTC.css" rel="stylesheet" type="text/css">

</head>

<body topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0">

<% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username<br> or password is incorrect.
</font></b> <% }%>

<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" rules="none"     bordercolor="" bgcolor="6EBFDF">
    <tr bgcolor=""> 
        <td height="100" colspan="3">
            <p>
                <h2 align="center">  CyberCafeManager </h2>
            </p>
            <div align="left"><img src="newheader.gif" width="900" height="100"></div>
        <div align="right"></div></td>
    </tr>
    <tr bgcolor="#D3EFE3"> 
        <td width="55%" bgcolor="#FFFFFF">
            <div align="left"> 
                <table width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="39%" height="35">
                            
                            
                        </td>
                        
                    </tr>
                </table>
                
            </div>
        </td>
        
        <td width="65%" bgcolor="#FFFFFF"><div align="left"><strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <script language="javascript" type="text/javascript">
                        
                        var mydate=new Date()
                        var year=mydate.getYear()
                        if (year < 1000)
                            year+=1900
                        var day=mydate.getDay()
                        var month=mydate.getMonth()
                        var daym=mydate.getDate()
                        if (daym<10)
                            daym="0"+daym
                        var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
                        var montharray=new Array("January","February","March","April","May","June","July","August","September","October","November","December")
                        document.write("<small><font color='000000' face='Arial'><b>"+dayarray[day]+", "+montharray[month]+" "+daym+", "+year+"</b></font></small>")
                    </script> 
                    
        &nbsp;&nbsp;&nbsp; <span  id=clock  style="position:relative;"></span></strong> </div></td>
        
    </tr>
</table>




<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<td width="100%" height="60%" > 
    
    <table width="100%" height="480" border="1" align="center" rules="none" cellpadding="0" cellspacing="0" bordercolor="">
        <tr> 
            <td height="425" valign="top">
                <table width="100%" height="441" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                        <td width="222"   valign="top"><div align="left"> 
                                
                                <table width="100%" height="307"  border="0" cellpadding="0" cellspacing="0" hspace="30">
                                    <tr> 
                                        <td> 
                                            
                                            
                                            
                                            <br>
                                            <table width="100%" rules="none" border="0" cellpadding="0" cellspacing="0">
                                                
                                                
                                                <tr><td>User:</td><td><input type='text' name='j_username'> </td></tr>
                                                <tr><td>Password:</td><td><input type='password' name='j_password'> </td></tr>
                                                
                                                <tr><td></td><td colspan='2'>
                                                        
                                                        
                                                <input type="submit" name="submit" value="Sign In"></td></tr>  
                                                
                                                <tr><td> <a href="registration.jsp">Sign Up</a> <br><br>
                                                <a href="forgotpassword.jsp">Fogot Username or Password?</a></td></tr>
                                                
                                                
                                                
                                                
                                            </table>
                                        </td>
                                    </tr>
                                    
                                    
                                    
                                    
                                    
                                </table>
                        </div></td>
                        
                        <td width="1" rowspan="2" bgcolor="">
                            
                            
                            <table border="0" cellpadding="0" cellspacing="0" rules="none">
                                <tr > 
                                    <td>&nbsp;</td>
                                </tr>
                                <tr> 
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                            
                        </td>
                        
                        <td width="511" rowspan="2" valign="top"><table width="100%" height="88%" border="0" cellpadding="0" cellspacing="0" rules="none">
                                <tr> 
                                    <td height="19" colspan="3"><div align="center"></div></td>
                                </tr>
                                <tr> 
                                    <td height="24" colspan="3"><div align="center"></div>
                                        <div align="center"> </div>
                                        <div align="center"><font size="-3" face="Verdana"><strong>Senior 
                                                    citizen&#8217;s here is AASARA, to make your life easier<br>
                                                    
                                                    Avail this Great range of facilities today to have<br>
                                    A Peaceful, Stress-Free tomorrow. </strong></font></div></td>
                                </tr>
                                <tr> 
                                    <td width="12%" height="128">&nbsp;</td>
                                    <td width="82%" valign="top"><div align="center"><img src="asara2.jpg" width="375" height="352"></div></td>
                                    <td>&nbsp;</td>
                                </tr>
                                
                        </table></td>
                        <td width="3" rowspan="2" bgcolor="#67B6E1"><font size="-7">&nbsp;</font></td>
                        <td width="246" rowspan="2" align="left" valign="top"><div align="right"> 
                                
                                
                                
                                <table width="50%" height="352" border="0" align="left" cellpadding="0" cellspacing="0" bordercolor="" rules="none">
                                    
                                    
                                    3rd column
                                    
                                    
                                    
                                </table>
                        </div></td>
                        
                    </tr>
            </table></td>
        </tr>
    </table>
    
</td>




<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<body>
<table width="100%" height="27" border="0" align="center" cellpadding="0" cellspacing="0" rules="none">
    <tr>
        <td bgcolor=""><div align="center"><font color="#000000" size="2" face="Verdana"><strong>Copyright 
                        &copy; 2008  <a href="bizintelapps.com">BizIntelApps</a>. All 
        rights reserved. <font size="1"></font></strong></font></div></td>
        
    </tr>
    
</table>