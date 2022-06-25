package com.gioco.thehuntress.battle;

import com.gioco.thehuntress.graphic.Grafica;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manages battle user-opponent
 */
public class MiniGameBattle {

    private User user;
    private Opponent opponent;
    private int userScore=20;
    private int opponentScore=20;

    /**
     * MiniGameBattle builder
     */
    public MiniGameBattle(){
        user=new User();
        opponent=new Opponent();
    }

    /**
     *method that initiates and manages the fight
     * @return win
     */
    public boolean startGame(){
        boolean win=false;
        Grafica.graphicBattle();
        while(userScore>=10 && opponentScore>=10) {
            Move userMove = user.getMove();
            Move opponentMove = opponent.getMove();
            System.out.println("\nHai usato  " + userMove + ".\n");
            System.out.println("Vanasha ha usato " + opponentMove + ".\n");
            int compareMoves = userMove.compareMoves(opponentMove);
            switch (compareMoves) {
                case 0: //pareggio
                    System.out.println("Siete allo stesso livello. Fai del tuo meglio.");
                    break;
                case 1: //vince l'utente
                    System.out.println(userMove + " e' piu' forte di " + opponentMove + ". Continua cosi'!");
                    opponentScore = opponentScore - 10;
                    break;
                case -1: //vince il nemico
                    System.out.println(opponentMove + " e' più forte di " + userMove + ". Non mollare!");
                    userScore = userScore - 10;
                    break;
            }
        }
        if(userScore<10 && opponentScore>=10){
            System.out.println("+----------------------------------------------------+");
            System.out.println("|Ad un certo punto perdi 'equilibrio e cadi a terra. |");
            System.out.println("| Vanasha ti punta un coltello alla gola.            |");
            System.out.println("|Il panico ti pervade...                             |");
            System.out.println("+----------------------------------------------------+");
            win=false;
        }else if(userScore>10 && opponentScore<=10){
            win=true;
        }
        return win;
    }
}