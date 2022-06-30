package com.gioco.thehuntress.minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manager the tris game in swing.
 */
public class TicTacGame implements ActionListener{

    Random random;
    JFrame frame;
    JPanel titlePanel;
    JPanel board;
    JLabel textField;
    JButton[] buttons;
    ImageIcon image;
    boolean firstTurn;
    boolean isEnd = false;
    char[][] grid;

    /**
    * this constructor allows to
    * initialize the JFrame on which the game will be shown
    */
    public TicTacGame() {

        grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = '-';
        random = new Random();
        frame = new JFrame("THE HUNTRESS ENIGMA");
        image = new ImageIcon("Immagini//Logo.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        titlePanel = new JPanel();
        board = new JPanel();
        textField = new JLabel();
        buttons = new JButton[9];
        frame.setSize(1500,1020);
        frame.setResizable(false);
        frame.setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        titlePanel.setLayout(new BorderLayout());
        textField.setBackground(Color.BLACK);
        textField.setForeground(new Color(255, 255, 255));
        textField.setFont(new Font("MV Boli", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        titlePanel.setBackground(Color.black);
        titlePanel.setBounds(0, 0, 700, 100);
        board.setLayout(new GridLayout(3, 3));
        board.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            board.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(board);
        frame.setVisible(true);
        firstTurn();
    }

     /**
     * method that calls game turn and handles all the actions of a component
     * @param e actions of  X or O
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().equalsIgnoreCase("")) {
                buttons[i].setForeground(new Color((firstTurn ? 255 : 0), 0, (firstTurn ? 0 : 255)));
                buttons[i].setText(firstTurn ? "X" : "O");
                grid[i / 3][i % 3] = (firstTurn ? 'X' : 'O');
                firstTurn = !firstTurn;
                textField.setText("Your turn");
                check();
            }
        }
        if (!firstTurn)
            computerPlay();
    }

/**
*  method that manages the system shift
*/
    public void computerPlay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (!firstTurn && !isEnd) {
            int idx;

            idx = random.nextInt(8);
            while (!buttons[idx].getText().equalsIgnoreCase("")) {
                idx = random.nextInt(8);

            }
            if (buttons[idx].getText().equalsIgnoreCase("")) {
                buttons[idx].setForeground(new Color((firstTurn ? 255 : 0), 0, (firstTurn ? 0 : 255)));
                buttons[idx].setText(firstTurn ? "X" : "O");
                grid[idx / 3][idx % 3] = (firstTurn ? 'X' : 'O');
                firstTurn = !firstTurn;
                textField.setText("Tuo turno");
                 check();
            }
        }
    }

    /**
    * function that calls the winning cells.
    *@param c string that can take "X" or "O"
    *@return cells
    */
    public int[] winCells(String c) {
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

    /**
     * isTie recalls the draw of the match
     * @return true if there is a tie
     */
    public boolean isTie() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equalsIgnoreCase(""))
                return false;
        }
        return true;
    }


    public void endWithTie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("PAREGGIO");
    }

    public void check() {
        if (isWin("X")) {
            int[] cells = winCells("X");
            win(cells[0], cells[1], cells[2], "Tu");
            isEnd = true;
            new BoxTextMingame();
        } else if (isWin("O")) {
            int[] cells = winCells("O");
            win(cells[0], cells[1], cells[2], "Lord");
            isEnd = false;
            new RestartMiniGame();
        } else if (isTie()) {
            endWithTie();
            isEnd = true;
            new RestartMiniGame();
        }
    }
    /**
    *  method  that retrieves the users state
    * @param a value of t
    * @param b
    * @param c
    * @param w
    */
    public void win(int a, int b, int c, String w) {
        buttons[a].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        buttons[b].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        buttons[c].setBackground((w.equalsIgnoreCase("Lord") ? Color.RED : Color.GREEN));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        if (w.equalsIgnoreCase("Lord")) {
            textField.setForeground(Color.RED);
            textField.setText("HAI PERSO");
        } else {
            textField.setForeground(Color.GREEN);
            textField.setText("HAI VINTO");
        }
    }

    public boolean isWin(String c) {
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

/**
*
*method that calls the users
*
*/
    public void firstTurn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textField.setText("Tuo Turno");
        if (random.nextInt(2) == 0) {
            firstTurn = true;
        } else {
            firstTurn = false;
            computerPlay();


        }
    }
}
