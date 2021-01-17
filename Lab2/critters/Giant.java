//  Alyce H
//  Judd Morse
//  Schuyler

//  CS 145
//  Lab 2 Critters

// This defines a class of critters that hops whenever it can, and turns right whenever it cannot.
// It also infects any other creature it runs into. This leads into it
// running clockwise around the edges of the map.
// It alternates between "fee", "fie", "foe", and "fum".

import java.awt.*;

public class Giant extends Critter{

   private int steps;

   public Giant() {
      this.steps = 0;
   }

   public Color getColor() {
      return Color.GRAY;  
   }
   
   //Infects if creature is in front of it 
   //Hops, and turns right if it cannot hop.
   public Action getMove(CritterInfo info) {
      steps++;
      if (steps > 24) {
         steps = 1;
      }

      if (info.getFront().equals(Neighbor.OTHER)) {
         return Action.INFECT;
      } else if (info.getFront() == (Neighbor.EMPTY)) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
    
   // Alternates between "fee", "fie", "foe", and "fum".
   public String toString() {
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