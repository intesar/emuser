<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Pro Accounting</title>
        
        
    </head>
    
    <body >
        <table width="830" height="28" border="0" align="center" bordercolor="#cc0001" bgcolor="#cc0001" >
            <tr>
                <td width="824"><span class="style32">FaceGuard Login </span></td>
            </tr>
        </table>
        <table width="800" height="554" border="0" align="center" bordercolor="#cc0001"  bgcolor="#ffffff">
            <tr>
                <td width="100" height="550" valign="top">
                    <% if (request.getParameter("login_error") != null) {%> <b> <font color=RED size="2"> Invalid Credentials! </font></b> <% }%> 
                    <form action="j_acegi_security_check" method="POST" id="login_form" >
                        <table width="188" border="0" rules="none" align="center" bordercolor="#cc0001" bgcolor="#cc0001">
                            
                            <tr>
                                <td width="185" valign="top"><span class="style28">Email:</span></td>
                            </tr>
                            <tr>
                                
                                <td valign="top">
                                    <label>
                                        <span class="style28"></span>
                                        <input type="text" name='j_username' size="17" />
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top" class="style28">Password:</td>
                                
                            </tr>
                            <tr>
                                <td valign="top">
                                    <label>                                        
                                        <input type="password" name='j_password' size="17" />
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top" align="justify">
                                    <input type="submit" value="Sign In " name="Sign In" />
                                </td>                                
                            </tr>
                            
                        </table>
                    </form>
                    
                    <div align="center">
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Home Page</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Features</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Customer</a> 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Testimonials</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Client</a> 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Software</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Suggestion</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9"> Benifits</a> |
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Tutorials</a> 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">And Demo</a> | 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Live</a> 
                        <a href="http://faceguard.bizintelapps.com/" class="style9">Chat</a> 
                        
                    </div>
                    <p align="center" class="style9"> <a href="http://faceguard.bizintelapps.com/index.php?option=com_contact&view=contact&id=1%3Acontact-bizintelapps&catid=12%3Acontacts&Itemid=62" class="style9">Contact Us</a> | USA 733.699.7898 | India 40.65764414</p>
                    <p align="center" class="style10 style2" >
                <span class="style2">&copy;</span> <span class="style2">Copyrights</span> <span class="style2"><a href="http://www.bizintelapps.com">BizIntelApps</a></span> <span class="style2">2008</span> <span class="style2">All</span> <span class="style2">Rights</span> <span class="style2">Reserved</span>. </p>    </td>
            </tr>
        </table>
        
    </body>
</html>
