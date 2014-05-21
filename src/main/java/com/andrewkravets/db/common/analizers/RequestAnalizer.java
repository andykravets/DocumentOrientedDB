package com.andrewkravets.db.common.analizers;

import com.andrewkravets.db.enums.ReservedWords;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class RequestAnalizer {

    public static ReservedWords parseCommand(String command) {
        if (command.equalsIgnoreCase("add"))
            return ReservedWords.ADD;
        if (command.equalsIgnoreCase("create"))
            return ReservedWords.CREATE;
        if (command.equalsIgnoreCase("remove"))
            return ReservedWords.REMOVE;
        if (command.equalsIgnoreCase("update"))
            return ReservedWords.UPDATE;
        if (command.equalsIgnoreCase("delete"))
            return ReservedWords.DELETE;
        if (command.equalsIgnoreCase("persist"))
            return ReservedWords.PERSIST;
        if (command.equalsIgnoreCase("load"))
            return ReservedWords.LOAD;
        return ReservedWords.WRONG;
    }

}
