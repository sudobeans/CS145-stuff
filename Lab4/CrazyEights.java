//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 4 Deck of Cards

import java.util.*;

public class CrazyEights {
    public static void main(String[] args) {
        // Test code
        Player bob = new Player();
        bob.addToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        bob.addToHand(new Card(Card.Rank.TWO, Card.Suit.DIAMONDS));
        bob.addToHand(new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));

        System.out.println(bob.handToString());
    }
    
    // Takes an ArrayList<Card> representing the player's hand
    // and a Scanner representing the console.
    // Asks the player which card they want to play, or quit.
    // Returns a card if they answered with one. If they answered with "q", return null.
    public static Card promptForAction(Scanner console, ArrayList<Card> hand) {
        String answer;
        String[] answerTokens;
        System.out.println("What card would you like to play? ");

        // Asks the user over and over until they give a good answer
        while (true) {
            answer = console.nextLine().toLowerCase();
            answerTokens = answer.split(" ");
            if (answer.equals("q")) {
                return null;
            }
            return null;
        }

    }
}
