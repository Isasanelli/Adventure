package com.gioco.thehuntress.type;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * Inventory class
 */
public class Inventory {

    private List<AdvObject> list= new ArrayList<>();

    public List<AdvObject> getList(){
        return list;
    }

    public void setLista(List<AdvObject> list){
        this.list=list;
    }

    public void add(AdvObject o){
        list.add(o);
    }

    public void remove(AdvObject o){
        list.remove(o);
    }
    
}
