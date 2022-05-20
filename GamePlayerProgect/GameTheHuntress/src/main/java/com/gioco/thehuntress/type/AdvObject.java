/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gioco.thehuntress.type;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class AdvObject {
    
    //definiamo gli attributi della classe oggetto 
    private final int id; 
    private String name;
    private String description;
    private Set<String> alias;
    private boolean active = false;
    private boolean pickupable = false;
    private boolean open = false; 

    //costruttori

    public AdvObject ( int id ){
        this.id = id; 
    }
    
    public AdvObject ( int id, String name){
        this.id = id; 
        this.name = name;
    }
    
    public AdvObject ( int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        
    }
    
    public AdvObject ( int id, String name, String description, Set<String> alias){
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
    }

    //metodi

     public String getName(){
        return name;
     }

     public void setName(String name){
        this.name = name;
     }
    public String getDescription(){
        return description;
    }
    public void setDescrizione(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return open;
    }

   public void setopen(boolean open) {
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

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    public int getId() {
        return id;
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
