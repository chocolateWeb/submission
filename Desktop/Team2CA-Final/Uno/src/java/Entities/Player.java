package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player {

    private String playerName;    
    private ArrayList<Card> cardsOnHand;
    

    public Player(String playerName) {
        this.playerName = playerName;
        this.cardsOnHand = new ArrayList<Card>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand;
    }
    

    public Player(int playerNumber, int score) {
        this.playerName = playerName;
        cardsOnHand = new ArrayList<Card>();
    }        

    //add card to player's hand from deck
    public void addCard(Card card) {
        
        cardsOnHand.add(card);

        for(int i = 0; i < cardsOnHand.size();i++)
        {
            System.out.println(cardsOnHand.get(i));
        }
    }
    
    public ArrayList<Card> removeCardsOnHand()
    {
        ArrayList<Card> temp = cardsOnHand;
        cardsOnHand = null;
        return temp;
    }
        //put card into pile
    public Card throwCard1(Card pileCard) 
    {
        // play the first playable card we can find
        for (Card c : cardsOnHand){
        if (c.canPlayOn(pileCard)){
        cardsOnHand.remove(c);
        return c;
        }
    }
    //no card to play
        return null;
    }
}
