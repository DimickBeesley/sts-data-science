package src;

import java.util.ArrayList;
import src.classes.*;

public class Main {
    
    public static void main(String[] args) {
       
        ArrayList<STSCharacter> baseCharacters = STSCharacter.instantiateBaseCharacters();
        
        for (STSCharacter c: baseCharacters) {
            System.out.println(c);  
        }

    }

}
