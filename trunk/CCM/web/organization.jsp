<%-- 
    Document   : organization
    Created on : Jul 7, 2008, 5:44:10 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="dhtml_goodies_include.jsp" />
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <style>
            a:link    {color:black; text-decoration:none; font-size:11pt}
            a:hover   {color:black; text-decoration:none; 
                font-size:11pt}
            a:active  {color:black; text-decoration:none; font-size:11pt}
            a:visited {color:black; text-decoration:none; font-size:11pt}
        </style>
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxAdminService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        
        <script type="text/javascript">
           
           
            var org;
            function fillTable() {
                dwr.util.useLoadingMessage();
                AjaxAdminService.getOrganization(function(people) {
                    org = people;
                    dwr.util.setValues(people);
                });
            }
        
        
            function writePerson() {                
                dwr.util.getValues(org);
                AjaxAdminService.saveOrganization(org, function (data) {
                 clearMessages();                
                if (  data == 'Operation succesful!') {
                    dwr.util.setValue("successReply", " Profile Updated at " + new Date());
                    fillTable();
                } else {
                    dwr.util.setValue("failureReply", data);
                }    
                });
                
                
            }
        
            
        </script>
         
       <jsp:include page="table_style.jsp" ></jsp:include>
    </head>
    
    <body>
        
        <jsp:include page="include.jsp" />
        
        
       
        <table align="center">
            <thead>
                <tr>
                    <th>
                        Company Details
                    </th>
                    <th></th>
                </tr>
            </thead>
            <tr>
                <td>Organization:</td>
                <td><input id="name" type="text" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Active:</td>
                <td><input id="enabled" type="text" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><input type="text" id="street" size="30"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" id="city" size="30"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" id="state" size="30"/></td>
            </tr>
            <tr>
                <td>Zipcode:</td>
                <td><input type="text" id="zipcode" size="30"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" id="country" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Person</td>
                <td><input type="text" id="contactName" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Phone</td>
                <td><input type="text" id="phone" size="30"/></td>
            </tr>
            <tr>
                <td>Contact Email</td>
                <td><input type="text" id="contactEmail" size="30"/></td>
            </tr>
            <tr>
                <td>License</td>
                <td><input type="text" id="licenceKey" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td>Expiration Date</td>
                <td><input type="text" id="expirationDate" size="30" disabled="disabled" value="UnLimited"/></td>
            </tr>
            
            
            
            <tr>
                <td >    </td>
                <td>
                    <input type="button" value="Save" onclick="writePerson()"/>                    
                </td>
            </tr>
        </table>
        
        
        
        <script type="text/javascript">
            onload = fillTable();
        </script>
        
       
        
        <jsp:include page="organization_help.jsp" />
        <jsp:include page="copyright.jsp" />
        
    </body>
</html>
