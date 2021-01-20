//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 4 Deck of Cards

import java.util.*;

public class CrazyEights {
    public static void main(String[] args) {
        // Test code
        Stack<Card> deck = Card.generateDeck();
        Collections.shuffle(deck);

        Scanner console = new Scanner(System.in);
        Player bob = new Player("bob");
        bob.addToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        bob.addToHand(new Card(Card.Rank.TWO, Card.Suit.DIAMONDS));
        bob.addToHand(new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        // Draw a card
        bob.addToHand(deck.pop());

        System.out.println(promptToPlayCard(console, bob));
    }
    
    // Takes a Player representing the person whose turn it is
    // and a Scanner representing the console.
    // Asks the player which card they want to play, or quit.
    // Returns the number that the player entered. If they answered with "q", return -1.
    // If the hand is empty, throw an IllegalArgumentException.
    public static int promptToPlayCard(Scanner console, Player player) {
        if (player.getHand().isEmpty()) {
            throw new IllegalArgumentException("Player has no cards in hand");
        }
        String answer;
        System.out.println(player.getName() + "'s hand:");
        System.out.println(player.handToString());
        System.out.print("What card would " + player.getName() + " like to play? ");

        // Asks the user over and over until they give a good answer
        while (true) {
            answer = console.nextLine().toLowerCase();
            if (answer.equals("q")) {
                return -1;
            } else if (!isInt(answer)) {
                System.out.println("That's not a number! Enter the number associated with " +
                                   "the card you want to play.");
            } else { // The answer is an integer
                int answerAsInt = Integer.parseInt(answer);

                if (answerAsInt < 0 || answerAsInt > player.getHand().size()) {
                    System.out.println("You don't have a card associated with that " +
                                       "number in your hand!");
                } else {
                    return answerAsInt;
                }
            }

            System.out.print("Enter the number of the card " + 
                               player.getName() + " would like to play: ");
        }
    }

    // Takes a string. Returns true if the string can be turned into an integer.
    public static boolean isInt(String s) {
        if (s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
