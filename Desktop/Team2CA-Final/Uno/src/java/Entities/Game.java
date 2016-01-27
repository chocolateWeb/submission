package Entities;

import java.util.ArrayList;

public class Game {

    private int numberOfPlayers, numberOfRounds;
    private ArrayList<Player> players;
    private Deck d;
    private Pile p;
    private boolean hasStarted;

    public Game(int numberOfPlayers, int numberOfRounds) {
        
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfRounds = numberOfRounds;
        
        players = new ArrayList<Player>();
        
        //create new deck
        d = new Deck();
        d.shuffle();
        
        //create a new pile
        p = new Pile();
        
        hasStarted = false;
    }

    public Deck getD() {
        return d;
    }

    public Pile getP() {
        return p;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public ArrayList<Player> removePlayers() {
        
        ArrayList<Player> p = players;
        players = null;
        return p;
    }
    
    public ArrayList<Player> getPlayers() {       
        return players;
    }

    public void addPlayer(String sessionID) {
        
        Player p = new Player(sessionID);        
        players.add(p);
        
        if(this.players.size() == numberOfPlayers)
        {
            hasStarted = true;
        }
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    
}
