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
    }

   //objects è la lista degli oggetti della stanza corrente, e objectsInv è la lista degli oggetti presenti nell'inventario
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> objectsInv, DbClass database) {
        List<String> tokens = Utils.parseString(command, stopwords);//tokens.get(0) c'è il comando, tokens.get(1) c'è l'oggetto, token.get(2) c'è l'oggetto
        if (!tokens.isEmpty()) { //se la lista non è vuota
            int ic = checkForCommand(tokens.get(0), commands);//ic è la posizione nella lista commands in cui si trova effettivamente il comando inserito
            if (ic > -1) {  //se il comando si trova nella lista commands:
                if (tokens.size() > 1) { //se la lista dei tokens contiene più di un elemento (quindi l'oggetto o gli oggetti oltre al comando):
                    int io = checkForObject(tokens.get(1), objects, database); //io è la posizione nella lista objects in cui si trova effettivamente l'oggetto inserito
                    int ioInv = -1;
                    if (io < 0 && tokens.size() > 2) {
                        io = checkForObject(tokens.get(2), objects, database);
                    }
                    if (io < 0) { //se l'oggetto non è nella lista degli oggetti della stanza corrente
                        ioInv= checkForObject(tokens.get(1), objectsInv, database); //vedo se l'oggetto si trova nella lista degli oggetti dell'inventario
                        if (ioInv < 0 && tokens.size() > 2) {
                            ioInv = checkForObject(tokens.get(2), objectsInv, database);
                        }
                    }
                    if (io > -1 && ioInv > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io),objectsInv.get(ioInv));
                    } else if (io > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io),null);
                    } else if (ioInv > -1) {
                        return new ParserOutput(commands.get(ic), null,objectsInv.get(ioInv));
                    } else {
                        return new ParserOutput(commands.get(ic), null, null);
                    }
                } else { //se la lista tokens contiene solo un elemento restituisce il comando
                    return new ParserOutput(commands.get(ic), null);
                }
            } else { //se il comando non si trova nella lista commands restituisce null
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }
}
