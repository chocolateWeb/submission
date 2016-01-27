
package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author KeljinChow
 */
public class Pile
{
    private Card topcardOnPile;
    HashMap<String, Card> pileOfCards;
    
    
    //new empty pile
    public Pile()
    {
        pileOfCards = new HashMap<>();       
    }
    

    public Card getTopcardOnPile() {
        return topcardOnPile;
    }

    public void setTopcardOnPile(Card topcardOnPile) {
        this.topcardOnPile = topcardOnPile;
        //pileOfCards.put(cardID, card);  
    }
       
}
