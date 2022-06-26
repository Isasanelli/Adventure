package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class ParserOutput {

    private  Command command;
    private  AdvObject object;
    
    public ParserOutput(Command command, AdvObject object){
        this.command = command;
        this.object = object;
    }


    public Command getCommand(){
        return command;
    }

    public void setCommand(Command command){
        this.command=command;
    }


    public AdvObject getObject() {
        return object;
    }

    public void setObject(AdvObject object) {
        this.object = object;
    }
}
