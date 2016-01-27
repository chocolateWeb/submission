<%-- 
    Document   : floorjsp
    Created on : Jan 20, 2016, 10:56:02 AM
    Author     : Hariharan
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
--%>
<%@ page language="java" import="java.security.MessageDigest" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 


<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <title>Uno Card Game</title>

    <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
    <script src="../lib/jquery-2.2.0.js"></script>

    <link rel="stylesheet" href="../lib/chocolatechip-ui-master/dist/chui-android-3.9.2.css">
    <script src="../lib/chocolatechip-ui-master/dist/chui-3.9.2.js"></script>

    <script src="floor.js"></script>
</head>
<body>
    <nav>
        <!-- h1>Hello <!--%= request.getRemoteUser() %></h1 -->
        <h1>Game Options</h1>
        <!--<form method="POST" action="../secret/signout">-->
        <form method="POST" action="../secret/signout">
        <button class="logout">
            <label>Logout</label>
        </button>
        </form>
    </nav>
    <article id="main" class="current">
        <section>
            <ul class='list' role='list'>
                <li class='comp' data-goto="creategame">
                    <div>
                        <h2>Create New Game</h2>
                    </div>
                    <aside>
                        <span class='nav'></span>
                    </aside>
                </li>
                <li class='comp' data-goto="joingame">
                    <div>
                        <h2>Join Existing Games</h2>
                    </div>
                    <aside>
                        <span class='nav'></span>
                    </aside>
                </li>
            </ul>
        </section>
    </article>
    <nav class='next'>
        <button class='back'>Back</button>
        <h1>Create New Game</h1>
        <form method="POST" action="../secret/signout">
        <button class="logout">
            <label>Logout</label>
        </button>
        </form>
    </nav>
    <article id="creategame" class='next'  align="center">
        <section>
            <form name="myForm" type="submit" method="GET" action="../secret/creategame" onsubmit="return validateForm()">
                <h2>Create a new game with 2 - 4 players</h2>          
                
                <ul class='list' ui-implements='form'>

                    <div style="font-size: 20px"><br>
                        &nbsp;Number of Players (2-4):
                        <input id="numberofplayers" type="number" name="numberofplayers" placeholder="2" min="2" max="4" style="font-size: 20px" required>
                    </div><br>
                    <div style="font-size: 20px">
                        Number of Rounds (1-20):
                        <input id="numberofrounds" type="number" name="numberofrounds" placeholder="1" min="1" max="20" style="font-size: 20px" required>
                    </div><br>
                    <div style="font-size: 20px">
                            Name of Game Room:
                            <input id="nameofgameroom" type="text" name="nameofgameroom" maxlength="20" style="font-size: 20px" required>
                    </div><br>
               </ul>
                <button type="submit" id="create" class="action">Create New Game</button>
            </form>
        </section>
    </article>

    <nav class='next'>
        <button class='back'>Back</button>
        <h1>Join Existing Games</h1>
        <form method="POST" action="../secret/signout">
        <button class="logout">
            <label>Logout</label>
        </button>
        </form>
    </nav>

    <article id="joingame" class='next'>
        <section>
            <button id="refreshbtn" class="action">Refresh Existing Games</button>
            <ul class='list'>

                <li>
                <div class="grid" align="center">
                    &nbsp;<div class="col flex-2"><p>Select Game Name</p></div>
                    <!--<div class="col flex-2"><p>No of Players to Start Game</p></div>
                    <div class="col flex-2"><p>Existing No of Players</p></div>
                    <div class="col flex-2"><p>No of Rounds</p></div>
                    <div class="col flex-2"><p>Join Game</p></div>-->
                </div>
                </li>

                <li align="center">
                        <div>
                            <form class="gameselected" name="myForm" type="submit" method="GET" action="../secret/playerjoin">
                                &nbsp;<select required name="listofgamenames" size="1" id="listofgamenames">                                    
                                </select>
                        </div>
                    </li>
                        <div class="col flex-2"><button id="joingamebtn" class="action" style="width:20px">Join Game</button></div>
                            </form> 
            </ul>

        </section>
    </article>
</body>
</html>
