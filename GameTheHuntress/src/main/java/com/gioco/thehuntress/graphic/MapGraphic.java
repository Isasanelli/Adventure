package com.gioco.thehuntress.graphic;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 *class that allows the creation of the map swing.
 */
public class MapGraphic {
     JFrame frame;
     ImageIcon image,imageMap;
     JLabel myLabel;

    /**
     * map builder.
     */
    public MapGraphic(){

    }

    /**
     * method that creates the swing window and inserts the map image.
     */
    public void createMap(){
        imageMap = new ImageIcon("Immagini//Mappa.jpeg");
        myLabel = new JLabel(imageMap);
        myLabel.setSize(800,500);

        frame = new JFrame();
        frame.setTitle("Mappa The Huntress");
        frame.add(myLabel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        image = new ImageIcon("Immagini//Logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0x123456));
    }
}
