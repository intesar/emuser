<%-- 
    Document   : Customer
    Created on : Aug 4, 2008, 9:28:52 AM
    Author     : intesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="dhtml_goodies_include.jsp" />
        <script type='text/javascript' src='/CCM/dwr/interface/AjaxWorkService.js'></script>
        <script type='text/javascript' src='/CCM/dwr/engine.js'></script>        
        <script type='text/javascript' src='/CCM/dwr/util.js'></script>
        <script type="text/javascript" src="email_validation.js"></script>
        
        <script type="text/javascript">
           
        
            function writePerson() {
                
                var customer = { id:null, name:null, img:null, email:null, 
                    homePhone:null, mobilePhone:null, otherPhone:null,
                    street:null,city:null, zipcode:null, state:null, 
                    country:null, passportNo:null, voterIdCardNo:null,
                    collegeName:null, rationCardNo:null, panCardNo:null,
                    dob:null, gender:null, comments:null };
                
                
                dwr.util.getValues(customer);
                
        
                //dwr.engine.beginBatch();
                //People.setPerson(person);
                if ( validateEmail(customer.email, true, true) ) {
                    //alert ( 'hi');
                    AjaxWorkService.createCustomer(customer, reply1);
                }
                //fillTable();
                //dwr.engine.endBatch();
            }
            
            var reply1 = function (data) {
                alert ( data );
            }
        
            function clearPerson() {
                
                dwr.util.setValues({ id:null, img:null, name:null, email:null, 
                    homePhone:null, mobilePhone:null, otherPhone:null,
                    street:null,city:null, zipcode:null, state:null, 
                    country:null, passportNo:null, voterIdCardNo:null,
                    collegeName:null, rationCardNo:null, panCardNo:null,
                    dob:null, gender:null, comments:null });
            }
            
            function search() {
                AjaxWorkService.getCustomer(dwr.util.getValue("key"), reply2);
            }
            
            var reply2 = function(customer) {
                dwr.util.setValues(customer);
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
                        Customer Look Up
                    </th>
                    <th></th>
                </tr>
            </thead>
            <tr>
                <td>
                    <input type="text" name="key" id="key" value="" />
                    <input type="submit" value="Search" onclick="search();"/>
                    <br>
                    
                    <img id="image" src="javascript:void(0);"/>
                    <br>
                </td>
            </tr>
        </table>
        
        <table   align="center">
            
            <thead>
                <tr>                    
                    <th>Create Customer Profile </th>
                    <th></th>
                </tr>
            </thead>
            
            <tr>
                <td>Id</td>
                <td><input id="id" type="text" size="30" disabled /></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="file" id="img" /></td>
                <td id="image.container">&nbsp;</td>
            </tr>
            
            <tr>
                <td>Name</td>
                <td><input id="name" type="text" size="30"/></td>
            </tr>
            <br>
            <tr>
                <td>Email</td>
                <td><input id="email" type="text" size="30"/></td>
            </tr> 
            <tr>
                <td>Home Phone</td>
                <td><input id="homePhone" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Mobile Phone</td>
                <td><input id="mobilePhone" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Other Phone</td>
                <td><input id="otherPhone" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Street</td>
                <td><input id="street" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input id="city" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Zipcode</td>
                <td><input id="zipcode" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>State</td>
                <td><input id="state" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input id="country" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Passport No</td>
                <td><input id="passportNo" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Voter Id</td>
                <td><input id="voterIdCardNo" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>College Name</td>
                <td><input id="collegeName" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Ration Card No</td>
                <td><input id="rationCardNo" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Pan Card No</td>
                <td><input id="panCardNo" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Date Of Birth</td>
                <td><input id="dob" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input id="gender" type="text" size="30"/></td>
            </tr>
            <tr>
                <td>Comments</td>
                <td><textarea name="comments" rows="4" cols="20">
                </textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">                    
                    <input type="button" value="Clear" onclick="clearPerson()"/>
                    <input type="button" value="Save" onclick="writePerson()"/>
                    
                </td>
            </tr> 
            
        </table>
        
        
    </body>
    
    <jsp:include page="customer_help.jsp" />
    <jsp:include page="copyright.jsp" />
</html>
