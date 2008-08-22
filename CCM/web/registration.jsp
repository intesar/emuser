<%-- 
    Document   : registration
    Created on : Jul 7, 2008, 1:36:50 PM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>
        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function createAccount() {
                var c = dwr.util.getValue("companyName");
                var u = dwr.util.getValue("email");
                var p = dwr.util.getValue("password");
                var cp = dwr.util.getValue("confirmPassword");
                var minutes = dwr.util.getValue("minutes");
                var rate = dwr.util.getValue("rate");
                //alert ( c + u + p + cp);
                if ( p == cp) {
                    AjaxUserService.registerNewOrganization ( c, "hyd", u, p, minutes, rate, reply1);
                } else {
                    alert ( " Password & ConfirmPassword donot match");
                }
            }
            
            var reply1 = function ( data ) {
                alert ( data );
            }
            
        </script>
    </head>
    
    
    
    
    
    
    
    
    
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
    
    <body>
        
        
        <table align="center" bordercolor="#EDDA74" border="2" rules="none" width="80%">
            <tr>
                <td>
                    <h2>
                        <p align="center">CyberCafeManager</p>
                    </h2>
                </td>    
            </tr>
        </table> 
        
        <table border="0" width="80%" rules="none" align="center">
            <tr>
                <td align="right">
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
                &nbsp;&nbsp;&nbsp; <span  id=clock  style="position:relative;"></span></td>
            </tr>
        </table>
        <br>
        
        <p align="left"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Register Your CyberCafe</font></p> 
        
        <table border="2" width="80%" align="center" rules="none" bordercolor="#EDDA74">
            
            
            <tr>
                <td> <table border="0" width="50%" >
                        
                        <tr>
                            <td>Company Name</td>
                            <td><input type="text" name="companyName" value="" size="30"/></td>
                        </tr>
                        <tr>
                            <td>Username/Email</td>
                            <td><input type="text" name="email" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Confirm Password</td>
                            <td><input type="password" name="confirmPassword" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Minimum Minute Rate</td>
                            <td><select name="minutes">
                                    <option value="15">Minimum 15 Minutes</option>
                                    <option value="30">Minimum 30 Minutes</option>
                                    <option value="60">Minimum 60 Minutes</option>
                                </select>
                                <select name="rate">
                                    <option value="1">Rs 1</option>
                                    <option value="2">Rs 2</option>
                                    <option value="3">Rs 3</option>
                                    <option value="4">Rs 4</option>
                                    <option value="5">Rs 5</option>
                                    <option value="6">Rs 6</option>
                                    <option value="7">Rs 7</option>
                                    <option value="8">Rs 8</option>
                                    <option value="9">Rs 9</option>
                                    <option value="10">Rs 10</option>
                                    <option value="11">Rs 11</option>
                                    <option value="12">Rs 12</option>
                                    <option value="13">Rs 13</option>
                                    <option value="14">Rs 14</option>
                                    <option value="15">Rs 15</option>
                                    <option value="16">Rs 16</option>
                                    <option value="17">Rs 17</option>
                                    <option value="18">Rs 18</option>
                                    <option value="19">Rs 19</option>
                                    <option value="20">Rs 20</option>
                                    <option value="21">Rs 21</option>
                                    <option value="22">Rs 22</option>
                                    <option value="23">Rs 23</option>
                                    <option value="24">Rs 24</option>
                                    <option value="25">Rs 25</option>
                                    <option value="26">Rs 26</option>
                                    <option value="27">Rs 27</option>
                                    <option value="28">Rs 28</option>
                                    <option value="29">Rs 29</option>
                                    <option value="30">Rs 30</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="reset" value="Clear" />
                            <input type="submit" value="Create" onclick="createAccount();"/></td>
                        </tr>
                        
                </table></td>
                <td width="50%" >
                    
                    <font size="2" face="verdena">
                        <br>
                        BizIntelApps product, Online CyberCafeManager provides a new kind of security to internet cafes, built on the idea that CyberCafe owners can increase their Revenue, manage their CyberCafes from any where in India, become stress free of the transactions in their CyberCafe. <br><br>
                        
                        BizIntelApps product, Online CyberCafeManager provides the features that makes you feel that you are in your CyberCafe.<br><br>
                        
                        BizIntelApps product, Online CyberCafeManager sends you Email and SMS off all the transactions that are happenning in your CyberCafe.<br><br>       
                        
                    </font>
                </td>
            </tr>
            <tr>
                <td> <font size="2">Click here to</font><a href="login.jsp"> Sign in</a></td>
                
            </tr>
            
        </table>
        <br>
        <br>
        <br> <br>
        <br>
        <br> <br>
        <br>
        
        <p align="center">
            <font size="2"> &copy; Copyrights BizIntelApps 2008 All Rights Reserved. <a href="http://bizintelapps.net/"><font color="blue">BizIntelApps</font></a> </font>
        </p>
        
    </body>
</html>
