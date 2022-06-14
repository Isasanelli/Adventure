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
        }catch (
                FileNotFoundException e ){
            System.err.println("il file non esiste");
        }catch (
                IOException e ){
            System.err.println("ERRORE  DI I/0");
        }
    }

    public static void readFileDialog(String pat) throws FileNotFoundException, IOException{
        try{
            File fileToRead= new File(pat);
            BufferedReader dialog= new BufferedReader(new FileReader(fileToRead));
            String singleLine="";
            char specialcharacter='#';
            char character; //consente di leggere carattere per carattere
            do{
                singleLine="";
                do{
                    character=(char) dialog.read();
                    singleLine+=character;
                }while ((specialcharacter!=character) && (character!=-1));
                if ((specialcharacter==character) || (character==-1) ){
                    System.out.println (singleLine);
                }
                Scanner sc = new Scanner(System.in);
                String input =sc.nextLine();
            }while(character != -1);
        }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");
        }catch (IOException e ){
            System.err.println("ERRORE  DI I/0");
        }
    }

}

