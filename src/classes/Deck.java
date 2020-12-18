package src.classes;

import java.util.ArrayList;
import java.lang.Character;

public class Deck {

    // INSTANCE VARS //
    private ArrayList<Card> deckContents = new ArrayList<Card>();
    private boolean starter;
    private char deckType; // 'D'efect, 'W'atcher, 'I'ronClad, 'S'ilent, 'O'ther

    // base decks //
    private static ArrayList<Card> ironcladDeck = 
        makeBaseDeck(5, 4, Card.ironcladBaseCards());
    
    private static ArrayList<Card> silentDeck = 
        makeBaseDeck(5, 5, Card.silentBaseCards());
    
    private static ArrayList<Card> defectDeck =
        makeBaseDeck(4, 4, Card.defectBaseCards());
    
    private static ArrayList<Card> watcherDeck =   
        makeBaseDeck(4, 4, Card.watcherBaseCards());




    // CONSTRUCTORS //

    public Deck(Character characterIn) {
        
        Character.toUpperCase(characterIn);

        switch (characterIn) {
            
            case 'I':
                this.deckContents = ironcladDeck;
                this.deckType = 'I';
                this.starter = true;
                break;
                
            case 'S':
                this.deckContents = silentDeck;
                this.deckType = 'S';
                this.starter = true;
                break;

            case 'D':
                this.deckContents = defectDeck;
                this.deckType = 'D';
                this.starter = true;
                break;

            case 'W':
                this.deckContents = watcherDeck;
                this.deckType = 'W';
                this.starter = true;
                break;

            default:
                this.deckType = 'O';

        }

    }

    public Deck() {
        // TODO decide what you're going to do with this
    }




    // SETTERS //

    public void setDeckContents(ArrayList<Card> deckContents) {
        this.deckContents = deckContents;
    }

    public void setDeckType(char deckType) {
        this.deckType = deckType;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }




    // GETTERS //

    public ArrayList<Card> getDeckContents() {
        return deckContents;
    }

    public char getDeckType() {
        return deckType;
    }

    public static ArrayList<Card> getIroncladDeck() {
        return ironcladDeck;
    }

    public static ArrayList<Card> getSilentDeck() {
        return silentDeck;
    }

    public static ArrayList<Card> getDefectDeck() {
        return defectDeck;
    }

    public static ArrayList<Card> getWatcherDeck() {
        return watcherDeck;
    }

    public boolean isStarter() {
        return starter;
    }

    // TODO see what we want to do about the difference in name of isStarter (considering it's basically a getter for bools)




    // TO STRING //

    public String toString() {
        String output = "(" + deckContents.size() + " cards)\n";
        
        for (Card c: deckContents) {
            output += "\n" + c + "\n";
            /*
            String output =
            cost + " / " + name + "\n"
            + "-------------\n"
            + text;
            return output;
            */
        }
        
        return output;
    }
    



    // EDITING DECK CONTENTS //

    /** for single card append */
    public boolean add(Card cardIn) {
        this.deckContents.add(cardIn);
        return true; // TODO will check to see if card exists
    }

    /** for multi card append */
    public boolean add(ArrayList<Card> deckContentsIn) {
        for (Card c: deckContentsIn) {
            this.deckContents.add(c);
        }
        return true; // TODO will check to see if cards exist
    }

    // TODO add removal and searches or something like that
    



    // BASE DECKS //

    // ironclad
    public static ArrayList<Card> makeBaseDeck
        (int numStrikes, int numDefends, ArrayList<Card> uniqueCards) 
    {
        ArrayList<Card> deck = uniqueCards;
        
        // add x strikes
        for (int i = 0; i < numStrikes; i++) {
            deck.add(Card.makeStrike());
        }
        // add x defends
        for (int i = 0; i < numStrikes; i++) {
            deck.add(Card.makeDefend());
        }

        return deck;
    }

}