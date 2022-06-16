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
            if (commands.get(i).getName().equals(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<AdvObject> obejcts, DbClass db)  {
        for (int i = 0; i < obejcts.size(); i++) {
            if (obejcts.get(i).getName(db).equals(token) || obejcts.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

   //objects è la lista degli oggetti della stanza corrente
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> inventory, DbClass database) {
        List<String> tokens = Utils.parseString(command, stopwords);
        if (!tokens.isEmpty()) { //tokens.get(0) c'è il comando, tokens.get(1) c'è l'oggetto
            int ic = checkForCommand(tokens.get(0), commands);
            System.out.println(ic);//ic è la posizione nella lista commands in cui si trova effettivamente il comando inserito
            if (ic > -1) {  //se il comando si trova il lista:
                if (tokens.size() > 1) { //se la lista contiene più di un elemento (quindi l'oggetto oltre al comando):
                    /*QUA FARE UN CONTROLLO SE E' UN OGGETTO DELLA CLASSE ADVOBJECT O CLASSE PERSONAGGIO, E SE è OGGETTO PROSEGUIRE ALTRIMENTI SCRIVERE IN ELSE */
                    int io = checkForObject(tokens.get(1), objects, database); //io è la posizione nella lista objects in cui si trova effettivamente l'oggetto inserito
                    int ioinv = -1;
                    if (io < 0 && tokens.size() > 2) {
                        io = checkForObject(tokens.get(2), objects, database);
                    }
                    if (io < 0) { //se l'oggetto non è nella lista degli oggetti della classe corrente:
                        ioinv = checkForObject(tokens.get(1), inventory, database); //vedo se l'oggetto si trova nella lista degli oggetti dell'inventario
                        if (ioinv < 0 && tokens.size() > 2) {
                            ioinv = checkForObject(tokens.get(2), inventory, database);
                        }
                    }
                    if (io > -1 && ioinv > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io), inventory.get(ioinv));
                    } else if (io > -1) {
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
