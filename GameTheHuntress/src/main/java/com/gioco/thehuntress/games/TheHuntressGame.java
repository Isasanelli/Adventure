package com.gioco.thehuntress.games;

import com.gioco.thehuntress.adventure.GameDescription;
import com.gioco.thehuntress.type.*;

public class TheHuntressGame extends GameDescription {

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
            Room roomTrainingCamp = new Room(2);

         //secondo capitolo : Tribù Carja
            Room roomTend = new Room(3);
            Room roomCollolungo = new Room(4);

        //terzo capitolo: Foresta dei caduti
            Room roomDivoratuono = new Room(5);

        //quarto capitolo: Tribù di Meridiana
            Room roomCalderone = new Room(6);

            //SONO DA SETTARE LE DESCRIZIONI CON LE CARDINALITA' ALL'INTERNO DI OGNI ROOM
        //definire le stanze in cui ogni oggetto contenitore si trova una volta che andiamo a sistemare bene i capitoli

        /**
         * AdvObject
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
         * AdvObjectContainer
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


    }


}
      
    
        
        /*maps
        kitchen.setEast(livingRoom);
        livingRoom.setNorth(hall);
        livingRoom.setWest(kitchen);
        hall.setSouth(livingRoom);
        hall.setWest(yourRoom);
        hall.setNorth(bathroom);
        bathroom.setSouth(hall);
        yourRoom.setEast(hall);
        getRooms().add(kitchen);
        getRooms().add(livingRoom);
        getRooms().add(hall);
        getRooms().add(bathroom);
        getRooms().add(yourRoom);


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



