$(window).bind("load", function()
{
    function getQueryVariable(variable)
    {
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
    }
    
    var socket = null;

    socket = new WebSocket("ws://localhost:8080/Uno/" + getQueryVariable("nameofgameroom"));
    socket.onopen = function ()
    {
        var msg =
        {
            command: "create game",            
            numberofplayers: $("#numberofplayers").val(),
            numberofrounds: $("#numberofrounds").val(),
            nameofgameroom: getQueryVariable("nameofgameroom"),
            status: "New game is created"
        };
        
        socket.send(JSON.stringify(msg));
    };

    socket.onmessage = function(evt)
    {
        var msg = JSON.parse(evt.data);
        document.getElementById("status").innerHTML = msg.status;
        
        if(msg.status == "New player has joined")
        {
            var elem = document.createElement("img");
        
            elem.setAttribute("src", "../images/player.png");
            elem.setAttribute("border-radius", "25px");
            elem.setAttribute("box-shadow", "5px 5px 5px #888888");        
            document.getElementById("playerimage").appendChild(elem);
        }
        
        
      
    };
    
    socket.onclose  = function()
    {
        socket.close();
    };
    
    $("#startbtn").on("click", function()
    {
	var msg =
        {
            command: "start game",            
            numberofplayers: $("#numberofplayers").val(),
            numberofrounds: $("#numberofrounds").val(),
            nameofgameroom: $("#nameofgameroom").val(),
            status: "start game"
        };
        
        socket.send(JSON.stringify(msg));
        
	socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
            //alert(msg.command);
            
            if(msg.command == "show top card")
                document.getElementById("topcardimage").src = "../images/" + msg.cardId + ".png";
        };
    });
});
