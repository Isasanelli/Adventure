/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gioco.thehuntress.type;


import com.gioco.thehuntress.database.DbClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * AdvObject class.
 */
public class AdvObject {
    
    public static final String SELECTNAME="SELECT name FROM advObjects WHERE id=?";
    public static final String SELECTDESCRIPTION ="SELECT desc FROM advObjects WHERE id=?";
    private final int id;
    private Set<String> alias;
    private boolean open = false;
    private boolean openable=false;
    private boolean scalable= false;
    private boolean scale= false;
    private boolean inspect=false;
    private boolean inspectable=false;
    private boolean focus=false;
    private boolean kill=false;
    private boolean killable=false;
    private boolean pushable=false;
    private boolean push=false;
    private boolean cripta=false;
    private boolean criptable=false;

    /**
     * AdvObject builder.
     * @param id
     */
    public AdvObject ( int id ){
        this.id = id;
    }



    public int getId() {
        return id;
    }

    /**
     * function that returns the name of the object.
     * @param db
     * @return name
     */
    public String getName(DbClass db){
        String name= getInformationAdvObject(db,SELECTNAME);
        return name;
    }

    /**
     * function that returns the description of the object.
     * @param db
     * @return description
     */
    public String getDescription(DbClass db){
        String description= getInformationAdvObject(db,SELECTDESCRIPTION);
        return description;
    }

    /**
     * function that accesses the db and executes the select.
     * @param db
     * @param select
     * @return resultSet, the information of interest
     */
    public String getInformationAdvObject(DbClass db, String select){
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

    public boolean isOpen() {
        return open;
    }
    public void setopen(boolean open){
      this.open= open;
    }

   public void setopenable(boolean openable) {
        this.openable = openable;
   }
   public boolean isOpenable(){return openable; }
    public void setKill(boolean kill){ this.kill= kill;}
    public boolean isKill(){ return kill;}
    
    public void setKillable(boolean killable){ this.killable=killable;}
    public boolean isKillable(){return killable;}

    public boolean isScalable(){ return scalable;}
    public void setScalable(boolean scalable){ this.scalable=scalable;}
    public boolean isScale(){ return scale;}
    public void setScale(Boolean scale){ this.scale=scale; }
    public boolean isInspect(){ return inspect;}
    public void  setInspect(boolean inspect){ this.inspect=inspect;}

    public boolean isInspectable() {
        return inspectable;
    }

    public void setInspectable(boolean inspectable){
        this.inspectable=inspectable;
    }

    public boolean isCripta(){ return cripta;}
    public void setCripta(Boolean cripta){ this.cripta=cripta; }

    public boolean isCriptable(){ return criptable;}
    public void setCriptable(Boolean criptable) { this.criptable=criptable; }

    public boolean isFocus(){ return focus;}
    public void setFocus(Boolean focus) { this.focus=focus; } 
   
    public  boolean isPush(){return push;}
    public void setPush(Boolean push ) {this.push=push;}

    public void setPushable(Boolean pushable) { this.pushable=pushable;}
    public Boolean isPushable(){ return pushable;}
    
    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }


    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final AdvObject other = (AdvObject) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
