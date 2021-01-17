
import java.awt.*;
import java.util.Random;

public class Super extends Critter {

    private int stepCounter;
    private static final Action[] stepCycle = {Action.LEFT, Action.LEFT, Action.LEFT, Action.LEFT, Action.HOP};
    private static final Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW};
    private Color currentColor;

    public Super() {
        this.stepCounter = 0;
    }

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
            return Action.RIGHT;
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
            return "a";
        } else if (stepCounter % 3 == 1) {
            return "A";
        } else {
            return "@";
        }
    }

    // Gets a random element from an array
    public Object getRandomElement(Object[] arr) {
        Random r = new Random();
        int elementToGet = r.nextInt(arr.length);
        return arr[elementToGet];
    }
}
