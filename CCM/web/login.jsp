<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>FaceGuard</title>
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
        .style16 {color: #FFFFFF}
    </style>
    <script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>
    <script type='text/javascript' src='/CCM/dwr/engine.js'></script>
    <script type="text/javascript" src="email_validation.js"></script>
    <script type='text/javascript' src='/CCM/dwr/util.js'></script>
    
    <script type="text/javascript"> 
        var email = "";
        var password = "";
        function createAccount() {
            var c = dwr.util.getValue("companyName");
            var u = dwr.util.getValue("email");
            var p = dwr.util.getValue("password");
            var cp = dwr.util.getValue("confirmPassword");
            var minutes = dwr.util.getValue("minutes");
            var rate = dwr.util.getValue("rate");
            var maxSystems = dwr.util.getValue("maxSystems");
            //alert ( c + u + p + cp);
            if ( c != null && c != "" && p != null && p != "" && p == cp) {
                if ( validateEmail(u, true, true) ) {
                    email = u;
                    password = p;
                    AjaxUserService.registerNewOrganization ( c, "hyd", u, p, minutes, rate, maxSystems, reply1);
                }
            } else {
                alert ( " Company Name, Password Cannot be Empty Or \n\ " +
                    " Password & ConfirmPassword donot match ");
            }
        
                
            //dwr.engine.endBatch();
                 
               
                    
        } 
                          
            
            
        var reply1 = function ( data ) {            
            if ( data == 'Please login with your email and password') {                        
                //alert ( 'Congratulation Your Account is Created Successfully!' );
                location.href="/CCM/j_acegi_security_check?j_garbage=abcdexehrelasdjf232343lkajflskdjfalsdfjasldkfjasldkfjalsdkjf&j_username=" + email + "&j_password=" + password;
            } else {                    
                alert ( data );
            }                
        }
    </script>
    
    <body>
        
        
        
        <table align="center" width="85%">
            <tr>
                <td width="33%" align="left"><a href="http://www.bizintelapps.net/" target="_blank"><img src="dash/logo.jpg" alt="logo" width="290" height="74" border="0"/></a>
                    <br><br>
                    <table border="0" width="50%" bgcolor="#C00" style="color:#FFF;
                    background:#C00;
                    border-collapse:collapse;
                    width:370px;        
                    border:5px solid #900;" >
                        <thead>
                            <tr>
                                <th></th>
                                <th style="padding:1em 1em .5em;
                                
                                font-size:120%;
                                text-align:left;">
                                    CyberCafe Registration
                                </th>
                                <th></th>
                            </tr>
                        </thead>
                        <tr>
                            <td align="right">Company Name * </td>
                            <td><input type="text" name="companyName" value="" size="30"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="right">Username/Email * </td>
                            <td><input type="text" name="email" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="right">Password * </td>
                            <td><input type="password" name="password" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="right">Confirm Password * </td>
                            <td><input type="password" name="confirmPassword" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="right">Rate *</td>
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
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td align="right">Max Computers * </td>
                            <td>
                                <select name="maxSystems">
                                    <option value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                    <option value="50">50</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                            <input type="submit" value="Create My Account" onclick="createAccount();"/></td>
                        </tr>
                        
                    </table>
                </td>
                
                <td width="4%"><img src="dash/line2.JPG" alt="line2" width="11" height="214" />&nbsp;&nbsp;</td>
                <td width="10%" align="center">
                    
                    <p align="left"><img src="dash/onlinelogo.png" alt="net" height="217"  /></p>
                    
                </td>
                <td width="4%">&nbsp;&nbsp;&nbsp; <img src="dash/line.JPG" alt="line" width="14" height="316" /></td>
                
                <td width="31%" align="right">
                     <table align="left"  style="color:#FFF;
                    background:#C00;
                    width:290px;
                    height:170px;
                    border-collapse:collapse;
                    border:5px solid #900;">
                        <tr>
                            <td>
                                
                                <font color="green" size="4" >
                                    <tr><td>* FaceGuard.org is webased Cyber Cafe Manager Suite</td></tr>
                                    <tr><td>* Compliance with Cyber Laws</td></tr>
                                    <tr><td>* Save Rs 6,000/month by removing unauthorize usage</td></tr>
                                    <tr><td>* Save Electricity bills (Intelligent Shutdown)</td></tr>
                                    <tr><td>* Bill Printing, Scanning, Snacks, and vitually anything.</td></tr>
                                    <tr><td>* Free Report via SMS/Emails</td></tr>
                                    <tr><td>* Automatic backups every day data.</td></tr>
                                    <tr><td>* Tackle Terrorism, Crime, Missuse etc</td></tr>
                                    
                                </font>
                            </td>
                        </tr>
                    </table>
                    <form action="j_acegi_security_check" method="POST" id="login_form">
                        <table align="left" style="color:#FFF;
                        background:#C00;
                        width:290px;
                        height:170px;
                        border-collapse:collapse;
                        border:5px solid #900;">
                            <thead>
                                <tr>
                                    <th   style="padding:1em 1em .5em;
                                    font-size:120%;
                                    text-align:left;">Login</th>
                                    <th  style="padding:1em 1em .5em;
                                    font-size:120%;
                                    text-align:left;">FaceGuard</th>
                                    
                                </tr>
                            </thead>
                            <tr>
                                <td align="right"> Email *</td>
                                <td><input type='text' name='j_username' size="25" /> </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr> <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="right">Password *</td>
                                <td><input type='password' name='j_password' size="25"> </td>
                            </tr>
                            <tr>
                                <td></td>    
                                <td>
                                    <input type="submit" value="Sign In" name="Sign In"  />
                                    <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Sorry, but either the username or password is incorrect.
                                    </font></b> <% }%> 
                                </td>      
                            </tr>
                            <tr> 
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                            <td></td>
                            <td>
                                <a href="forgotpassword.jsp"><font size="-1" > Forgot Username or Password?</font></a>
                            </td>
                        </table>       
                    </form>
                   
                </td>
            </tr>
            <tr>
                
            </tr>
        </table>
        
        
        <p align="center" >
        
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Home Page </a> | 
        <a style="color:blue" href="http://secure.bizintelapps.net/index.php?option=com_content&view=article&id=1&Itemid=2/" >Features </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Client Software </a> | 
        <a style="color:blue" href="customer_registration.jsp" >Customer Self Registration </a> | 
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Customer Testimonials </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Suport Forum </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Suggestions </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Benefits </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" >Tutorials & Demo </a> |
        <a style="color:blue" href="http://secure.bizintelapps.net/" > Live Chat With Representative</a> |
        <br>
        <a style="color:blue" href="#" >  Contact Us : </a> 
        <a style="color:blue" href="" > info@bizintelapps.com | USA 773.699.7898 | India 40.65764414 </a>
        
        <p style="color:blue" align="center"><font size="2">&copy; Copyrights BizIntelApps 2008 All Rights Reserved. <a href="http://bizintelapps.net/" target="_blank"><font color="blue">BizIntelApps</font></a> </font>
        </p>
    </body>
</html>


