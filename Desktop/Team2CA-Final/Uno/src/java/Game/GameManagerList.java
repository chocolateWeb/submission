package Game;

import Entities.Card;
import Entities.GameManager;
import Entities.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameManagerList {

    private Map<String, GameManager> gamemanagers = new HashMap<>();

    private Lock lock = new ReentrantLock();

    public void startGame(String gameRoomName) {
        lock.lock();
        try {

            GameManager gm = gamemanagers.remove(gameRoomName);
            gm.start();
            gamemanagers.put(gameRoomName, gm);

        } finally {
            lock.unlock();
        }
    }

    public Card showCardOnTopOfPile(String gameRoomName) {
        lock.lock();
        try {

            GameManager gm = gamemanagers.remove(gameRoomName);
            Card c = gm.getTopcardOnPile();
            gamemanagers.put(gameRoomName, gm);
            return c;

        } finally {
            lock.unlock();
        }
    }
    
    public Card takeCard(String gameRoomName, String sessionID)
    {
        lock.lock();
        try {

            GameManager gm = gamemanagers.remove(gameRoomName);
            Card c = gm.getCardFromDeck(sessionID);
            gamemanagers.put(gameRoomName, gm);
            return c;

        } finally {
            lock.unlock();
        }
    }
    
    public Card throwCard(String gameRoomName, String sessionID, String cardID)
    {
        lock.lock();
        try {

            GameManager gm = gamemanagers.remove(gameRoomName);
            Card c = gm.putCardIntoPileFromPlayerHand(sessionID, cardID);
            gamemanagers.put(gameRoomName, gm);
            return c;
        } finally {
            lock.unlock();
        }
    }
    
    public int getScore(String gameRoomName, String sessionID)
    {
        lock.lock();
        try {

            GameManager gm = gamemanagers.remove(gameRoomName);
            
            int score = gm.scorePerRound(gm.getGame().getPlayers());
            gamemanagers.put(gameRoomName, gm);
            return score;
        } finally {
            lock.unlock();
        }
    }
    

    public void addPlayerToGame(String gameRoomName, String playerSessionID) {

        lock.lock();
        try {
            GameManager gm = gamemanagers.remove(gameRoomName);

            if (!gm.getGame().isHasStarted()) {
                gm.getGame().addPlayer(playerSessionID);
            }
            
            gamemanagers.put(gameRoomName, gm);
        } finally {
            lock.unlock();
        }
    }

    public boolean checkGame(String gameRoomName) {

        lock.lock();
        try {
            return gamemanagers.get(gameRoomName).getGame().isHasStarted();

        } finally {
            lock.unlock();
        }

    }

    public void add(String gameRoomName, int numberOfPlayers, int numberOfRounds) {
        lock.lock();
        try {
            GameManager gm = gamemanagers.get(gameRoomName);

            if (null == gm) {
                gm = new GameManager(numberOfPlayers, numberOfRounds);
                gamemanagers.put(gameRoomName, gm);
            }
        } finally {
            lock.unlock();
        }
    }

    public void remove(String gameRoomName) {
        lock.lock();
        try {
            System.out.println("Game Room Name to remove >>> " + gameRoomName);

            gamemanagers.remove(gameRoomName);
        } finally {
            lock.unlock();
        }
    }

    public Set<String> roomNames() {
        lock.lock();
        try {

            return (gamemanagers.keySet());
        } finally {
            lock.unlock();
        }
    }

    public Card[] getCardsForPlayer(String gameRoomName, String playerName) {
        lock.lock();
        try {
        
            GameManager gm = gamemanagers.get(gameRoomName);
            
            Card[] cArr = null;
            
            if(gm != null)
            {
                ArrayList<Player> players = gm.getGame().getPlayers();
                
                for(int i = 0; i < players.size(); i++)
                {
                    Player p = players.get(i);
                    if(p.getPlayerName().equals(playerName))
                    {
                        ArrayList<Card> cardsOnHand = p.getCardsOnHand();
                        cArr = cardsOnHand.toArray(new Card[cardsOnHand.size()]);
                    }
                }
            }
            
            return cArr;
            
        } finally {
            lock.unlock();
        }
    }
    
    public ArrayList<Player> getPlayers(String gameRoomName) {
        lock.lock();
        try {
        
            GameManager gm = gamemanagers.get(gameRoomName);
            
            ArrayList<Player> p = gm.getGame().getPlayers();
            return p;
            
        } finally {
            lock.unlock();
        }
    }
}
