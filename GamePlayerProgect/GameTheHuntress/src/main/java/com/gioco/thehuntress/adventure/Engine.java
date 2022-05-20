/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gioco.thehuntress.adventure;




/**
 *
 *  @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Engine {


   public void avvio() {

        System.out.println("Pianeta terra del XXXI secolo d.C \n"

                + "In un lussureggiante e vibrante mondo post-apocalittico, gruppi di umani vivono \n"
                + "all'interno di tribù primitive di cacciatori. "
                + "Il loro dominio sulla natura è stato usurpato dalle Macchine, temibili creature meccaniche dall'origine ignota.\n"
                + "che sono guidate dal temibile soldato di nome Vanasha \n"
                + "All'interno delle tribu, Victoria, una giovane ragazza dal carattere ribllere, \n"
                + "avrà il compito di liberare l'intera umanità dal dominio delle macchine \n"
                + "Lei è : LA CACCIATRICE \n"
        );

    }


public static void main(String[] args) {



    Grafica menu = new Grafica();
    menu.writeMenu();

    Engine engine = new Engine();
    engine.avvio();


    }
}

