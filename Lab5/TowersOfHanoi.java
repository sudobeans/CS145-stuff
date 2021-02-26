// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// This is a program that plays the Towers of Hanoi game and prints it to the console.
import java.util.Stack;

public class TowersOfHanoi {
    // The number of discs
    public static final int DISCS_IN_PUZZLE = 8;

    public static void main(String[] args) {
        // Towers are represented as stacks of integers.
        // Each number in the stack represents a disc.
        // A bigger number represents a bigger disc.
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();

        // Add discs to tower 1
        for (int i = DISCS_IN_PUZZLE; i >= 1; i--) {
            tower1.push(i);
        }
        
        solve(tower1, tower2, tower3);
    }

    // Recursively moves the discs around until the discs are where they are supposed to be.
    public static void solve(Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
        // TODO: Make this method move stuff around!
        // To move a disc from tower1 to tower3, use move(tower1, tower3).
    }

    // Moves the top disc of the first tower to the second tower.
    // Throws an exception if the second tower's top disc is higher than the first one.
    public static void move(Stack<Integer> givingTower, Stack<Integer> takingTower) {
        if (takingTower.peek() < givingTower.peek()) {
            throw new IllegalStateException("Tried to give a tower " + givingTower.peek() + 
                                "when its highest disc was " + takingTower.peek());
        }
        takingTower.push(givingTower.pop());
    }

    // Takes in any number of Stack<Integer>s representing towers,
    // and returns them as a string, side-by-side.
    @SafeVarargs
    public static String towersToString(Stack<Integer>... towers) {
        int tallestTowerHeight = 0;
        String towersString = "";

        // Figure out the tallest tower's height
        for (Stack<Integer> t : towers) {
            if (t.size() > tallestTowerHeight) {
                tallestTowerHeight = t.size();
            }
        }

        // Build towersString
        for (int level = tallestTowerHeight; level >= 0; level--) {
            for (Stack<Integer> t : towers) {
                if (level >= t.size()) {
                    towersString += " |  | ";
                } else {
                    towersString += String.format("[ %2d ]", t.get(level));
                }
            }
            towersString += "\n";
        }

        return towersString;
    }
}