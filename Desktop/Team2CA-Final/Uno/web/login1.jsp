<%-- 
    Document   : Login
    Created on : Jan 20, 2016, 5:03:40 PM
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

        <title>Uno Card Game</title>
        
        <script src="lib/jquery-2.2.0.js"></script>

        <link rel="stylesheet" href="lib/chocolatechip-ui-master/dist/chui-android-3.9.2.css">
        <script src="lib/chocolatechip-ui-master/dist/chui-3.9.2.js"></script>
    </head>
    <body align="center">
        <nav>
            <p class="alignleft"><h1>Welcome to the UNO Game!</h1></p>
            <p class="alignright" style ="color:red; font: 100 14px/18px Roboto, SegoeWP, HelveticaNeue, sans-serif;" name = "SuccessMsg">${SuccessMsg}</p>
            <div style="clear: both;"></div>
        </nav>
        <article class='current'>
            <section>
                <div>
                    <img src="images/uno.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888">
                    <h2>Login to play or signup as a new user</h2>

                    <ul class='list' ui-implements='form'>

                        <form type="submit" method="post" action="j_security_check">
                        <div><br>
                            <input class="emailaddr" type="text" name="j_username" maxlength="45" placeholder="Email Address" style="font-size: 20px;" required>
                        </div><br>
                        <div>
                            <input class ="password" type="password" name="j_password" maxlength="10" placeholder="Password" style="font-size: 20px;" required>
                        </div> <br>
                    </ul>

                        <button id="login" class="action">Login</button>
                    </form>

                    <form action="../register.jsp"><button id="register" class="action">Register</button></form>

                </div>
            </section>
        </article>
    </body>
</html>
