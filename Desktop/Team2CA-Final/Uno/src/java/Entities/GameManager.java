package Entities;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    
    private Game g;

    public GameManager(int numberOfPlayers, int numberOfRounds) {
        
        g = new Game(numberOfPlayers, numberOfRounds);
    }
    
    
    public Game getGame() {
        return g;
    }
    
    public void start()
    {
        //init stage distribute 7 cards to each player
        //dealsCard();
        getTopCardFromDeckIntoPile();
    }
    
    public void dealsCard()
    {     
        for (int i = 0; i < 7; i++) {
            for (Player ply : g.getPlayers())
            {
                Card c = g.getD().removeTopCard();
                
                ply.addCard(c);
            }
        }
    }
    
    public Card getCardFromDeck(String playerName)
    {
        Card c = g.getD().removeTopCard();
        System.out.println("+++++" + c.getCardId());
        ArrayList<Player> p = g.removePlayers();
        
        System.out.println(p.size());
        
        for(int i = 0; i < p.size(); i++)
        {
            if(p.get(i).getPlayerName().equals(playerName))
            {
                Player player = p.remove(i);
                player.addCard(c);
                p.add(player);
                
                //System.out.println("IVE ADDED A CARD");
            }
        }
        
        g.setPlayers(p);
        
        return c;
    }
    
    public Card getTopcardOnPile()
    {
        Card c = g.getP().getTopcardOnPile();        
        return c;
    }
    
    public void getTopCardFromDeckIntoPile()
    {
        Card c = g.getD().removeTopCard();
        g.getP().setTopcardOnPile(c);
    }
    
    public Card putCardIntoPileFromPlayerHand(String sessionID, String cardID)
    {
        System.out.println(sessionID + " " + cardID);
        ArrayList<Player> p = g.removePlayers();
        
        Card c = null;
        
        for(int i = 0; i < p.size(); i++)
        {
            if(p.get(i).getPlayerName().equals(sessionID))
            {
                Player ply = p.remove(i);
                ArrayList<Card> temp = ply.removeCardsOnHand();
                for(int j = 0; j < temp.size(); j++)
                {
                    if(temp.get(j).equals(cardID))
                    {
                        //System.out.println("FOUND IT!!!!!");
                        c = temp.remove(j);
                    }
                }
                
                //System.out.println("I'M HERE!!!!!");
                
                //add to pile
                if(c != null)
                {
                    g.getP().setTopcardOnPile(c);
                    System.out.println("Added Card to Pile >>> " + cardID);
                }
            }
        }
        
        return c;
    }
    
    public int scorePerRound(ArrayList<Player> p){
    
        int winnerScore = 0;
        
        for(Player ply: p){
            winnerScore = winnerScore + scoring(ply);
        }      
        
        return winnerScore;
    }
    
    public int scoring(Player p){        
       
        int value = 0;
        ArrayList<Card> Cards = p.getCardsOnHand();
        
        String name = p.getPlayerName();
        
        for(Card c: Cards){
        
            value = value + c.getValue();
        
        }        
       
       return value;       
        
       
    }

}
