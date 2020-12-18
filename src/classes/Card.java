package src.classes;

// import java.util.ArrayList;
import java.lang.Character;
import java.util.ArrayList;

public class Card {
    
    // INSTANCE VARS //
    private String name, text;
    private int cost, dmg, block, draws;
    private boolean exhaustsSelf;
    private char color; // 'D'efect, 'W'atcher, 'I'ronClad, 'S'ilent, 'O'ther

    // CONSTRUCTORS //

    public Card(String nameIn, char typeIn, int costIn, String textIn, char colorIn) {
        name = nameIn;
        cost = costIn;
        color = Character.toUpperCase(colorIn); // TODO are curses and stati colorless?
        text = textIn;
    }

    public Card(String nameIn, int costIn, String textIn) {
        name = nameIn;
        cost = costIn;
        text = textIn;
    }




    // SETTERS //

    public void setBlock(int block) {
        this.block = block;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setExhaustsSelf(boolean exhaustsSelf) {
        this.exhaustsSelf = exhaustsSelf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(char color) {
        this.color = color;
    }




    // GETTERS //

    public int getBlock() {
        return block;
    }

    public int getCost() {
        return cost;
    }

    public int getDmg() {
        return dmg;
    }

    public int getDraws() {
        return draws;
    }

    public String getName() {
        return name;
    }

    public boolean exhaustsSelf() {
        return exhaustsSelf;
    }

    public char getColor() {
        return color;
    }




    // TO STRING //

    public String toString() {
        String dashes = "";

        for (int i = text.length(); i > 0; i--) {
            dashes += "-";
        }
        
        String output =
        name + " (" + cost + ")\n"
        + dashes + "\n" + text;
        return output;
    }




    // STRIKE AND DEFEND //

    public static Card makeStrike() {
        return new Card("Strike", 'A', 1, "Deal 6 damage.", 'O');
    }

    public static Card makeDefend() {
        return new Card("Defend", 'A', 1, "Gain 6 Block.", 'O');
    }




    // IRONCLAD BASE CARDS //

    public static ArrayList<Card> ironcladBaseCards() {
        ArrayList<Card> baseCards = new ArrayList<Card>();

        // instantiate Ironclad's unique cards
        Card bash = new Card("Bash", 'A', 2, "Deal 8 damage. Apply 2 Vunerable.", 'I');

        // set dmg of Bash
        bash.setDmg(8);

        // add Bash to the list
        baseCards.add(bash);

        return baseCards; 
    }




    // SILENT BASE CARDS //

    public static ArrayList<Card> silentBaseCards() {
        ArrayList<Card> baseCards = new ArrayList<Card>();
        
        // instantiate Silent's unique cards
        Card nuetralize = new Card("Nuetralize", 'A', 0, "Deal 3 damage. Apply 1 Weak.", 'S');
        Card survivor = new Card("Survivor", 'S', 1, "Gain 8 Block. Discard 1 card.", 'S');
        
        // set dmg and block of cards
        nuetralize.setDmg(3);
        survivor.setBlock(8);

        // add the base cards to the list
        baseCards.add(nuetralize);
        baseCards.add(survivor);

        return baseCards; 
    }




    // DEFECT BASE CARDS //

    public static ArrayList<Card> defectBaseCards() {
        ArrayList<Card> baseCards = new ArrayList<Card>();

        // instantiate Defects's unique cards
        baseCards.add(new Card("Zap", 'S', 1, "Channel 1 Lightning.", 'D'));
        baseCards.add(new Card("Dualcast", 'S', 1, "Evoke your next Orb twice.", 'D'));

        return baseCards; 
    }




    // WATCHER BASE CARDS //

    public static ArrayList<Card> watcherBaseCards() {
        ArrayList<Card> baseCards = new ArrayList<Card>();

        // instantiate Watcher's unique cards
        Card eruption = new Card("Eruption", 'A', 2, "Deal 9 damage. Enter Wrath.", 'W');
        Card vigilance = new Card("Vigilance", 'S', 2, "Gain 8 Block. Enter Calm.", 'W');

        // set dmg and block of cards
        eruption.setDmg(9);
        vigilance.setBlock(8);

        // add the cards to the list of base cards
        baseCards.add(eruption);
        baseCards.add(vigilance);
        
        return baseCards; 
    }

}
