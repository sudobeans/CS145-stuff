// This defines a class of critters that move back and forth between two walls.
// Whenever they bump into a creature, they infect it.

import java.awt.*;

public class Giant extends Critter{

   int steps = 0; 
   
   public Color getColor() {
      return Color.GRAY;  
   }
 
   

   public Action getMove(CritterInfo info) {
      if (info.getFront().equals(Neighbor.OTHER)) {
         steps++;
         return Action.INFECT;
      }else if (info.getFront() == (Neighbor.EMPTY)) {
         steps++;
         return Action.HOP;
      } else {
         steps++;
         return Action.RIGHT;
      }
   }
    
   public String toString() {
      if (steps <= 6){
         return "fee";
      }else if (steps >= 7 && steps <= 12){
         return "fie";
      }else if (steps <= 13 && steps <= 18){
         return "foe";
      }else {
         return "fum";
      } 
   }
    
}