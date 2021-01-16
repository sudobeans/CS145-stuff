//  Alyce H
//  Judd Morse
//  Schuyler

//  CS 145
//  Lab 2 Critters


import java.awt.*;

public class Giant extends Critter{

   int steps = 0; 
   
   public Color getColor() {
      return Color.GRAY;  
   }
 
   
   //Infects if creature is in front of it 
   //Hops, and turns right if it cannot hop.
   public Action getMove(CritterInfo info) {
      if (info.getFront().equals(Neighbor.OTHER)) {
         return Action.INFECT;
      }else if (info.getFront() == (Neighbor.EMPTY)) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
    
   // Alternates between "fee", "fie", "foe", and "fum".
   public String toString() {
      steps++;
      if (steps > 24) {
         steps = 1;
      }
      if (steps <= 6){
         return "fee";
      } else if (steps >= 7 && steps <= 12){
         return "fie";
      } else if (steps >= 13 && steps <= 18){
         return "foe";
      } else { 
         return "fum";
      } 
   }
    
}