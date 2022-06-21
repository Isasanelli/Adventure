package com.gioco.thehuntress.eventi;

import javax.swing.*;
import java.awt.*;

public class MapGraphic {
     JFrame frame;
     ImageIcon image,imageMap;
     JLabel myLabel;

    //creazione costruttore MapGrafic
    public MapGraphic(){

    }
    public void createMap(){
        imageMap = new ImageIcon("Immagini//Mappa.jpeg");
        myLabel = new JLabel(imageMap);
        myLabel.setSize(800,500);

        frame = new JFrame(); //creazione del frame
        frame.setTitle("Mappa The Huntress"); //titolo della mappa
        frame.add(myLabel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Elimina l'oggetto frame, ma mantiene l'applicazione in esecuzione.
        frame.setSize(800,600); //dimensione per altezza e lunghezza della finestra
        frame.setLocationRelativeTo(null); // permette di far comparire la finestra al centro
        frame.setResizable(false);
        frame.setVisible(true); //rendiamo visibile la mappa


        image = new ImageIcon("Immagini//Logo.png"); //inserimento logo del gioco
        frame.setIconImage(image.getImage());//permette di cambiare l'immagine
        frame.getContentPane().setBackground(new Color(0x123456)); //impostiamo un colore di sfondo
    }
}
