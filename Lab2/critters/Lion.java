// Schuyler Duryee, Alyce Harlan, Judd Morse
// 01/16/2020
// CS 145
// Lab #2
//
// This defines a class of critters that move back and forth between two walls.

import java.awt.*;
import java.util.Random;

public class Lion extends Critter {

    Color[] colors = new Color[] {Color.RED, Color.GREEN, Color.BLUE};
    private int stepCounter = 0;
    Color currentColor = (Color) getRandomElement(colors);

    // See the header for the lion's AI description.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Lion() {
        this.stepCounter = stepCounter;
    }

    // The lion randomly picks to be red, green, or blue, then stays that way for 3 steps
    public Color getColor() {
        stepCounter++;
        if (stepCounter == 3) {
            currentColor = (Color) getRandomElement(colors);
            stepCounter = 0;
        }
        return currentColor;
    }

    // The lion is always an "L"
    public String toString() {
        return "L";
    }

    // Gets a random element from the given array
    public Object getRandomElement(Object[] arr) {
        Random r = new Random();
        int elementToGet = r.nextInt(arr.length);
        return arr[elementToGet];
    }
}
