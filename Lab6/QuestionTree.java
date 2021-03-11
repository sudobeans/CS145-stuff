// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// Stores the data of and plays the "20 questions" game.

import java.util.*;
import java.io.*;

public class QuestionTree {

    // Constructs a QuestionTree using the given UserInterface.
    // Throws an IllegalArgumentException if the UI is null.
    public QuestionTree(UserInterface ui) {
        throwIfNull(ui, "UI is null");
        // Write some code here!
    }

    // Plays one complete guessing game with the user.
    public void play() {
        // Write some code here!
    }

    // Stores the tree's current state to an output file represented by the given PrintStream.
    // Throws an IllegalArgumentException if the output PrintStream is null.
    public void save(PrintStream output) {
        throwIfNull(output, "output PrintStream is null");
        // Write some code here!
    }

    // Replaces the current tree with a new tree, based off the text in the scanner.
    // Throws an IllegalArgumentException if the input Scanner is null.
    public void load(Scanner input) {
        throwIfNull(input, "input scanner is null");
        // Write some code here!
    }

    // Returns the total number of games the user has played.
    public int totalGames() {
        // Write some code here!
        return 0;
    }

    // Returns the number of games the user has won.
    public int gamesWon() {
        // Write some code here!
        return 0;
    }

    // Throws an IllegalArgumentException with the given message if the given Object is null.
    public void throwIfNull(Object o, String message) {
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }
}