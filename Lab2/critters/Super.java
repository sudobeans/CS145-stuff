
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

    // See the header for the orca's AI description.
/*    public Action getMove(CritterInfo info) {
        // Infects other creatures
        if (info.getFront() == Neighbor.OTHER && info.getDirection() == Direction.NORTH) {
            if (info.getFrontDirection() != Direction.SOUTH) {
                return Action.INFECT;
            } else return Action.LEFT;
        } else if (info.getFront() == Neighbor.OTHER && info.getDirection() == Direction.EAST) {
            if (info.getFrontDirection() != Direction.WEST) {
                return Action.INFECT;
            }
            else return Action.LEFT;
        } else if (info.getFront() == Neighbor.OTHER && info.getDirection() == Direction.SOUTH) {
            if (info.getFrontDirection() != Direction.NORTH) {
                return Action.INFECT;
            }
            else return Action.LEFT;
        } else if (info.getFront() == Neighbor.OTHER && info.getDirection() == Direction.WEST) {
            if (info.getFrontDirection() != Direction.EAST) {
                return Action.INFECT;
            }
            else return Action.LEFT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            stepCounter++;
            return Action.HOP;
            // turns away left
        } else if (info.getRight() != Neighbor.EMPTY && info.getFront() != Neighbor.EMPTY) {
            return Action.LEFT;
            // Spins and right
        } else if (info.getLeft() != Neighbor.EMPTY && info.getFront() != Neighbor.EMPTY) {
            return Action.RIGHT;
        } else {
            stepCounter++;
            stepCounter %= stepCycle.length; // Makes its steps loop
            return stepCycle[stepCounter];
        }
    }
*/
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
