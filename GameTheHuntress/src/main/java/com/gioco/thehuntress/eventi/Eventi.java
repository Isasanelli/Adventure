package com.gioco.thehuntress.eventi;

import java.io.*;
import java.util.Scanner;

public class Eventi {
    public static final String PATFILERULES="file//regole.txt";
    public static final String PATFILECOMMANDS="file//comandi.txt";

    public static void readRules() throws FileNotFoundException, IOException{
        readFile(PATFILERULES);
    }

    public static void readCommands() throws FileNotFoundException, IOException{
        readFile(PATFILECOMMANDS);
    }

    public static void readFile(String patString) throws FileNotFoundException, IOException{
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

    public static void readFileDialog(String pat) {
        try{
            File fileToRead= new File(pat);// creo un oggetto file
            Scanner dialog= new Scanner(fileToRead);//creo l'oggetto scanner 
            dialog.useDelimiter("#");
            String singleLine ;
        
           do{
              singleLine=dialog.next(); //legge le linee fino all'#
              System.out.println (singleLine);
              Scanner sc = new Scanner(System.in); 
              String input =sc.nextLine();// per l'invio
             }while(dialog.hasNext());   // finchè se c'è altro testo 
             dialog.close();
        
            }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");
       }
    }
}
    



