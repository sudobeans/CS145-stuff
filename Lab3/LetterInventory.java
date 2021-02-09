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
    public static final char START = 'a';
    public static final char END = 'z';

    // Constructs an inventory (a count) of the alphabetic letters in the given string, 
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    public LetterInventory(String data) {
        charCounts = new TreeMap<>();
        size = 0;
        data = data.toLowerCase();
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
    }

    // Returns the sum of all of the counts in this inventory.
    public int size() {
    	return size;
    }

    // Returns true if this inventory is empty (all counts are 0).
    public boolean isEmpty() {
        return (size <= 0);
    }

    // Returns a String representation of the inventory.
    public String toString() {
        String result = "[";
        for (char valyou : charCounts.keySet()){
            int value = charCounts.get(valyou);
            for(int repeat = 0; repeat < value; repeat++){
                result += valyou;
            }
        }
        result += "]";
        return result;
    }
    
    public Map<Character, Integer> toMap() {
        TreeMap<Character, Integer> result = new TreeMap<>();
        result.putAll(charCounts);
        return result;
    }

    // Constructs and returns a new LetterInventory object that represents the 
    // sum of this letter inventory and the other given LetterInventory.
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for(char a : other.toMap().keySet()){
            if (this.charCounts.containsKey(a)) {
                int newCValue = this.get(a) + 1;
                sum.set(a, newCValue);
                size++;
            }
        }
        return sum;
    }


    // Constructs and returns a new LetterInventory object that represents the 
    // result of subtracting the other inventory from this inventory. 
    // If any resulting count would be negative, returns null.
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory result = this.copy();
        for (char c : this.toMap().keySet()) {
            int difference = this.get(c) - other.get(c);
            // Returns null if the count is negative
            if (difference < 0) {
                return null;
            }
            result.set(c, difference);
        }
        return result;
    }

    // Returns a copy of this LetterInventory.
    public LetterInventory copy() {
        LetterInventory result = new LetterInventory("");
        for (char c : this.toMap().keySet()) {
            result.set(c, this.get(c));
        }
        return result;
    }
}