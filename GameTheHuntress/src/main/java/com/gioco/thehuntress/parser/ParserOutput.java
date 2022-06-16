package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

public class ParserOutput {

    private  Command command;
    private  AdvObject object;
    private AdvObject invObject;

    public ParserOutput(Command command, AdvObject object){
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, AdvObject object,AdvObject InvObject){
        this.command=command;
        this.object=object;
        this.invObject=invObject;
    }

    public Command getCommand(){
        return command;
    }

    public void setCommand(Command command){
        this.command=command;
    }

    public AdvObject getInvObject(){
        return invObject;
    }

    public void setInvObject(AdvObject invObject){
        this.invObject=invObject;
    }

    public AdvObject getObject() {
        return object;
    }

    public void setObject(AdvObject object) {
        this.object = object;
    }
}
