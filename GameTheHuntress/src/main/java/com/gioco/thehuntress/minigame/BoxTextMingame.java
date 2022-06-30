package com.gioco.thehuntress.minigame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
* text frame setting
*
*/
public class BoxTextMingame extends JFrame implements ActionListener {

    JFrame frame;
    JButton prosegui;
    JLabel text_field;
    ImageIcon image;


    /**
    *
    *this constructor initializes the text frame belonging to the tic tac minigames.
    *
    */
   public BoxTextMingame(){
        prosegui = new JButton("Prosegui");
        text_field = new JLabel("LA PORTA E' APERTA");
        frame = new JFrame("THE HUNTRESS ENIGMA");
        image = new ImageIcon("Immagini//Logo.png");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 180);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        prosegui.setBounds(140, 100, 100, 30);
        text_field.setBounds(80, 20, 300, 50);
        prosegui.addActionListener(this);
        prosegui.setForeground(new Color(12, 143, 49));
        text_field.setForeground(Color.BLACK);
        text_field.setFont(new Font("MV Boli", Font.BOLD, 20));
        prosegui.setFont(new Font("MV Boli", Font.BOLD, 13));
        frame.add(prosegui);
        frame.add(text_field);
        frame.setVisible(true);
    }
    /**
    * this method returns the message to the user to continue with the Aventure.
    * Inside we find the closure of the text box and the minigame window.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        Window[] win = Window.getWindows();
        for (Window window : win) {
            window.dispose();
        }
        if(e.getSource() == prosegui){
            frame.dispose();
        }else {
            System.exit(0);
        }
    }

}