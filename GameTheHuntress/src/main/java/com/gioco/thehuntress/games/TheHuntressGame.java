package com.gioco.thehuntress.games;

import com.gioco.thehuntress.adventure.GameDescription;
import com.gioco.thehuntress.type.*;

public class TheHuntressGame extends GameDescription {

    public static final String PATROOM1="file//roomGarden.txt";
    public static final String PATROOM2="file//roomTrainingCamp.txt";
    public static final String PATROOM3="file//roomValleyOfDeath.txt";
    public static final String PATROOM4="file//roomTend.txt";
    @Override
    public void init() throws Exception {
        /**
         * command
         */
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);

        Command inventory = new Command(CommandType.INVENTARIO, "inventario");
        inventory.setAlias(new String[]{"inv"});
        getCommands().add(inventory);

        Command sud = new Command(CommandType.SUD, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);

        Command est = new Command(CommandType.EST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);

        Command ovest = new Command(CommandType.OVEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);

        Command end = new Command(CommandType.ESCI, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "exit"});
        getCommands().add(end);

        Command look = new Command(CommandType.GUARDA, "guarda");
        look.setAlias(new String[]{ "vedi", "descrivi", "osserva"});
        getCommands().add(look);

        Command pickup = new Command(CommandType.PRENDI, "raccogli");
        pickup.setAlias(new String[]{"prendi", "r", "R"});
        getCommands().add(pickup);

        Command control = new Command(CommandType.CRIPTA, "Cripta");
        control.setAlias(new String[]{"corrompi", "controlla", "C", "c"});
        getCommands().add(control);

        Command push = new Command(CommandType.PREMI, "premi");
        push.setAlias(new String[]{"spingi", "attiva", "pre", "Pre"});
        getCommands().add(push);

        Command leave = new Command(CommandType.LASCIA, "lascia");
        leave.setAlias(new String[]{"la", "La"});
        getCommands().add(leave);

        Command hideyourself = new Command(CommandType.NASCONDITI, "nasconditi");
        hideyourself.setAlias(new String[]{"giu", "silenzio", "g"});
        getCommands().add(hideyourself);

        /*Command focus = new Command(CommandType.FOCUS, "Focus");
        focus.setAlias(new String[]{"f", "F", "descrivi"});
        getCommands().add(focus);*/

        /**
         * Rooms
         */
        //primo capitolo:Tribù sheeva
            Room roomGarden= new Room(1);
            roomGarden.setDialog(PATROOM1);
            roomGarden.setNorthInTheRoom(new String[] {"Da li si va verso il campo d'addestramento", "Il campo d'addestramento è da quella parte"});
            roomGarden.setSouthInTheRoom(new String[] {"Non c'è nulla","E' solo un muro oltre la siepe, non ti interessa"});
            roomGarden.setEastInTheRoom(new String[]  {"Questa foresta ha troppi alberi per i miei gusti","Non c'è nulla da guardare li"});
            roomGarden.setWestInTheRoom(new String[]  {"Non c'è nulla che ti possa interessare. Parla con Rost se non l'hai già fatto","Non c'e' nulla qui"});

            Room roomTrainingCamp = new Room(2);
            roomTrainingCamp.setDialog(PATROOM2);
            roomTrainingCamp.setNorthInTheRoom(new String[] {"Da li si va verso la valle dei caduti","la valle dei caduti è da quella parte"});
            roomTrainingCamp.setSouthInTheRoom(new String[] {"Da li si si ritorna in giardino","Il giardino è da quella parte"});
            roomTrainingCamp.setEastInTheRoom(new String[] {"La mandria di biomacchhine è ancora lì...saranno stanche?","Qui c'è il corsiero che hai ucciso. Non c'è nulla da guadare"});
            roomTrainingCamp.setWestInTheRoom(new String[] {"Non c'è nulla","Non c'è nulla per te"});

            Room roomValleyOfDeath=new Room(3);
            roomValleyOfDeath.setDialog(PATROOM3);
            roomValleyOfDeath.setNorthInTheRoom(new String[] {"Non puoi andare da quella parte","Non c'è niente per te"});
            roomValleyOfDeath.setSouthInTheRoom(new String[] {"Da li si va verso il campo d'addestramento","il campo d'addestramento è da quella parte"});
            roomValleyOfDeath.setEastInTheRoom(new String[] {"Da li si va verso la tende del Re Sole","La tenda del Re sole è da quella parte"});
            roomValleyOfDeath.setWestInTheRoom(new String[] {"Da li non si puà andare, c'è solo un ruscello","Che bello questo ruscello"});


         //secondo capitolo : Tribù Carja
            Room roomTend = new Room(4);
            roomTend.setDialog(PATROOM4);
            roomTend.setNorthInTheRoom(new String[] {"La finestra: cos'e' tutto quel movimento?Forse è meglio guardare", "c'è una finestra"});
            roomTend.setSouthInTheRoom(new String[] {"Il fuoco del camino è caldo e accogliente","Il fuoco è ancora bello presente"});
            roomTend.setEastInTheRoom(new String[] {"Da li si va verso il Campo del collolungo", "il Campo del collolungo è da quella parte"});
            roomTend.setWestInTheRoom(new String[] {"Da li si va verso la valle dei caduti ","la valle dei caduti è da quella parte"});

            Room roomCollolungo = new Room(5);
            roomCollolungo.setNorthInTheRoom(new String[] {"Trovi il collolungo ","La statua del collolungo"});
            roomCollolungo.setSouthInTheRoom(new String[] {"Da quella parte c'è Meridiana  ","Il calderone è da quella parte "});
            roomCollolungo.setEastInTheRoom(new String[] {"Li non puoi andare, meglio non esporsi. Non sei ancora in grado di volare","non c'è nulla che ti possa interessare, a meno che tu non voglia morire"});
            roomCollolungo.setWestInTheRoom(new String[] {"Da li si va verso la tenda del Re Sole","La tenda del Re Sole è da quella parte"});


            //SONO DA SETTARE LE DESCRIZIONI CON LE CARDINALITA' ALL'INTERNO DELLE ROOMS DEL CAPITOLO 3

        /**
         * Definizione oggetti AdvObject.
         */
        AdvObject focus = new AdvObject(1);
        focus.setAlias(new String[] {"focus","foc"});


        AdvObject batteria = new AdvObject(2);
        batteria.setAlias(new String[] {"batteria","batt","vampa"});

        AdvObject arco = new AdvObject(3);
        arco.setAlias(new String[] {"arco","arc"});

        AdvObject lancia = new AdvObject(4);
        lancia.setAlias(new String[] {"lancia","lanc","cripta","crip"});

        AdvObject map= new AdvObject(5);
        map.setAlias(new String[] {"mappa","map","m"});

        /**
         * Definizione oggetti AdvObjectContainer.
         */

        AdvObjectContainer corsiero= new AdvObjectContainer(1);
        corsiero.setAlias(new String[] {"corsiero","cors"});
        corsiero.setopenable(true);
        corsiero.add(batteria);

        AdvObjectContainer collolungo= new AdvObjectContainer(2);
        collolungo.setAlias(new String[] {"collolungo","collo", "coll", "lungo"});
        collolungo.setopenable(true);
        collolungo.setScalable(true);
        collolungo.add(map);

        AdvObjectContainer avistempesta= new AdvObjectContainer(3);
        avistempesta.setAlias(new String[] {"avistempesta","avi"});
        avistempesta.setopenable(true);
        avistempesta.add(batteria);

        AdvObjectContainer giftBox= new AdvObjectContainer(4);
        giftBox.setAlias(new String[] {"pacco regalo","pacco","regalo"});
        giftBox.setopenable(true);
        giftBox.add(focus);

        /**
         * Assegnazione degli oggetti alle rispettive stanze.
         */
        roomGarden.getObjects().add(giftBox);
        roomGarden.getObjects().add(arco);
        roomTrainingCamp.getObjects().add(corsiero);
        roomTend.getObjects().add(lancia);
        roomCollolungo.getObjects().add(collolungo);
        //manca avistempesta e da sistemare le rooms

        /**
         * Mappa.
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

        /**
         * settaggio stanza iniziale
         */
        setCurrentRoom(roomGarden);

    }


}

/*
        //obejcts
        AdvObject battery = new AdvObject(1, "batteria", "Un pacco di batterie, chissà se sono cariche.");
        battery.setAlias(new String[]{"batterie", "pile", "pila"});
        bathroom.getObjects().add(battery);
        AdvObjectContainer wardrobe = new AdvObjectContainer(2, "armadio", "Un semplice armadio.");
        wardrobe.setAlias(new String[]{"guardaroba", "vestiario"});
        wardrobe.setOpenable(true);
        wardrobe.setPickupable(false);
        wardrobe.setOpen(false);
        yourRoom.getObjects().add(wardrobe);
        AdvObject toy = new AdvObject(3, "giocattolo", "Il gioco che ti ha regalato zia Lina.");
        toy.setAlias(new String[]{"gioco", "robot"});
        toy.setPushable(true);
        toy.setPush(false);
        wardrobe.add(toy);
        //set starting room
        setCurrentRoom(hall);


    }  */
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



