package com.gioco.thehuntress.battle;

import java.util.Scanner;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manages user's move
 */
public class User {
    private Scanner inputScanner;

    /**
     *method that reads the user's input and returns its type
     * @return Move or getMove()
     */
    public Move getMove(){
        inputScanner=new Scanner(System.in);
        System.out.println("Cosa vuoi fare?");
        String userInput= inputScanner.nextLine().toLowerCase();
        if(!userInput.equalsIgnoreCase("")){
            if(!userInput.equals("schiva") && !userInput.equals("attacca") && !userInput.equals("para")) {
                System.out.println("Mossa errata, riprova");
            }else {
                switch (userInput) {
                    case "schiva":
                        return Move.SCHIVA;
                    case "attacca":
                        return Move.ATTACCA;
                    case "para":
                        return Move.PARA;
                }
            }
        }else
            System.out.println("Mossa errata, riprova");
        return getMove();
    }

}
