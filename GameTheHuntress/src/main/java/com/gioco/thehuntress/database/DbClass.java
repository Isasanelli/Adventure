package com.gioco.thehuntress.database;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class that manages the database.
 */
public class  DbClass {

    public static final String CREATE_ROOM= "CREATE TABLE IF NOT EXISTS rooms (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(1000), look VARCHAR(1000), descReturn VARCHAR(1000))";
    public static final String CREATE_ADVOBJECT="CREATE TABLE IF NOT EXISTS advObjects (id int PRIMARY KEY, name VARCHAR(100), desc VARCHAR(1000))";

    public static final String SELECT1="SELECT id FROM rooms WHERE id=?";
    public static final String SELECT2="SELECT id FROM advObjects WHERE id=?";

    public static final String INSERT1= "INSERT INTO rooms VALUES (?,?,?,?,?)";
    public static final String INSERT2="INSERT INTO advObjects VALUES (?,?,?)";

    private static Connection conn;
    private Properties prop;


    /**
     * DbClass builder.
     */
    public DbClass(){
        try{
            prop =properties();
            conn=connection(prop);
            createAllTable();
        }catch (SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
    }

    /**
     * function that loads the driver through the connection string.
     * @param prop Properties object
     * @return driver
     * @throws SQLException
     */
    public static Connection connection (Properties prop) throws SQLException {
         return DriverManager.getConnection("jdbc:h2:./resources/db/playgame",prop);
    }


    /**
     * function that allows you to read the select and id of interest.
     * @param select
     * @param idStatement object's id
     * @return rs result of the select
     * @throws SQLException
     */
    public static ResultSet readFromDb(String select,int idStatement) throws SQLException{
        PreparedStatement pstm= getConnection().prepareStatement(select);
        pstm.setInt(1,idStatement);
        ResultSet rs= pstm.executeQuery();
        return rs;
    }

    /**
     *method that check if the tuple with id = ? already exists in the table, and if not, it will be inserted.
     * @param select
     * @param id object's id
     * @param queryInsert string that contains query that inserts items into the table
     * @param array contains the elements to be inserted in the db table
     * @throws SQLException
     */
    public void init(String select,int id, String queryInsert, String[] array) throws SQLException{
        ResultSet rs= readFromDb(select,id);

        if(!exists(rs, id)){
            insertStringIntoTheTable(id,queryInsert, array);
        }
    }

    /**
     * function that checks if the object is present in the table or not.
     * @param resultSet result of the select
     * @param id
     * @return toReturn it is true if the object is present in the table, otherwise it is false
     * @throws SQLException
     */
    public Boolean exists( ResultSet resultSet, int id) throws SQLException{
        Boolean toReturn=false;
        while(resultSet.next()){
            if(resultSet.getInt(1)==id)
                toReturn=true;
        }
        return toReturn;
    }

    /**
     * method that inserts the string's array into the table.
     * @param id
     * @param insert string that contains query that inserts items into the table
     * @param array contains the elements to be inserted in the db table
     * @throws SQLException
     */
    public void insertStringIntoTheTable(int id, String insert, String[] array) throws SQLException{
        PreparedStatement pstm= getConnection().prepareStatement(insert);
        if(array.length==4) { //for the rooms
            pstm.setInt(1, id);
            pstm.setString(2, array[0]);
            pstm.setString(3, array[1]);
            pstm.setString(4, array[2]);
            pstm.setString(5,array[3]);
            pstm.executeUpdate();
        } else if(array.length==2){ //for the advObjects
            pstm.setInt(1,id);
            pstm.setString(2,array[0]);
            pstm.setString(3,array[1]);
            pstm.executeUpdate();
        } else{
            System.out.println("Errore su insertStringIntoTheTable" + id);
        }
        pstm.close();
    }

    /**
     *  method that creates the table inside the db.
     * @param table string that contains the query that creates the table
     * @throws SQLException
     */
    public void createTable(String table) throws SQLException{
        Statement stat= getConnection().createStatement();
        stat.executeUpdate(table);
        stat.close();
    }

    /**
     * method that closes the connection of the db
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        getConnection().close();
    }

    /**
     *function that creates the properties object.
     * @return prop
     */
    public static Properties properties(){
        Properties prop =new Properties();
        prop.setProperty("user","Huntress");
        prop.setProperty("password","1234");
        return prop;
    }

    /**
     * function that returns the connection.
     * @return conn
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return conn;
    }


    /**
     * method that creates the tables inside the db and calls the function that populates the tuples.
     * @throws SQLException
     */
    public void createAllTable() throws SQLException{
        createTable(CREATE_ROOM);
        createTable(CREATE_ADVOBJECT);
        populationTable();
    }

    /**
     * method that populates the tuples of the tables present in the db.
     * @throws SQLException
     */
    public void populationTable() throws SQLException{

        String[] room1={"Giardino","Sei sdraiata sul prato ad osservare le forme delle nuvole nel cielo.\n"
                +" Oggi il cielo e' piu' azzurro delle altre volte.\n"
                +" Stai per crollare in un pisolino gradevole ma appena cerchi di addormentarti.\n"
                +" Tuo padre Rost viene verso di te. Parla con Rost","Sei circondata dall'erba verde del tuo giardino. Hai gia' parlato con Rost?",
                "Sei nel giardino della tua famiglia, qui ci sei gia' stata.\n"
                +"Il fuoco e' spento e intorno al ruscello piccoli uccelli cinguettano.\n"
                +"Non c'e' nulla qui. Torna alla tua missione."};
        init(SELECT1,1,INSERT1,room1);

        String[] room2={"Campo di addestramento",
                "Sei al campo di addestramento della tua famiglia. Rost ha qualcosa da dirti",
                "Una mandria di biomacchine sono rannicchiate accanto ad un fiume",
                "Alcuni corsieri sono rannicchiati sotto l'albero che riposano.\n"
            +" Vedi ancora il corsiero che Rost ha ucciso.\n"
            +"Non c'e' nulla che ti possa interessare. E' meglio tornare alla missione"};
        init(SELECT1,2,INSERT1,room2);

        String[] room3={"Valle dei caduti",
                "Tu e Rost avete appena terminato la vostra sessione di addestramento.\n"
              + " Rost ha qualcosa da dirti",
                "Siete nella valle dei caduti a godervi un po di tranquillita'.\n"
               + "Senti scorrere in lontananza un ruscello\n",
                "La valle dei caduti ha un nome cosi triste. Sei gia' stata qui.\n"
                +"Torna sui tuoi passi"};
        init(SELECT1,3,INSERT1,room3);

        String[] room4={"Tenda del Re Sole",
                "Apri gli occhi. La stanza in cui ti trovi sembra appartenere alla Tribu' del sole.\n"
                    +" Cerchi di alzarti, ma ad un certo punto senti dei passi provenire verso di te.\n"
                    +" Un uomo alto e' entrato nella stanza\n "+"E' il Re Sole,parla con lui",
                     "A sud e' presente un camino\n,"+
                     "a est c'e' una porta,\n"+
                     "a nord c'e' una finestra",
                    "E' rimasto tutto come l'hai lasciato. Il fuoco del camino arde ancora.\n"
                     + "Il letto e' ordinato e intorno a te senti odore di incenzo.\n"
                + " Non so cosa puoi fare qui. Forse e' meglio tornare alla missione"};
        init(SELECT1,4,INSERT1,room4);

        String[] room5={"Campo del collolungo",
                "Ti trovi fuori il templio del Re Sole. Il re Sole ha qualcosa da dirti",
                "A nord e' possibile notare una strana ed enorme sagoma che si affaccia tra gli alberi,\n"+"Forse e' meglio dare un'occhiata più da vicino.\n"+"A est c'e'un burrone, a ovest c'e' la tenda del Re Sole ",
                "Ti trovi fuori il templio del Re Sole. Hai appena notato quanto e' piccolo in confronto alla statua del collolungo...\n" + "Ma perche' non pensi a cose piu' importanti? Tipo la TUA MISSIONE"};
        init(SELECT1,5,INSERT1,room5);

        String[] room6={"Torre di Meridiana: porta del Calderone",
                "Sei giunta finalmente a Meridiana.\n" + "Della Trbu' non trovi nessuna traccia.\n" + "In lontananza trovi una grande roccia a forma di piramide.\n" + "Una strana luce proviene verso quella che dovrebbe essere la porta della torre.\n" + "Ti avvicini. Noti alla tua destra un pulsante illuminato. Ci dobbiamo fidare a premerlo?",
                "C'e' un pulsante alla tua destra, sara' il caso di premerlo",
                "Intorno a te svolazzano un covo di biomacchine. Sembrano essere le Avistempesta. Meglio non disturbarle.\n"+
                "Questo posto mette i brividi. Sara' il caso di tornare alla tua missione"};
        init(SELECT1,6,INSERT1,room6);

        String[] room7={"Torre di Meridiana: Calderone",
                "Sei riuscita ad entrare dentro il calderone. \n" +
                "A fine del corridoio, noti una luce blu che illumina la stanza. \n" +
                "Improvvisamente qualcuno ti colpisce alle spalle, facendoti cadere per terra. \n" +
                "Girandoti rapidamente, noti Vanasha.\n" +
                "E' il momento di COMBATTERE.",
                "A nord c'e' la porta del Calderone,\n" +
                "a sud trovi il cuore della madre\n" +
                "a ovest ci sono delle macchiene. Che posto macrabo.\n",
                 "Meridiana non e' la stessa senza tutto quel verde che c'era prima...\n" +
                "ma tutto tornera' al suo posto."};
        init(SELECT1,7,INSERT1,room7);


        String[] object1={"focus","Sistema di calcolo di realta' aumentata indossabile che consente di identificarne le bio-macchine"};
        init(SELECT2,1,INSERT2,object1);

        String[] object2={"batteria","Puo' essere ottenuta dal corsiero e avintempesta"};
        init(SELECT2,2,INSERT2,object2);

        String[] object3={"nucleo","E' il nucleo della madre, chip del comando delle macchine"};
        init(SELECT2,3,INSERT2,object3);

        String[] object4={"lancia con cripta","Ne consente il ripristino del cuore madre delle macchine"};
        init(SELECT2,4,INSERT2,object4);

        String[] object5={"mappa","Illustrera' il luogo del gioco. Richiamala quando piu' ti serve!"};
        init(SELECT2,5,INSERT2,object5);

        String[] object6={"corsiero","Grande quanto dei comuni animali da soma,\n"+" il corpo del corsiero somiglia molto a quello dei cavalli.\n"+" La testa tuttavia somiglia piu' a quella dei bovini, con due corna che puntano all'indietro.\n"+" Nella parte posteriore della groppa e' presente il serbatoio di Vampa della macchina"};
        init(SELECT2,6,INSERT2, object6);

        String[] object7={"collolungo","I collilunghi sono gigantesche statue che possono essere scalate sfruttando l'ambiente circostante"};
        init(SELECT2,7,INSERT2,object7);

        String[] object8={"avistempesta","Classe combattimento,solca i cieli ad alta quota e\n"+" puo' lanciarsi in picchia contro la sua preda per colpirla con forza.\n"+"Le sue enormi ali di metallo sono in grado di accumulare l'elettricita' nell'aria per poi sprigionarla nelle sue prede"};
        init(SELECT2,8,INSERT2,object8);

        String[] object9={"pacco", "Pacco regalo che conterra' il focus"};
        init(SELECT2,9,INSERT2,object9);
        
        String[] object10={"bottone","Bottone che ne consentirà l'apertura della torre di meridiana superato un enigma"};
        init(SELECT2,10,INSERT2,object10);
    }
}
