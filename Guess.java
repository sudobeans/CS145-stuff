// Schuyler Duryee
// Judd Morse
// Alyce Harlan
// 01/07/2020
// CS 145
// Lab #1
//
// This program will play a guessing game with the user.

import java.util.*;

public class Guess {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;
        boolean playAgain = true;
        int totalGuesses = 0;
        int totalGames = 0;
        int guessesTaken;
        int guessesInBestGame = 10000;

        introGame();
        System.out.println();

        while (playAgain) {
            // Plays a game, then updates the user's stats
            guessesTaken = playGame(console);
            totalGuesses += guessesTaken;
            totalGames++;

            if (totalGames <= 1) { // Makes the first game the best game
                guessesInBestGame = guessesTaken;
            }
            if (guessesInBestGame > guessesTaken) { // Updates guessesInBestGame
                guessesInBestGame = guessesTaken;
            }

            // Asks the user if they want to play again
            System.out.print("Do you want to play again? ");
            answer = console.nextLine();
            playAgain = getTruth(answer);

            System.out.println();
        }

        // Displays the user's results
        displayResults(totalGuesses, totalGames, guessesInBestGame);
    }

    // Introduces the game
    public static void introGame() {
        System.out.println(
        "This program allows you to play a guessing game.\n" +
        "I will think of a number between " + MIN_NUMBER + " and \n" +
        MAX_NUMBER + " and will allow you to guess until\n" +
        "you get it. For each guess, I will tell you\n" +
        "whether the right answer is higher or lower\n" +
        "than your guess."
        );
    }

    // Takes a scanner so it can get input from the console.
    // Runs the game, then returns the number of guesses the user took.
    public static int playGame(Scanner console) {
        Random r = new Random();
        int thinkingNumber = r.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        System.out.printf("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "...");
        int guesses = 0;
        int guess = MIN_NUMBER - 1; // Initializes guess

        // Asks the user for their guess until they guess right
        while (guess != thinkingNumber) {
            System.out.print("Your guess? ");
            guess = Integer.parseInt(console.nextLine());
            guesses++;

            if (guess == thinkingNumber) {
                displayGuessesTaken(guesses);
            } else if (guess < thinkingNumber && guess > MIN_NUMBER) {
                System.out.println("It's higher.");
            } else if (guess > thinkingNumber && guess < MAX_NUMBER) {
                System.out.println("It's lower.");
            } else {
                System.out.println("Invalid choice, please select a number between " + MAX_NUMBER + " and " + MIN_NUMBER + ".");
            }
        }
        return guesses;
    }

    // Takes some number of guesses, then prints a message telling 
    // the user how many guesses they took.
    public static void displayGuessesTaken(int guesses) {
        if (guesses == 1) {
            System.out.println("You got it right in 1 guess");
        } else {
            System.out.println("You got it right in " + guesses + " guesses");
        }
    } 

    // Takes the users guesses, games, and best game, then displays the user's games' stats.
    public static void displayResults(int guesses, int games, int bestGame) {
        float guessesPerGame = (float) guesses / games;
        System.out.printf(
            "Overall results:\n" +
            "\ttotal games    = %d\n" + 
            "\ttotal guesses  = %d\n" + 
            "\tguesses/game   = %.1f\n" + 
            "\tbest game      = %d\n",
            games, guesses, guessesPerGame, bestGame);
    }

    // returns true if the first character of answer is y, otherwise returns false.
    public static boolean getTruth(String answer) {
        char firstChar;
        // This if statement is needed so the program doesn't break if answer is empty
        if (answer.equals("")) {
            return false;
        }
        firstChar = answer.charAt(0);
        firstChar = Character.toLowerCase(firstChar);
        return (firstChar == 'y');
    }

} 