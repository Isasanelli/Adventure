package com.gioco.thehuntress.minigame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.gioco.thehuntress.eventi.RestartMiniGame;


public class TicTacGame implements ActionListener {

    Random random;
    JFrame frame;
    JPanel title_panel;
    JPanel board;
    JLabel text_field;
    JButton[] buttons;
    ImageIcon image;
    boolean first_turn;
    boolean is_end;
    char[][] grid;

    public TicTacGame() {

        grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = '-';
        random = new Random();
        frame = new JFrame("THE HUNTRESS ENIGMA");
        image = new ImageIcon("Immagini//Logo.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title_panel = new JPanel();
        board = new JPanel();
        text_field = new JLabel();
        buttons = new JButton[9];
        frame.setSize(800, 800);
        frame.setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        title_panel.setLayout(new BorderLayout());
        text_field.setBackground(Color.BLACK);
        text_field.setForeground(new Color(255, 255, 255));
        text_field.setFont(new Font("MV Boli", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);
        title_panel.setBackground(Color.black);
        title_panel.setBounds(0, 0, 700, 100);
        board.setLayout(new GridLayout(3, 3));
        board.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            board.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(board);
        frame.setVisible(true);
        is_end = false;
        First_turn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().equalsIgnoreCase("")) {
                buttons[i].setForeground(new Color((first_turn ? 255 : 0), 0, (first_turn ? 0 : 255)));
                buttons[i].setText(first_turn ? "X" : "O");
                grid[i / 3][i % 3] = (first_turn ? 'X' : 'O');
                first_turn = !first_turn;
                text_field.setText("Your turn");
                check();
            }
        }
        if (!first_turn)
            computer_play();
    }

    public void computer_play() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (!first_turn && !is_end) {
            int idx;

            idx = random.nextInt(8);
            while (!buttons[idx].getText().equalsIgnoreCase("")) {
                idx = random.nextInt(8);

            }
            if (buttons[idx].getText().equalsIgnoreCase("")) {
                buttons[idx].setForeground(new Color((first_turn ? 255 : 0), 0, (first_turn ? 0 : 255)));
                buttons[idx].setText(first_turn ? "X" : "O");
                grid[idx / 3][idx % 3] = (first_turn ? 'X' : 'O');
                first_turn = !first_turn;
                text_field.setText("Tuo turno");
                check();
            }
        }
    }

    public int[] win_cells(String c) {
        int[] cells = new int[3];
        if (buttons[0].getText().equalsIgnoreCase(c) && buttons[1].getText().equalsIgnoreCase(c) && buttons[2].getText().equalsIgnoreCase(c)) {
            cells[0] = 0;
            cells[1] = 1;
            cells[2] = 2;
        } else if (buttons[3].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[5].getText().equalsIgnoreCase(c)) {
            cells[0] = 3;
            cells[1] = 4;
            cells[2] = 5;
        } else if (buttons[6].getText().equalsIgnoreCase(c) && buttons[7].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) {
            cells[0] = 6;
            cells[1] = 7;
            cells[2] = 8;
        } else if (buttons[0].getText().equalsIgnoreCase(c) && buttons[3].getText().equalsIgnoreCase(c) && buttons[6].getText().equalsIgnoreCase(c)) {
            cells[0] = 0;
            cells[1] = 3;
            cells[2] = 6;
        } else if (buttons[1].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[7].getText().equalsIgnoreCase(c)) {
            cells[0] = 1;
            cells[1] = 4;
            cells[2] = 7;
        } else if (buttons[2].getText().equalsIgnoreCase(c) && buttons[5].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) {
            cells[0] = 2;
            cells[1] = 5;
            cells[2] = 8;
        } else if (buttons[0].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) {
            cells[0] = 0;
            cells[1] = 4;
            cells[2] = 8;
        } else if (buttons[2].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[6].getText().equalsIgnoreCase(c)) {
            cells[0] = 2;
            cells[1] = 4;
            cells[2] = 6;
        } else {
            cells[0] = -1;
            cells[1] = -1;
            cells[2] = -1;
        }
        return cells;
    }

    public boolean is_tie() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equalsIgnoreCase("")) return false;
        }
        return true;
    }

    public void end_with_tie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("PAREGGIO");
    }

    public void check() {
        if (is_win("X")) {
            int[] cells = win_cells("X");
            win(cells[0], cells[1], cells[2], "Tu");
            is_end = true;
            //DA MODIFICARE QUANDO SI ARRIVA AL CAP 4
           //System.exit(0);
        } else if (is_win("O")) {
            int[] cells = win_cells("O");
            win(cells[0], cells[1], cells[2], "Lord");
            is_end = true;
            new RestartMiniGame();

        } else if (is_tie()) {
            end_with_tie();
            is_end = true;
            new RestartMiniGame();

        }
    }

    public void win(int a, int b, int c, String w) {
        buttons[a].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        buttons[b].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        buttons[c].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        if (w.equalsIgnoreCase("Lord")) {
            text_field.setForeground(Color.RED);
            text_field.setText("HAI PERSO");
        } else {
            text_field.setForeground(Color.GREEN);
            text_field.setText("HAI VINTO");
        }
    }

    public boolean is_win(String c) {
        if (buttons[0].getText().equalsIgnoreCase(c) && buttons[1].getText().equalsIgnoreCase(c) && buttons[2].getText().equalsIgnoreCase(c)) return true;
        if (buttons[3].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[5].getText().equalsIgnoreCase(c)) return true;
        if (buttons[6].getText().equalsIgnoreCase(c) && buttons[7].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) return true;
        if (buttons[0].getText().equalsIgnoreCase(c) && buttons[3].getText().equalsIgnoreCase(c) && buttons[6].getText().equalsIgnoreCase(c)) return true;
        if (buttons[1].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[7].getText().equalsIgnoreCase(c)) return true;
        if (buttons[2].getText().equalsIgnoreCase(c) && buttons[5].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) return true;
        if (buttons[0].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[8].getText().equalsIgnoreCase(c)) return true;
        if (buttons[2].getText().equalsIgnoreCase(c) && buttons[4].getText().equalsIgnoreCase(c) && buttons[6].getText().equalsIgnoreCase(c)) return true;
        return false;
    }

    public void First_turn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        text_field.setText("Tuo Turno");
        if (random.nextInt(2) == 0) {
            first_turn = true;
        } else {
            first_turn = false;
            computer_play();
        }
    }
}
