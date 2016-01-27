<%-- 
    Document   : PlayerRegister
    Created on : Jan 20, 2016, 5:01:26 PM
    Author     : Hariharan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="msapplication-tap-highlight" content="yes">

    <title>Signup as a new user</title>

    <link rel="stylesheet" href="css/styles.css" type="text/css"/>
    <script src="lib/jquery-2.2.0.js"></script>

    <link rel="stylesheet" href="lib/chocolatechip-ui-master/dist/chui-android-3.9.2.css">
    <script src="lib/chocolatechip-ui-master/dist/chui-3.9.2.js"></script>

    <script src="register.js"></script>
    
    <script src = "register.js"></script>
<body>
    <nav>
        <h1>Register as a new user</h1>
    </nav>
    <article class='current'>
        <section  align="center">
            <h2>Register with your email and password</h2>
            <ul class='list' ui-implements='form'>
                <form name="myform" type="submit" method="post" action="createplayerservlet"> 
                    <div><br>
                        <input class="emailaddr" type="text" name="emailaddr" maxlength="45" placeholder="Email (max 45 chars)" style="font-size: 20px;" required>
                        <div><label style ="color:red" name = "ErrorMsg">${ErrorMsg}</label></div>
                    </div><br>
                    <div>
                        <input class ="password1" type="password" name="password1" maxlength="10" placeholder="Password (max 10 chars)" style="font-size: 20px;" required>
                    </div><br>
                    <div>
                        <input class ="password2" type="password" name="password2" maxlength="10" placeholder="Re-enter Password" style="font-size: 20px;" required>
                    </div><br>
            </ul>
                    <div align="center">
                        <button  type="submit" id="register" class="action"  onclick="return validateForm()">Register</button>
                    </div>
                </form>

        </section>
    </article>
</body>
</html>
