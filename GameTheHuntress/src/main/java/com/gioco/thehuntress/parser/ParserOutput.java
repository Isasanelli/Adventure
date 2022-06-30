package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * ParselOutput class.
 */
public class ParserOutput {

    private  Command command;
    private  AdvObject object;

    /**
     * ParselOutput builder.
     * @param command
     * @param object
     */
    public ParserOutput(Command command, AdvObject object){
        this.command = command;
        this.object = object;
    }

    /**
     * function that returns the command.
     * @return Command
     */
    public Command getCommand(){
        return command;
    }

    /**
     * function that returns the object.
     * @return AdvObject
     */
    public AdvObject getObject() {
        return object;
    }

}
