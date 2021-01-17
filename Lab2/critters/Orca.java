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

    private int stepCounter;
    private static final Action[] stepCycle = {Action.LEFT, Action.LEFT, Action.LEFT, Action.LEFT, Action.HOP};
    private static final Color[] colors = new Color[] {Color.BLACK, Color.WHITE, Color.GRAY};
    private Color currentColor;

    public Orca() {
        this.stepCounter = 0;
    }

    // See the header for the orca's AI description.
    public Action getMove(CritterInfo info) {
        if (info.getDirection() == Direction.NORTH) {
            if(info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getRight() == Neighbor.OTHER) {
                return Action.RIGHT;
            }
            else if (info.getFront() == Neighbor.EMPTY) {
                stepCounter ++;
                return Action.HOP;
            } else {
                stepCounter++;
                return Action.LEFT;
            }
        }
        if (info.getDirection() == Direction.EAST) {
            if(info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getRight() == Neighbor.OTHER) {
                return Action.RIGHT;
            }
            else if (info.getFront() == Neighbor.EMPTY) {
                stepCounter ++;
                return Action.HOP;
            } else {
                stepCounter++;
                return Action.LEFT;
            }
        }
        if (info.getDirection() == Direction.SOUTH) {
            if(info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getRight() == Neighbor.OTHER) {
                return Action.RIGHT;
            }
            else if (info.getFront() == Neighbor.EMPTY) {
                stepCounter ++;
                return Action.HOP;
            } else {
                stepCounter++;
                return Action.LEFT;
            }
        }
        if (info.getDirection() == Direction.WEST) {
            if(info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            }
            else if (info.getFront() != Neighbor.OTHER && info.getRight() == Neighbor.OTHER) {
                return Action.RIGHT;
            }
            else if (info.getFront() == Neighbor.EMPTY) {
                stepCounter ++;
                return Action.HOP;
            } else {
                stepCounter++;
                return Action.LEFT;
            }
        }
        else {
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
