
<script type="text/javascript">
    function showdiv(role) {
        //var role = dwr.util.getValue("role_hidden");
        var m = document.getElementById("mainDiv");
        var a = document.getElementById("adminDiv");
        var b = document.getElementById("employeeDiv");
        //alert ( role );
        if ( role == "admin" ) {        
            document.getElementById('adminDiv').style.visibility="visible";            
            m.removeChild(b);
        }
        else if ( role == "user" ) {
            document.getElementById('employeeDiv').style.visibility="visible";            
            m.removeChild(a);
        }   
        else {            
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


<br>
<div id="mainDiv">
    <div id="adminDiv" align="center">
        <a onclick="forwardFunction('dashboard2.jsp');">
            <img src="dash/1 home.png" width="40" height="40" alt="Dashboard" title="Dashboard"/>
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
        <a onclick="forwardFunction('j_acegi_logout');"><img src="dash/logout.png" title="LogOut" width="40" height="40" alt="11 logout"/>
        </a> 
        &nbsp;&nbsp;&nbsp;
        <a onclick="refresh();"><img src="dash/ref.gif" title="Refresh" width="40" height="40" alt="11 logout"/>
        </a> 
        
    </div>
    <!--
    <div id="employeeDiv" style="visibility: hidden" align="center">
        <a onclick="forwardFunction('dashboard.jsp');">
            <img src="dash/1. home.gif" width="40" height="40" alt="Dashboard"/>
        </a>&nbsp;&nbsp;&nbsp;<a onclick="forwardFunction('users.jsp');"><img src="dash/2 users.jpg" width="40" height="43"/>
        </a>&nbsp;&nbsp;&nbsp; 
        <a onclick="forwardFunction('systemlease.jsp');"><img src="dash/9 history.jpg" width="40" height="40" alt="9 history"/>
        </a>&nbsp;&nbsp;&nbsp; 
        <a onclick="forwardFunction('customer.jsp');"><img src="dash/6.jpg" width="40" height="40" alt="6"/>
        </a>&nbsp;&nbsp;&nbsp; 
        <a onclick="forwardFunction('suggestions.jsp');"><img src="dash/10 feedback.jpg" width="40" height="38" alt="10 feedback"/>
        </a>&nbsp;&nbsp;&nbsp; 
        <a onclick="forwardFunction('j_acegi_logout');"><img src="dash/11 logout.jpg" width="40" height="40" alt="11 logout"/>
        </a>&nbsp;&nbsp;&nbsp; 
        <a onclick="refresh();"><img src="dash/ref.gif" width="40" height="40" alt="11 logout"/>
        </a>
    </div>
    -->
</div>
<br><br>

<script type="text/javascript">
    //onLoad = showdiv();
</script>

