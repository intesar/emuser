<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<html>
    <head>        
        <style type="text/css">
            body {color: white;background: white}
            a { color: white; }
        </style>
        <meta http-equiv="Content-Language" content="en" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />        
        <script type="text/javascript" src="jquery/jquery.js"></script>
        <script type="text/javascript" src="jquery/interface.js"></script>
        
        <link type="text/css" href="jquery/style.css" rel="stylesheet">
        <script type="text/javascript">
            
            function refresh() {        
                window.location.reload();
            }
            function forwardFunction(link) {
                location.href=link;
            }
        </script>
        
    </head>
    <body>
        <div class="dock" id="dock">
            <div  class="dock-container">
                
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('dashboard2.jsp');" class="dock-item" >
                    <img src="dash/1 home.png" alt="Dashboard" title="Dashboard"/>
                    <span style="display: none;">Dashboard</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('users.jsp');" class="dock-item" >
                    <img src="dash/2 users.jpg" title="Control Panel" />
                    <span style="display: none;">Users</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('systems.jsp');" class="dock-item" >
                    <img src="dash/8 system lease.png" title="Computers" />
                    <span style="display: none;">Computers</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('services.jsp');" class="dock-item" >
                    <img src="dash/store_services.png" title="Services" />
                    <span style="display: none;">Extra Services/Products</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('emails.jsp');" class="dock-item" >
                    <img src="dash/4 emails.jpg" title="Emails/SMS"  />
                    <span style="display: none;">Emails/SMS</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('emailtimings.jsp');" class="dock-item" >
                    <img src="dash/5 Time.jpg" title="Report Timing" />
                    <span style="display: none;">Report Time</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('organization.jsp');" class="dock-item" >
                    <img src="dash/profile.png" title="Profile" />
                    <span style="display: none;">Profile</span>
                </a>
                <a style="width: 40px; left: 0px;" onclick="forwardFunction('systemlease.jsp');" class="dock-item" >
                    <img src="dash/history.gif" title="Rental History" />
                    <span style="display: none;">History</span>
                </a>                
                <a style="width: 40px; left: 0px;" class="dock-item" href="#"><img src="dash/9 report.png" title="Billing Report" />
                    <span style="display: none;">Report</span>
                </a>                
                <a onclick="forwardFunction('customer.jsp');" style="width: 40px; left: 0px;" class="dock-item" >
                    <img src="dash/6.jpg" title="Customer Profiles"/>
                    <span style="display: none;">Customers</span>
                </a>                
                <a onclick="forwardFunction('j_acegi_logout');" style="width: 40px; left: 0px;" class="dock-item" >
                    <img src="dash/logout.png" title="LogOut"  alt="11 logout"/>
                    <span style="display: none;">Logout</span>
                </a>                 
                <a onclick="refresh();" class="dock-item" style="width: 40px; left: 0px;"   >
                    <img src="dash/ref.gif" title="Refresh"  alt="11 logout"/>
                    <span style="display: none;">Refresh</span>
                </a> 
            </div> 
        </div>
        
        
        <!--dock menu JS options -->
        <script type="text/javascript">
        
            $(document).ready(
            function()
            {
                $('#dock').Fisheye(
                {
                    maxWidth: 50,
                    items: 'a',
                    itemsText: 'span',
                    container: '.dock-container',
                    itemWidth: 40,
                    proximity: 60,
                    halign : 'center'
                }
            )
                        
            }
        );

        </script>
    </body>
</html> 