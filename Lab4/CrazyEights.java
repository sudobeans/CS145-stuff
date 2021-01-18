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

// Represents a playing card from a fifty-two card deck. Has a rank and a suit.
public class Card {
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    int rank;
    int suit;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }
    
    public Rank getRank() {
        return this.rank;
    }
}