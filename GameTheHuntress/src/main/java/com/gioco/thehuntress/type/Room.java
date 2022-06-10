package com.gioco.thehuntress.type;

import com.gioco.thehuntress.eventi.DbClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int id;
    public static final String SELECTNAME="SELECT name FROM rooms WHERE id=?";
    public static final String SELECTDESCRIPTION="SELECT desc FROM rooms WHERE id=?";
    public static final String SELECTLOOK="SELECT look FROM rooms WHERE id=?";
    private boolean visible = true;
    /*private Room south= null;
    private Room north=null;
    private Room east= null;
    private Room west= null;*/
    private  String southInTheRoom= new String();
    private  String northInTheRoom= new String();
    private  String eastInTheRoom= new String();
    private String westInTheRoom= new String();
    private final List<AdvObject> objects= new ArrayList<>();



    public Room(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(DbClass db){
        String name =getInformationRoom(db, SELECTNAME);
        return name;
    }

    public String getDescription(DbClass db){
        String description= getInformationRoom(db,SELECTDESCRIPTION);
        return description;
    }

    public String getLook(DbClass db){
        String look= getInformationRoom(db,SELECTLOOK);
        return look;
    }

    public String getInformationRoom(DbClass db, String select){
        String resultSelect= new String();
        try{
            ResultSet rs= db.readFromDb(select,getId());
            while(rs.next()){
                resultSelect= rs.getString(1);
            }
            rs.close();
        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
        return resultSelect;
    }


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /*public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }
     */

    /**
     * servono per rendere dinamica a stanza
     */
    public String getNorthInTheRoom(){
        return northInTheRoom;
    }

    public void setNorthInTheRoom(String northInTheRoom){
        this.northInTheRoom = northInTheRoom;
    }

    public String getSouthInTheRoom(){
        return southInTheRoom;
    }

    public void setSouthInTheRoom(String southInTheRoom){
        this.southInTheRoom= southInTheRoom;
    }

    public String getEastInTheRoom(){
        return eastInTheRoom;
    }

    public void setEastInTheRoom(String eastInTheRoom){
        this.eastInTheRoom=eastInTheRoom;
    }

    public String getWestInTheRoom(){
        return westInTheRoom;
    }

    public void setWestInTheRoom(String westInTheRoom){
        this.westInTheRoom= westInTheRoom;
    }




    public List<AdvObject> getObjects() {
        return objects;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


}
