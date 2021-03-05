public class Towers2 {
    

    
    public static void main(String[] args) {

        tower(8, "left", "right", "middle");

    }

    public static void tower(int numberOfDiscs, String startingPoint, String endingPoint, String floaterPoint) {
        
        if (numberOfDiscs == 1) { //Base case; if there's only one disc to move, it goes from startingPoint to endingPoint.
            System.out.println("Move disc 1 from rod " + startingPoint + " to rod " + endingPoint);
            return;
        }

        tower(numberOfDiscs - 1, startingPoint, floaterPoint, endingPoint);
        System.out.println("Move disc " + numberOfDiscs + " from rod " + startingPoint + " to rod " + endingPoint);
        tower(numberOfDiscs - 1, floaterPoint, endingPoint, startingPoint);

    }

}
