/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gioco.thehuntress.adventure;


/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Grafica {
    
    public Grafica() {}

    public void writeMenu() {
        System.out.println("  \n"

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
        System.out.println("Scrivi un opzione:   \n");

    }

    public void writeIntro() {

        System.out.println("*****************************************************************************");
        System.out.println("Pianeta terra del XXXI secolo d.C \n"

                + "In un lussureggiante e vibrante mondo post-apocalittico, gruppi di umani vivono \n"
                + "all'interno di tribu' primitive di cacciatori.\n "
                + "Il loro dominio sulla natura e' stato usurpato dalle Macchine,\n"
                +"temibili creature meccaniche dall'origine ignota.\n"
                + "che sono guidate dal temibile soldato di nome Vanasha \n"
                + "All'interno delle tribu, Victoria, una giovane ragazza dal carattere ribllere, \n"
                + "avra' il compito di liberare l'intera umanità dal dominio delle macchine \n"
                + "Lei e' : LA CACCIATRICE \n"
        );
        System.out.println("*****************************************************************************");
    }

}