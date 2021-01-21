//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 4 Deck of Cards

import java.util.*;

public class CrazyEights {
    public static final int MAX_PLAYERS = 5;
    public static void main(String[] args) {
        // test();

        Scanner console = new Scanner(System.in);
        int numberOfPlayers;
        Queue<Player> players = new LinkedList<>();
        
        // Asks how many players there will be
        numberOfPlayers = promptForPlayers(console);

        // Creates queue of players
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = promptForName(console, i);
            players.add(new Player(name));
        }
    }

    public static void playGame(Scanner console, Queue<Player> playerQueue) {
        boolean playing = true;
        Player winner;
        Stack<Card> deck = Card.generateDeck();
        Stack<Card> discardPile = new Stack<>();
        // The suit the last player who played an eight chose
        Card.Suit chosenSuit;

        // Shuffles and draws a card from the deck
        Collections.shuffle(deck);
        discardPile.push(deck.pop());
        System.out.println("The first card from the deck is " + discardPile.peek() + "!\n");
        // prevents the game from breaking if the first card is an 8
        chosenSuit = discardPile.peek().getSuit();
        while (playing) {
            Card topCard = discardPile.peek();
            Player currentPlayer = playerQueue.peek();
            System.out.println("The card on top of the discard pile is: " + topCard);
            if (topCard.getRank() == Card.Rank.EIGHT) {
                System.out.println("This card is an eight, and the chosen suit is " +
                                   chosenSuit.toString().toLowerCase() + ".");
            }
            System.out.println(currentPlayer.getName() + "'s hand:");
            System.out.println(currentPlayer.handToString());

            // Shifts the queue of players
            playerQueue.add(playerQueue.remove());

            break; // Remove this whenever you add some code that sets playing to false
        }
    }

    // Takes two cards as parameters, and the Suit that the last player who played
    // and eight chose. If the player can play the second card on top of the first
    // card, returns true. Otherwise, returns false.
    public static boolean canPlayCard(Card topCard, Card playedCard, Card.Suit chosenSuit) {
        return (
        // Do they have the same rank?
        (topCard.getRank() == playedCard.getRank()) ||
        // Do they have the same suit?
        (topCard.getRank() != Card.Rank.EIGHT && topCard.getSuit() == playedCard.getSuit()) ||
        // Is the top card an eight, and does this card have the chosen suit?
        (topCard.getRank() == Card.Rank.EIGHT && playedCard.getSuit() == chosenSuit)
        );
    }

    // Takes a Scanner representing the console, and an int for the player's number,
    // then asks that player what name they want. Returns their name.
    public static String promptForName(Scanner console, int playerNumber) {
        System.out.print("Enter the name of player " + playerNumber + ": ");
        return console.nextLine();
    }

    // Takes a scanner representing the console and asks how many players there will be.
    // Returns that number.
    public static int promptForPlayers(Scanner console) {
        System.out.print("How many players are there? (2-" + MAX_PLAYERS + ") ");
        while (true) {
            String answer = console.nextLine();
            if (!isInt(answer)) {
                System.out.print("That's not a number! Try again: ");
            } else {
                int answerAsInt = Integer.parseInt(answer);
                if (answerAsInt < 2 || answerAsInt > MAX_PLAYERS) {
                    System.out.print("That's not between 2 and " + MAX_PLAYERS + "! Try again: ");
                } else {
                    return answerAsInt;
                }
            }
        }
    }
    
    // Takes a Player representing the person whose turn it is,
    // and a Scanner representing the console.
    // Asks the player which card they want to play, or quit.
    // Returns the number that the player entered. If they answered with "q", return -1.
    // If the hand is empty, throw an IllegalArgumentException.
    public static int promptToPlayCard(Scanner console, Player player) {
        if (player.getHand().isEmpty()) {
            throw new IllegalArgumentException("Player has no cards in hand");
        }

        // Asks the user over and over until they give a good answer
        while (true) {
            System.out.print("What card would " + player.getName() + " like to play? ");
            String answer = console.nextLine().toLowerCase();
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

    // a method you can put code in to test stuff
    public static void test() {
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
        System.out.println(promptForPlayers(console));
        System.out.println(promptToPlayCard(console, bob));
    }
}
