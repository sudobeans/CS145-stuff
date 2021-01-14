//  Alyce H
//  Judd Morse
//  Schuyler

//  CS 145
//  Lab 2 Critters

import java.awt.*;

public class Bear extends Critter {

// Establishes starting fields.
    public boolean polar;
    public int move;

// Constructor boolean, allows user to set polar or black.
    public Bear(boolean polar) {
        this.polar = polar;
        this.move = 0;
    }

// Attacks if another animal/thing is in front,
// otherwise hops, otherwise turns left.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor () {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public String toString() {
        if (move % 2 == 0) {
            return "/";
        } else {
            return "\\";
        }
    }
}