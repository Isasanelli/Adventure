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
            System.out.println("Errore su insertStringIntoTheTable" + id);
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

        String[] room1={"Giardino","Sei sdraiata sul prato accanto ad un focolaio spento ad osservare le forme delle nuvole nel cielo,\n"
                +" sommersa nei tuoi pensieri.Oggi il cielo e' piu' azzurro delle altre volte.\n"
                +" Stai per crollare in un pisolino gradevole ma appena cerchi di riaddormentarti\n"
                +" tuo padre Rost viene verso di te per dirti una cosa. Parla con Rost","Sei circondata dall'erba verde del tuo giardino. Hai già parlato con Rost?",
                "Sei nel giardino della tua famiglia, qui ci sei gia' stata.\n"
                +" Hai ancora in mente i ricordi di te e Rost che giocavate intorno al fuoco.\n"
                +" Forse e' meglio riprendere il tuo viaggio. Questa non e' piu' casa tua"};
        //controllo se la tupla con id=1 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,1,INSERT1,room1);

        String[] room2={"Campo di addestramento",
                "Sei al campo di addestramento della tua famiglia. Rost ha qualcosa da dirti",
                "Una mandria di biomacchine sono rannicchiate accanto ad un fiume. Parla con Rost",
                "Piccoli brividi ti invadono.\n"
            +" Vedi ancora il corsiero che hai ucciso ancora li...\n"
            +"Non c'e' nulla che ti possa interessare. Forse e' meglio tornare alla missione"};
        //controllo se la tupla con id=2 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,2,INSERT1,room2);

        String[] room3={"Valle dei caduti",
                "Tu e Rost avete appena terminato la vostra sessione di addestramento.\n"
              + " Rost ha qualcosa da dirti",
                "Siete nella valle dei caduti a godervi un po di tranquillità.\n"
               + "Senti scorrere in lontananza un ruscello\n",
                "Piccoli brividi ti invadono al solo pensiero di questo luogo.\n"
                +" Qui e' dove è stato ucciso Rost. Sei invasa da rabbia e tristezza.\n "
                +"Torna sui tuoi passi"};
        //controllo se la tupla con id=3 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,3,INSERT1,room3);

        String[] room4={"Tenda del Re Sole",
                "Apri gli occhi. Senti odore di incenso. La stanza in cui ti trovi sembra appartenere alla Tribu' del sole.\n"
                    + "Sei stesa su un soffice letto avvolta da una coperta calda. Tutto il tuo corpo e' indolenzito.\n"
                    +" Cerchi di alzarti ma ad un certo punto senti dei piccoli passi provenire verso di te.\n"
                    +" Non fai in tempo a nasconderti, perche' un uomo alto con una corona in testa a forma di sole e' entrato nella stanza\n "+"Parla con il Re Sole",
                     "A sud e' presente un camino,a est c'è una porta, a nord c'e' una finestra",
                    "E' rimasto tutto come l'hai lasciato. Il fuoco del camino arde ancora.\n"
                     + "Il letto e' ordinato e intorno a te senti odore di incenzo.\n"
                + " Non so cosa puoi fare qui. Forse e' meglio tornare alla missione"};
        //controllo se la tupla con id=3 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,4,INSERT1,room4);

        String[] room5={"Campo del collolungo",
                "Ti trovi fuori il templio del Re Sole",
                "A nord e' possibile notare una strana ed enorme sagoma che si affaccia tra gli alberi,\n"+" cosa potrà essere?\n"+"Forse e' meglio dare un'occhiata più da vicino.\n"+"A est c'e'un burrone, a ovest c'e' la tenda del Re Sole ",
                "Ti trovi fuori il templio del Re Sole. Hai appena notato quanto è piccolo in confronto alla statua del collolungo...\n" + "Ma perchè non pensi a cose più importanti? Tipo la TUA MISSIONE"};
        //controllo se la tupla con id=4 esiste già nella tabella rooms, e se non è così verrà inserita
        init(SELECT1,5,INSERT1,room5);

        /**
         * inserimento degli oggetti nella tabella advObjects
         */

        String[] object1={"focus","Sistema di calcolo di realta' aumentata indossabile che consente di identificare importanti oggetti e macchine"};
        //controllo se la tupla con id=1 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,1,INSERT2,object1);

        String[] object2={"batteria","Puo' essere ottenuta dal corsiero, divoratuono e avintempesta"};
        //controllo se la tupla con id=2 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,2,INSERT2,object2);

        String[] object3={"arco da caccia","Usa freccie da caccia con massima precisione"};
        //controllo se la tupla con id=3 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,3,INSERT2,object3);

        String[] object4={"lancia con cripta","Ne consente il controllo delle macchine"};
        //controllo se la tupla con id=4 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,4,INSERT2,object4);

        String[] object5={"mappa","Illustrera' il luogo del gioco"};
        //controllo se la tupla con id=5 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,5,INSERT2,object5);

        String[] object6={"corsiero","Grande quanto dei comuni animali da soma,\n"+" il corpo del corsiero somiglia molto a quello dei cavalli.\n"+" La testa tuttavia somiglia piu' a quella dei bovini, con due corna che puntano all'indietro.\n"+" Nella parte posteriore della groppa e' presente il serbatoio di Vampa della macchina"};
        //controllo se la tupla con id=6 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT2,6,INSERT2, object6);

        String[] object7={"collolungo","I collilunghi sono gigantesche statue che possono essere scalate sfruttando l'ambiente circostante"};
        //controllo se la tupla con id=7 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT2,7,INSERT2,object7);

        String[] object8={"avistempesta","Classe combattimento,solca i cieli ad alta quota e\n"+" puo' lanciarsi in picchia contro la sua preda per colpirla con forza.\n"+"Le sue enormi ali di metallo sono in grado di accumulare l'elettricita' nell'aria per poi sprigionarla nelle sue prede"};
        //controllo se la tupla con id=8 esiste già nella tabella machines, e se non è così verrà inserita
        init(SELECT2,8,INSERT2,object8);

        String[] object9={"pacco", "Pacco regalo che conterra' il focus"};
        //controllo se la tupla con id=9 esiste già nella tabella advObjects, e se non è così verrà inserita
        init(SELECT2,9,INSERT2,object9);


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
