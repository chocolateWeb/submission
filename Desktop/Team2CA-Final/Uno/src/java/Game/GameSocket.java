package Game;

import Entities.Card;
import Entities.Player;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@RequestScoped
@ServerEndpoint("/{nameofgameroom}")
public class GameSocket
{
    @Inject private GameRooms gameRooms;
    @Inject private GameManagerList gameManagers;

    private Session session;
    
    @OnOpen
    public void open(Session s, @PathParam("nameofgameroom") String nameofgameroom)
    {        
        System.out.println(nameofgameroom + " >>> @OnOpen = " + s.getId());
        session = s;
        
        gameRooms.add(nameofgameroom, session);
    }
        
    @OnMessage
    public void message(String msg)
    {
        System.out.println(">>>> msg = " + msg);

        JsonReader reader = Json.createReader(new ByteArrayInputStream(msg.getBytes()));
        JsonObject json = reader.readObject();
            
        System.out.println(">>> command = " + json.getString("command"));
        System.out.println(">>> numberofplayers = " + json.getString("numberofplayers"));
        System.out.println(">>> numberofrounds = " + json.getString("numberofrounds"));
        System.out.println(">>> nameofgameroom = " + json.getString("nameofgameroom"));
        System.out.println(">>> status = " + json.getString("status"));
        
        String command = json.getString("command");
        int numberofplayers = Integer.parseInt(json.getString("numberofplayers"));
        int numberofrounds = Integer.parseInt(json.getString("numberofrounds"));
        String nameofgameroom = json.getString("nameofgameroom");
        String status = json.getString("status");
        
        if(command.equals("create game"))
        {
            gameManagers.add(nameofgameroom, numberofplayers, numberofrounds);
            gameRooms.broadcast(nameofgameroom, json);
        }
        
        if(command.equals("call uno") || command.equals("choose red") || command.equals("choose blue") || command.equals("choose green") || command.equals("choose yellow"))
        {            
            gameRooms.broadcast(nameofgameroom, json);
        }
        
        if(command.equals("get games"))
        {
            Set<String> s = gameRooms.roomNames();
            String[] sArr = s.toArray(new String[s.size()]);
            
            JsonArrayBuilder builder = Json.createArrayBuilder();
            
            for(int i = 0; i < sArr.length; i++)
            {
                if(!sArr[i].equals("getgames"))
                {
                    System.out.println(">>Rooms " + sArr[i]);                 
                    builder.add(sArr[i]);
                }
            }
            
            JsonArray arr = builder.build();
            
            try
            {            
                gameRooms.broadcastList("getgames", arr);
            }
            catch (EncodeException ex)
            {
                Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(command.equals("join game"))
        {            
           boolean hasStarted = gameManagers.checkGame(nameofgameroom);
           
           if(!hasStarted)
           {
               gameManagers.addPlayerToGame(nameofgameroom, session.getId());
               
               gameRooms.broadcast(nameofgameroom, json);
               
               if(gameManagers.checkGame(nameofgameroom))
               {
                    JsonObject reply = Json.createObjectBuilder()
                             .add("command", "join game")
                             .add("numberofplayers", numberofplayers)
                             .add("numberofrounds", numberofrounds)
                             .add("nameofgameroom", nameofgameroom)
                             .add("status", "Game is ready to start")
                             .build();
                    
                    gameRooms.broadcast(nameofgameroom, reply);
               }
            }   
            
            else
            {                
                /*get kicked out*/
                                
                JsonObject reply = Json.createObjectBuilder()
                        .add("command", "join game")
                        .add("numberofplayers", numberofplayers)
                        .add("numberofrounds", numberofrounds)
                        .add("nameofgameroom", nameofgameroom)
                        .add("status", "Game is full.")
                        .build();
                try {
                    session.getBasicRemote().sendObject(reply);
                } catch (IOException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncodeException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(command.equals("start game"))
        {
            boolean hasStarted = gameManagers.checkGame(nameofgameroom);
            
            if(hasStarted)
            {
                gameManagers.startGame(nameofgameroom);

                //show the cards on top of pile          
                Card c = gameManagers.showCardOnTopOfPile(nameofgameroom);

                JsonObject reply = null;
                
                if(c.getActionCard().equals("number"))
                {
                    reply = Json.createObjectBuilder()
                                .add("command", "show top card")
                                .add("cardId", c.getCardId())
                                .add("colour", c.getColour())
                                .add("actioncard", c.getActionCard())
                                .add("value", c.getValue())
                                .add("status", c.getColour() + " " + c.getActionCard() + " " + c.getValue())
                                .build();
                }
                else
                {
                    reply = Json.createObjectBuilder()
                                    .add("command", "show top card")
                                    .add("cardId", c.getCardId())
                                    .add("colour", c.getColour())
                                    .add("actioncard", c.getActionCard())
                                    .add("value", c.getValue())
                                    .add("status", c.getColour() + " " + c.getActionCard())
                                    .build();
                }

                gameRooms.broadcast(nameofgameroom, reply);
            }
            
            else
            {
                gameManagers.startGame(nameofgameroom);

                //show the cards on top of pile          
                Card c = gameManagers.showCardOnTopOfPile(nameofgameroom);

                JsonObject reply = Json.createObjectBuilder()
                            .add("command", "invalid start game")
                            .add("cardId", "back")
                            .add("colour", c.getColour())
                            .add("actioncard", c.getActionCard())
                            .add("value", c.getValue())
                            .add("status", "Can't start game yet")
                            .build();

                gameRooms.broadcast(nameofgameroom, reply);
            }
        }
        
        if(command.equals("draw card"))
        {
            boolean hasStarted = gameManagers.checkGame(nameofgameroom);
            if(hasStarted)
            {
                Card c = gameManagers.takeCard(nameofgameroom, session.getId());
            
                JsonObject reply = Json.createObjectBuilder()
                        .add("command", "get card")
                        .add("cardId", c.getCardId())
                        .add("colour", c.getColour())
                        .add("actioncard", c.getActionCard())
                        .add("value", c.getValue())
                        .add("status", "1 Card Taken")
                        .build();
            
            System.out.println("Card Taken: >> " + c.getCardId());
            
               try {
                    session.getBasicRemote().sendObject(reply);
                } catch (IOException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncodeException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            else
            {                
                /*get kicked out*/
                System.out.println(">>> Game has not started.");
                
                JsonObject reply = Json.createObjectBuilder()
                        .add("command", "join game")
                        .add("numberofplayers", numberofplayers)
                        .add("numberofrounds", numberofrounds)
                        .add("nameofgameroom", nameofgameroom)
                        .add("status", "Game has not started.")
                        .build();
                try {
                    session.getBasicRemote().sendObject(reply);
                } catch (IOException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncodeException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(command.equals("throw card"))
        {
            Card c = gameManagers.throwCard(nameofgameroom, session.getId(), status);
            JsonObject reply =  Json.createObjectBuilder()
                                .add("command", "show top card")
                                .add("cardId", c.getCardId())
                                .add("colour", c.getColour())
                                .add("actioncard", c.getActionCard())
                                .add("value", c.getValue())
                                .add("status", c.getColour() + " " + c.getActionCard() + " " + c.getValue())
                                .build();

            gameRooms.broadcast(nameofgameroom, reply);
        }
        
        if(command.equals("get score"))
        {
            int score = gameManagers.getScore(nameofgameroom, session.getId());
            
            JsonObject reply = Json.createObjectBuilder()
                        .add("command", "get score")
                        .add("numberofplayers", numberofplayers)
                        .add("numberofrounds", numberofrounds)
                        .add("nameofgameroom", nameofgameroom)
                        .add("status", score)
                        .build();
                try {
                    session.getBasicRemote().sendObject(reply);
                } catch (IOException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EncodeException ex) {
                    Logger.getLogger(GameSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
	
    @OnClose
    public void close(@PathParam("nameofgameroom") String nameofgameroom)
    {        
        System.out.println(">>> @OnClose = " + session.getId());
        gameRooms.remove(nameofgameroom, session.getId());     
    }
}
