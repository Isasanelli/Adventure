package com.gioco.thehuntress.minigame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxTextMingame extends JFrame implements ActionListener {

    JFrame frame;
    JButton prosegui;
    JLabel text_field;
    ImageIcon image;

    public BoxTextMingame(){
        prosegui = new JButton("Prosegui");
        text_field = new JLabel("LA PORTA E' APERTA");
        frame = new JFrame("THE HUNTRESS ENIGMA");
        image = new ImageIcon("Immagini//Logo.png");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 180);
        frame.setResizable(false);
        frame.setBackground(new Color(32, 20, 50));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        prosegui.setBounds(130, 100, 100, 30);
        text_field.setBounds(115, 20, 300, 50);
        prosegui.addActionListener(this);
        prosegui.setForeground(new Color(22, 2, 66));
        text_field.setForeground(Color.BLUE);
        text_field.setFont(new Font("MV Boli", Font.BOLD, 20));
        prosegui.setFont(new Font("MV Boli", Font.BOLD, 13));
        frame.add(prosegui);
        frame.add(text_field);
        frame.setVisible(true);
    }

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