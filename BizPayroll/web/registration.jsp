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
    </head>
    <body>
        <h2>New Company Registration</h2>
        <form>
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Organization Name</td>
                        <td><input type="text" name="org_name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Organization Type</td>
                        <td><select name="org_type">
                                <option>Education</option>
                                <option>Computes & It</option>
                                <option>Medicals</option>
                                <option>General</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><textarea name="org_description" rows="4" cols="20">
                        </textarea></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirm_password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Clear" /></td>
                        <td><input type="submit" value="Save" name="Save" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
