package com.gioco.thehuntress.games;

import com.gioco.thehuntress.adventure.GameDescription;
import com.gioco.thehuntress.battle.MiniGameBattle;
import com.gioco.thehuntress.database.DbClass;
import com.gioco.thehuntress.eventi.Eventi;
import com.gioco.thehuntress.graphic.Grafica;
import com.gioco.thehuntress.graphic.MapGraphic;
import com.gioco.thehuntress.minigame.TicTacGame;
import com.gioco.thehuntress.parser.ParserOutput;
import com.gioco.thehuntress.type.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

//manca javadoc classe
public class TheHuntressGame extends GameDescription {
    public MapGraphic mapGraphic = new MapGraphic();

    /**
     * method that allows the creation of objects and their setting
     * @throws Exception
     */
    @Override
    public void init() throws Exception {


         String PATROOM1 = "file//roomGarden.txt";
         String PATROOM2 = "file//roomTrainingCamp.txt";
         String PATROOM3 = "file//roomValleyOfDeath.txt";
         String PATROOM4 = "file//roomTend.txt";
         String PATROOM5= "file//roomCollolungo.txt";

        /**
         * commands for interaction between rooms
         */
        Command northOutTheRoom = new Command(CommandType.NORD, "nord");
        northOutTheRoom.setAlias(new String[]{"nord"});
        getCommands().add(northOutTheRoom);

        Command southOutTheRoom = new Command(CommandType.SUD, "sud");
        southOutTheRoom.setAlias(new String[]{"sud"});
        getCommands().add(southOutTheRoom);

        Command eastOutTheRoom = new Command(CommandType.EST, "est");
        eastOutTheRoom.setAlias(new String[]{"est"});
        getCommands().add(eastOutTheRoom);

        Command westOutTheRoom = new Command(CommandType.OVEST, "ovest");
        westOutTheRoom.setAlias(new String[]{"ovest"});
        getCommands().add(westOutTheRoom);

        /**
         * Commands for interaction inside the room
         */

        Command northInTheRoom = new Command(CommandType.N, "n");
        northInTheRoom.setAlias(new String[]{"n"});
        getCommands().add(northInTheRoom);

        Command southInTheRoom = new Command(CommandType.S, "s");
        southInTheRoom.setAlias(new String[]{"s"});
        getCommands().add(southInTheRoom);

        Command eastInTheRoom = new Command(CommandType.E, "e");
        eastInTheRoom.setAlias(new String[]{"e"});
        getCommands().add(eastInTheRoom);

        Command westInTheRoom = new Command(CommandType.O, "o");
        westInTheRoom.setAlias(new String[]{"o"});
        getCommands().add(westInTheRoom);

        /**
         * general commands
         */
        Command mapCommand = new Command(CommandType.MAPPA, "mappa");
        mapCommand.setAlias(new String[]{"map"});
        getCommands().add(mapCommand);

        Command end = new Command(CommandType.ESCI, "esci");
        end.setAlias(new String[]{"fine", "fine partita", "f", "esci"});
        getCommands().add(end);

        Command talk = new Command(CommandType.PARLA, "parla");
        talk.setAlias(new String[]{"parl", "p"});
        getCommands().add(talk);


        Command look = new Command(CommandType.GUARDA, "guarda");
        look.setAlias(new String[]{"gua", "vedi", "descrivi", "osserva"});
        getCommands().add(look);

        Command rules = new Command(CommandType.REGOLE, "regole");
        rules.setAlias((new String[]{"re", "regole"}));
        getCommands().add(rules);

        Command commands = new Command(CommandType.COMANDI, "comandi");
        commands.setAlias(new String[]{"com"});
        getCommands().add(commands);

        Command inventory = new Command(CommandType.INVENTARIO, "inventario");
        inventory.setAlias(new String[]{"inv"});
        getCommands().add(inventory);

        /**
         * commands on objects
         */
        Command open = new Command(CommandType.APRI, "apri");
        open.setAlias(new String[]{"ap"});
        getCommands().add(open);

        Command use = new Command(CommandType.USA, "usa");
        use.setAlias(new String[]{"us", "u"});
        getCommands().add(use);

        Command inspects = new Command(CommandType.ISPEZIONA, "ispeziona");
        inspects.setAlias(new String[]{"ispe", "isp"});
        getCommands().add(inspects);

        Command scalable = new Command(CommandType.SCALA, "scala");
        scalable.setAlias(new String[]{"sal", "sca"});
        getCommands().add(scalable);

        Command push =new Command (CommandType.PREMI, "premi");
        push.setAlias(new String[]{"prem","pre", "schiaccia"});
        getCommands().add(push);

        /**
         * combat commands
         */
        Command cripta = new Command(CommandType.CRIPTA, "cripta");
        cripta.setAlias(new String[]{"controllo", "manipola"});
        getCommands().add(cripta);

        Command focus = new Command(CommandType.FOCUS, "focus");
        focus.setAlias(new String[]{"foc"});
        getCommands().add(focus);

        Command combatti = new Command(CommandType.COMBATTI, "combatti");
        combatti.setAlias(new String[] {"attacca","aggredisci","att","aggred","comb","affronta","affr"});
        getCommands().add(combatti);

        /**
         * Rooms
         */

        Room roomGarden = new Room(1);
        roomGarden.setDialog(PATROOM1);
        roomGarden.setNorthInTheRoom(new String[]{"Da li si va verso il campo d'addestramento", "Il campo d'addestramento e' da quella parte"});
        roomGarden.setSouthInTheRoom(new String[]{"Non c'e' nulla", "E' solo un muro oltre la siepe, non ti interessa"});
        roomGarden.setEastInTheRoom(new String[]{"Questa foresta ha troppi alberi per i miei gusti", "Non c'e' nulla da guardare li"});
        roomGarden.setWestInTheRoom(new String[]{"Non c'è nulla che ti possa interessare. Parla con Rost se non l'hai gia' fatto", "Non c'e' nulla qui"});

        Room roomTrainingCamp = new Room(2);
        roomTrainingCamp.setDialog(PATROOM2);
        roomTrainingCamp.setNorthInTheRoom(new String[]{"Da li si va verso la valle dei caduti", "la valle dei caduti e' da quella parte"});
        roomTrainingCamp.setSouthInTheRoom(new String[]{"Da li si si ritorna in giardino", "Il giardino e' da quella parte"});
        roomTrainingCamp.setEastInTheRoom(new String[]{"C'e' una mandria di biomacchine da quella parte. Fai attenzione ", "Qui c'è il corsiero che hai ucciso. Non c'è nulla da guadare"});
        roomTrainingCamp.setWestInTheRoom(new String[]{"Non c'e' nulla", "Non c'e' nulla per te"});

        Room roomValleyOfDeath = new Room(3);
        roomValleyOfDeath.setDialog(PATROOM3);
        roomValleyOfDeath.setNorthInTheRoom(new String[]{"Non puoi andare da quella parte", "Non c'e' niente per te"});
        roomValleyOfDeath.setSouthInTheRoom(new String[]{"Da li si va verso il campo d'addestramento", "il campo d'addestramento e' da quella parte"});
        roomValleyOfDeath.setEastInTheRoom(new String[]{"Da li si va verso la tende del Re Sole", "La tenda del Re sole e' da quella parte"});
        roomValleyOfDeath.setWestInTheRoom(new String[]{"Da li non si puo' andare, c'e' solo un ruscello", "Che bello questo ruscello"});


        Room roomTend = new Room(4);
        roomTend.setDialog(PATROOM4);
        roomTend.setNorthInTheRoom(new String[]{"La finestra: vedere come le macchine e il popolo comunicano fra di loro, ti mette calma e speranza", "c'e' una finestra"});
        roomTend.setSouthInTheRoom(new String[]{"Il fuoco del camino e' caldo e accogliente", "Il fuoco e' ancora bello presente"});
        roomTend.setEastInTheRoom(new String[]{"Da li si va verso il Campo del collolungo", "il Campo del collolungo e' da quella parte"});
        roomTend.setWestInTheRoom(new String[]{"Da li si va verso la valle dei caduti ", "la valle dei caduti e' da quella parte"});

        Room roomCollolungo = new Room(5);
        roomCollolungo.setDialog(PATROOM5);
        roomCollolungo.setNorthInTheRoom(new String[]{"Trovi il collolungo ", "La statua del collolungo"});
        roomCollolungo.setSouthInTheRoom(new String[]{"Da quella parte c'e' Meridiana  ", "Il calderone e' da quella parte "});
        roomCollolungo.setEastInTheRoom(new String[]{"Li non puoi andare, meglio non esporsi. Non sei ancora in grado di volare", "C'e' il vuoto da quella parte. Non credo che tu voglia provare l'ebbrezza di volare"});
        roomCollolungo.setWestInTheRoom(new String[]{"Da li si va verso la tenda del Re Sole", "La tenda del Re Sole e' da quella parte"});

        Room roomOutMeridiana = new Room(6);
        roomOutMeridiana.setNorthInTheRoom(new String[] {"Troverai il templio del Re Sole","Troverai il templio del Re Sole"});
        roomOutMeridiana.setSouthInTheRoom(new String []{"Una volta premuto il bottone ti toverai nella Torre di Meridiana","Una volta premuto il bottone ti troverai nella Torre di Meridiana "});
        roomOutMeridiana.setEastInTheRoom(new String[] {"Non c'e' nulla che ti puo interessare qui ","Non c'e' nulla che ti puo interessare qui"});
        roomOutMeridiana.setWestInTheRoom(new String[] {"Non c'e' nulla che ti puo interessare qui ","Non c'e' nulla ch eti puo intressare qui"});


        Room roomCalderone = new Room(7);
        roomCalderone.setNorthInTheRoom(new String[] {"C'è il cuore della madre. La sua luce blu è cosi calda e forte","C'è il cuore della madre. La sua luce blu è cosi calda e forte"});
        roomCalderone.setSouthInTheRoom(new String[] {"c'e' la porta del Calderone: non è il momento di uscire. Sei a un passo dal salvare il mondo. Non fermarti","c'e' la porta del calderone"});
        roomCalderone.setEastInTheRoom(new String[] {"non c'e' nulla","non c'e' nulla"});
        roomCalderone.setWestInTheRoom(new String[] {"Ci sono delle macchine, collegate a dei fili. Alcune dormono dentro a delle celle. Che posto macrabo","Ci sono delle macchine dentro delle gabbie"});

        /**
         * Creation of advobjects objects
         */
        AdvObject focusObject = new AdvObject(1);
        focusObject.setAlias(new String[]{"focus", "foc"});

        AdvObject batteria = new AdvObject(2);
        batteria.setAlias(new String[]{"batteria", "batt", "vampa"});

        AdvObject nucleo = new AdvObject(3);
        nucleo.setAlias(new String[]{"nucleo", "cuore"});
        nucleo.setCriptable(true);


        AdvObject lancia = new AdvObject(4);
        lancia.setAlias(new String[]{"lancia", "lanc", "cripta", "crip"});

        AdvObject map = new AdvObject(5);
        map.setAlias(new String[]{"mappa", "map", "m"});

        AdvObject botton = new AdvObject(10);
        botton.setAlias(new String[]{"bot","pulsante", "puls"});
        botton.setPushable(true);

        /**
         * Creation of advObjectsContainer objects
         */
        AdvObjectContainer corsiero = new AdvObjectContainer(6);
        corsiero.setAlias(new String[]{"corsiero", "cors","corsieri"});
        corsiero.setInspectable(true);
        corsiero.add(batteria);
        corsiero.setCriptable(true);
        corsiero.setFocus(true);
        corsiero.setKillable(true);

        AdvObjectContainer collolungo = new AdvObjectContainer(7);
        collolungo.setAlias(new String[]{"collolungo", "collo", "coll", "lungo"});
        collolungo.setInspectable(true);
        collolungo.setScalable(true);
        collolungo.add(map);
        collolungo.setCriptable(true);
        collolungo.setFocus(true);

        AdvObjectContainer avistempesta = new AdvObjectContainer(8);
        avistempesta.setAlias(new String[]{"avistempesta", "avi"});
        avistempesta.setInspectable(true);
        avistempesta.add(batteria);
        avistempesta.setCriptable(true);
        avistempesta.setFocus(true);
        avistempesta.setKillable(true);

        AdvObjectContainer giftBox = new AdvObjectContainer(9);
        giftBox.setAlias(new String[]{"pacco regalo", "pacco", "regalo"});
        giftBox.setopenable(true);
        giftBox.add(focusObject);

        /**
         * Assigning objects to their respective rooms.
         */
        roomGarden.getObjects().add(giftBox);
        roomGarden.getObjects().add(focusObject);
        roomTrainingCamp.getObjects().add(corsiero);
        roomTend.getObjects().add(lancia);
        roomCollolungo.getObjects().add(collolungo);
        roomOutMeridiana.getObjects().add(botton);
        roomCalderone.getObjects().add(nucleo);

        /**
         * setting of the rooms in their respective positions
         */
        roomGarden.setNorth(roomTrainingCamp);

        roomTrainingCamp.setSouth(roomGarden);
        roomTrainingCamp.setNorth(roomValleyOfDeath);

        roomValleyOfDeath.setSouth(roomTrainingCamp);
        roomValleyOfDeath.setEast(roomTend);

        roomTend.setWest(roomValleyOfDeath);
        roomTend.setEast(roomCollolungo);

        roomCollolungo.setWest(roomTend);
        roomCollolungo.setSouth(roomOutMeridiana);

        roomOutMeridiana.setNorth(roomCollolungo);
        roomOutMeridiana.setSouth(roomCalderone);
        roomCalderone.setNorth(roomOutMeridiana);


        getRooms().add(roomGarden);
        getRooms().add(roomTrainingCamp);
        getRooms().add(roomValleyOfDeath);
        getRooms().add(roomTend);
        getRooms().add(roomCollolungo);

        /**
         * initial room setting
         */
        setCurrentRoom(roomGarden);
        roomGarden.setFirstTimeHere(true);
    }

    /**
     *
     * @param db
     * @param p
     * @param out
     */
    @Override
    public void nextMove(DbClass db, ParserOutput p, PrintStream out) {
        String PATROOM7VINCITA= "file//roomCalderoneWin.txt";
        String PATROOM7PERDITA="file//roomCalderoneLoser.txt";
        boolean noroom = false;
        boolean move = false;
        if (p.getCommand().getType() == CommandType.NORD) {
            if (getCurrentRoom().getNorth() != null) {
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().setFirstTimeHere(false);
                    setCurrentRoom(getCurrentRoom().getNorth());
                    move = true;
                } else if (!getCurrentRoom().getFirstTimeHere()) {
                    setCurrentRoom(getCurrentRoom().getNorth());
                    move = true;
                }
            } else {
                noroom = true;
            }
        } else if (p.getCommand().getType() == CommandType.SUD) {
            if (getCurrentRoom().getSouth() != null) {
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().setFirstTimeHere(false);
                    setCurrentRoom(getCurrentRoom().getSouth());
                    move = true;
                } else if (!getCurrentRoom().getFirstTimeHere()) {
                    setCurrentRoom(getCurrentRoom().getSouth());
                    move = true;
                }
            } else {
                noroom = true;
            }
        } else if (p.getCommand().getType() == CommandType.EST) {
            if (getCurrentRoom().getEast() != null) {
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().setFirstTimeHere(false);
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                } else if (!getCurrentRoom().getFirstTimeHere()) {
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                }
            } else {
                noroom = true;
            }
        } else if (p.getCommand().getType() == CommandType.OVEST) {
            if (getCurrentRoom().getWest() != null) {
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().setFirstTimeHere(false);
                    setCurrentRoom(getCurrentRoom().getWest());
                    move = true;
                } else if (!getCurrentRoom().getFirstTimeHere()) {
                    setCurrentRoom(getCurrentRoom().getWest());
                    move = true;
                }
            } else {
                noroom = true;
            }
        } else if (p.getCommand().getType() == CommandType.N) {
            System.out.println(getCurrentRoom().getNorthInTheRoom());
        } else if (p.getCommand().getType() == CommandType.S) {
            System.out.println(getCurrentRoom().getSouthInTheRoom());
        } else if (p.getCommand().getType() == CommandType.E) {
            System.out.println(getCurrentRoom().getEastInTheRoom());
        } else if (p.getCommand().getType() == CommandType.O) {
            System.out.println(getCurrentRoom().getWestInTheRoom());
        } else if (p.getCommand().getType() == CommandType.MAPPA) {
            Iterator<AdvObject> it = inventario.getList().listIterator();
            boolean flagMappa = false;
            while (it.hasNext()) {
                try {
                    AdvObject next = it.next();
                    if (next.getId() == 5) {
                        flagMappa = true;
                    }
                } catch (NoSuchElementException ex) {
                    System.out.println("ERRORE");
                }
            }
            if (flagMappa) {
                mapGraphic.createMap();
            } else {
                System.out.println("la mappa non e' presente nel tuo inventario.");
            }
        } else if (p.getCommand().getType() == CommandType.GUARDA) {
            System.out.println(getCurrentRoom().getLook(db));
        } else if (p.getCommand().getType() == CommandType.COMANDI) {
            try {
                Eventi.readCommands();
            } catch (IOException exception) {
                System.err.println("Errore");
            }
        } else if (p.getCommand().getType() == CommandType.REGOLE) {
            try {
                Eventi.readRules();
            } catch (IOException exception) {
                System.err.println("Errore");
            }
        } else if (p.getCommand().getType() == CommandType.PARLA) {
            if (getCurrentRoom().getId() != 3 && getCurrentRoom().getId() != 4) {
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().Dialog();
                } else {
                    System.out.println("non c'e' nessuno con cui dialogare qui ");
                }
            } else if (getCurrentRoom().getId() == 3) { //se la stanza è la valle dei caduti
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().Dialog();
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                } else {
                    System.out.println("non c'e' nessuno con cui dialogare qui");
                }
            } else if (getCurrentRoom().getId() == 4) { //se la stanza è la tenda del re sole
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().Dialog();
                    Iterator<AdvObject> it = getCurrentRoom().getObjects().iterator();
                    while(it.hasNext()){
                        try{
                            AdvObject next = it.next();
                            if(next.getId() == 4){
                                inventario.add(next);
                                System.out.println("=====================================================");
                                System.out.println("***     Lancia aggiunta nel tuo inventario!   ***");
                                System.out.println("=====================================================");
                            }
                        }catch(NoSuchElementException ex){
                            System.out.println("Errore");
                        }
                    }
                } else{
                    System.out.println("non c'e' nessuno con cui dialogare qui");
                }
            }
        } else if (p.getCommand().getType() == CommandType.INVENTARIO) {
            System.out.println("=====================================================================================");
            System.out.println("Nel tuo inventario ci sono:");
            Iterator<AdvObject> it = inventario.getList().iterator();
            while (it.hasNext()) {
                try {
                    AdvObject oggetto = it.next();
                    System.out.println(oggetto.getName(db) + " : " + oggetto.getDescription(db));
                } catch (NoSuchElementException ex) {
                    System.out.println("errore");
                }
            }
            System.out.println("=====================================================================================");
        } else if (p.getCommand().getType() == CommandType.APRI) {
            if (p.getObject() == null && p.getObject2() == null) {
                System.out.println("Non c'e' nulla da aprire qui ");
            } else {
                if (p.getObject() != null) {
                        if (p.getObject().isOpenable() && !p.getObject().isOpen()) {
                            p.getObject().setopen(true);
                            if (p.getObject() instanceof AdvObjectContainer) { //se l'oggetto pacco è un oggetto contenitore allora
                                System.out.println("HAI APERTO: " + p.getObject().getName(db));
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {//controlla che il pacco non è vuoto dentro
                                    System.out.println("\ncontiene:");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    while (it.hasNext()) {//finchè la lista degli oggetti contenuti nel pacco non termina
                                        try {
                                            AdvObject next = it.next(); //assegna il prossimo elemento
                                            inventario.add(next);//focus aggiunto all'inventario
                                            System.out.println("***" + next.getName(db) + "***\n" + next.getDescription(db));
                                            System.out.println("*** Congratulazioni! Un nuovo elemento e' stato aggiunto nel tuo inventario ***");
                                        } catch (NoSuchElementException ex) {
                                            System.out.println("Errore");
                                        }
                                        it.remove();
                                    }
                                    if(p.getObject().getId()==9 && getCurrentRoom().getId()==1){
                                        System.out.println("\n\n\n");
                                        System.out.println("|ROST:Adesso scendiamo a valle.\n" +
                                                "|VICTORIA: Cosa c'e' a valle?\n" +
                                                "|ROST: Seguimi verso \"nord\" e lo scoprirai.");
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("L'oggetto e' vuoto");
                                }
                            } else {
                                out.println("non puoi aprire questo oggetto ");
                            }
                        } else if (p.getObject().isOpenable() && p.getObject().isOpen()) {
                            System.out.println(p.getObject().getName(db) + " e' gia' stato aperto!");
                        } else if (!p.getObject().isOpenable()) {
                            System.out.println(p.getObject().getName(db) + " non e' apribile!");
                        }
                }
            }
        } else if (p.getCommand().getType() == CommandType.SCALA) {
            if (p.getObject() != null) {
                if (p.getObject().isScalable() && !p.getObject().isScale()) {
                    p.getObject().setScale(true);
                    System.out.println("Sei in cima a  " + p.getObject().getName(db));
                    System.out.println("Adesso puoi usare la cripta! \n" + "Usa il comando CRIPTA + <nome della macchina> per prenderne il controllo \n");
                } else if(!p.getObject().isScalable()){
                    System.out.println("non posso salire su " + p.getObject().getName(db));
                } else if (p.getObject().isScalable() && p.getObject().isScale()) {
                    System.out.println("Hai già scalato " + p.getObject().getName(db) + "!"+"\n"+ "Non perdere tempo...");
                }
            } else {
                System.out.println("Cosa vuoi scalare?\n" + "Specifica col comando 'scala <oggetto>' ");
            }
        } else if (p.getCommand().getType() == CommandType.ISPEZIONA) {
            if (p.getObject() == null && p.getObject2() == null) {
                System.out.println("Non c'e' nulla da ispezionare qui ");
            } else {
                if (p.getObject() != null && (p.getObject().isCripta() || p.getObject().isKill()) && p.getObject2() ==null) {
                    if (p.getObject().isInspectable() && !p.getObject().isInspect()) {
                        if (p.getObject() instanceof AdvObjectContainer) { //se l'oggetto macchina è un oggetto contenitore allora
                            p.getObject().setInspect(true);
                            System.out.println("HAI ISPEZIONATO:  " + p.getObject().getName(db));
                            AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                            if (!c.getList().isEmpty()) {//controlla che la macchina non è vuoto dentro
                                System.out.println(p.getObject().getName(db) + "  contiene: \n");
                                Iterator<AdvObject> it = c.getList().iterator();
                                while (it.hasNext()) {//finchè la lista degli oggetti contenuti nella macchina non termina
                                    try {
                                        AdvObject next = it.next(); //assegna il prossimo elemento
                                        inventario.add(next);//oggetto  aggiunto all'inventario
                                        System.out.println("***" + next.getName(db) + "***");
                                        System.out.println("*** Congratulazioni! Un nuovo elemento e' stato aggiunto nel tuo inventario ***");
                                    } catch (NoSuchElementException ex) {
                                        System.out.println("Errore");
                                    }
                                    it.remove();
                                }
                                System.out.println();
                                if(getCurrentRoom().getId()==2 && p.getObject().getId()==6){
                                    System.out.println("|ROST: Spostiamoci verso nord a rilassarci un po'...");
                                }else if(getCurrentRoom().getId()==5 && p.getObject().getId()==7){
                                    System.out.println("|Avad: Adesso sei veramente pronta a sconfiggere Vanasha, il Calderone ti aspetta a sud...Che la fortuna sia con te Victoria!");
                                }
                            } else {
                                System.out.println("La macchina e' vuota");
                            }
                        } else {
                            System.out.println("Non c'e' niente da ispezionare");
                        }
                    } else if (p.getObject().isInspectable() && p.getObject().isInspect()) {
                        System.out.println(p.getObject().getName(db) + " e' gia' stato ispezionato!");
                    } else if (!p.getObject().isInspectable()) {
                        System.out.println(p.getObject().getName(db) + " non e' possibile ispezionarlo!");
                    }
                }else{
                        System.out.println("Uccidi la macchina o cripta la macchina prima di ispezionarla!");
                    }
            }
        } else if (p.getCommand().getType() == CommandType.CRIPTA) {
            boolean flagCripta = false;
            Iterator<AdvObject> it = inventario.getList().iterator();
            while (it.hasNext()) {
                try {
                    AdvObject next = it.next();
                    if (next.getId() == 4) {
                        flagCripta = true;
                    }
                } catch (NoSuchElementException ex) {
                    System.out.println("errore");
                }
            }
            if (p.getObject() != null && flagCripta == true) {
                if (getCurrentRoom().getId() == 5 && p.getObject().isScale()) {
                    if (p.getObject().isCriptable() == true && !p.getObject().isCripta()) {
                        p.getObject().setCripta(true);
                        System.out.println("Ben fatto! Utilizzando la cripta avrai il controllo delle macchina. Ora Ispeziona la macchina");
                    } else if (p.getObject().isCriptable() == true && p.getObject().isCripta() == true) {
                        System.out.println("Hai gia' il controllo di questa macchina");
                    } else if (p.getObject().isCriptable() && p.getObject().isCripta()) {
                        System.out.println(p.getObject().getName(db) + " e' gia' Criptato !");
                    } else if (!p.getObject().isCriptable()) {
                        System.out.println(p.getObject().getName(db) + " non e' possibile applicare la cripta !");
                    }
                } else if (getCurrentRoom().getId() == 5 && !p.getObject().isScale()) {
                    System.out.println("Scala il collolungo prima di utilizzare la cripta!");
                }else if(getCurrentRoom().getId() !=5 && getCurrentRoom().getId() !=7){
                    if (p.getObject().isCriptable() == true && !p.getObject().isCripta()) {
                        p.getObject().setCripta(true);
                        System.out.println("Ben fatto! Utilizzando la cripta avrai il controllo della macchina. Ora Ispezionala");
                    } else if (p.getObject().isCriptable() == true && p.getObject().isCripta() == true) {
                        System.out.println("Hai gia' il controllo di questa macchina");
                    } else if (p.getObject().isCriptable() && p.getObject().isCripta()) {
                        System.out.println(p.getObject().getName(db) + " e' gia' Criptato !");
                    } else if (!p.getObject().isCriptable()) {
                        System.out.println(p.getObject().getName(db) + " non e' possibile applicare la cripta !");
                    }
                }else if(getCurrentRoom().getId() !=5){
                    if (p.getObject().isCriptable() == true && !p.getObject().isCripta()) {
                        p.getObject().setCripta(true);
                        getCurrentRoom().Dialog();
                        Grafica.end();
                        System.exit(0);
                    }
                }
            }
        } else if (p.getCommand().getType().equals(CommandType.FOCUS)) {
                Iterator<AdvObject> it = inventario.getList().iterator();
                boolean flagFocus = false;
                while (it.hasNext()) {
                    try {
                        AdvObject next = it.next();
                        if (next.getId() == 1) {
                            flagFocus = true;
                        }
                    } catch (NoSuchElementException ex) {
                        System.out.println("Errore!");
                    }
                }
                if (p.getObject() != null && flagFocus == true) { //se il focus è nell'inventario ed è stato scritto focus macchina
                    if (p.getObject().isFocus() == true) { //se sull'oggetto è applicabile il focus
                        System.out.println(p.getObject().getName(db) + " : " + p.getObject().getDescription(db));
                        if(getCurrentRoom().getId()==2){
                            System.out.println();
                            System.out.println("|ROST: Vuoi vedere cosa c'e' al suo interno? Stai a guardare");
                            System.out.println();
                            System.out.println("+----------------------------+");
                            System.out.println("| ROST HA UCCISO IL CORSIERO |");
                            System.out.println("+----------------------------+");
                            System.out.println();
                             System.out.println("+------------------------------------------+\n");
                            System.out.println("|Suggerimento:                              |\n");
                            System.out.println("|  Puoi ispezionare il corsiero scrivendo   |\n");
                            System.out.println("|       <<ispezione + nome macchina>>       |\n");
                            System.out.println("+-------------------------------------------+");
                             System.out.println();
                            p.getObject().setKill(true);
                        }
                    } else { //se sull'oggetto non è applicabile il focus
                     System.out.println("Non e' possibile applicare il focus a questo oggetto!");

                    }
                } else if (p.getObject() == null) {
                    System.out.println("Il focus puo' essere applicato solo sulle macchine!\n" + " Specifica la macchina col comando 'focus <nome macchina>'!");
                } else if (p.getObject() != null && !flagFocus) {
                    System.out.println("il focus non e' presente ancora nel tuo inventario!");
                }

        } else if (p.getCommand().getType().equals(CommandType.PREMI)){
            boolean flag=false;
            if(p.getObject()!=null && p.getObject2()== null) {
                if (!p.getObject().isPush() && p.getObject().isPushable()) {
                    p.getObject().setPush(true);
                    if (p.getObject().getId() == 10 && getCurrentRoom().getId()==6) {
                        new TicTacGame().computerPlay();
                        setCurrentRoom(getCurrentRoom().getSouth());
                        move=true;
                    }
                }else if (p.getObject().isPushable() && p.getObject().isPush()) {
                    if (p.getObject().getId() == 10) {
                        System.out.println("La porta per entrare nel calderone e' gia' stata aperta! Vai verso sud per entraci");
                    } else {
                        System.out.println("L'oggetto e' gia' stato premuto");
                    }
                }else if(!p.getObject().isPushable() ){
                   System.out.println("Non e' possibile premere questo oggetto");
                }
            }else if(p.getObject()==null){
                System.out.println ("Specifica l'oggetto che vuoi premere");
            }
        } else if(p.getCommand().getType().equals(CommandType.COMBATTI)) {
            if (getCurrentRoom().getId() == 7 && p.getObject() == null && p.getObject2() == null) {
                boolean win;
                MiniGameBattle gameBattle = new MiniGameBattle();
                win = gameBattle.startGame();
                System.out.println();
                if (win) {
                    getCurrentRoom().setDialog(PATROOM7VINCITA);
                    System.out.println();
                    System.out.println("+----------------------------------------------------+");
                    System.out.println("| ADESSO TOCCA A TE! CRIPTA IL NUCLEO DELLA TORRE!!! |");
                    System.out.println("+----------------------------------------------------+");
                } else {
                    getCurrentRoom().setDialog(PATROOM7PERDITA);
                    getCurrentRoom().Dialog();
                    Grafica.end();
                    System.exit(0);
                }
            } else if (getCurrentRoom().getId() != 7) {
                System.out.println("Non puoi combattere con nussuno qui");
            }else{
                System.out.println("C'e' qualcosa che non ti e' chiaro");
            }
        }
        if (noroom) {
                System.out.println("Da quella parte non si può andare!!!");
        } else if (move==true) {
                System.out.println("======================================================================");
                System.out.println("                  " + getCurrentRoom().getName(db));
                System.out.println("======================================================================");
                System.out.println(getCurrentRoom().getDescription(db));
        }
    }//nextmove
}//class
