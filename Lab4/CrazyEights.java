//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 4 Deck of Cards

public class CrazyEights {
    public static void main(String[] args) {
        // Play crazy eights
    }
}

// This class represents a player. A player has a hand and a win/not win boolean.
public class Player {
    // the player's hand
    private ArrayList<Card> hand;
    // winner should be set to true if they win
    private boolean winner;

    public Player() {
        hand = new ArrayList<>();
        winner = false;
    }

    // Adds a card to the player's hand
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    
}

// Represents a playing card from a fifty-two card deck. Has a rank and a suit.
public class Card {
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    // Returns the card's suit
    public Suit getSuit() {
        return this.suit;
    }
    
    // Returns the card's rank
    public Rank getRank() {
        return this.rank;
    }

    // Returns true if they have the same suit and rank
    public boolean equals(Card other) {
        return (this.getSuit() == other.getSuit() && 
                this.getRank() == other.getRank());
    }
}