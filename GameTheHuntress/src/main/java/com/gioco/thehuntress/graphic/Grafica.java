
package com.gioco.thehuntress.graphic;


/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that contains the graphics of the game.
 */
public class Grafica {

    /**
     * builder Grafica.
     */
    public Grafica() {}

    /**
     * method that prints the initial menu.
     */
    public static void writeMenu() {
        System.out.println(" \n"

                + " +--------------------------------------+ \n"
                + " |                                      | \n"
                + " |           BENVENUTI IN:              | \n"
                + " |           THE HUNTRESS               | \n"
                + " |                                      | \n"
                + " +--------------------------------------+ \n"
                + " |    Nuova Partita                     | \n"
                + " +--------------------------------------+ \n"
                + " |    Regole del Gioco                  | \n"
                + " +--------------------------------------+ \n"
                + " |    Comandi                           | \n"
                + " +--------------------------------------+ \n"
                + " |    Esci Partita                      | \n"
                + " +--------------------------------------+ \n"
        );


    }

    /**
     * method that prints the introduction of the game.
     */

    public static void writeIntro() {
        System.out.println(   "\n  Pianeta terra del XXXI secolo d.C  "
                             +"\n  In un  mondo post-apocalittico, gruppi di umani vivono all'interno di tribu'. "
                             +"\n  Il loro dominio sulla natura e' stato usurpato dalle Macchine, "
                             +"\n  temibili creature dall'origine ignota. "
                             +"\n  guidate dal temibile soldato di nome Vanasha "
                             +"\n  Victoria, una giovane ragazza dal carattere ribelle, "
                             +"\n  avra' il compito di liberare l'intera umanita' dal dominio delle macchine "
                             +"\n  Lei e' : LA CACCIATRICE " );

    }

    /**
     * method that prints the program termination message.
     */
    public static void end(){
        System.out.println(" \n"

                + " +-----------------------------------------+ \n"
                + " |   Il gioco e' bello quando dura poco.   | \n"
                + " |   PACE E AMORE                          | \n"
                + " |   Un saluto da:                         | \n"
                + " |                 Margari Chiara          | \n"
                + " |                 Ricciardi Raffaella     | \n"
                + " |                 Sasanelli Ilenia        | \n"
                + " +-----------------------------------------+ \n"
        );
    }

    /**
     * method that prints the battle command menu.
     */
    public static void graphicBattle(){


        System.out.println("***          Battle The Huntress            *** \n");
        System.out.println("    [ ATTACCA ]  -  [ SCHIVA ]  -  [ PARA ]     \n");
    }
}