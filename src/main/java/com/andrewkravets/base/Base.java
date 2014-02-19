package com.andrewkravets.base;

import com.andrewkravets.enums.ReservedWords;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * User: andrey.kravets
 * Date: 2/19/14 2:11 PM
 */
public class Base {
    Map<Integer, JsonObject> documents = new HashMap<Integer, JsonObject>();

    public void add(JsonObject object){
        documents.put(getObjectId(object), object);
    }

    public void remove(JsonObject object){
        documents.remove(getObjectId(object));
    }

    public void edit(JsonObject object){
        add(object);
    }

    public Integer getLastId(){
        return documents.size();
    }

    private Integer getObjectId(JsonObject object){
        return object.get(ReservedWords.ID.getRepresentation()).getAsInt();
    }


}
