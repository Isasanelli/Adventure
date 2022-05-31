package com.gioco.thehuntress.eventi;

import java.io.*;

public class Eventi {
    public static final String patFileRegole="file//regole.txt";
    public static final String patFileComandi="file//comandi.txt";

    public static void leggiRegole() throws FileNotFoundException, IOException{
        leggiFile(patFileRegole);
    }

    public static void leggiComandi() throws FileNotFoundException, IOException{
        leggiFile(patFileComandi);
    }

    public static void leggiFile(String stringaPat) throws FileNotFoundException, IOException{
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

