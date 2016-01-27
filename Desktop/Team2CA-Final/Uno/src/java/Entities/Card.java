package Entities;

public class Card {

/*
Colour = Red, Blue, Green, Yellow, Black
actionCard - skip, reverse, draw2, draw4, wild(change color)

Draw Two, Reverse, Skip = 20pt
Wild, Wild Draw Four = 50pt
*/

    private String cardID, colour, actionCard;
    private int value;

    public Card(String cardID, String colour, String actionCard, int value) {
        this.cardID = cardID;
        this.colour = colour;
        this.actionCard = actionCard;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" + "cardID=" + cardID + ", colour=" + colour + ", actionCard=" + actionCard + ", value=" + value + '}';
    }

    public String getCardId() {
        return cardID;
    }

    public String getColour() {
        return colour;
    }

    public String getActionCard() {
        return actionCard;
    }

    public int getValue() {
        return value;
    }

    //Check whether this card can be played on the given card. 
    public boolean canPlayOn(Card card) {
        return (card.colour.equals(colour) || card.actionCard.equals(actionCard) || card.value == value);
    }
}
