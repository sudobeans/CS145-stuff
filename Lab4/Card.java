
import java.util.*;

// Represents a playing card from a fifty-two card deck. Has a rank and a suit.
public class Card {
    // Enums for suits and ranks
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

    // Takes another card. Returns true if they have the same suit and rank
    public boolean equals(Card other) {
        return (this.getSuit() == other.getSuit() && 
                this.getRank() == other.getRank());
    }

    // Takes a String, s, and returns the rank associated with the given string.
    public static String rankToString(Rank r) {
        return r.toString().toLowerCase();
    }

    // Takes a Suit, s, and returns the string associated with the suit.
    public static String suitToString(Suit s) {
        return s.toString().toLowerCase();
    }

    // Returns the card in the following format: "<rank> of <suit>"
    public String toString() {
        return rankToString(this.getRank()) + " of " + suitToString(this.getSuit());
    }
}