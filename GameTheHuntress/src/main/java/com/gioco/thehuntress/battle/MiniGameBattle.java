package com.gioco.thehuntress.battle;

import com.gioco.thehuntress.graphic.Grafica;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manages battle user-opponent.
 */
public class MiniGameBattle {

    private User user;
    private Opponent opponent;
    private int userScore=20;
    private int opponentScore=20;

    /**
     * MiniGameBattle builder.
     */
    public MiniGameBattle(){
        user=new User();
        opponent=new Opponent();
    }

    /**
     *function that initiates and manages the fight.
     * @return win which has a false value if the user loses and a true value if he wins
     */
    public boolean startGame(){
        boolean win=false;
        Grafica.graphicBattle();
        while(userScore>=10 && opponentScore>=10) {
            Move opponentMove = opponent.getMove();
            System.out.println("Vanasha ha usato " + opponentMove + ".\n");
            Move userMove = user.getMove();
            System.out.println("\nHai usato  " + userMove + ".\n");
            int compareMoves = userMove.compareMoves(opponentMove);
            switch (compareMoves) {
                case 0: 
                    System.out.println("Fai del tuo meglio.");
                    break;
                case 1: 
                    System.out.println(userMove + " e' piu' forte di " + opponentMove + "\n");
                    opponentScore = opponentScore - 10;
                    System.out.println("Hai vinto !!");
                    break;
                case -1: 
                    System.out.println(opponentMove + " e' piu' forte di " + userMove + "\n");
                    userScore = userScore - 10;
                    System.out.println("Hai perso !!");
                    break;
            }
        }
        if(userScore == 0 && opponentScore>=10){
            System.out.println("+----------------------------------------------------+");
            System.out.println("|Ad un certo punto perdi 'equilibrio e cadi a terra. |");
            System.out.println("| Vanasha ti punta un coltello alla gola.            |");
            System.out.println("|Il panico ti pervade...                             |");
            System.out.println("+----------------------------------------------------+");
             win=false;
        }else if(userScore>=10 && opponentScore == 0){
            win=true;
        }
        return win;
    }
}
