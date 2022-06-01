package com.gioco.thehuntress.eventi;

import java.io.*;
import java.util.Scanner;


public class Eventi {
    public static final String PATFILEREGOLE="file//regole.txt";
    public static final String PATFILECOMANDI="file//comandi.txt";

    

    public static void leggiRegole() throws FileNotFoundException, IOException{
        leggiFile(PATFILEREGOLE);
    }

    public static void leggiComandi() throws FileNotFoundException, IOException{
        leggiFile(PATFILECOMANDI);
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

    public static void readFileDialog(String pat) throws FileNotFoundException, IOException{
        try{
            File fileDaLeggere= new File(pat);
            BufferedReader dialoghi= new BufferedReader(new FileReader(fileDaLeggere ));
            String lineaSingola="";
            char carSpec='#';
            char carattere; //consente di leggere carattere per carattere
            do{
                lineaSingola="";

                do{

                    carattere=(char) dialoghi.read();
                    lineaSingola+=carattere ;


                }while ( (carSpec!=carattere)&&(carattere!=-1) );
                if ((carSpec==carattere)|| (carattere==-1) ){
                    System.out.println (lineaSingola);

                }
                Scanner sc = new Scanner(System.in);
                String input =sc.nextLine();
            }while(carattere != -1);
        }catch (FileNotFoundException e ){
            System.err.println("il file non esiste");

        }catch (IOException e ){
            System.err.println("ERRORE  DI I/0");
        }
    }

}

