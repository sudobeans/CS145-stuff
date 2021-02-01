// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// Lab 3: Letter Inventory

public class LetterInventory {
    // Letters passed into any method may be uppercase or lowercase.

    // Constructs an inventory (a count) of the alphabetic letters in the given string, 
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    public LetterInventory(String data) {

    }    

    // Returns a count of how many of this letter are in the inventory. 
    // If a non-alphabetic character is passed, throws an IllegalArgumentException.
    public int get(char letter) {
        return 0;
    }

    // Sets the count for the given letter to the given value. 
    public void set(char letter, int value) {
        return;
    }

    // Returns the sum of all of the counts in this inventory.
    public int size() {
        return 0;
    }

    // Returns true if this inventory is empty (all counts are 0).
    public boolean isEmpty() {
        return false;
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