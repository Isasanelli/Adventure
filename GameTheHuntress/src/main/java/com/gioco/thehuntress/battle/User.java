package com.gioco.thehuntress.battle;

import java.util.Scanner;

public class User {
    private Scanner inputScanner;

    public User(){
        inputScanner=new Scanner(System.in);
    }

    public Move getMove(){
        // Leggiamo l'input inserito dall'utente
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
