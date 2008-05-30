<!-- 
    Document   : test
    Created on : 25 May, 2008, 1:55:10 PM
    Author     : imran
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="lform">
            
            <body class="tundra">
            
            
            <p align ="center">
            <center>    
                <h3><u>User Details</u></h3>  
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>&nbsp;Name&nbsp;</th>
                            <th>&nbsp;Username&nbsp;</th>            
                            <th>&nbsp;Actions&nbsp;</th>
                            
                        </tr>
                    </thead>
                    <tbody id="usersbody">    
                    
                    <tr id="pattern"  style="display:none;">
                    <td>
                        <span id="tableName">Name</span><br/> 
                    </td>                        
                    <td><span id="tableUsername">Username</span></td>
                    <td>
                    <input id="edit" type="button" value="Edit" />
                </table>
                
                
                <br><br>   
                
                <h3>Edit User Details</h3> 
                <table border="0">
                    <thead>
                        <tr>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Username</td>
                            <td><input class='itext' type="text" name="username" class="small" value='' id='p10'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Username.">
                        </td></tr>
                        <!--<input class='itext'type="text" name="username" value='' id='p10' />-->
                    
                        <tr>
                            <td>Firstname</td>
                            <td><input class='itext' type="text" name="firstname" class="small" value='' id='p12'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Firstname.">
                                <!--<input class='itext'type="text" name="firstname" value='' id='p12' />-->
                            </td>
                        </tr>
                        <tr>
                            <td>Lastname</td>
                            <td><input class='itext' type="text" name="lastname" class="small" value='' id='p13'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Lastname.">
                            <!--<input class='itext'type="text" name="lastname" value='' id='p13' />--></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input class='itext' type="password" name="password" class="small" value='' id='p11'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Password.">
                            <!--<input class='itext' type="password" name="password" id='p11' />--></td>
                        </tr>
                        <tr>
                            <td> Confirm Password</td>
                            <td><input class='itext' type="password" name="confirmpassword" class="small" value='' id='p14'
                                           dojoType="dijit.form.ValidationTextBox"
                                           regExp="[\w]+"
                                           required="true"
                                           invalidMessage="Enter Confirm Password">
                            <!--<input class='itext' type="password" name="confirmpassword"   id='p14' />--></td>
                        </tr>
                        <tr>  <td><button dojoType="dijit.form.Button" >
                                Save
                            </button> <button dojoType="dijit.form.Button" >
                                Clear
                        </button></td>
                        
                    </tr>
                    </tbody>
                </table>
            </center> 
        </form>
        
    </body>
    
</html>
