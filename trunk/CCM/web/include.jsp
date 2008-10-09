<script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>

<!--
<script type='text/javascript' src='/CCM/dwr/engine.js'></script>
<script type='text/javascript' src='/CCM/dwr/util.js'></script>
-->


<script type="text/javascript">
    var isMenuCreated = false;
    function createMenu() {
        if ( !isMenuCreated ) {
            AjaxUserService.getUserRole(function(isAdmin) {
                showDiv(isAdmin);
                isMenuCreated = true;
            });
            
        }
    }
    function showDiv(role) {
        //var role = dwr.util.getValue("role_hidden");
        var m = document.getElementById("mainDiv");
        var a = document.getElementById("adminDiv");
        var b = document.getElementById("employeeDiv");
        var c = document.getElementById("customerDiv");
        //alert ( role );
        if ( role  == "admin" ) {        
            a.style.visibility="visible";            
            m.removeChild(b);
            m.removeChild(c);
        }
        else if ( role == "employee" ) {
            b.style.visibility="visible";            
            m.removeChild(a);
            m.removeChild(c);
        } else {
            c.style.visibility="visible";            
            m.removeChild(a);
            m.removeChild(b);
        }   
      
    } 
            
    function refresh() {
        window.location.reload();
    }
    function forwardFunction(link) {
        location.href=link;
    }
</script>



<div id="mainDiv">
    <div id="adminDiv" align="center">
        <a onclick="forwardFunction('dashboard2.jsp');">
            <img src="icons/dashboard.png" alt="Dashboard" title="Dashboard" />            
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('users.jsp');"><img src="icons/control panel1.png" title="Control Panel" />
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('systems.jsp');"><img src="icons/systems.png" title="Computers" alt="3"/>
        </a>        
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('services.jsp');"><img src="icons/service.png" title="Services"  alt="10 feedback"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('emails.jsp');"><img src="icons/emailsms.png" title="Emails/SMS"  alt="4 emails"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('emailtimings.jsp');"><img src="icons/report time.png" title="Report Timing"  alt="5 Time"/>
        </a>
        &nbsp;&nbsp;&nbsp;    
        <a onclick="forwardFunction('organization.jsp');"><img src="icons/profile.png" title="Profile" alt="7 profile"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('systemlease.jsp');"><img src="icons/rental history.png" title="Rental History" alt="9 history"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('report.jsp');"><img src="icons/billing.png" title="Billing Report" alt="8 report"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('customer.jsp');"><img src="icons/customer profile_1.png" title="Customer Profiles" alt="6"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="icons/myhistory234.png" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="icons/logout.png" title="LogOut" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="icons/re.png" title="Refresh" alt="11 logout"/>
        </a> 
        
    </div>
    
    
    <div id="employeeDiv" style="visibility: hidden" align="center">
        <a onclick="forwardFunction('dashboard2.jsp');">
            <img src="icons/dashboard.png" alt="Dashboard" title="Dashboard" />            
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('customer.jsp');"><img src="icons/customer profile_1.png" title="Customer Profiles" alt="6"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="icons/myhistory234.png" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="icons/logout.png" title="LogOut" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="icons/re.png" title="Refresh" alt="11 logout"/>
        </a> 
    </div>
    
    <div id="customerDiv" style="visibility: hidden" align="center">
        
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="icons/myhistory234.png" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="icons/logout.png" title="LogOut" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="icons/re.png" title="Refresh" alt="11 logout"/>
        </a> 
    </div>
    <br>
    <div align="center">   
        <span id="successReply" style="background-color:#99ff66;"></span>            
        <span id="failureReply" style="background-color:#ff3300; font-weight:bold;"></span>
    </div>
</div>
<br>
<script type="text/javascript">
    window.onload = createMenu();
    function writeMessage(type,  message) {
        dwr.util.setValue (type, message);
        // clear message after 5 seconds
        setTimeout("clearMessages();", 5000);
    }
    function clearMessages() {
        dwr.util.setValue ("failureReply", "" );
        dwr.util.setValue ("successReply", "" );
    }
</script>

