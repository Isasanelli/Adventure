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
 * AdvObjectContainer class
 */
public class AdvObjectContainer extends AdvObject {

    private List<AdvObject> list = new ArrayList<>();

    public AdvObjectContainer(int id) {
        super(id);
    }

    public List<AdvObject> getList() {
        return list;
    }

    public void setList(List<AdvObject> list) {
        this.list = list;
    }

    public void add(AdvObject o) {
        list.add(o);
    }

    public void remove(AdvObject o) {
        list.remove(o);
    }

}