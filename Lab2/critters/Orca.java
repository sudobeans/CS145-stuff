// Schuyler Duryee, Alyce Harlan, Judd Morse
// 01/16/2020
// CS 145
// Lab #2
//
// This defines a class of critters that slowly move back and forth between two walls,
// rotating as they travel. 
// They also hop out of the way of any creature that tries to infect them.

import java.awt.*;
import java.util.Random;

public class Orca extends Critter {

    private int stepCounter = 0;
    private static final Action[] stepCycle = {Action.LEFT, Action.LEFT, Action.LEFT, Action.LEFT, Action.HOP};
    private static final Color[] colors = new Color[] {Color.BLACK, Color.WHITE, Color.GRAY};
    private Color currentColor;

    public Orca() {
        this.stepCounter = stepCounter;
    }

    // See the header for the orca's AI description.
    public Action getMove(CritterInfo info) {
        // Infects other creatures
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        // Turns to face away from walls and allies
        } else if (info.getFront() == Neighbor.WALL || 
                   info.getFront() == Neighbor.SAME ||
                   info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        // Hops away from other creatures and walls
        } else if (info.getRight() == Neighbor.OTHER ||
                   info.getLeft() == Neighbor.OTHER  ||
                   info.getBack() == Neighbor.OTHER  ||
                   info.getBack() == Neighbor.WALL) {
            return Action.HOP;
        // Spins and hops
        } else {
            stepCounter++;
            stepCounter %= stepCycle.length; // Makes its steps loop
            return stepCycle[stepCounter];
        }
    }

    // Randomly picks between gray, black, and white each step
    public Color getColor () {
        if (stepCounter % 2 == 1) {
            currentColor = (Color) getRandomElement(colors);
        }
        return currentColor;
    }

    // Alternates between o, O, and 0
    public String toString() {
        if (stepCounter % 3 == 0) {
            return "o";
        } else if (stepCounter % 3 == 1) {
            return "O";
        } else {
            return "0";
        }
    }

    // Gets a random element from an array
    public Object getRandomElement(Object[] arr) {
        Random r = new Random();
        int elementToGet = r.nextInt(arr.length);
        return arr[elementToGet];
    }
}
