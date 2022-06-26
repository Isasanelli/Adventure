package com.gioco.thehuntress.parser;

import com.gioco.thehuntress.adventure.Utils;
import com.gioco.thehuntress.database.DbClass;
import com.gioco.thehuntress.type.AdvObject;
import com.gioco.thehuntress.type.Command;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * class in which the parsel is implemented
 */
public class Parser {
    private final Set<String> stopwords;

    /**
     * Parsel builder
     * @param stopwords
     */
    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    /**
     * function that checks if the token string is in the game's command list
     * @param token
     * @param commands game's command list
     * @return -1 if the token is not in the command list, otherwise it returns the position of the list where the command is located
     */
    private int checkForCommand(String token, List<Command> commands){
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equals(token)) {
                return i;
            }else if (commands.get(i).getAlias()!=null && commands.get(i).getAlias().contains(token))
                return i;
        }
        return -1;
    }

    /**
     * function that checks if the token string is in the objects list of the current room
     * @param token
     * @param objects objects list of the current room
     * @param db
     * @return -1 if the token is not in the objects list, otherwise it returns the position of the list where the object is located
     */
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

    /**
     *
     * @param command input command
     * @param commands game's command list
     * @param objects objects list of the current room
     * @param database
     * @return an object of type ParselOutput
     */
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, DbClass database) {
        List<String> tokens = Utils.parseString(command, stopwords);
        if (!tokens.isEmpty()) {
            int ic = checkForCommand(tokens.get(0), commands);
            if (ic > -1) {
                if (tokens.size() > 1) {
                    int io = checkForObject(tokens.get(1), objects, database);

                    if (io > -1 ) {
                        return new ParserOutput(commands.get(ic), objects.get(io));
                    }   else {
                        return new ParserOutput(commands.get(ic), null);
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
