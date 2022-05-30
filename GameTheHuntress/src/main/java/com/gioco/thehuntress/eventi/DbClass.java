package com.gioco.thehuntress.eventi;

import java.sql.*;
import java.util.Properties;

public class DbClass {

    public static final String CREATE_ROOM= "CREATE TABLE IF NOT EXISTS rooms (id int PRIMARY KEY, nome VARCHAR(100), desc VARCHAR(1000), look VARCHAR(1000))";
    public static final String SELECT1="SELECT id FROM rooms WHERE id=?";
    public static final String INSERIMENTO1= "INSERT INTO rooms VALUES (?,?,?,?)";


    public DbClass(){
        try{
            Properties prop =new Properties();
            prop.setProperty("user","Huntress");
            prop.setProperty("password","1234");
            //Connessione col driver
            Connection conn=connection(prop);
            //creazione tabella rooms
            Statement stat= conn.createStatement();
            stat.executeUpdate(CREATE_ROOM);
            stat.close();

            String[] room1={"Giardino","Sei sdraiata sul prato accanto ad un focolaio spento ad osservare le forme delle nuvole nel cielo,sommersa nei tuoi pensieri.Oggi il cielo è più azzurro delle altre volte. Stai per crollare in un pisolino gradevole ma appena cerchi di riaddormentarti tuo padre appare alle tue spalle: ","Sei circondata dall'erba verde del tuo giardino"};
            //controllo se la tupla con id=1 esiste già in db, e se non è così verrà inserita
            init(SELECT1,conn,1,INSERIMENTO1,room1);


            String[] room2={"Campo di addestramento","Sei al campo di addestramento della tua famiglia","Solo ad est vedi una mandria di biomacchine rannicchiate accanto ad un fiume. Segui Rost"};
            //controllo se la tupla con id=2 esiste già in db, e se non è così verrà inserita
            init(SELECT1,conn,2,INSERIMENTO1,room2);

            String[] room3={"Tenda del Re Sole","Apri gli occhi. Senti odore di incenso. La stanza in cui ti trovi sembra cxalda e accogliente. Sei stesa su un soffice letto avvolta da una copera calda. Tutto il tuo corpo è indolenzito. Cerchi di alzarti ma ad un certo punto senti dei piccoli passi provenire verso di te. Non fai in tempo a nasconderti, perchè quel qualcuno è già entrato...","A nord è presente un camino, a sud una porta,a ovest c'è un muro. A est c'è una finestra: cosa saranno quelle figure accanto agli abitanti? Sarà forse meglio dare un'occhiata"};
            //controllo se la tupla con id=3 esiste già in db, e se non è così verrà inserita
            init(SELECT1,conn,3,INSERIMENTO1,room3);

            String[] room4={"Campo del collolungo","Ti trovi fuori il tempio del Re Sole","A nord trovi una piccola fontanella, a sud grandi alberi con foglie intrecciate, a est un burrone...meglio non esporsi troppo, a ovest è possibile notare una strana ed enorme sagoma che si affaccia tra gli alberi, cosa potrà essere? Forse è meglio dare un'occhiata più da vicino"};
            //controllo se la tupla con id=4 esiste già in db, e se non è così verrà inserita
            init(SELECT1,conn,4,INSERIMENTO1,room4);


           /*PreparedStatement pstm2= conn.prepareStatement("SELECT id,desc,look FROM rooms WHERE id=?");
            pstm2.setInt(1,4);
            ResultSet rs2= pstm2.executeQuery();
            while(rs2.next()){
                System.out.println(rs2.getInt(1) + "--" + rs2.getString(2)+ "--" + rs2.getString(3));
            }
            rs2.close();
            pstm2.close();*/
        }catch (SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
    }

    //connessione al db
    public Connection connection (Properties prop) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:h2:./resources/db/playgame",prop);
        return conn;
    }


    //metodo che consente di leggere la select e l'id di interesse
    public ResultSet readFromDb(String select, Connection conn, int idStatement) throws SQLException{
        PreparedStatement pstm= conn.prepareStatement(select);
        pstm.setInt(1,idStatement);
        ResultSet rs= pstm.executeQuery();
        return rs;
    }


    public void init(String select,Connection conn,int id, String queryInserimento, String[] array) throws SQLException{
        ResultSet rs= readFromDb(select,conn,id);

        if(!exists(rs, id)){
            insertStringIntoTheTable(id,queryInserimento, array, conn);
        }
    }

    //metodo che ritorna false se l'oggetto non è stato scritto in db
    public Boolean exists( ResultSet resultSet, int id) throws SQLException{
        Boolean toReturn=false;
        while(resultSet.next()){
            if(resultSet.getInt(1)==id)
                toReturn=true;
        }
        return toReturn;
    }

    //metodo che inserisce all'interno della tabella la stringa
    public void insertStringIntoTheTable(int id, String insert, String[] array, Connection conn) throws SQLException{
        PreparedStatement pstm= conn.prepareStatement(insert);
        pstm.setInt(1,id);
        pstm.setString(2,array[0]); //nome oggetto
        pstm.setString(3,array[1]); //descrizione
        pstm.setString(4,array[2]); //look
        pstm.executeUpdate();
        pstm.close();
    }


}
