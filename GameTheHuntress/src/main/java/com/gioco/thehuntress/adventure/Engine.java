package com.gioco.thehuntress.adventure;

import com.gioco.thehuntress.eventi.DbClass;
import com.gioco.thehuntress.eventi.Eventi;
import com.gioco.thehuntress.games.TheHuntressGame;
import com.gioco.thehuntress.parser.Parser;
import com.gioco.thehuntress.parser.ParserOutput;
import com.gioco.thehuntress.type.CommandType;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Engine {

    public DbClass db = new DbClass(); //ricordare di chiudere la connessione col db con il metodo close() di Connection;
    public static final String PATHSTOPWORDS="file//stopwords";

    private final GameDescription game;
    private Parser parser;

    private static Engine engine;

    public Engine(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File(PATHSTOPWORDS));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
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
                      execute(graphic);
                        break;
                    case "regole del gioco":
                        Eventi.readRules();
                        break;
                     case "comandi":
                        Eventi.readCommands();
                        break;
                    case "esci partita":
                        break;
                    default: System.out.println("Scelta non valida. Riprova");
                        break;
                }//end of game
        } while (!input.equals("esci partita"));

        System.out.println("""
                Il gioco e' bello quando dura poco.
                 PACE E AMORE\s
                 Un saluto da : Chiara Margari,  Ricciardi Raffaella e Sasanelli Ilenia""");
        System.exit(0);
        }

        public void execute(Grafica graphic){
            graphic.writeIntro();
            System.out.println("======================================================================");
            System.out.println("                          "+ game.getCurrentRoom().getName(db));
            System.out.println("======================================================================");
            System.out.println();
            System.out.println(game.getCurrentRoom().getDescription(db));
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory(), db);

           if (p.getCommand() == null ) {
                    System.out.println("Non capisco quello che mi vuoi dire.");

            }else if (p.getCommand() != null && p.getCommand().getType() == CommandType.ESCI) {
                    System.out.println("Fine partita");

                    //ritorno del menù principale una volta che l'utente esce dalla partita
                    try {
                        engine.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    game.nextMove(db,p, System.out);
                    System.out.println();
                }
            }
        }

    public static void main(String[] args) throws IOException {
        engine= new Engine(new TheHuntressGame());
        engine.start();
        //new TicTacGame().computer_play();
        //new MapGraphic();


    }
}
