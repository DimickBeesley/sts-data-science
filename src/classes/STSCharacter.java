package src.classes;

import java.util.ArrayList;
import java.lang.Character;



public class STSCharacter {
    
    private String name;
    private Deck startDeck;
    private Relic startRelic = new Relic();
    private int baseMaxHP, startGold;
    private char charChar;

    public STSCharacter(String nameIn, char charChar, 
        Relic startRelicIn, int baseMaxHPIn) {
        
        Character.toUpperCase(charChar);

        name = nameIn;
        startDeck = new Deck(charChar);
        startRelic = startRelicIn;
        baseMaxHP = baseMaxHPIn;
        startGold = 99;

    }



    // SETTERS //

    public void setBaseMaxHP(int baseMaxHPIn) {
        this.baseMaxHP = baseMaxHPIn;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public void setStartDeck(Deck startDeckIn) {
        this.startDeck = startDeckIn;
    }

    public void setStartGold(int startGoldIn) {
        this.startGold = startGoldIn;
    }

    public void setStartRelic(Relic startRelicIn) {
        this.startRelic = startRelicIn;
    }

    public void setCharChar(char charChar) {
        this.charChar = charChar;
    }




    // GETTERS //

    public int getBaseMaxHP() {
        return baseMaxHP;
    }

    public String getName() {
        return name;
    }

    public Deck getStartDeck() {
        return startDeck;
    }

    public int getStartGold() {
        return startGold;
    }

    public Relic getStartRelic() {
        return startRelic;
    }

    public char getCharChar() {
        return charChar;
    }

    

    // TO STRING //

    public String toString() {
        
        String dashes = "";

        for (int i = name.length(); i > 0; i--) {
            dashes += "-";
        }

        String output = name + "\n" + dashes
        + "\nBase HP: " + baseMaxHP + "\nStart Gold: " + startGold + "\n"
        + "Starting Relic: " + startRelic.getName() + "\n"
        + "Starting Deck: " + startDeck.toString() + "\n\n";
        
        return output;
    }



    // GENERATE ALL STARTER CHARACTERS //

    public static ArrayList<STSCharacter> instantiateBaseCharacters() {

        ArrayList<STSCharacter> baseCharacters =  new ArrayList<STSCharacter>();
        // instantiate a character object for each base character
        STSCharacter ironclad = new STSCharacter("The Ironclad", 'I', Relic.getBurningBlood(), 80);
        STSCharacter silent = new STSCharacter("The Silent", 'S', Relic.getRingOfTheSnake(), 70);
        STSCharacter defect = new STSCharacter("The Defect", 'D', Relic.getCrackedCore(), 70);
        STSCharacter watcher = new STSCharacter("The Watcher", 'W', Relic.getPureWater(), 70);

        baseCharacters.add(ironclad);
        baseCharacters.add(silent);
        baseCharacters.add(defect);
        baseCharacters.add(watcher);

        return baseCharacters; 


        }

}