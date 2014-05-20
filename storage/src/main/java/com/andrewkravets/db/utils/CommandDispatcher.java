package com.andrewkravets.db.utils;

import com.andrewkravets.db.base.Base;
import com.andrewkravets.db.enums.ReservedWords;
import com.google.gson.JsonObject;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class CommandDispatcher {
    public static JsonObject execute(ReservedWords command, JsonObject object) {
        switch (command) {
            case ADD:
                return Base.getInstance().add(object);
            case CREATE:
                return Base.getInstance().add(object);
            case REMOVE:
                return Base.getInstance().remove(object);
            case UPDATE:
                return Base.getInstance().edit(object);
            case DELETE:
                return Base.getInstance().remove(object);
            case PERSIST:
                Base.getInstance().persist();
                break;
            case LOAD:
                Base.getInstance().load();
                break;
            default:
                return new JsonObject();
        }
        return new JsonObject();
    }
}
