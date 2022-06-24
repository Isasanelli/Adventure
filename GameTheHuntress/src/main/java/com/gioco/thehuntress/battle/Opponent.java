package com.gioco.thehuntress.battle;

import java.util.Random;

public class Opponent {
    public Opponent(){

    }

    public Move getMove(){
        Move[] moves = Move.values();
        Random random = new Random();
        int index=random.nextInt(moves.length);
        return moves[index];
    }
}
