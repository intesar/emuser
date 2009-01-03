<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        
        <link rel="stylesheet" type="text/css" media="screen" href="../css/milk.css">
        <link rel="stylesheet" type="text/css" media="screen" href="../css/chili.css">
        <script type="text/javascript" src="../js/lib/jquery-1.2.6.min.js" ></script>
        <script type="text/javascript" src="../js/lib/jquery.validate.js"></script>
        <script type="text/javascript" src="../js/local/signup.validate.js"></script>
        <script type='text/javascript' src='../js/local/signup.js'></script>
        <script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>
        <script type='text/javascript' src='../dwr/engine.js'></script>
        <script type='text/javascript' src='../dwr/util.js'></script>
        
        <style type="text/css">
            pre { text-align: left; }
        </style>        
        
        
    </head>
    <body>
        
        
        <div id="main">
            
            <div id="content">
                
                <div id="header">                    
                </div>
                
                <div style="clear: both;">
                    <div></div>
                </div>
                
                
                <div class="content">
                    
                    <div id="signupwrap">
                        <form id="signupform" autocomplete="off" method="get" action="">
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="label"><label id="lfirstname" for="firstname">First Name</label></td>
                                        <td class="field"><input class="" id="firstname" name="firstname" value="" maxlength="100" type="text"></td>
                                        <td class="status"><label class="" generated="true" for="firstname">&nbsp;</label></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="llastname" for="lastname">Last Name</label></td>
                                        <td class="field"><input class="" id="lastname" name="lastname" value="" maxlength="100" type="text"></td>
                                        <td class="status"><label class="" generated="true" for="lastname">&nbsp;</label></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lusername" for="username">Username</label></td>
                                        <td class="field"><input class="" id="username" name="username" value="" maxlength="50" type="text"></td>
                                        <td class="status"><label class="" generated="true" for="username">&nbsp;</label></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lpassword" for="password">Password</label></td>
                                        <td class="field"><input id="password" name="password" maxlength="50" value="" type="password"></td>
                                        <td class="status"></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lpassword_confirm" for="password_confirm">Confirm Password</label></td>
                                        <td class="field"><input class="" id="password_confirm" name="password_confirm" maxlength="50" value="" type="password"></td>
                                        <td class="status"><label class="" generated="true" for="password_confirm">&nbsp;</label></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lemail" for="email">Email Address</label></td>
                                        <td class="field"><input id="email" name="email" value="" maxlength="150" type="text"></td>
                                        <td class="status"></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lorganization" for="email">Company Name</label></td>
                                        <td class="field"><input id="organization" name="organization" value="" maxlength="150" type="text"></td>
                                        <td class="status"></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lcity" for="email">City</label></td>
                                        <td class="field"><input id="city" name="city" value="" maxlength="150" type="text"></td>
                                        <td class="status"></td>
                                    </tr>
                                    <tr>
                                        <td class="label"><label id="lsignupsubmit" for="signupsubmit">Signup</label></td>
                                        <td class="field" colspan="2">
                                            <input id="signup" name="signup" value="Signup" type="button" onclick="signupClicked();">
                                        </td>
                                    </tr>
                                    <tr></tr>
                                    <tr>
                                        <td></td>
                                        <td><a href="../view/login.jsp"> Login Here </a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>