<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
<style type="text/css">

label {display:block;margin:2px;}
.form {padding:0px;margin:0px;background-color:#EDECDC;}
.form li {width:190px;margin:3px;padding:5px 5px 5px 30px;list-style:none;position:relative;}
*html .form li {left:-15px;}
.form li img {position:absolute;left:5px;}
.form .error {border:1px solid #A90000;padding:4px 4px 4px 29px;background-color:#F8E5E5;}
.form .success {border:1px solid #74F019;padding:4px 4px 4px 29px;background-color:#DEF8CA;}
.form .selected {border:1px solid #1AA8E1;padding:4px 4px 4px 29px;background-color:#8DD8F7;}
#login_table .pad {padding:15px;}
.form input.login {padding:2px 7px;width:auto;}
.form input {width:180px;}

</style>
<script type="text/javascript" src="../js/lib/jquery-1.2.6.min.js" ></script>                
<script type='text/javascript' src='../dwr/interface/AjaxUsersService.js'></script>        
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../js/local/signup.js'></script>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="val.js"></script>
</head>
<body>
   <ul class="form">
	 <li class="validated" id="firstname_li">
                  <label for="r_username">First Name:</label>
                  <div id="username_img"></div>
                  <input class="validated" name="firstname" id="firstname" type="text" maxlength="20" value=""  />
                  <div id="username_msg"></div>
          </li>
		  
		  <li class="validated" id="lastname_li">
                  <label for="r_username">Last Name:</label>
                  <div id="username_img"></div>
                  <input class="validated" name="lastname" id="lastname" type="text" maxlength="20" value=""  />
                  <div id="username_msg"></div>
          </li>

          <li class="validated" id="password_li">
                  <label for="r_password">Password:</label>
                  <div id="password_img"></div>
                  <input name="password" id="password" type="password" maxlength="20"  />
                  <div id="password_msg"></div>
          </li>
          <li id="password_copy_li">
                  your password is <input id="password_copy" />

          </li>
          <li id="confirmpass_li">
                  <label for="r_confirmpass">Confirm Password:</label>
                  <div id="confirmpass_img"></div>
                  <input name="r_confirmpass" id="confirmpass" type="password" maxlength="20" />
                  <div id="confirmpass_msg"></div>
          </li>
          <li class="validated" id="dob_li">

                  <label for="dob">date of birth:</label>
                  <div id="dob_img"></div>
                  <input name="dob" id="dob" type="dob" maxlength="20"  />
                  <div id="dob_msg"></div>
          </li>
		  <li class="validated" id="company_li">
                  <label for="r_username">company:</label>
                  <div id="username_img"></div>
                  <input class="validated" name="company" id="company" type="text" maxlength="20" value=""  />
                  <div id="username_msg"></div>
          </li>
		  
          <li class="validated" id="email_li">
                  <label for="email">email:</label>
                  <div id="email_img"></div>

                  <input name="email" id="email" type="email" maxlength="20"  />
                  <div id="email_msg"></div>
          </li>
    </ul>
	<input id="signup" name="signup" value="Signup" type="button" ">    
</body>
</html>