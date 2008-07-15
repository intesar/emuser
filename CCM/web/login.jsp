<html>
    <head>
        <title>Counselling Engine Secure Login System</title>
        
    </head>
    
    <style>
        a:link    {color:black; text-decoration:none; font-size:8.5pt}
        a:hover   {color:black; text-decoration:none; 
            font-size:8.5pt}
        a:active  {color:black; text-decoration:none; font-size:8.5pt}
        a:visited {color:black; text-decoration:none; font-size:8.5pt}
    </style>
    <style>
        a:link    {color:black; text-decoration:none; font-size:8.5pt}
        a:hover   {color:black; text-decoration:none; 
            font-size:8.5pt}
        a:active  {color:black; text-decoration:none; font-size:8.5pt}
        a:visited {color:black; text-decoration:none; font-size:8.5pt}
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
    
    <body>
        <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED> Sorry, but either the username or password is incorrect.
        </font></b> <% }%>
        


        <table align="center">
            <tr>
                <td>
                    <h2>
                        <p align="center">CyberCafeManager</p>
                    </h2>
                </td>    
            </tr>
        </table> 
        
        <table border="0" width="100%" rules="none">
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
        <br>
        
        <form action="j_acegi_security_check" method="POST">
            
            <table width="100%">
                
                <td width="30%" height="20">
                    <table width="100%">
                        <tr><td>User:</td><td><input type='text' name='j_username'> </td></tr>
                        <tr><td>Password:</td><td><input type='password' name='j_password'> </td></tr>
                        
                        <tr><td></td><td colspan='2'>
                                
                        <input name="submit"  value="Sign In" type="submit" ></td></tr>
                        <tr>
                            <td>
                                <a href="registration.jsp">Sign Up</a> <br><br>
                                <a href="forgotpassword.jsp">Fogot Username or Password?</a>
                            </td>
                        </tr>
                        
                        
                    </table>
                </td>
                
                <td width="60%">
                    <table>
                        <tr>
                            <td>
                                <p >
                                    Online CyberCafeManager increases your revenew, manages your CyberCafe, reduces your stress, keeps you in touch with your CyberCafe from anywhere. 
                                    <br><br>
                                        Online CyberCafeManager Eliminates unauthorized usage of your CyberCafe's computers.
                                    <br><br>
                                       Online CyberCafeManager is in compliance with the Indian Cyber Law, which keeps your business running without future hurdles. 
                                    <br><br>
                                        Online CyberCafeManager keeps you connected to your CyberCafe.
                                    <br><br>
                                    <br><br>
                                    <br><br>
                                    <br><br>    
                                </p>
                                
                            </td>
                        </tr>
                    </table>
                </td>
                
                <td width="10%">
                    454545454545454242124
                </td>
                
            </table>
            
            
            
        </form>
        
    </body>
</html>
