
package com.gioco.thehuntress.adventure;

import com.gioco.thehuntress.eventi.DbClass;
import com.gioco.thehuntress.eventi.Eventi;

import java.io.IOException;
import java.util.Scanner;
import com.gioco.thehuntress.type.Room;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Engine {

    public DbClass db = new DbClass(); //ricordare di chiudere la connessione col db con il metodo close() di Connection;
<<<<<<< HEAD
=======
public static final String PATH="file//roomGarden.txt";
>>>>>>> 5ff7329d6078d61b5c58f21db8b9273621836547
    public Engine(){

    }
    public  void start() throws IOException {

        Scanner io = new Scanner(System.in);
        Grafica graphic = new Grafica();
        graphic.writeMenu();
        String input ;
        

        do {
                input = io.nextLine();
                input=input.toLowerCase();

                switch (input) {
                    case "nuova partita":
                      graphic.writeIntro();
                        break;
                    case "regole del gioco":
                        Eventi.readRules();
                        break;
                     case "comandi":
                        Eventi.readCommands();
                        break;
                    case "esci":
                        break;
                    default: System.out.println("Scelta non valida. Riprova");
                        break;
                }//end of game
        } while (!input.equals("esci"));

        System.out.println("Il gioco e' bello quando dura poco."
                + " PACE E AMORE "
                + " Un saluto da :"
                + " Chiara Margari, "
                + " Ricciardi Raffaella e"
                + " Sasanelli Ilenia");
        }

    public static void main(String[] args) throws IOException {
        new Engine().start();
        //new TicTacGame().computer_play();
        //new MapGraphic();


    }
}
