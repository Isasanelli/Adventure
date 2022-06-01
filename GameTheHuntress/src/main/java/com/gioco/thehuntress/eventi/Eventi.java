package com.gioco.thehuntress.eventi;

import java.io.*;

public class Eventi {
    public static final String patFileRules="file//regole.txt";
    public static final String patFileCommands="file//comandi.txt";

    public static void readRules() throws FileNotFoundException, IOException{
        readFile(patFileRules);
    }

    public static void readCommands() throws FileNotFoundException, IOException{
        readFile(patFileCommands);
    }

    public static void readFile(String stringaPat) throws FileNotFoundException, IOException{
        try{
            File fileDaLeggere= new File (stringaPat);
            BufferedReader regole= new BufferedReader(new FileReader(fileDaLeggere ));
            String lineaSingola;

            do{
                lineaSingola=regole.readLine();
                if (lineaSingola!=null){
                    System.out.println (lineaSingola);
                }
            }while ( lineaSingola != null);

        }catch (
                FileNotFoundException e ){
            System.err.println("il file non esiste");

        }catch (
                IOException e ){
            System.err.println("ERRORE  DI I/0");


        }
    }

}

