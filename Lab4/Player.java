import java.util.*;

// This class represents a player. A player has a hand and a win/not win boolean.
public class Player {
    // the player's hand and name
    private ArrayList<Card> hand;
    private String name;
    // winner should be set to true if they win
    private boolean winner;

    public Player(String name) {
        this.hand = new ArrayList<>();
        this.winner = false;
        this.name = name;
    }

    public String getName() {
        return this.name;
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
    public void addToHand(Card card) {
        hand.add(card);
    }
    
    // Removes the given card from the player's hand
    public void removeFromHand(Card card) {
        hand.remove(hand.indexOf(card));
    }
    // Removes the card at the given index from the player's hand
    public void removeFromHand(int index) {
        hand.remove(index);
    }

    // Returns the card from the player's hand at the given index
    public Card getCardAt(int index) {
        return hand.get(index);
    }

    // Returns a copy of the cards in the player's hand
    public ArrayList<Card> getHand() {
        // My debugger says this is an "unchecked cast", whatever that means!
        return (ArrayList<Card>) hand.clone();
    }

    // Returns the player's hand as a string.
    public String handToString() {
        String handString = "";
        // Adds each card to the handString
        for (int i = 0; i < hand.size(); i++) {
            handString += (i + ": " + hand.get(i).toString() + "\n");
        }

        return handString;
    }
}