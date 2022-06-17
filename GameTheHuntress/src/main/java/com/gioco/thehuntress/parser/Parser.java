package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.adventure.Utils;
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
            if (commands.get(i).getName().equals(token)) {
                return i;
            }else if (commands.get(i).getAlias()!=null && commands.get(i).getAlias().contains(token))
                return i;
        }
        return -1;
    }


    private int checkForObject(String token, List<AdvObject> objects, DbClass db)  {
        if (!objects.isEmpty()) {
        for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getName(db).equals(token)) {
                    return i;
                } else if (objects.get(i).getAlias() != null && objects.get(i).getAlias().contains(token))
                    return i;
            }
        }
        return -1;
        /*for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName(db).equals(token) || objects.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;*/
    }

   //objects è la lista degli oggetti della stanza corrente
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> inventory, DbClass database) {
        List<String> tokens = Utils.parseString(command, stopwords);
        int io1=-1, io2=-1, inv1=-1, inv2=-1;
        if (!tokens.isEmpty()) {
            int ic = checkForCommand(tokens.get(0), commands);
            if (ic > -1) {
                if (tokens.size() > 1) {
                    io1 = checkForObject(tokens.get(1), objects,database);
                    if(io1 > -1 && tokens.size() > 2) {
                        io2 = checkForObject(tokens.get(2), objects,database);
                        if (io2 < 0)
                            inv2 = checkForObject(tokens.get(2), inventory,database);
                    }
                    if(io1 < 0)
                        inv1 = checkForObject(tokens.get(1), inventory,database);
                    if(inv1 > -1 && tokens.size() > 2) {
                        inv2 = checkForObject(tokens.get(2), inventory,database);
                        if (inv2 < 0)
                            io2 = checkForObject(tokens.get(2), objects,database);
                    }
                    if (io1 > -1 && io2 > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io1), objects.get(io2));
                    } else if (io1 > -1 && inv2 > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io1), inventory.get(inv2));
                    }else if (inv1 > -1 && io2 > -1) {
                        return new ParserOutput(commands.get(ic), inventory.get(inv1), objects.get(io2));
                    }else if (inv1 > -1 && inv2 > -1) {
                        return new ParserOutput(commands.get(ic), inventory.get(inv1), inventory.get(inv2));
                    }
                    else if (io1 > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io1), null);
                    } else if (inv1 > -1) {
                        return new ParserOutput(commands.get(ic), inventory.get(inv1), null);
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
