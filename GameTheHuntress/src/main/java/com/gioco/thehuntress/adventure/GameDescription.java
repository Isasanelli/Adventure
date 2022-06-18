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

    private final List<AdvObject> inventory = new ArrayList<>();
    
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

    public List<AdvObject> getInventory() {
        return inventory;
    }

    public abstract void init() throws Exception;


   public abstract void nextMove(DbClass db, ParserOutput p, PrintStream out);



    /*public int getStartingRoomId() {
        return startingRoomId;
    }

    public void setStartingRoomId(int startingRoomId) {
        this.startingRoomId = startingRoomId;
    }

     public void printAdjRooms() {
        System.out.println("\nLuoghi adiacenti: ");
        if(getCurrentRoom().getNorth()!= null) {
            System.out.println("NORD: "+getCurrentRoom().getNorth().getName());
        }
        if(getCurrentRoom().getEast()!= null) {
            System.out.println("EST: "+getCurrentRoom().getEast().getName());
        }
        if(getCurrentRoom().getSouth()!= null) {
            System.out.println("SUD: "+getCurrentRoom().getSouth().getName());
        }
        if(getCurrentRoom().getWest()!= null) {
            System.out.println("OVEST: "+getCurrentRoom().getWest().getName());
        }*/
}


