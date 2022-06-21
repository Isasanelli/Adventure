package com.gioco.thehuntress.adventure;


import com.gioco.thehuntress.eventi.DbClass;
import com.gioco.thehuntress.parser.ParserOutput;
import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;
import com.gioco.thehuntress.type.Inventory;
import com.gioco.thehuntress.type.Room;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class GameDescription{

    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<AdvObject> objects = new ArrayList<>();
    
    public static Inventory inventario = new Inventory();

    private Room currentRoom;

    //private int startingRoomId;

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

    public List<AdvObject> getObjects() {
        return objects;
    }

    public abstract void init() throws Exception;


   public abstract void nextMove(DbClass db, ParserOutput p, PrintStream out);

}


