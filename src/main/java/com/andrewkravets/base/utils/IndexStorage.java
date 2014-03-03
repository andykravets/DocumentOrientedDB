package com.andrewkravets.base.utils;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * User: andrey.kravets
 * Date: 2/19/14 2:47 PM
 */
public class IndexStorage {
    Map<Object, List<JsonObject>> indexes = new ConcurrentHashMap<Object, List<JsonObject>>();

    public void addObject(Object index, JsonObject object){
        createIndexIfNotPresent(index);
        indexes.get(index).add(object);
    }

    public void removeObject(Object index, JsonObject object){
        createIndexIfNotPresent(index);
        indexes.get(index).remove(object);
    }

    private boolean isIndexPresent(Object index){
        return indexes.containsKey(index);
    }

    private void createNewIndex(Object index){
        indexes.put(index, new CopyOnWriteArrayList<JsonObject>());
    }

    private void createIndexIfNotPresent(Object index){
        if(!isIndexPresent(index)) createNewIndex(index);
    }



}
