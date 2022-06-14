package com.gioco.thehuntress.eventi;

import java.sql.*;
import java.util.Properties;

public class  DbClass {

    public static final String CREATE_ROOM= "CREATE TABLE IF NOT EXISTS rooms (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(1000), look VARCHAR(1000), descReturn VARCHAR(1000))";
    public static final String CREATE_ADVOBJECT="CREATE TABLE IF NOT EXISTS advObjects (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(1000))";
    public static final String CREATE_ADVOBJECTCONTAINER="CREATE TABLE IF NOT EXISTS advObjectsContainer (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(1000))";

    public static final String SELECT1="SELECT id FROM rooms WHERE id=?";
    public static final String SELECT2="SELECT id FROM advObjects WHERE id=?";
    public static final String SELECT3="SELECT id FROM advObjectsContainer WHERE id=?";
    public static final String INSERT1= "INSERT INTO rooms VALUES (?,?,?,?,?)";
    public static final String INSERT2="INSERT INTO advObjects VALUES (?,?,?)";
    public static final String INSERT3="INSERT INTO advObjectsContainer VALUES(?,?,?)";

    private static Connection conn;
    private Properties prop;


    public DbClass(){
        try{
            prop =properties();
            conn=connection(prop);
            createAllTable();
        }catch (SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
    }

    //connessione al db
    public static Connection connection (Properties prop) throws SQLException {
         return DriverManager.getConnection("jdbc:h2:./resources/db/playgame",prop);
    }


    //metodo che consente di leggere la select e l'id di interesse
    public static ResultSet readFromDb(String select,int idStatement) throws SQLException{
        PreparedStatement pstm= getConnection().prepareStatement(select);
        pstm.setInt(1,idStatement);
        ResultSet rs= pstm.executeQuery();
        return rs;
    }


    public void init(String select,int id, String queryInsert, String[] array) throws SQLException{
        ResultSet rs= readFromDb(select,id);

        if(!exists(rs, id)){
            insertStringIntoTheTable(id,queryInsert, array);
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
    public void insertStringIntoTheTable(int id, String insert, String[] array) throws SQLException{
        PreparedStatement pstm= getConnection().prepareStatement(insert);
        if(array.length==4) {
            pstm.setInt(1, id);
            pstm.setString(2, array[0]); //nome
            pstm.setString(3, array[1]); //descrizione
            pstm.setString(4, array[2]); //look
            pstm.setString(5,array[3]); //descrizione di ritorno
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
    public void createTable(String table) throws SQLException{
        Statement stat= getConnection().createStatement();
        stat.executeUpdate(table);
        stat.close();
    }

    public static Properties properties(){
        Properties prop =new Properties();
        prop.setProperty("user","Huntress");
        prop.setProperty("password","1234");
        return prop;
    }

    public static Connection getConnection() throws SQLException{
        return conn;
    }


    //crea le tabelle all'interno del db e chiama la funzione che popola le tuple
    public void createAllTable() throws SQLException{
        //creazione tabella rooms
        createTable(CREATE_ROOM);

        //creazione tabella oggetti
        createTable(CREATE_ADVOBJECT);

        //creazione tabella macchine
        createTable(CREATE_ADVOBJECTCONTAINER);

        populationTable();
    }

    //vengono popolate le tuple nelle tabelle
    public void populationTable() throws SQLException{
        /**
         * inserimento delle stanze nella tabella rooms
         */

        String[] room1={"Giardino","Sei sdraiata sul prato accanto ad un focolaio spento ad osservare le forme delle nuvole nel cielo,sommersa nei tuoi pensieri.Oggi il cielo è più azzurro delle altre volte. Stai per crollare in un pisolino gradevole ma appena cerchi di riaddormentarti tuo padre appare alle tue spalle: E'Rost ","Sei circondata dall'erba verde del tuo giardino", "Sei nel giardino della tua famiglia, qui ci sei già stata. Hai ancora in mente i ricordi di te e Rost che giocavate intorno al fuoco. Forse è meglio riprendere il tuo viaggio. Questa non è più casa tua"};
        //controllo se la tupla con id=1 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,1,INSERT1,room1);

        String[] room2={"Campo di addestramento","Sei al campo di addestramento della tua famiglia","Solo ad est vedi una mandria di biomacchine rannicchiate accanto ad un fiume. Segui Rost",
        "Piccoli brividi ti invadono. Vedi ancora il corsiero che hai ucciso ancora li...Non c'è nulla che ti possa interessare. Forse è meglio tornare alla missione"};
        //controllo se la tupla con id=2 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,2,INSERT1,room2);

        String[] room3={"Valle della morte", "Tu e rost avete appena terminato la vostra sessione di addestramento.Siete nella valle dei caduti a godervi un po di tranquillità", "Senti scorrere in lontananza un ruscello", "Piccoli brividi ti invadono al solo pensiero di questo luogo. Qui è dove è stato ucciso Rost. Sei invasa da rabbia e tristezza. Torna sui tuoi passi"};
        //controllo se la tupla con id=3 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,3,INSERT1,room3);

        String[] room4={"Tenda del Re Sole","Apri gli occhi. Senti odore di incenso. La stanza in cui ti trovi sembra cxalda e accogliente. Sei stesa su un soffice letto avvolta da una copera calda. Tutto il tuo corpo è indolenzito. Cerchi di alzarti ma ad un certo punto senti dei piccoli passi provenire verso di te. Non fai in tempo a nasconderti, perchè quel qualcuno è già entrato...","A nord è presente un camino, a sud una porta,a ovest c'è un muro. A est c'è una finestra: cosa saranno quelle figure accanto agli abitanti? Sarà forse meglio dare un'occhiata"," DA SCRIVERE"};
        //controllo se la tupla con id=3 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,4,INSERT1,room4);

        String[] room5={"Campo del collolungo","Ti trovi fuori il tempio del Re Sole","A nord è possibile notare una strana ed enorme sagoma che si affaccia tra gli alberi, cosa potrà essere? Forse è meglio dare un'occhiata più da vicino, a sud si intravede il Calderone, a est un burrone, a ovest c'è la tenda del Re Sole ","da scrivere"};
        //controllo se la tupla con id=4 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,5,INSERT1,room5);

        /**
         * inserimento degli oggetti nella tabella advObjects
         */

        String[] object1={"Focus","Sistema di calcolo e realtà aumentata indossabile, che consente di identificare importanti oggetti e macchine"};
        //controllo se la tupla con id=1 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,1,INSERT2,object1);

        String[] object2={"Batteria","Può essere ottenuta dal corsiero, divoratuono e avintempesta"};
        //controllo se la tupla con id=2 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,2,INSERT2,object2);

        String[] object3={"Arco da Caccia","Usa freccie da caccia con massima precisione"};
        //controllo se la tupla con id=3 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,3,INSERT2,object3);

        String[] object4={"Lancia con Cripta","Ne consente il controllo delle macchine"};
        //controllo se la tupla con id=4 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,4,INSERT2,object4);

        String[] object5={"Mappa","Illustrerà il luogo del gioco"};
        //controllo se la tupla con id=5 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,5,INSERT2,object5);


        /**
         * inserimento delle macchine all'interno della tabella machines
         */

        String[] advObjectContainer1={"Corsiero","Grande quanto dei comuni animali da soma, il corpo del corsiero somiglia molto a quello dei cavalli. La testa tuttavia somiglia più a quella dei bovini, con due corna che puntano all'indietro. Nella parte posteriore della groppa è presente il serbatoio di Vampa della macchina"};
        //controllo se la tupla con id=1 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT3,1,INSERT3, advObjectContainer1);

        String[] advObjectContainer2={"Collolungo","I collilunghi sono gigantesche statue che possono essere scalate sfruttando l'ambiente circostante"};
        //controllo se la tupla con id=2 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT3,2,INSERT3,advObjectContainer2);

        String[] advObjectContainer3={"Avistempesta","Classe combattimento,solca i cieli ad alta quota e può lanciarsi in picchia contro la sua preda per colpirla con forza.Le sue enormi ali di metallo sono in grado di accumulare l'elettricità nell'aria per poi sprigionarla nelle sue prede"};
        //controllo se la tupla con id=3 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT3,3,INSERT3,advObjectContainer3);

        String[] advObjectContainer4={"Pacco", "Pacco regalo che conterrà il focus"};
        //controllo se la tupla con id=5 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,4,INSERT3,advObjectContainer4);


        /*PreparedStatement pstm2= conn.prepareStatement("SELECT id,name,desc FROM machines WHERE id=?");
        pstm2.setInt(1,2);
        ResultSet rs2= pstm2.executeQuery();
        while(rs2.next()){
            System.out.println(rs2.getInt(1) + "--" + rs2.getString(2)+ "--" + rs2.getString(3));
        }
        rs2.close();
        pstm2.close();*/
    }


}
