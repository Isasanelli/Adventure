package com.gioco.thehuntress.eventi;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manages the events of the game.
 */

public class Eventi {
    public static final String PATFILERULES="file//regole.txt";
    public static final String PATFILECOMMANDS="file//comandi.txt";

    /**
     * method that allows you to read the rules file.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readRules() throws FileNotFoundException, IOException{
        readFile(PATFILERULES);
    }

    /**
     * method that allows you to read the command file.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readCommands() throws FileNotFoundException, IOException{
        readFile(PATFILECOMMANDS);
    }

    /**
     * method that reads the file, whose pat is passed as a parameter.
     * @param patString pat file
     */

    public static void readFile(String patString){
        try{
            File fileToRead= new File (patString);
            BufferedReader buffer= new BufferedReader(new FileReader(fileToRead));
            String singleLine;
            do{
                singleLine=buffer.readLine();
                if (singleLine!=null){
                    System.out.println(singleLine);
                }
            }while (singleLine!= null);
            buffer.close();
        }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");
        }catch (IOException e ){
            System.err.println("ERRORE  DI I/0");
        }
    }

    /**
     * method that allows reading the dialog file whose pat is passed as a parameter.
     * @param pat pat file
     */
    public static void readFileDialog(String pat) {
        try{
            File fileToRead= new File(pat);
            Scanner dialog= new Scanner(fileToRead);
            dialog.useDelimiter("#");
            String singleLine ;
        
           do{
              singleLine=dialog.next();
              System.out.println (singleLine);
              Scanner sc = new Scanner(System.in); 
              String input =sc.nextLine();
             }while(dialog.hasNext());
             dialog.close();
        
            }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");
       }
    }
}
    



