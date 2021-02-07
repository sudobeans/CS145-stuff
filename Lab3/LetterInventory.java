// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// Lab 3: Letter Inventory

import java.util.*;

public class LetterInventory {
    // Letters passed into any method may be uppercase or lowercase.
    private Map<Character, Integer> charCounts;
    private int size;

    // The range of characters to count
    public static final int START = 'a';
    public static final int END = 'z';

    // Constructs an inventory (a count) of the alphabetic letters in the given string, 
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    public LetterInventory(String data) {
        charCounts = new TreeMap<>();
        size = 0;
    }    

    // Returns a count of how many of this letters are in the inventory.
    // If a non-alphabetic character is passed, throws an IllegalArgumentException.
    public int get(char letter) {
        int letter = 0;
        while(letter.!isEmpty()){
            for(int i = START; i<= END; i++){
                letter++;
            }
        }
        return 0;
    }

    // Sets the count for the given letter to the given value. 
    public void set(char letter, int value) {
        for(int j = START; j<= END; j++){

        }
        return;
    }

    // Returns the sum of all of the counts in this inventory.
    public int size() {

        return 0;
    }

    // Returns true if this inventory is empty (all counts are 0).
    public boolean isEmpty() {
        if(LetterInventory.isEmpty){
            return true;
        }
        return false;
    }

    // Returns a String representation of the inventory.
    public String toString() {
        charCounts.toString();
        return null;
    }

    // Constructs and returns a new LetterInventory object that represents the 
    // sum of this letter inventory and the other given LetterInventory.
    public LetterInventory add(LetterInventory other) {
        return null;
    }

    // Constructs and returns a new LetterInventory object that represents the 
    // result of subtracting the other inventory from this inventory. 
    // If any resulting count would be negative, returns null.
    public LetterInventory subtract(LetterInventory other) {
        return null;
    }
}