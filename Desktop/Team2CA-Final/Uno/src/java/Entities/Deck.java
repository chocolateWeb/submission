package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author Team 2
 */
public class Deck implements Serializable  {
    private HashMap<String, Card> stackOfCards;
    private HashMap<String, Card> shuffledCards;
    private List <String> cardId = new ArrayList<>();
    
    public Deck()
    {
        stackOfCards = new HashMap<>();
        
        Card card;
        shuffledCards = new HashMap<>();
        
        card = new Card ("1","red","number",0);
        stackOfCards.put("1",card);
        card = new Card ("2", "red","number",1);
        stackOfCards.put("2",card);      
        card = new Card ("53","red","number",1);
         stackOfCards.put("53",card);                 
        card = new Card ("3", "red","number",2);
        stackOfCards.put("3",card);        
        card = new Card ("54","red","number",2);
        stackOfCards.put("54",card);        
        card = new Card ("4", "red","number",3);
        stackOfCards.put("4",card);                
        card = new Card ("55","red","number",3);
        stackOfCards.put("55",card);   
        card = new Card ("5", "red","number",4);
        stackOfCards.put("5",card);       
        card = new Card ("56","red","number",4);
        stackOfCards.put("56",card);
        card = new Card ("6", "red","number",5);
        stackOfCards.put("6",card);           
        card = new Card ("57","red","number",5);
        stackOfCards.put("57",card);       
        card = new Card ("7","red","number",6);
        stackOfCards.put("7",card);        
        card = new Card ("58","red","number",6);
        stackOfCards.put("58",card);
        card = new Card ("8", "red","number",7);
        stackOfCards.put("8",card); 
        card = new Card ("59", "red","number",7);
        stackOfCards.put("59",card);     
        card = new Card ("9", "red","number",8);
        stackOfCards.put("9",card);       
        card = new Card ("60","red","number",8);
        stackOfCards.put("60",card);
        card = new Card ("10", "red","number",9);
        stackOfCards.put("10",card);             
        card = new Card ("61","red","number",9);
        stackOfCards.put("61",card); 
        card = new Card ("11", "red","skip",20);
        stackOfCards.put("11",card);        
        card = new Card ("62","red","skip",20);
        stackOfCards.put("62",card);
        card = new Card ("12", "red","reverse",20);
        stackOfCards.put("12",card);              
        card = new Card ("63","red","reverse",20);
        stackOfCards.put("63",card);     
        card = new Card ("13", "red","draw2",20);
        stackOfCards.put("13",card);
        card = new Card ("64","red","draw2",20);
        stackOfCards.put("64",card);    
        
        card = new Card ("14", "yellow","number",0);
        stackOfCards.put("14",card);
        card = new Card ("15", "yellow","number",1);
        stackOfCards.put("15",card);        
        card = new Card ("65","yellow","number",1);
        stackOfCards.put("65",card);                 
        card = new Card ("16", "yellow","number",2);
        stackOfCards.put("16",card);        
        card = new Card ("66","yellow","number",2);
        stackOfCards.put("66",card);        
        card = new Card ("17", "yellow","number",3);
        stackOfCards.put("17",card);                
        card = new Card ("67","yellow","number",3);
        stackOfCards.put("67",card);   
        card = new Card ("18", "yellow","number",4);
        stackOfCards.put("18",card);       
        card = new Card ("68","yellow","number",4);
        stackOfCards.put("68",card);
        card = new Card ("19", "yellow","number",5);
        stackOfCards.put("19",card);           
        card = new Card ("69","yellow","number",5);
        stackOfCards.put("69",card);       
        card = new Card ("20", "yellow","number",6);
        stackOfCards.put("20",card);        
        card = new Card ("70","yellow","number",6);
        stackOfCards.put("70",card);
        card = new Card ("21", "yellow","number",7);
        stackOfCards.put("21",card); 
        card = new Card ("71","yellow","number",7);
        stackOfCards.put("71",card);     
        card = new Card ("22", "yellow","number",8);
        stackOfCards.put("22",card);       
        card = new Card ("72","yellow","number",8);
        stackOfCards.put("72",card);
        card = new Card ("23", "yellow","number",9);
        stackOfCards.put("23",card);             
        card = new Card ("73","yellow","number",9);
        stackOfCards.put("73",card); 
        card = new Card ("24", "yellow","skip",20);
        stackOfCards.put("24",card);        
        card = new Card ("74","yellow","skip",20);
        stackOfCards.put("74",card);
        card = new Card ("25", "yellow","reverse",20);
        stackOfCards.put("25",card);              
        card = new Card ("75","yellow","reverse",20);
        stackOfCards.put("75",card);     
        card = new Card ("26", "yellow","draw2",20);
        stackOfCards.put("26",card);
        card = new Card ("76","yellow","draw2",20);
        stackOfCards.put("76",card);       
        
        card = new Card ("27", "green","number",0);
        stackOfCards.put("27",card);
        card = new Card ("28", "green","number",1);
        stackOfCards.put("28",card);        
        card = new Card ("77","green","number",1);
        stackOfCards.put("77",card);                 
        card = new Card ("29","green","number",2);
        stackOfCards.put("29",card);        
        card = new Card ("78","green","number",2);
        stackOfCards.put("78",card);        
        card = new Card ("30","green","number",3);
        stackOfCards.put("30",card);                
        card = new Card ("79","green","number",3);
        stackOfCards.put("79",card);   
        card = new Card ("31","green","number",4);
        stackOfCards.put("31",card);       
        card = new Card ("80","green","number",4);
        stackOfCards.put("80",card);
        card = new Card ("32","green","number",5);
        stackOfCards.put("32",card);           
        card = new Card ("81","green","number",5);
        stackOfCards.put("81",card);       
        card = new Card ("33","green","number",6);
        stackOfCards.put("33",card);        
        card = new Card ("82","green","number",6);
        stackOfCards.put("82",card);
        card = new Card ("34","green","number",7);
        stackOfCards.put("34",card); 
        card = new Card ("83","green","number",7);
        stackOfCards.put("83",card);     
        card = new Card ("35","green","number",8);
        stackOfCards.put("35",card);       
        card = new Card ("84","green","number",8);
        stackOfCards.put("84",card);
        card = new Card ("36","green","number",9);
        stackOfCards.put("36",card);             
        card = new Card ("85","green","number",9);
        stackOfCards.put("85",card); 
        card = new Card ("37","green","skip",20);
        stackOfCards.put("37",card);        
        card = new Card ("86","green","skip",20);
        stackOfCards.put("86",card);
        card = new Card ("38","green","reverse",20);
        stackOfCards.put("38",card);              
        card = new Card ("87","green","reverse",20);
        stackOfCards.put("87",card);     
        card = new Card ("39","green","draw2",20);
        stackOfCards.put("39",card);
        card = new Card ("88","green","draw2",20);
        stackOfCards.put("88",card);   
        
        card = new Card ("40","blue","number",0);
        stackOfCards.put("40",card);
        card = new Card ("41","blue","number",1);
        stackOfCards.put("41",card);        
        card = new Card ("89","blue","number",1);
        stackOfCards.put("89",card);                 
        card = new Card ("42","blue","number",2);
        stackOfCards.put("42",card);        
        card = new Card ("90","blue","number",2);
        stackOfCards.put("90",card);        
        card = new Card ("43","blue","number",3);
        stackOfCards.put("43",card);                
        card = new Card ("91","blue","number",3);
        stackOfCards.put("91",card);   
        card = new Card ("44","blue","number",4);
        stackOfCards.put("44",card);       
        card = new Card ("92","blue","number",4);
        stackOfCards.put("92",card);
        card = new Card ("45","blue","number",5);
        stackOfCards.put("45",card);           
        card = new Card ("93","blue","number",5);
        stackOfCards.put("93",card);       
        card = new Card ("46","blue","number",6);
        stackOfCards.put("46",card);        
        card = new Card ("94","blue","number",6);
        stackOfCards.put("94",card);
        card = new Card ("47","blue","number",7);
        stackOfCards.put("47",card); 
        card = new Card ("95","blue","number",7);
        stackOfCards.put("95",card);     
        card = new Card ("48","blue","number",8);
        stackOfCards.put("48",card);       
        card = new Card ("96","blue","number",8);
        stackOfCards.put("96",card);
        card = new Card ("49","blue","number",9);
        stackOfCards.put("49",card);             
        card = new Card ("97","blue","number",9);
        stackOfCards.put("97",card); 
        card = new Card ("50","blue","skip",20);
        stackOfCards.put("50",card);        
        card = new Card ("98","blue","skip",20);
        stackOfCards.put("98",card);
        card = new Card ("51","blue","reverse",20);
        stackOfCards.put("51",card);              
        card = new Card ("99","blue","reverse",20);
        stackOfCards.put("99",card);     
        card = new Card ("52","blue","draw2",20);
        stackOfCards.put("52",card);
        card = new Card ("100","blue","draw2",20);
        stackOfCards.put("100",card);         
        
        card = new Card ("101","black","wild",50);
        stackOfCards.put("101",card);              
        card = new Card ("102","black","wild",50);
        stackOfCards.put("102",card);     
        card = new Card ("103","black","wild",50);
        stackOfCards.put("103",card);
        card = new Card ("104","black","wild",50);
        stackOfCards.put("104",card);   
        
        card = new Card ("105","black","draw4",50);
        stackOfCards.put("105",card);              
        card = new Card ("106","black","draw4",50);
        stackOfCards.put("106",card);     
        card = new Card ("107","black","draw4",50);
        stackOfCards.put("107",card);
        card = new Card ("108","black","draw4",50);
        stackOfCards.put("108",card);
        shuffle();
        shuffledCards = stackOfCards;
    }

    //shuffle the card on deck
    public void shuffle() {  
               
        cardId = new ArrayList(stackOfCards.keySet());
        
        Collections.shuffle(cardId);
        
        for (String c : cardId){
            shuffledCards.put(c,stackOfCards.get(c));
        }
    }    
    
    public Card removeTopCard()
    {
        Set<String>keySet = shuffledCards.keySet();        
        ArrayList<String> nList = new ArrayList<String>(keySet);
        
        Random r = new Random();
        int i = r.nextInt(107) + 1;
        
        Card c = shuffledCards.remove(nList.get(i));
        
        return c;
    }  
}

