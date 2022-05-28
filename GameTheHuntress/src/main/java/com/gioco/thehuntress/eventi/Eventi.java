package com.gioco.thehuntress.eventi;

import java.io.*;

public class Eventi {
    public static void leggiRegole()throws FileNotFoundException, IOException{

    try{
        File fileDaLeggere= new File("file//regole.txt");
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

    public static void leggiComandi()throws FileNotFoundException, IOException{

        try{
            File fileDaLeggere= new File ("file//comandi.txt");
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

