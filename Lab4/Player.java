import java.util.*;

// This class represents a player. A player has a hand and a win/not win boolean.
public class Player {
    // the player's hand
    private ArrayList<Card> hand;
    // winner should be set to true if they win
    private boolean winner;

    public Player() {
        this.hand = new ArrayList<>();
        this.winner = false;
    }

    // Sets winner to the boolean passed in
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    // Returns true if the player has won
    public boolean isWinner() {
        return winner;
    }

    // Adds a card to the player's hand
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    
    // Removes the given card from the player's hand
    public void removeCardFromHand(Card card) {
        hand.remove(hand.indexOf(card));
    }

    // Returns a copy of the cards in the player's hand
    public ArrayList<Card> getHand() {
        // My debugger says this is an "unchecked cast", whatever that means!
        return (ArrayList<Card>) hand.clone();
    }
}