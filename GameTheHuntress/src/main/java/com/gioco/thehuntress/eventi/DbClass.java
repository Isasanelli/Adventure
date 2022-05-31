package com.gioco.thehuntress.eventi;

import java.sql.*;
import java.util.Properties;

public class DbClass {

    public static final String CREATE_ROOM= "CREATE TABLE IF NOT EXISTS rooms (id int PRIMARY KEY, nome VARCHAR(100), desc VARCHAR(1000), look VARCHAR(1000))";
    public static final String CREATE_ADVOBJECT="CREATE TABLE IF NOT EXISTS advObjects (id int PRIMARY KEY, nome VARCHAR(100), desc VARCHAR(1000))";
    public static final String CREATE_MACHINE="CREATE TABLE IF NOT EXISTS machines (id int PRIMARY KEY, nome VARCHAR(100), desc VARCHAR(1000))";

    public static final String SELECT1="SELECT id FROM rooms WHERE id=?";
    public static final String SELECT2="SELECT id FROM advObjects WHERE id=?";
    public static final String SELECT3="SELECT id FROM machines WHERE id=?";
    public static final String INSERIMENTO1= "INSERT INTO rooms VALUES (?,?,?,?)";
    public static final String INSERIMENTO2="INSERT INTO advObjects VALUES (?,?,?)";
    public static final String INSERIMENTO3="INSERT INTO machines VALUES(?,?,?)";



    public DbClass(){
        try{
            Properties prop =new Properties();
            prop.setProperty("user","Huntress");
            prop.setProperty("password","1234");
            //Connessione col driver
            Connection conn=connection(prop);

            //creazione tabella rooms
            createTable(CREATE_ROOM, conn);

            //creazione tabella oggetti
            createTable(CREATE_ADVOBJECT, conn);

            //creazione tabella macchine
            createTable(CREATE_MACHINE, conn);

            /**
             * inserimento delle stanze nella tabella rooms
             */

            String[] room1={"Giardino","Sei sdraiata sul prato accanto ad un focolaio spento ad osservare le forme delle nuvole nel cielo,sommersa nei tuoi pensieri.Oggi il cielo è più azzurro delle altre volte. Stai per crollare in un pisolino gradevole ma appena cerchi di riaddormentarti tuo padre appare alle tue spalle: ","Sei circondata dall'erba verde del tuo giardino"};
            //controllo se la tupla con id=1 esiste già nella tabella rooms, e se non è così verrà inserita
            init(SELECT1,conn,1,INSERIMENTO1,room1);


            String[] room2={"Campo di addestramento","Sei al campo di addestramento della tua famiglia","Solo ad est vedi una mandria di biomacchine rannicchiate accanto ad un fiume. Segui Rost"};
            //controllo se la tupla con id=2 esiste già nella tabella rooms, e se non è così verrà inserita
            init(SELECT1,conn,2,INSERIMENTO1,room2);

            String[] room3={"Tenda del Re Sole","Apri gli occhi. Senti odore di incenso. La stanza in cui ti trovi sembra cxalda e accogliente. Sei stesa su un soffice letto avvolta da una copera calda. Tutto il tuo corpo è indolenzito. Cerchi di alzarti ma ad un certo punto senti dei piccoli passi provenire verso di te. Non fai in tempo a nasconderti, perchè quel qualcuno è già entrato...","A nord è presente un camino, a sud una porta,a ovest c'è un muro. A est c'è una finestra: cosa saranno quelle figure accanto agli abitanti? Sarà forse meglio dare un'occhiata"};
            //controllo se la tupla con id=3 esiste già nella tabella rooms, e se non è così verrà inserita
            init(SELECT1,conn,3,INSERIMENTO1,room3);

            String[] room4={"Campo del collolungo","Ti trovi fuori il tempio del Re Sole","A nord trovi una piccola fontanella, a sud grandi alberi con foglie intrecciate, a est un burrone...meglio non esporsi troppo, a ovest è possibile notare una strana ed enorme sagoma che si affaccia tra gli alberi, cosa potrà essere? Forse è meglio dare un'occhiata più da vicino"};
            //controllo se la tupla con id=4 esiste già nella tabella rooms, e se non è così verrà inserita
            init(SELECT1,conn,4,INSERIMENTO1,room4);

            /**
             * inserimento degli oggetti nella tabella advObjects
             */

            String[] object1={"Focus","Sistema di calcolo e realtà aumentata indossabile, che consente di identificare importanti oggetti e macchine"};
            //controllo se la tupla con id=1 esiste già nella tabella advObjects, e se non è così verrà inserita
            init(SELECT2,conn,1,INSERIMENTO2,object1);

            String[] object2={"Fiore di metallo","Fiore di metallo che si ottiene dal Corsiero"};
            //controllo se la tupla con id=2 esiste già nella tabella advObjects, e se non è così verrà inserita
            init(SELECT2,conn,2,INSERIMENTO2,object2);

            String[] object3={"Batteria","Può essere ottenuta dal corsiero, divoratuono e avintempesta"};
            //controllo se la tupla con id=3 esiste già nella tabella advObjects, e se non è così verrà inserita
            init(SELECT2,conn,3,INSERIMENTO2,object3);

            /**
             * inserimento delle macchine all'interno della tabella machines
             */

            String[] machine1={"Corsiero","Grande quanto dei comuni animali da soma, il corpo del corsiero somiglia molto a quello dei cavalli. La testa tuttavia somiglia più a quella dei bovini, con due corna che puntano all'indietro. Nella parte posteriore della groppa è presente il serbatoio di Vamoa della macchina"};
            //controllo se la tupla con id=1 esiste già nella tabella machines, e se non è così verrà inserita
            init(SELECT3,conn,1,INSERIMENTO3,machine1);

            String[] machine2={"Collolungo","I collilunghi sono gigantesche statue che possono essere scalate sfruttando l'ambiente circostante"};
            //controllo se la tupla con id=2 esiste già nella tabella machines, e se non è così verrà inserita
            init(SELECT3,conn,2,INSERIMENTO3,machine2);

            String[] machine3={"Divoratuono","Classe combattimento, è una delle macchine più letali. Se ha spazio a sufficienza può anche scatenare una serie di attacchi in kischia, con cariche o sferzate con la coda"};
            //controllo se la tupla con id=3 esiste già nella tabella machines, e se non è così verrà inserita
            init(SELECT3,conn,3,INSERIMENTO3,machine3);

            String[] machine4={"Avistempesta","Classe combattimento,solca i cieli ad alta quota e può lanciarsi in picchia contro la sua preda per colpirla con forza.Le sue enormi ali di metallo sono in grado di accumulare l'elettricità mell'aria per poi sprigionarla nelle sue prede"};
            //controllo se la tupla con id=3 esiste già nella tabella machines, e se non è così verrà inserita
            init(SELECT3,conn,4,INSERIMENTO3,machine4);


            /*PreparedStatement pstm2= conn.prepareStatement("SELECT id,nome,desc FROM machines WHERE id=?");
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
        if(array.length==3) {
            pstm.setInt(1, id);
            pstm.setString(2, array[0]); //nome
            pstm.setString(3, array[1]); //descrizione
            pstm.setString(4, array[2]); //look
            pstm.executeUpdate();
        } else if(array.length==2){
            pstm.setInt(1,id);
            pstm.setString(2,array[0]); //nome
            pstm.setString(3,array[1]);//descrizione
            pstm.executeUpdate();
        } else{
            System.out.println("Errore su insertStringIntoTheTable");
        }
        pstm.close();
    }

    //metodo che crea la tabella all'interno del db
    public void createTable(String table, Connection conn) throws SQLException{
        Statement stat= conn.createStatement();
        stat.executeUpdate(table);
        stat.close();
    }


}
