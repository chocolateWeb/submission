
$(function()
{
    var socket = null;
    
    // Bind event to show the popup:
    $(".logout").on("singletap", function() {
        $.UIPopup({
            id: "message",
            title: 'Logout',
            message: 'You have been logged out.',
            continueButton: 'Back to main',
            callback: function(){
                /*var popupMessageTarget = document.querySelector('#popupMessageTarget');
                popupMessageTarget.textContent = 'Thanks for staying with us a bit longer.';
                popupMessageTarget.classList.remove("animatePopupMessage");
                popupMessageTarget.classList.add("animatePopupMessage");*/

                window.location="login.jsp";
            }
        });
    });
    
    $("#refreshbtn").on("click", function()
    {
        //alert("REFRESH");
	socket = new WebSocket("ws://localhost:8080/Uno/getgames");
	socket.onopen = function()
        {
            //alert("Connected");
            var msg =
            {
                command: "get games",            
                numberofplayers: "0",
                numberofrounds: "0",
                nameofgameroom: "0",
                status: "Game list is created"
            }
        
            socket.send(JSON.stringify(msg));
	};
        
	socket.onmessage = function(evt)
        {
            //alert("Received");
            var arr = JSON.parse(evt.data);
            
            var select = document.getElementById("listofgamenames");
            select.innerHTML = "";
            
            for(var i = 0; i < arr.length; i++)
            {
                //alert(arr[i]);
                var gamerooms = arr[i];
                var el = document.createElement("option");
                el.textContent = gamerooms;
                el.value = gamerooms;
                select.appendChild(el);
            }  
        };
        
        socket.onclose  = function()
        {
            socket.close();
        };
    });
});

function validateForm()
{    
    var numberofplayers = document.forms["myForm"]["numberofplayers"].value;
    var numberofrounds = document.forms["myForm"]["numberofrounds"].value;
    var nameofgameroom = document.forms["myForm"]["nameofgameroom"].value;
        
    if (numberofplayers == null || numberofplayers == "" || numberofrounds == null || numberofrounds == "" || nameofgameroom == null || nameofgameroom == "")
    {
        alert("All fields must be filled.");
        return false;
    }
}