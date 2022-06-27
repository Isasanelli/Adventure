package com.gioco.thehuntress.type;

import com.gioco.thehuntress.database.DbClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gioco.thehuntress.eventi.Eventi.readFileDialog;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * Room class.
 */
public class Room {
    private final int id;
    public static final String SELECTNAME="SELECT name FROM rooms WHERE id=?";
    public static final String SELECTDESCRIPTION="SELECT desc FROM rooms WHERE id=?";
    public static final String SELECTDESCRIPTIONRETURN="SELECT descReturn FROM rooms WHERE id=?";
    public static final String SELECTLOOK="SELECT look FROM rooms WHERE id=?";
    private boolean firstTimeHere= true; //attribute that will have value true if the user has to access the room for the first time, false value otherwise
    private Room south= null;
    private Room north=null;
    private Room east= null;
    private Room west= null;
    private  String[] southInTheRoom={"",""};
    private  String[] northInTheRoom= {"",""};
    private  String[] eastInTheRoom= {"",""};
    private String[] westInTheRoom={"",""};
    private final List<AdvObject> objects= new ArrayList<>();

    private String dialogPat = null; //attribute that will contain the room dialogue

    /**
     * Room builder
     * @param id
     */
    public Room(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    /**
     * function that returns the name of the room.
     * @param db
     * @return name
     */
    public String getName(DbClass db){
        String name =getInformationRoom(db, SELECTNAME);
        return name;
    }

    /**
     * function that returns the description of the room.
     * @param db
     * @return description
     */

    public String getDescription(DbClass db){
        String description="";
        if(getFirstTimeHere()){
            description= getInformationRoom(db,SELECTDESCRIPTION);
        } else{
            description= getInformationRoom(db,SELECTDESCRIPTIONRETURN);
        }
       return description;
    }

    /**
     * function that returns the look of the room.
     * @param db
     * @return look
     */
    public String getLook(DbClass db){
        String look= "";
        if (getFirstTimeHere()){
            look= getInformationRoom(db,SELECTLOOK);
        }else{
            look= getInformationRoom(db,SELECTDESCRIPTIONRETURN);
        }
        return look;
    }

    /**
     * function that accesses the db and executes the select.
     * @param db
     * @param select
     * @return String, the information of interest
     */
    public String getInformationRoom(DbClass db, String select){
        String resultSelect= "";
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

    public String getDialog(){
        return dialogPat;
    }
    

    public void setDialog(String dialogPat) {
        this.dialogPat = dialogPat;
    }

    /**
     * method that reads the dialogue of the room.
     */
    public void Dialog(){
        if(getDialog()== null){
            System.out.println("Non c'e' nessuno con cui parlare");
        }else{
            readFileDialog(getDialog());
        }
    }

    public boolean getFirstTimeHere(){
        return firstTimeHere;
    }

    public void setFirstTimeHere(Boolean firstTimeHere){
        this.firstTimeHere= firstTimeHere;
    }

    public Room getSouth() {
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

    public String getNorthInTheRoom(){
        if(getFirstTimeHere()){
            return northInTheRoom[0];
        }else{
            return northInTheRoom[1];
        }
    }

    public void setNorthInTheRoom(String[] northInTheRoom){
        this.northInTheRoom = northInTheRoom;
    }

    public String getSouthInTheRoom(){
        if(getFirstTimeHere()){
            return southInTheRoom[0];
        }else{
            return southInTheRoom[1];
        }
    }

    public void setSouthInTheRoom(String[] southInTheRoom){
        this.southInTheRoom= southInTheRoom;
    }

    public String getEastInTheRoom(){
        if(getFirstTimeHere()){
            return eastInTheRoom[0];
        }else{
            return eastInTheRoom[1];
        }
        
    }

    public void setEastInTheRoom(String[] eastInTheRoom){
        this.eastInTheRoom=eastInTheRoom;
    }

    public String getWestInTheRoom(){
        if(getFirstTimeHere()){
            return westInTheRoom[0];
        }else{
            return westInTheRoom[1];
        }
        
    }

    public void setWestInTheRoom(String[] westInTheRoom){
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
