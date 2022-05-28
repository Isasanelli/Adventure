
package com.gioco.thehuntress.adventure;

import com.gioco.thehuntress.minigame.TicTacGame;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import com.gioco.thehuntress.eventi.Eventi;
import java.sql.*;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Engine {



    public  void avvio() throws IOException {

        Scanner io = new Scanner(System.in);
        Grafica menu = new Grafica();
        menu.writeMenu();

        String input ;

        do {
             input = io.nextLine();
            input=input.toLowerCase();

            switch (input) {
                case "nuova partita":
                    menu.writeIntro();
                    break;
                case "regole del gioco":
                    Eventi.leggiRegole();
                    break;
                case "comandi":
                    Eventi.leggiComandi();
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
       new TicTacGame().computer_play();

        //crezione della conessione del drive di un DB
        try{
            Properties prop = new Properties();
            prop.setProperty("user", "Huntress");
            prop.setProperty("password", "1234");
            Connection con = DriverManager.getConnection("jdbc:h2:./resources/db/playgame");

        }catch (SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());

        }
        //new Engine().avvio();

    }

    }
