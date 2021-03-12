// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// Stores the data of and plays the "20 questions" game.

import java.util.*;
import java.io.*;

public class QuestionTree {

    private QuestionNode treeRoot;
    private UserInterface ui;

    // Constructs a QuestionTree using the given UserInterface.
    // Throws an IllegalArgumentException if the UI is null.
    public QuestionTree(UserInterface ui) {
        throwIfNull(ui, "UI is null");
        this.ui = ui;
        treeRoot = new QuestionNode("computer");
    }

    // Plays one complete guessing game with the user.
    public void play() {
        treeRoot = play(treeRoot);
    }

    // Helper method for play. Launches game based on current
    // userInput (either a load or starting from scratch).
    // Stores questions/answers as it goes, to become smarter.
    // Uses bigYup bool to react to client's input.
    private QuestionNode play(QuestionNode current) {
        if (isAnswerNode(current)) {
            if (bigYup("Is this thing possibly a " + current.userInput +"?")) {
                ui.println("Haha! I am unstoppable! Skynet forever, baybee!");
            } else {
                ui.println("Well, dang. I thought I had you there.");
                ui.print("What was your object? --->>> ");
                QuestionNode thisAnswer = new QuestionNode(ui.nextLine());
                ui.println("Hmm. Okay. Didn't see that one coming.");
                ui.println("Can you help me think of a good yes/no");
                ui.println("question that sets your thing apart");
                ui.print("from mine? --->>> ");
                String newQuestion = ui.nextLine();
                if (bigYup("And is the answer yes or no?")) {
                    current = new QuestionNode(newQuestion, thisAnswer, current);
                } else {
                    current = new QuestionNode(newQuestion, current, thisAnswer);
                }

            }
        } else {
            if (bigYup(current.userInput)) {
                current.yesAnswer = play(current.yesAnswer);
            } else {
                current.noAnswer = play(current.noAnswer);
            }
        }
        return current;
    }

    // Stores the tree's current state to an output file represented by the given PrintStream.
    // Throws an IllegalArgumentException if the output PrintStream is null.
    public void save(PrintStream output) {
        throwIfNull(output, "output PrintStream is null");
        saveHelper(treeRoot, output);
    }
    
    // Helper method for save, allows for the treeRoot Question Node to be called.
    // Saves questions and answers to a file.
    private void saveHelper(QuestionNode treeRoot, PrintStream output) {
        if (isAnswerNode(treeRoot)) {
            output.println("A:");
            output.println(treeRoot.userInput);
        } else {
            output.println("Q:");
            output.println(treeRoot.userInput);
            saveHelper(treeRoot.yesAnswer, output);
            saveHelper(treeRoot.noAnswer, output);
        }
    }

    // Replaces the current tree with a new tree, based off the text in the scanner.
    // Throws an IllegalArgumentException if the input Scanner is null.
    public void load(Scanner input) {
        throwIfNull(input, "input scanner is null");
        while(input.hasNextLine()) {
            treeRoot = loadHelper(input);
        }
    }
    // Helper method for load.
    private QuestionNode loadHelper(Scanner input) {
        String type = input.nextLine();
        String data = input.nextLine();
        QuestionNode root = new QuestionNode(data);
        if (type.contains("Q:")) {
            root.yesAnswer = loadHelper(input);
            root.noAnswer = loadHelper(input);
        }
        return root;
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
    private static void throwIfNull(Object o, String message) {
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }

    // Tests to see if the QuestionNode is a leaf (answer) or a branch (question).
    private boolean isAnswerNode(QuestionNode node) {
        return (node.yesAnswer == null && node.noAnswer == null);
    }

    // Bool method to deliver a true on client 'y' answers. Could be
    // lengthened to take full words, but I like the brevity for now.
    public boolean bigYup(String question) {
        ui.print(question + " (y/n)? ");
        return ui.nextBoolean();
    }
}