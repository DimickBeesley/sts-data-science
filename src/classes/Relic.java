package src.classes;

import java.lang.Character;

public class Relic {
    
    // INSTANCE VARS //
    private String name, text;
    private char character;
    private boolean starter;

    // starter Relic instances
    private static Relic burningBlood = new Relic("Burning Blood", "At the end of combat, heal 6 HP.", true, 'I');
    private static Relic ringOfTheSnake = new Relic("Ring of the Snake", "At the start of each combat, draw 2 additional cards.", true, 'S');
    private static Relic crackedCore = new Relic("Cracked Core", "At the start of each combat, Channel 1 Lightning.", true, 'D');
    private static Relic pureWater = new Relic("Pure Water", "At the start of each combat, add a Miracle into your hand.", true, 'W');

    public Relic(String nameIn, String textIn, boolean starterBool, char characterIn) {
        name = nameIn;
        text = textIn;
        character = Character.toUpperCase(characterIn);
        starter = starterBool;
    }

    public Relic(){
        
    }



    // GETTERS //

    public String getName() {
        return name;
    }
    
    public String getText() {
        return text;
    }

    public char getcharacter() {
        return character;
    }

    public boolean getStarter() {
        return starter;
    }

    public char getCharacter() {
        return character;
    }

    // starter relics
    public static Relic getBurningBlood() {
        return burningBlood;
    }

    public static Relic getRingOfTheSnake() {
        return ringOfTheSnake;
    }

    public static Relic getCrackedCore() {
        return crackedCore;
    }

    public static Relic getPureWater() {
        return pureWater;
    }



    // SETTERS //

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setcharacter(char input) {
        character = Character.toUpperCase(input);
    }

    public void setStarter(boolean input) {
        starter = input;
    }
    
    public void setText(String textIn) {
        text = textIn;
    }




    // TO STRING //

    public String toString() {
        String output =
            name + " " + character + " " + starter + "\n"
            + "--------------\n"
            + text;

            return output;
    }

}