// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// Lab 3: Letter Inventory
// LetterInventory defines a class that is a bit like a Map. It keeps an inventory of the letters
// of the alphabet.

import java.util.*;

public class LetterInventory {
    // Letters passed into any method may be uppercase or lowercase.
    private int[] charCounts;
    private int size;
    // The range of characters to count
    public static final char START = 'a';
    public static final char END = 'z';
    public static final int NUMBER_OF_LETTERS = END - START + 1;

    // Constructs an inventory (a count) of the alphabetic letters in the given string, 
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    public LetterInventory(String data) {
        charCounts = new int[26];
        size = 0;
        data = data.toLowerCase();
        // Initializes charCounts
        Arrays.fill(charCounts, 0);
        // Adds the string to charCounts
        for (char c : data.toCharArray()) { 
            if (letters().contains(c)) {
                int newValueAtC = charCounts[letterToIndex(c)] + 1;
                charCounts[letterToIndex(c)] = newValueAtC;
                size++;
            }
        }
    }    

    // Returns a count of how many of this letter are in the inventory. 
    // If a non-alphabetic character is passed, throws an IllegalArgumentException.
    public int get(char letter) {
        if (!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException("Not alphabetic: " + letter);
        }
        char letterLower = Character.toLowerCase(letter);
        return charCounts[letterToIndex(letterLower)];
    }

    // Sets the count for the given letter to the given value. 
    // If a non-alphabetic character is passed or if value is negative, 
    // throws an IllegalArgumentException.
    public void set(char letter, int value) {
        if (!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException("Not alphabetic: " + letter);
        } else if (value < 0) {
            throw new IllegalArgumentException("Value is negative: " + value);
        }
        // changes size to reflect the change in value
        size -= this.get(letter);
        size += value;

        char letterLower = Character.toLowerCase(letter);
        charCounts[letterToIndex(letterLower)] = value;
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
        for (char valyou : letters()){
            int value = this.get(valyou);
            for(int repeat = 0; repeat < value; repeat++){
                result += valyou;
            }
        }
        result += "]";
        return result;
    }
    
    // Constructs and returns a new LetterInventory object that represents the 
    // sum of this letter inventory and the other given LetterInventory.
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for(char a : letters()){
            int newCValue = this.get(a) + other.get(a);
            sum.set(a, newCValue);
        }
        return sum;
    }


    // Constructs and returns a new LetterInventory object that represents the 
    // result of subtracting the other inventory from this inventory. 
    // If any resulting count would be negative, returns null.
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory result = this.copy();
        for (char c : letters()) {
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
        for (char c : letters()) {
            result.set(c, this.get(c));
        }
        return result;
    }
    
    // Returns an array as a list
    public static List<Character> asList(char[] arr) {
        ArrayList<Character> result = new ArrayList<>();
        for (char c : arr) {
            result.add(c);
        }
        return result;
    }

    // Returns an array of all the different letters, in order.
    public static List<Character> letters() {
        ArrayList<Character> lettersArray = new ArrayList<>(26);
        for (char c = START; c <= END; c++) {
            lettersArray.add(c);
        }
        return lettersArray;
    }

    // Takes a letter and returns its index in the array (ex. a is 0, b is 1, c is 2, etc.)
    private static int letterToIndex(char letter) {
        char letterLower = Character.toLowerCase(letter);
        return letters().indexOf(letterLower);
    }
}