package Game;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Session;

@ApplicationScoped
public class GameRooms
{
    private Map<String, List<Session>> gamerooms = new HashMap<>();
    
    private Lock lock = new ReentrantLock();

    public Map<String, List<Session>> getGamerooms() {
        return gamerooms;
    }
    
    public void add(String gameRoomName, Session session)
    {
       lock.lock();
       try
       {
            List<Session> sessions = gamerooms.get(gameRoomName);
            
            if (null==sessions)
            {
		sessions = new LinkedList<>();
		gamerooms.put(gameRoomName, sessions);
            }
                            
            sessions.add(session);                
	}
        finally
        {
            lock.unlock();
        }
    }
    
    public void remove(String gameRoomName, String sessionid)
    {
       lock.lock();
       try
       {           
           System.out.println("Session ID to remove >>> " + sessionid);
           System.out.println("Game Room Name to remove >>> " + gameRoomName);
           
            List<Session> sessions = gamerooms.remove(gameRoomName);           
            
            for (int i = 0; i < sessions.size(); i++)
            {
                System.out.println("Sessions: " + sessions.get(i));
                if(sessions.get(i).getId().equals(sessionid))
                   sessions.remove(i);
            }            
            gamerooms.put(gameRoomName, sessions);                         
	}
        finally
        {
            lock.unlock();
        }
    }

    public Set<String> roomNames()
    {
        lock.lock();
        try
        {
            return (gamerooms.keySet());
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public void broadcastList(String roomName, JsonArray arr) throws EncodeException, IllegalStateException
    {
        lock.lock();
		
        try
        {
            List<Session> sessions = gamerooms.get(roomName);
            if (null == sessions)
                return;
                
            for (Session s: sessions)
		try
                {
                    s.getBasicRemote().sendObject(arr);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
		}
        }
        finally
        {
            lock.unlock();
        }
    }

    public void broadcast(String roomName, JsonObject msg)
    {
        lock.lock();
		
        try
        {
            List<Session> sessions = gamerooms.get(roomName);
            if (null == sessions)
                return;
		
            final String msgToRoom = msg.toString();
            
            System.out.println("Msg to Room: " + msgToRoom);
                
            for (Session s: sessions)
		try
                {
                    s.getBasicRemote().sendText(msgToRoom);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
		}
        }            
        finally
        {
            lock.unlock();
        }
    }
    
    public void send(String roomName, JsonArray arr, String playerName)
    {
        lock.lock();
		
        try
        {
            List<Session> sessions = gamerooms.get(roomName);
            if (null == sessions)
            {
                return;
            }
            
                
            for (Session s: sessions)
		try
                {
                    System.out.println(s.getId());
                    if(s.getId().equals(playerName))
                        s.getBasicRemote().sendObject(arr);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
		} catch (EncodeException ex) {
                    Logger.getLogger(GameRooms.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        finally
        {
            lock.unlock();
        }
    }
}
