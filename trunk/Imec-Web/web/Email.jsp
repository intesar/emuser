<%-- 
    Document   : Email
    Created on : 30 May, 2008, 5:36:57 PM
    Author     : imran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type='text/javascript' src='/Imec-Web/dwr/interface/JEmailAjaxService.js'></script>
        <script type='text/javascript' src='/Imec-Web/dwr/engine.js'></script>
        
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.Editor");
        </script>
        <script type='text/javascript' src='/Imec-Web/dwr/util.js'></script>
        <script type='text/javascript'>
            function objectEval(text)
            {
                // eval() breaks when we use it to get an object using the { a:42, b:'x' }
                // syntax because it thinks that { and } surround a block and not an object
                // So we wrap it in an array and extract the first element to get around
                // this.
                // This code is only needed for interpreting the parameter input fields,
                // so you can ignore this for normal use.
                // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
                text = text.replace(/\n/g, ' ');
                text = text.replace(/\r/g, ' ');
                if (text.match(/^\s*\{.*\}\s*$/))
                {
                    text = '[' + text + '][0]';
                }
                return eval(text);
            }
        </script>
        
        
        
        <script type="text/javascript">
            function init() {                
                fillTable();
            }
            window.onload=init;

            var emailsCache = { };
            var viewed = -1;
            var myStatus = "unread"

            function fillTable() {
                JEmailAjaxService.getAll(myStatus, function(emails) {
                    // Delete all the rows except for the "pattern" row
                    dwr.util.removeAllRows("emailsbody", { filter:function(tr) {
                            return (tr.id != "pattern");
                        }});
                    // Create a new set cloned from the pattern row
                    var email, id;
                   
                    for (var i = 0; i < emails.length; i++) {
                        email = emails[i];
                        id = email.id;
                        dwr.util.cloneNode("pattern", { idSuffix:id });
                        dwr.util.setValue("tableFrom" + id, email.from);                        
                        dwr.util.setValue("tableSubject" + id, email.subject);
                        dwr.util.setValue("tableEmailDate" + id, email.emailDate);
                        dwr.util.setValue("tableStatus" + id, email.status);
                        $("pattern" + id).style.display = "table-row";
                        emailsCache[id] = email;
                    }
                });
            }
    
        </script>
        
        <!--   <script type="text/javascript">
   function getAll()
   {
       
   }
        var reply6 = function(data)
    {
      if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
      else dwr.util.setValue('d6', dwr.util.toDescriptiveString(data, 1));
    }
  </script>
  <span id='d6' class='reply'></span>
-->
    </head>
    
    <body class="tundra">
         <form method="post">
        <center><table border="0" >
                
                <thead>
                <tr>
                <th><center><h2>Email Details</h2></center><br> 
                
                <table> 
                    <tr>
                        <td>
                            <select name="EmailDropDown">
                                <option value=" ">Select Status</option>
                                <option value="unread">Unread</option>
                                <option value="replied">Replied</option>
                            </select>
                        </td>
                </tr></table>
                <table border="1" id="emailsTable" height="200" width="800">
                    <thead>
                        <tr>
                            <th><center><h4> <b>FROM</b></h4></center></th>
                            <th><center><h4><b> SUBJECT</b></h4></center> </th>            
                            <th><center> <h4><b>EMAIL DATE</b></h4></center> </th>
                            <th><center> <h4><b>STATUS</b></h4></center> </th>
                            
                        </tr>
                    </thead> 
                    
                    <tbody id="emailsbody">    
                        
                        <tr id="pattern" style="display:none;">
                            <td>
                                    <center><span id="tableFrom">From</span></center><br/>
                            </td>                        
                            <td><center><span id="tableSubject">Subject</span></center></td>
                            <td><center><span id="tableEmailDate">EmailDate</span></center></td>
                            <td><center><span id="tableStatus">Status</span></center></td>
                            
                            </tr>
                                    
                        
                    </tbody>
                 
                                    
                </table>
                <br>
                    <table border="1" width="800" rules="none">
                        <tr>
                            <td>
                       <textarea name="field" width="200px" dojoType="dijit.Editor">
        
        Welcome To Intelligent Marketing Email Client!
            </textarea>
              </td></tr>
            </table></table>
            <br>
              
            <input type="submit" value="Send" />  
        </center>
        
        
       
        </form>
       
    </body>
</html>
