/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import junit.framework.*;

/**
 *
 * @author User
 */
public class PlayerTest extends TestCase {
    
    private Player player;
    private Card gr3;
    private Card yel6;
    private Card yel6b;
    private Card bluskp;
    private Card blu6;

        public void setUp() {
        player = new Player ("sarah");
        gr3 = new Card ("30","green","number",3);
        yel6 = new Card("20", "yellow","number",6);
        yel6b = new Card("21", "yellow","number",5);
        bluskp = new Card("50","blue","skip",20);
        blu6 = new Card("46","blue","number",6);
    }

         public void getCardFromDeck() {

        // hand is initially empty
        assertTrue(player.getCardsOnHand().isEmpty()); 

        player.addCard(yel6);
        assertEquals(1, player.getCardsOnHand().size());
        assertTrue(player.getCardsOnHand().contains(yel6));
        
        player.addCard(gr3);
        assertEquals(2, player.getCardsOnHand().size());
        assertTrue(player.getCardsOnHand().contains(yel6));
        assertTrue(player.getCardsOnHand().contains(gr3));
     
        // check duplicates are allowed
        player.addCard(yel6b);
        assertEquals(3, player.getCardsOnHand().size());
        assertTrue(player.getCardsOnHand().contains(yel6));
        assertTrue(player.getCardsOnHand().contains(yel6b));
        assertTrue(player.getCardsOnHand().contains(gr3));    
    }
   
    public void testPlayCard1() {
        // when the player has no cards, playCard should always return null
        assertNull(player.throwCard1(gr3));
        assertNull(player.throwCard1(yel6));
    }
    public void testPlayCard2b() {
        // play on same colour
        player.addCard(yel6);
        assertEquals(1, player.getCardsOnHand().size());

        assertEquals(yel6, player.throwCard1(yel6));        
        // once the card is played, it is lost
        assertEquals(0, player.getCardsOnHand().size());
    }
        public void testPlayCard2c() {
        // play on same number
        player.addCard(yel6);
        assertEquals(1, player.getCardsOnHand().size());

        assertEquals(yel6, player.throwCard1(blu6));        
        // once the card is played, it is lost
        assertEquals(0, player.getCardsOnHand().size());
    }
    public void testPlayCard3() {
       // can't play        
        player.addCard(yel6);
        player.addCard(blu6);
        assertEquals(2, player.getCardsOnHand().size());
        // draw one card from Deck
        player.addCard(gr3);        
        assertEquals(3, player.getCardsOnHand().size());
    }
}
