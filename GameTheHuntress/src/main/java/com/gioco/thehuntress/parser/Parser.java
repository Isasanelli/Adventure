package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.eventi.DbClass;
import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

import java.util.List;
import java.util.Set;

public class Parser {
    private final Set<String> stopwords;


    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    private int checkForCommand(String token, List<Command> commands){
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().toLowerCase().equals(token))
                return i;
            if (commands.get(i).getAlias()!=null)
                if (commands.get(i).getAlias().contains(token))
                    return i;
        }
        return -1;
    }


    private int checkForObject(String token, List<AdvObject> objects, DbClass db)  {
        for (int i = 0; i < objects.size(); i++) {
            if (!objects.isEmpty()) {
                if (objects.get(i).getName(db).toLowerCase().equals(token))
                    return i;
                if (objects.get(i).getAlias() != null)
                    if (objects.get(i).getAlias().contains(token))
                        return i;
            }
        }
        return -1;
    }

   //objects è la lista degli oggetti della stanza corrente
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> inventory, DbClass database) {
        //String[] tokens = Utils.parseString(command, stopwords);
        String cmd = command.toLowerCase().trim();
        String[] tokens = cmd.split("\\s+");
        int i = 0;
        int io = -1, ic = -1, ioinv = -1;
        if (tokens.length > 0) {
            while (ic<0 && i<tokens.length){
                ic = checkForCommand(tokens[i], commands);
                i++;
            }
            if (ic > -1) {
                i = 0; //riparte dalla prima parola
                if (tokens.length > 1) {
                    while (io<0 && i<tokens.length){
                        io = checkForObject(tokens[i], objects,database);
                        i++;
                    }
                    if (io<0) {
                        i = 0;
                        while (ioinv<0 && i<tokens.length){
                            ioinv = checkForObject(tokens[i], inventory,database);
                            i++;
                        }
                    }
                    if (io > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io), null);
                    } else if (ioinv > -1) {
                        return new ParserOutput(commands.get(ic), null, inventory.get(ioinv));
                    } else {
                        return new ParserOutput(commands.get(ic), null, null);
                    }
                } else {
                    return new ParserOutput(commands.get(ic), null);
                }
            } else {
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }
}

