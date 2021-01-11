// This defines a class of critters that move back and forth between two walls.
// Whenever they bump into a creature, they infect it.

import java.awt.*;
import java.util.Random;

public class Lion extends Critter {

    Color[] colors = new Color[] {Color.RED, Color.GREEN, Color.BLUE};
    int stepCounter = 0;
    Color currentColor;

    public Action getMove(CritterInfo info) {
        if (info.getFront().equals(Neighbor.OTHER)) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        stepCounter++;
        if (stepCounter == 3) {
            currentColor = (Color) getRandomElement(colors);
            stepCounter = 0;
        }
        return currentColor;
    }

    public String toString() {
        return "L";
    }

    public Object getRandomElement(Object[] arr) {
        Random r = new Random();
        int elementToGet = r.nextInt(arr.length);
        return arr[elementToGet];
    }
}
