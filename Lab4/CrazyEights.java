//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 4 Deck of Cards

import java.util.*;

public class CrazyEights {
    public static final int MAX_PLAYERS = 5;
    public static void main(String[] args) {
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

        playGame(console, players);
    }

    // Plays a game of crazy eights. Takes in a console and a list of players.
    public static void playGame(Scanner console, Queue<Player> playerQueue) {
        boolean playing = true;
        Player winner;
        Stack<Card> deck = Card.generateDeck();
        Stack<Card> discardPile = new Stack<>();
        // The suit the last player who played an eight chose
        Card.Suit chosenSuit;

        // Shuffles the deck
        Collections.shuffle(deck);
        
        // Draws 5 cards for each player
        for (Player player : playerQueue) {
            for (int i = 0; i < 5; i++) {
                player.addToHand(deck.pop());
            }
        }

        // Draws the first card
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

            // Draws cards until the player has a card they can play
            while (!canPlayHand(topCard, currentPlayer, chosenSuit)) {
                conditionalDraw(deck, discardPile, currentPlayer);
            }

            System.out.println(currentPlayer.getName() + "'s hand:");
            System.out.println(currentPlayer.handToString());

            // Asks the player for a card
            int playedCard = promptToPlayCard(console, currentPlayer);
            // If they cannot play the card, asks them again
            while (!canPlayCard(topCard, currentPlayer.getCardAt(playedCard), chosenSuit)) {
                System.out.println("You can't play that card!");
                playedCard = promptToPlayCard(console, currentPlayer);
            }
            // Plays the card
            discardPile.push(currentPlayer.removeFromHand(playedCard));

            // Asks the player what suit they want if they played an 8
            if (discardPile.peek().getRank() == Card.Rank.EIGHT) {
                System.out.println("You played an 8, so you get to choose the next suit.");
                
                int index = 0;
                for (Card.Suit s : Card.Suit.values()) {
                    System.out.println(index + ": " + s.toString());
                    index++;
                }
                System.out.print("Pick a number from this list: ");
                // Asks for a number and converts their answer to an integer
                chosenSuit = Card.Suit.values()[Integer.valueOf(console.nextLine())];
            }

            if (currentPlayer.getHand().isEmpty()) {
                currentPlayer.setWinner(true);
                playing = false;
                System.out.println(currentPlayer.getName() + " has no cards, so they win!");
            }

            System.out.println();

            // Shifts the queue of players
            playerQueue.add(playerQueue.remove());
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

    // Takes the card on top of the discard pile, a player, and the Suit that the last player
    // who played an eight chose. Returns true if they have a Card in their hand they can play.
    public static boolean canPlayHand(Card topCard, Player player, Card.Suit chosenSuit) {
        for (Card c : player.getHand()) {
            if (canPlayCard(topCard, c, chosenSuit)) {
                return true;
            }
        }
        return false;
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
    
    // Draws a card from deck and adds it to a player's hand. If there are no cards in deck,
    // shuffle the cards from discard into deck.
    public static void conditionalDraw(Stack<Card> deck, Stack<Card> discard, Player player) {
        if(deck.isEmpty()) {
            Card discardTop = discard.pop();
            int deckSize = discard.size();
            for(int i = 0; i < deckSize; i++) {
                deck.push(discard.pop());
            }
            discard.push(discardTop);
            Collections.shuffle(deck);
            System.out.println("There were no more cards in the deck, so the discard pile\n" + 
                               "was shuffled into the draw pile.");
        }
        player.addToHand(deck.pop());
    }
}
