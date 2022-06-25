package com.gioco.thehuntress.battle;

import java.util.Random;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */


/**
 * class that manages the opponent's moves
 */
public class Opponent {

    /**
     * method that randomly generates the opponent's move
     * @return Move
     */
    public Move getMove(){
        Move[] moves = Move.values();
        Random random = new Random();
        int index=random.nextInt(moves.length);
        return moves[index];
    }
}
