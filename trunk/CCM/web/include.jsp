<script type='text/javascript' src='/CCM/dwr/interface/AjaxUserService.js'></script>
<script type='text/javascript' src='/CCM/dwr/engine.js'></script>
<script type='text/javascript' src='/CCM/dwr/util.js'></script>
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
        /*
        else {            
            m.removeChild(a);
            m.removeChild(b);
        }
         */
    
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
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="Dashboard" />            
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('users.jsp');"><img src="dash/2 users.jpg" title="Control Panel" width="40" height="43"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('systems.jsp');"><img src="dash/8 system lease.png" title="Computers" width="40" height="40" alt="3"/>
        </a>        
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('services.jsp');"><img src="dash/store_services.png" title="Services" width="40" height="38" alt="10 feedback"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('emails.jsp');"><img src="dash/4 emails.jpg" title="Emails/SMS"  width="40" height="39" alt="4 emails"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('emailtimings.jsp');"><img src="dash/5 Time.jpg" title="Report Timing" width="40" height="42" alt="5 Time"/>
        </a>
        &nbsp;&nbsp;&nbsp;    
        <a onclick="forwardFunction('organization.jsp');"><img src="dash/profile.png" title="Profile" width="40" height="40" alt="7 profile"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('systemlease.jsp');"><img src="dash/history.gif" title="Rental History" width="40" height="40" alt="9 history"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('report.jsp');"><img src="dash/9 report.png" title="Billing Report" width="40" height="40" alt="8 report"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('customer.jsp');"><img src="dash/6.jpg" title="Customer Profiles" width="40" height="40" alt="6"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="dash/logout.png" title="LogOut" width="40" height="40" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="dash/ref.gif" title="Refresh" width="40" height="40" alt="11 logout"/>
        </a> 
        
    </div>
    
    
    <div id="employeeDiv" style="visibility: hidden" align="center">
        <a onclick="forwardFunction('dashboard2.jsp');">
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="Dashboard" />            
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('customer.jsp');"><img src="dash/6.jpg" title="Customer Profiles" width="40" height="40" alt="6"/>
        </a>
        &nbsp;&nbsp;&nbsp;
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="dash/logout.png" title="LogOut" width="40" height="40" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="dash/ref.gif" title="Refresh" width="40" height="40" alt="11 logout"/>
        </a> 
    </div>
    
    <div id="customerDiv" style="visibility: hidden" align="center">
        <a onclick="forwardFunction('my_systemlease.jsp');">
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="My History" />            
        </a>
        &nbsp;&nbsp;&nbsp;        
        <a onclick="forwardFunction('j_acegi_logout');"><img src="dash/logout.png" title="LogOut" width="40" height="40" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="dash/ref.gif" title="Refresh" width="40" height="40" alt="11 logout"/>
        </a> 
    </div>
    
    <div align="center">
        <font style="color:green"><span id="successReply"></span></font><font style="color:red"><span id="failureReply"></span></font>
    </div>
</div>
<br>
<script type="text/javascript">
    onLoad = createMenu();
    function clearMessages() {
        dwr.util.setValue ("failureReply", "" );
        dwr.util.setValue ("successReply", "" );
    }
</script>

