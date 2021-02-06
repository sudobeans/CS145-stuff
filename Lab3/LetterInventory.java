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
        // Initializes charCounts
        for (char c = START; c <= END; c++) {
            charCounts.put(c, 0);
        }
        // Adds the string to charCounts
        for (char c : data.toCharArray()) { 
            if (charCounts.containsKey(c)) {
                int newValueAtC = charCounts.get(c) + 1;
                charCounts.put(c, newValueAtC);
                size++;
            }
        }
    }    

    // Returns a count of how many of this letter are in the inventory. 
    // If a non-alphabetic character is passed, throws an IllegalArgumentException.
    public int get(char letter) {
        return charCounts.get(letter);
    }

    // Sets the count for the given letter to the given value. 
    public void set(char letter, int value) {
        charCounts.put(letter, value);
    	return;
    }

    // Returns the sum of all of the counts in this inventory.
    public int size() {
    	return charCounts.values().stream().mapToInt(i->i).sum();
    }

    // Returns true if this inventory is empty (all counts are 0).
    public boolean isEmpty() {
        if(charCounts.isEmpty() == true) {
        	return true;
        } else { return false;}
    }

    // Returns a String representation of the inventory.
    public String toString() {
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