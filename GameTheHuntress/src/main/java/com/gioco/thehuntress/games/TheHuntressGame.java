package com.gioco.thehuntress.games;

import com.gioco.thehuntress.adventure.GameDescription;
import com.gioco.thehuntress.eventi.DbClass;
import com.gioco.thehuntress.eventi.Eventi;
import com.gioco.thehuntress.eventi.MapGraphic;
import com.gioco.thehuntress.parser.ParserOutput;
import com.gioco.thehuntress.type.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class TheHuntressGame extends GameDescription {

    public static final String PATROOM1 = "file//roomGarden.txt";
    public static final String PATROOM2 = "file//roomTrainingCamp.txt";
    public static final String PATROOM3 = "file//roomValleyOfDeath.txt";
    public static final String PATROOM4 = "file//roomTend.txt";
    public MapGraphic mapGraphic = new MapGraphic();

    @Override
    public void init() throws Exception {

        //Comandi per l'interazione tra le rooms

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
        westOutTheRoom.setAlias(new String[]{ "ovest"});
        getCommands().add(westOutTheRoom);

        //Comandi per l'interazione dentro la stanza

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

        //Comandi generali
        Command mapCommand = new Command(CommandType.MAPPA, "mappa");
        mapCommand.setAlias(new String[]{"map"});
        getCommands().add(mapCommand);

        Command end = new Command(CommandType.ESCI, "esci");
        end.setAlias(new String[]{"fine", "fine partita", "f","esci"});
        getCommands().add(end);

        Command talk = new Command(CommandType.PARLA, "parla");
        talk.setAlias(new String[]{"parl", "p"});
        getCommands().add(talk);


        Command look = new Command(CommandType.GUARDA, "guarda");
        look.setAlias(new String[]{ "gua", "vedi", "descrivi", "osserva"});
        getCommands().add(look);

        Command rules = new Command(CommandType.REGOLE, "regole");
        look.setAlias((new String[]{"re", "regole"}));
        getCommands().add(rules);

        Command commands = new Command(CommandType.COMANDI, "comandi");
        commands.setAlias(new String[]{"com"});
        getCommands().add(commands);

        Command inventory = new Command(CommandType.INVENTARIO, "inventario");
        commands.setAlias(new String[]{"inv"});
        getCommands().add((inventory));

        //Comandi sugli oggetti
        Command open = new Command(CommandType.APRI, "apri");
        open.setAlias(new String[]{"ap"});
        getCommands().add(open);

        Command use = new Command(CommandType.USA, "usa");
        use.setAlias(new String[]{"us",  "u"});
        getCommands().add(use);

        Command inspects = new Command(CommandType.ISPEZIONA, "ispeziona");
        inspects.setAlias(new String[]{"ispe", "isp"});
        getCommands().add(inspects);

        Command scalable = new Command(CommandType.SCALA, "scala");
        scalable.setAlias(new String[]{ "sal",  "sca"});
        getCommands().add(scalable);

        //comando per il combattimento
        Command cripta =new Command (CommandType.CRIPTA,"cripta");
        cripta.setAlias(new String []{"controllo","cripta"});
         getCommands().add(cripta);

        /*Command pickup = new Command(CommandType.PRENDI, "raccogli");
        pickup.setAlias(new String[]{"prendi", "r", "R"});
        getCommands().add(pickup);

        /**
         * Rooms
         */
        //primo capitolo:Tribù sheeva
        Room roomGarden = new Room(1);
        roomGarden.setDialog(PATROOM1);
        roomGarden.setNorthInTheRoom(new String[]{"Da li si va verso il campo d'addestramento", "Il campo d'addestramento è da quella parte"});
        roomGarden.setSouthInTheRoom(new String[]{"Non c'è nulla", "E' solo un muro oltre la siepe, non ti interessa"});
        roomGarden.setEastInTheRoom(new String[]{"Questa foresta ha troppi alberi per i miei gusti", "Non c'è nulla da guardare li"});
        roomGarden.setWestInTheRoom(new String[]{"Non c'è nulla che ti possa interessare. Parla con Rost se non l'hai già fatto", "Non c'e' nulla qui"});

        Room roomTrainingCamp = new Room(2);
        roomTrainingCamp.setDialog(PATROOM2);
        roomTrainingCamp.setNorthInTheRoom(new String[]{"Da li si va verso la valle dei caduti", "la valle dei caduti è da quella parte"});
        roomTrainingCamp.setSouthInTheRoom(new String[]{"Da li si si ritorna in giardino", "Il giardino è da quella parte"});
        roomTrainingCamp.setEastInTheRoom(new String[]{"C'è una mandria di biomacchine da quella parte. Facciamo attenzione ", "Qui c'è il corsiero che hai ucciso. Non c'è nulla da guadare"});
        roomTrainingCamp.setWestInTheRoom(new String[]{"Non c'è nulla", "Non c'è nulla per te"});

        Room roomValleyOfDeath = new Room(3);
        roomValleyOfDeath.setDialog(PATROOM3);
        roomValleyOfDeath.setNorthInTheRoom(new String[]{"Non puoi andare da quella parte", "Non c'è niente per te"});
        roomValleyOfDeath.setSouthInTheRoom(new String[]{"Da li si va verso il campo d'addestramento", "il campo d'addestramento è da quella parte"});
        roomValleyOfDeath.setEastInTheRoom(new String[]{"Da li si va verso la tende del Re Sole", "La tenda del Re sole è da quella parte"});
        roomValleyOfDeath.setWestInTheRoom(new String[]{"Da li non si puà andare, c'è solo un ruscello", "Che bello questo ruscello"});


        //secondo capitolo : Tribù Carja
        Room roomTend = new Room(4);
        roomTend.setDialog(PATROOM4);
        roomTend.setNorthInTheRoom(new String[]{"La finestra: cos'e' tutto quel movimento?Forse è meglio guardare", "c'è una finestra"});
        roomTend.setSouthInTheRoom(new String[]{"Il fuoco del camino è caldo e accogliente", "Il fuoco è ancora bello presente"});
        roomTend.setEastInTheRoom(new String[]{"Da li si va verso il Campo del collolungo", "il Campo del collolungo è da quella parte"});
        roomTend.setWestInTheRoom(new String[]{"Da li si va verso la valle dei caduti ", "la valle dei caduti è da quella parte"});

        Room roomCollolungo = new Room(5);
        roomCollolungo.setNorthInTheRoom(new String[]{"Trovi il collolungo ", "La statua del collolungo"});
        roomCollolungo.setSouthInTheRoom(new String[]{"Da quella parte c'è Meridiana  ", "Il calderone è da quella parte "});
        roomCollolungo.setEastInTheRoom(new String[]{"Li non puoi andare, meglio non esporsi. Non sei ancora in grado di volare", "non c'è nulla che ti possa interessare, a meno che tu non voglia morire"});
        roomCollolungo.setWestInTheRoom(new String[]{"Da li si va verso la tenda del Re Sole", "La tenda del Re Sole è da quella parte"});


        //SONO DA SETTARE LE DESCRIZIONI CON LE CARDINALITA' ALL'INTERNO DELLE ROOMS DEL CAPITOLO 3

        /*
          Definizione oggetti AdvObject.
         */
        AdvObject focus = new AdvObject(1);
        focus.setAlias(new String[]{"focus", "foc"});

        AdvObject batteria = new AdvObject(2);
        batteria.setAlias(new String[]{"batteria", "batt", "vampa"});

        AdvObject arco = new AdvObject(3);
        arco.setAlias(new String[]{"arco", "arc"});
        arco.setUsable(true);

        AdvObject lancia = new AdvObject(4);
        lancia.setAlias(new String[]{"lancia", "lanc", "cripta", "crip"});

        AdvObject map = new AdvObject(5);
        map.setAlias(new String[]{"mappa", "map", "m"});

        /*
          Definizione oggetti AdvObjectContainer.
         */

        AdvObjectContainer corsiero = new AdvObjectContainer(1);
        corsiero.setAlias(new String[]{"corsiero", "cors"});
        corsiero.setInspectable(true);
        corsiero.add(batteria);

        AdvObjectContainer collolungo = new AdvObjectContainer(2);
        collolungo.setAlias(new String[]{"collolungo", "collo", "coll", "lungo"});
        collolungo.setInspectable(true);
        collolungo.setScalable(true);
        collolungo.add(map);

        AdvObjectContainer avistempesta = new AdvObjectContainer(3);
        avistempesta.setAlias(new String[]{"avistempesta", "avi"});
        avistempesta.setInspectable(true);
        avistempesta.add(batteria);

        AdvObjectContainer giftBox = new AdvObjectContainer(4);
        giftBox.setAlias(new String[]{"pacco regalo", "pacco", "regalo"});
        giftBox.setopenable(true);
        giftBox.add(focus);

        /*
          Assegnazione degli oggetti alle rispettive stanze.
         */
        roomGarden.getObjects().add(giftBox);
        roomGarden.getObjects().add(arco);
        roomTrainingCamp.getObjects().add(corsiero);
        roomTend.getObjects().add(lancia);
        roomCollolungo.getObjects().add(collolungo);
        //manca avistempesta e da sistemare le rooms

        /*
          Mappa.
         */

        roomGarden.setNorth(roomTrainingCamp);

        roomTrainingCamp.setSouth(roomGarden);
        roomTrainingCamp.setNorth(roomValleyOfDeath);

        roomValleyOfDeath.setSouth(roomTrainingCamp);
        roomValleyOfDeath.setEast(roomTend);

        roomTend.setWest(roomValleyOfDeath);
        roomTend.setEast(roomCollolungo);

        roomCollolungo.setWest(roomTend);


        getRooms().add(roomGarden);
        getRooms().add(roomTrainingCamp);
        getRooms().add(roomValleyOfDeath);
        getRooms().add(roomTend);
        getRooms().add(roomCollolungo);

        /*
          settaggio stanza iniziale
         */
        setCurrentRoom(roomGarden);
        roomGarden.setFirstTimeHere(true);

    }

    @Override
    public void nextMove(DbClass db,  ParserOutput p, PrintStream out) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare ! Prova con un altro comando ");
        } else {
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getType() == CommandType.NORD) {
                if (getCurrentRoom().getNorth() != null) {
                    setCurrentRoom(getCurrentRoom().getNorth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.SUD) {
                if (getCurrentRoom().getSouth() != null) {
                    setCurrentRoom(getCurrentRoom().getSouth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.EST) {
                if (getCurrentRoom().getEast() != null) {
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.OVEST) {
                if (getCurrentRoom().getWest() != null) {
                    setCurrentRoom(getCurrentRoom().getWest());
                    move = true;
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
                mapGraphic.createMap();
            } else if (p.getCommand().getType() == CommandType.GUARDA) { //si riferisce al guarda dentro alla stanza (look)
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
                if (getCurrentRoom().getFirstTimeHere()) {
                    getCurrentRoom().Dialog();
                } else {
                    out.println("NON C'E' NESSUNO CON CUI PARLARE QUI !");
                }
            } else if (p.getCommand().getType() == CommandType.INVENTARIO) {
                System.out.println("===========================================================");
                System.out.println("Nel tuo inventario ci sono:");
                for (AdvObject object : getInventory()) {
                    System.out.println(object.getName(db) + ": \n" + object.getDescription(db));
                }
                System.out.println("===========================================================");
            } else if (p.getCommand().getType() == CommandType.APRI) {
                if (p.getObject()==null &&  p.getInvObject()==null){
                    System.out.println("Non c'e' nulla da aprire qui ");
                }else{
                    if (p.getObject()!=null){
                        if(p.getObject().isOpenable() && !p.getObject().isOpen()){
                            if (p.getObject() instanceof AdvObjectContainer){
                                out.println("HAI APERTO: " +p.getObject().getName(db));
                                AdvObjectContainer c =(AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()){
                                    out.println(c.getName(db)+"contiene:");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    while (it.hasNext()){
                                        AdvObject next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.println(""+next.getName(db));
                                        it.remove();
                                    }
                                    out.println();
                                }
                            }else {
                                out.println("Hai aperto :"+ p.getObject().getName (db));
                                p.getObject().setopen (true);
                            }

                        }else{
                            out.println("non puoi aprire questo oggetto ");
                        }
                        if (p.getInvObject()!=null) {
                            if (p.getInvObject().isOpenable() && !p.getInvObject().isOpen() ) {
                              if(p.getInvObject() instanceof  AdvObjectContainer) {
                                  AdvObjectContainer c =(AdvObjectContainer) p.getInvObject();
                                  if (!c.getList().isEmpty()){
                                      out.print(c.getName(db)+ "contiene:");
                                    Iterator <AdvObject> it= c.getList().iterator();
                                    while(it.hasNext()){
                                        AdvObject  next= it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getName(db));
                                        it.remove();
                                    }
                                    out.println();
                                }
                            }else{
                                p.getInvObject().setopen(true);
                            }
                            out.println("hai aperto nel tuo inventario :" +p.getInvObject().getName(db));
                            }else{
                                out.println("non puoi aprire questo oggetto");

                            }
                        }
                    }
                }
                }else if (p.getCommand().getType() == CommandType.SCALA) {
                    if (p.getObject() != null) {
                        if(p.getObject().isScalable()){
                            p.getObject().setScalable(true);
                            System.out.println("Sei in cima a collo lungo");
                            System.out.println("Adesso puoi usare la cripta! \n" + "usa il comando CRIPTA per il controllo della macchina \n");
                            //...
                        }else{
                            System.out.println("non posso salire su " + p.getObject().getName(db));
                        }
                    }else{
                        System.out.println("Non trovo nulla qui su cui salire!");
                    }
                } else if (p.getCommand().getType() == CommandType.ISPEZIONA) {
               /* if (p.getObject() != null) {
                    if (p.getObject().isInspectable() && !p.getObject().isInspect()) {
                        if (p.getObject() instanceof AdvObjectContainer) {
                            System.out.println("Hai ispezionato la macchina, hai trovato: " + p.getObject().getName(db));
                            AdvObjectContainer advObjectContainer = (AdvObjectContainer) p.getObject();
                            if (!advObjectContainer.getList().isEmpty()) {
                                System.out.println(advObjectContainer.getName(db) + "contiene: \n");
                                Iterator<AdvObject> iterator = advObjectContainer.getList().iterator();
                                while (iterator.hasNext()) {
                                    AdvObject next = iterator.next();
                                    getCurrentRoom().getObjects().add(next);
                                    System.out.println(" " + next.getName(db));
                                    iterator.remove();
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.println("Hai aperto: " + p.getObject().getName(db));
                            p.getObject().setInspect(true);
                        }
                    }
                }
                if (p.getInvObject() != null) {
                    if (p.getInvObject().isInspectable() && p.getInvObject().isInspect() == false) {
                        if (p.getInvObject() instanceof AdvObjectContainer) {
                            AdvObjectContainer advObjectContainer = (AdvObjectContainer) p.getInvObject();
                            if (!advObjectContainer.getList().isEmpty()) {
                                System.out.println(advObjectContainer.getName(db) + "contiene: ");
                                Iterator<AdvObject> iterator = advObjectContainer.getList().iterator();
                                while (iterator.hasNext())
                            }
                        }
                    }
                }*/
                }
                if (noroom) {
                    out.println("Da quella parte non si può andare c'è un muro!\n Non hai ancora acquisito i poteri per oltrepassare i muri...");
                } else if (move) {
                    getCurrentRoom().setFirstTimeHere(true);
                    out.println(getCurrentRoom().getName(db));
                    out.println("================================================");
                    out.println(getCurrentRoom().getDescription(db));
                }
            }
        }//nextmove
    }//class


/*
    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getType() == CommandType.NORD) {
                if (getCurrentRoom().getNorth() != null) {
                    setCurrentRoom(getCurrentRoom().getNorth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                if (getCurrentRoom().getSouth() != null) {
                    setCurrentRoom(getCurrentRoom().getSouth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.EAST) {
                if (getCurrentRoom().getEast() != null) {
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.WEST) {
                if (getCurrentRoom().getWest() != null) {
                    setCurrentRoom(getCurrentRoom().getWest());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.INVENTORY) {
                out.println("Nel tuo inventario ci sono:");
                for (AdvObject o : getInventory()) {
                    out.println(o.getName() + ": " + o.getDescription());
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (getCurrentRoom().getLook() != null) {
                    out.println(getCurrentRoom().getLook());
                } else {
                    out.println("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        out.println("Hai raccolto: " + p.getObject().getDescription());
                    } else {
                        out.println("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    out.println("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                /*ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                 * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                 * Potrebbe non esssere la soluzione ottimale.
                 */
       /*         if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                            if (p.getObject() instanceof AdvObjectContainer) {
                                out.println("Hai aperto: " + p.getObject().getName());
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        AdvObject next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.print(" " + next.getName());
                                        it.remove();
                                    }
                                    out.println();
                                }
                            } else {
                                out.println("Hai aperto: " + p.getObject().getName());
                                p.getObject().setOpen(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                            if (p.getInvObject() instanceof AdvObjectContainer) {
                                AdvObjectContainer c = (AdvObjectContainer) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<AdvObject> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        AdvObject next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getName());
                                        it.remove();
                                    }
                                    out.println();
                                }
                            } else {
                                p.getInvObject().setOpen(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.PUSH) {
                //ricerca oggetti pushabili
                if (p.getObject() != null && p.getObject().isPushable()) {
                    out.println("Hai premuto: " + p.getObject().getName());
                    if (p.getObject().getId() == 3) {
                        tictac.esegui();
                    }
                } else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
                    out.println("Hai premuto: " + p.getInvObject().getName());
                    if (p.getInvObject().getId() == 3) {
                        //end(out);
                        tictac.esegui();
                    }
                } else {
                    out.println("Non ci sono oggetti che puoi premere qui.");
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
            } else if (move) {
                out.println(getCurrentRoom().getName());
                out.println("================================================");
                out.println(getCurrentRoom().getDescription());
            }
        }
    }

    private void end(PrintStream out) {
        out.println("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }

}
        */







