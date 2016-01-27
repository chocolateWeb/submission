var socket = null;

function getQueryVariable(variable)
    {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (pair[0] == variable) {
                return pair[1];
            }
        }
        return(false);
    }

$(window).bind("load", function ()
{
    
    var cardpx = 5;

    socket = new WebSocket("ws://localhost:8080/Uno/" + getQueryVariable("listofgamenames"));
    socket.onopen = function ()
    {
        var msg =
                {
                    command: "join game",
                    numberofplayers: "0",
                    numberofrounds: "0",
                    nameofgameroom: getQueryVariable("listofgamenames"),
                    status: "New player has joined"
                }

        socket.send(JSON.stringify(msg));
    };

    socket.onmessage = function (evt)
    {  
        var msg = JSON.parse(evt.data);
        document.getElementById("status").innerHTML = msg.status;
    };

    socket.onclose = function ()
    {
        socket.close();
    };
    
    
    
    $("#choosered").on("click", function()
    {
        var msg =
        {
            command: "choose red",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "RED"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
        };
    });
    
    $("#chooseblue").on("click", function()
    {
        var msg =
        {
            command: "choose blue",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "BLUE"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
        };
    });
    
    $("#choosegreen").on("click", function()
    {
        var msg =
        {
            command: "choose green",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "GREEN"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
        };
    });
    
    $("#chooseyellow").on("click", function()
    {
        var msg =
        {
            command: "choose yellow",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "YELLOW"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
        };
    });
    
    $("#draw").on("click", function()
    {        
	var msg =
        {
            command: "draw card",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "1 Card Taken"
        };
        
        socket.send(JSON.stringify(msg));
        
	socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            
            document.getElementById("status").innerHTML = msg.status;            
            
            var elem = document.createElement("img");

            elem.setAttribute("src", "../images/" + msg.cardId + ".png");
            elem.setAttribute("style", "position: absolute; left:" +  cardpx + "px");
            elem.setAttribute("onclick", "removeElement(this.id)");
            elem.setAttribute("id", msg.cardId);
            
            document.getElementById("cardimage").appendChild(elem);
            
            cardpx = cardpx + 60;
            
        };
    });
    
    $("#calluno").on("click", function()
    {
        var msg =
        {
            command: "call uno",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "UNO!!!"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("status").innerHTML = msg.status;
        };
    });
    
    $("#sortcardbtn").on("click", function()
    {
        var nodes = document.getElementById('cardimage').getElementsByTagName("img");
        cardpx = 5;
       
        for(var i=0; i<nodes.length; i++)
        {
            nodes[i].setAttribute("style", "position: absolute; left:" +  cardpx + "px");
            cardpx = cardpx + 60;
        }  
    });
    
    $("#getscore").on("click", function()
    {
       var msg =
        {
            command: "get score",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: "0"
        };
        socket.send(JSON.stringify(msg))
        
        socket.onmessage = function(evt)
        {
            var msg = JSON.parse(evt.data);
            document.getElementById("score").innerHTML = msg.status;
        }; 
    });
});

function removeElement(clicked_id)
{
        //alert(clicked_id);
        remove(clicked_id);
        
        //alert(getQueryVariable("listofgamenames"));
    
        var msg =
        {
            command: "throw card",            
            numberofplayers: "0",
            numberofrounds: "0",
            nameofgameroom: getQueryVariable("listofgamenames"),
            status: clicked_id
        };
        socket.send(JSON.stringify(msg))
        
        
}
function remove(id) {
    return (elem = document.getElementById(id)).parentNode.removeChild(elem);
}

