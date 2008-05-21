<%-- 
    Document   : registration
    Created on : May 20, 2008, 5:11:48 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type='text/javascript' src='/BizPayroll/dwr/interface/JUserAjaxService.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/engine.js'></script>
        <script type='text/javascript' src='/BizPayroll/dwr/util.js'></script>
        
        <script type='text/javascript'>
            function objectEval(text)
            {
                //text = '"' + text + '"';
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
    </head>
    <body>
        <p align="center">
        <h2>New Company Registration</h2>
        <form>        
            <table border="0">
                <p align="center">
                <tbody>
                    <tr>
                        <td>Organization Name</td>
                        <td><input class='itext' type='text' size='10' value='' id='org_name' title='Enter organization name' /></td>
                    </tr>
                    <tr>
                        <td>Organization Type</td>
                        <td><select class='itext' value='' id='org_type' title='Select your Category'>
                                <option>Select</option>
                                <option>Education</option>
                                <option>Computes & It</option>
                                <option>Medicals</option>
                                <option>General</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><textarea class='itext' type='text' size='10' value='' id='org_description' title='Enter your Organization Description'>
                        </textarea></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input class='itext' type='text' size='10' value='' id='firstname' title='Enter first name'/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input class='itext' type='text' size='10' value='' id='lastname' title='Enter Last Name'/></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input class='itext' type='text' size='10' value='' id='username' title='Enter User Name'/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input class='itext' type='password' size='10' value='' id='password' title='Enter Password'/></td>
                        
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input class='itext' type='password' size='10' value='' id='confirm_password' title='Confirm password'/></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Clear" /></td>
                        <td><input class='ibutton' type='button' onclick='createUserFunction();' value='Execute'  title='Calls JUserAjaxService.createUser(). View source for details.'/></td>
                        <script type='text/javascript'>
                            function createUserFunction() {
                      
                                var organizationName = '"' + $("org_name").value + '"';
                                var organizationType = '"' + $("org_type").value + '"';
                                var organizationDesc = '"' + $("org_description") + '"';
                                var FirstName = '"' + $("firstname").value + '"';
                                var LastName = '"' + $("lastname").value + '"';
                                var UserName = '"' + $("username").value + '"';
                                var Password = '"' + $("password").value + '"';
                                var confirmpassword = '"' + $("confirm_password").value + '"';
                              
                                organizationName = objectEval( organizationName );
                                organizationType = objectEval( organizationType );
                                organizationDesc = objectEval( organizationDesc );
                                FirstName = objectEval( FirstName );
                                LastName = objectEval( LastName );
                                UserName = objectEval( UserName );
                                Password = objectEval( Password );
                                confirmpassword = objectEval( confirmpassword );
                                if ( Password == confirmpassword )
                                    {
                                        JUserAjaxService.createUser(organizationName, organizationType, organizationDesc, FirstName, LastName, UserName, Password, reply0);
                                    } else {
                                        alert("Password & confirm Password are not matching");
                                    }
                                                               
                            }
                            var reply0 = function(data)
                            {
                                if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                else dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
                                 
                            }
                        </script>
                        <span id='d0' class='reply'></span>
                        
                    </tr>
                </tbody>
             </table>
        </form>
       </body>
</html>
