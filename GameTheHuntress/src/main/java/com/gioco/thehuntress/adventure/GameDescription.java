package com.gioco.thehuntress.adventure;


import com.gioco.thehuntress.database.DbClass;
import com.gioco.thehuntress.parser.ParserOutput;
import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;
import com.gioco.thehuntress.type.Inventory;
import com.gioco.thehuntress.type.Room;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 *  GameDescription is an abstract class that contains the abstract
 *  methods for handling commands and the data structures of containing the rooms, commands and inventory.
 */
public abstract class GameDescription{

    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<AdvObject> objects = new ArrayList<>();
    
    private final Inventory inventory = new Inventory();

    private Room currentRoom;


    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public Inventory getInventory(){return inventory;}

    public List<AdvObject> getObjects() {
        return objects;
    }

    public abstract void init();


   public abstract void nextMove(DbClass db, ParserOutput p, PrintStream out) throws SQLException;

}


