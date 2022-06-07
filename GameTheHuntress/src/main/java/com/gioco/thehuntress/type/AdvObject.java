/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gioco.thehuntress.type;


import com.gioco.thehuntress.eventi.DbClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class AdvObject {
    
    public static final String SELECTNAME="SELECT name FROM advObjects WHERE id=?";
    private final int id;
    private Set<String> alias;
    private boolean active = false;
    private boolean pickupable = false;
    private boolean open = false;

    private boolean scalable= false;  //scalabile, serve per il collolungo


    public AdvObject ( int id ){
        this.id = id;
    }


    //metodi
    public int getId() {
        return id;
    }

    public String getName(){
        String name= new String();
        try {
            Properties prop = DbClass.properties();
            Connection conn=DbClass.connection(prop);
            ResultSet rs=DbClass.readFromDb(SELECTNAME,conn,getId());
            while(rs.next()){
                name= rs.getString(1);
            }
            rs.close();
        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ":" + ex.getMessage());
        }
        return name;
    }

    public boolean isOpen() {
        return open;
    }

   public void setopenable(boolean open) {
        this.open = open;
   }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable (boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isScalable(){ return scalable;}
    public void setScalable(boolean scalable){ this.scalable=scalable;}

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
   // public void setVisible();

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
