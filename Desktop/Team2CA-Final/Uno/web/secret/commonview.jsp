<%-- 
    Document   : commonview
    Created on : 20 Jan, 2016, 11:52:38 PM
    Author     : KeljinChow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">

        <title>Uno Card Game</title>

        <script src="../lib/jquery-2.2.0.js"></script>

        <link rel="stylesheet" href="../lib/chocolatechip-ui-master/dist/chui-android-3.9.2.css">
        <script src="../lib/chocolatechip-ui-master/dist/chui-3.9.2.js"></script>
        
        <script src="commonview.js"></script>
    </head>
    <body>
        <nav>
            <p class="alignleft"><h1>Name of Game Room: ${nameofgameroom}</h1></p> 
            <p id="status" class="alignright" style ="color:red; font: 100 16px/20px Roboto, SegoeWP, HelveticaNeue, sans-serif;"></p>
            <div style="clear: both;"></div>
        </nav>

        <article class='current'>
            <section>
                
                <button type="submit" id="startbtn" class="action">Start Game</button>
                
                <input type="hidden" id="numberofplayers" name="numberofplayers" value="${numberofplayers}"/>
                <input type="hidden" id="numberofrounds" name="numberofrounds" value="${numberofrounds}"/>
                <input type="hidden" id="nameofgameroom" name="nameofgameroom" value="${nameofgameroom}"/>
                
                <ul class='list' >
                <li>
                <h2>Players Joined</h2>
                <ul>
                    <div id="playerimage" class="grid" style="height: 154px;">
                        
                    </div>
                </ul>
                <h2>Cards</h2>
                <ul>
                    <div class="grid">
                        <img src="../images/back.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888">
                        <img id="topcardimage" src="../images/back.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888">
                    </div>
                </ul>
                    
                </li>
                </ul>

            </section>
        </article>
    </body>
</html>
