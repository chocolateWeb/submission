<%-- 
    Document   : playerview
    Created on : 20 Jan, 2016, 11:53:39 PM
    Author     : KeljinChow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="msapplication-tap-highlight" content="yes">

        <title>Game Table</title>

        <script src="../lib/jquery-2.2.0.js"></script>

        <link rel="stylesheet" href="../lib/chocolatechip-ui-master/dist/chui-android-3.9.2.css">
        <script src="../lib/chocolatechip-ui-master/dist/chui-3.9.2.js"></script>
        
        <script src="playerview.js"></script>
        <style>
        .buttn {
            opacity: 0.4;
            filter: alpha(opacity=40);
        }

        .buttn:hover {
            opacity: 1.0;
            filter: alpha(opacity=100);
        }
        </style>
    </head>
    <body>
        <nav>
            <p class="alignleft"><h1 id="nameofgameroom">Name of Game Room: ${nameofgameroom}</h1></p>
            <p id="status" class="alignright" style ="color:red; font: 100 16px/20px Roboto, SegoeWP, HelveticaNeue, sans-serif;"></p>
            <div style="clear: both;"></div>
        </nav>

        <article id='main'>
            <section>
                <button type="submit" id="sortcardbtn" class="action">Sort Cards</button>
                
                <h2>Your Cards On Hand</h2>

                <ul>
                    <div id="cardimage" class="grid" style="height: 256px;">
                    </div>                    
                </ul>

                <h2>Buttons</h2>
                <ul style="height: 120px;">
                    <div class="grid">
                        <div align="center"><img class="buttn" id="choosered" src="../images/red.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Red</h3></div>&nbsp;
                        <div align="center"><img class="buttn" id="chooseblue" src="../images/blue.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Blue</h3></div>&nbsp;
                        <div align="center"><img class="buttn" id="choosegreen" src="../images/green.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Green</h3></p></div>&nbsp;
                        <div align="center"><img class="buttn" id="chooseyellow" src="../images/yellow.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Yellow</h3></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div align="center"><img class="buttn" id="draw" src="../images/draw.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Draw 1 Card</h3></div>&nbsp;
                        <div align="center"><img class="buttn" id="calluno" src="../images/unobutton.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>UNO</h3></div>&nbsp;
                        <div align="center"><img class="buttn" id="getscore" src="../images/orange.png" style="border-radius: 25px; box-shadow:5px 5px 5px #888888"><h3>Get Score</h3></div>&nbsp;
                    </div>
                </ul>

                <h2>Your Score</h2>
                <ul>
                    <div class="grid">
                        <h2 id="score" style="font-size: 20px">0<h2>
                    </div>
                </ul-->
            </section>
        </article>
    </body>
</html>
