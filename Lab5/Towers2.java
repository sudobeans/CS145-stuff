// Judd Morse
// Alyce Harlan
// Daniel Lewis
// Schuyler Duryee

// This code prints out how to solve the Tower of Hanoi puzzle step=by=step.

public class Towers2 {
    public static final int DISCS = 8;
    public static void main(String[] args) {
        tower(DISCS, "left", "right", "middle");
    }

    public static void tower(int numberOfDiscs, String startingPoint, String endingPoint, 
                             String floaterPoint) {

        if (numberOfDiscs == 1) { 
            //Base case; if there's only one disc to move,
            // it goes from startingPoint to endingPoint.
            System.out.println("Move disc 1 from rod " + startingPoint + " to rod " + endingPoint);
            return;
        }

        tower(numberOfDiscs - 1, startingPoint, floaterPoint, endingPoint);
        System.out.println("Move disc " + numberOfDiscs + " from rod " + 
                           startingPoint + " to rod " + endingPoint);
        tower(numberOfDiscs - 1, floaterPoint, endingPoint, startingPoint);
    }
}
