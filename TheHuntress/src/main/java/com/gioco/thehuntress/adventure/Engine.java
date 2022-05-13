package com.gioco.thehuntress.adventure;
 //import com.gioco.thehuntress.games.TheHuntress;

//import java.util.Scanner;

/**
 * L'Engine contiene il main e il metodo run che serve a gestire il caricamento dell'entità del gioco
 * 
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class Engine {
    
    public void avvio(){
        System.out.println("Pianeta terra del XXXI secolo d.C \n"
                           
                +"In un lussureggiante e vibrante mondo post-apocalittico, gruppi di umani vivono \n"
                +"all'interno di tribù primitive di cacciatori. "
                +"Il loro dominio sulla natura è stato usurpato dalle Macchine, temibili creature meccaniche dall'origine ignota.\n"
                +"che sono guidate dal temibile soldato di nome Vanasha \n"
                +"All'interno delle tribu, Victoria, una giovane ragazza dal carattere ribllere \n,"
                +" avrà il compito di liberare l'intera umanità dal dominio delle macchine \n"
                +"Lei è : LA CACCIATRICE \n"
       );
        
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       /* Engine e = new Engine(new TheHuntress());
        e.avvio();
        */
     
       Grafica menu = new Grafica();
       menu.writeMenu();
    }
}
