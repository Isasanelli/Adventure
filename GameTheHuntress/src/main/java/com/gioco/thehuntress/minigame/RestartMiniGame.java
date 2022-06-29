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
public class RestartMiniGame extends JFrame implements ActionListener {

    JFrame frame;
    JButton ok;
    JLabel text_field;
    ImageIcon image;


    public RestartMiniGame(){
        ok = new JButton("OK");
        text_field = new JLabel("RIPROVA");
        frame = new JFrame("The Huntress Enigma");
        image = new ImageIcon("Immagini//Logo.png");
         frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(390, 200);
        frame.setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        ok.setBounds(140, 100, 100, 30);
        text_field.setBounds(135, 20, 300, 50);
        ok.addActionListener(this);
        ok.setForeground(new Color(0, 0, 255));
        text_field.setForeground(Color.BLUE);

        text_field.setFont(new Font("MV Boli", Font.BOLD, 17));
        ok.setFont(new Font("MV Boli", Font.BOLD, 13));
        frame.add(ok);
        frame.add(text_field);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window[] win = Window.getWindows();
        for (Window window : win) {
            window.dispose();
        }
        if(e.getSource() == ok){
            new TicTacGame();
        }else {
           System.exit(0);
        }
    }
}
