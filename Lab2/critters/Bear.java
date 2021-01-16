//  Alyce H
//  Judd Morse
//  Schuyler

//  CS 145
//  Lab 2 Critters

import java.awt.*;

public class Bear extends Critter {

// Establishes starting fields.
    private boolean polar;
    private int step;

// Constructor boolean, allows user to set polar or black.
    public Bear(boolean polar) {
        this.polar = polar;
        this.step = 0;
    }

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
    }
   
   //determines color based on bear species
    public Color getColor () {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }
   //defines character that will appear in UI
    public String toString() {
        if (step % 2 == 0) {
            return "/";
        } else {
            return "\\";
        }
    }
}