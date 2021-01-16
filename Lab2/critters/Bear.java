//  Alyce Harlan
//  Judd Morse
//  Schuyler Duryee

//  CS 145
//  Lab 2 Critters

// This is the Bear class, to be used within CritterMain.java.
// The class uses a Bear boolean constructor to determine species.
// Bear attacks enemies in front, else hops, else turns left.
// Color (black or white) is determined by species.
// Appearance alternates between "/" and "\" on each step.

import java.awt.*;

public class Bear extends Critter {

    // Establishes starting fields.
    private boolean polar;
    private int step;

    // Constructor boolean, allows user to set polar or black.
    public Bear(boolean polar) {
        this.polar = polar;
        this.step = 0;
    } // end Bear constructor

    // Attacks if another animal/thing is in front,
    // otherwise hops, otherwise turns left.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            step ++;
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    } // end getMove
   
   //Determines color based on bear species.
    public Color getColor () {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    } // end getColor

   //Defines character that will appear in UI.
    public String toString() {
        if (step % 2 == 0) {
            return "/";
        } else {
            return "\\";
        }
    } // end toString

} // end Bear class
