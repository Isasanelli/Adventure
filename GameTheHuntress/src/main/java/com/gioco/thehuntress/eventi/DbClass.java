package com.gioco.thehuntress.eventi;

import java.sql.*;
import java.util.Properties;

public class DbClass {

    public static final String CREATE_ROOM= "CREATE TABLE IF NOT EXISTS rooms (id int PRIMARY KEY, nome VARCHAR(100), desc VARCHAR(1000), look VARCHAR(1000))";

    public DbClass(){

    }

    public void metodoProva(){
        try{
            Properties prop =new Properties();
            prop.setProperty("user","Huntress");
            prop.setProperty("password","1234");
            Connection conn=connessione(prop);
            Statement stat= conn.createStatement();
            stat.executeUpdate(CREATE_ROOM);
            stat.close();
            PreparedStatement pstm= conn.prepareStatement("INSERT INTO rooms VALUES (?,?,?,?)");
            pstm.setInt(1,1);
            pstm.setString(2,"Giardino");
            pstm.setString(3,"Sei sdraiata sul prato accanto ad un focolaio spento ad osservare le forme delle nuvole nel cielo. Immersa nei tuoi pensieri senti qualcuno dietro le tue spalle: è Rost");
            pstm.setString(4,"Sei circondata dall'erba verde del tuo giardino");
            pstm.executeUpdate();
            pstm.close();
            pstm=conn.prepareStatement("INSERT INTO rooms VALUES (?,?,?,?)");
            pstm.setInt(1,2);
            pstm.setString(2,"Campo di addestramento");
            pstm.setString(3,"Sei al campo di addestramento della tua famiglia");
            pstm.setString(4,"Solo ad est vedi una mandria di biomacchine rannicchiate accanto ad un fiume. Segui Rost");
            pstm.executeUpdate();
            pstm.close();
            pstm=conn.prepareStatement("INSERT INTO rooms VALUES (?,?,?,?)");
            pstm.setInt(1,3);
            pstm.setString(2,"Tenda del Re Sole");
            pstm.setString(3,"Apri gli occhi. Senti odore di incenso. La stanza in cui ti trovi sembra calda e accogliente,e tu ti trovi stesa, avvolta da una morbida coperta.Ad un certo punto senti dei piccoli passi provenire verso di te");
            pstm.setString(4,"A nord è presente un camino, a sud una porta, a ovest c'è un muro, a est una finestra. Cosa saranno quelle figure accanto agli abitanti? Sarà meglio guardare");
            pstm.executeUpdate();
            pstm.close();
            pstm=conn.prepareStatement("INSERT INTO rooms VALUES (?,?,?,?)");
            pstm.setInt(1,4);
            pstm.setString(2,"Campo del collolungo");
            pstm.setString(3,"Ti trovi fuori il templio del Re Sole");
            pstm.setString(4,"A nord vedi una piccola fontanella, a sud grandi alberi con foglie intrecciate, a est un burrone, a ovest è possibile notare una strana e gigantesca sagoma che si affaccia fra gli alberi. Cosa potrà mai essere? Forse è meglio dare un'occhiata più da vicino");
            pstm.executeUpdate();
            pstm.close();
            stat= conn.createStatement();
            /*ResultSet rs=stat.executeQuery("SELECT id,desc,look FROM rooms WHERE id=4");
            while(rs.next()){
                System.out.println(rs.getInt(1) + "--" + rs.getString(2)+ "--" + rs.getString(3));
            }
            rs.close();
            stat.close();*/
        }catch (SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
    }

    public Connection connessione (Properties prop) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:h2:./resources/db/playgame",prop);
        return conn;
    }

}
