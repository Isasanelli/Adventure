package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

public class ParserOutput {

    private  Command command;
    private  AdvObject object;
    private AdvObject object2;

    public ParserOutput(Command command, AdvObject object){
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, AdvObject object,AdvObject object2){
        this.command=command;
        this.object=object;
        this.object2 =object2;
    }

    public Command getCommand(){
        return command;
    }

    public void setCommand(Command command){
        this.command=command;
    }

    public AdvObject getObject2(){
        return object2;
    }

    public void setObject2(AdvObject object2){
        this.object2=object2;
    }

    public AdvObject getObject() {
        return object;
    }

    public void setObject(AdvObject object) {
        this.object = object;
    }
}
