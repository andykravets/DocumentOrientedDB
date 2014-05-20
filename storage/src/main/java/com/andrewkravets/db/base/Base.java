package com.andrewkravets.db.base;


import com.andrewkravets.db.enums.ReservedWords;
import com.andrewkravets.db.model.ObjectId;
import com.andrewkravets.db.utils.PersistHelper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * User: andrey.kravets
 * Date: 2/19/14 2:11 PM
 */
public class Base {

    private static final Logger LOG = LoggerFactory.getLogger(Base.class);

    private static Base instance = null;

    private Map<ObjectId, JsonObject> documents = new HashMap<ObjectId, JsonObject>();

    public static Base getInstance() {
        if (instance == null) {
            synchronized (Base.class) {
                if (instance == null) {
                    instance = new Base();
                }
            }
        }
        return instance;
    }

    public JsonObject add(JsonObject object) {
        Gson g = new Gson();
        object.add(ReservedWords.ID.getRepresentation(), g.toJsonTree(new ObjectId()));
        documents.put(getObjectId(object), object);
        return object;
    }

    public JsonObject remove(JsonObject object) {
        documents.remove(getObjectId(object));
        return object;
    }

    public JsonObject edit(JsonObject object) {
        return add(object);
    }

    private Base() {
    }

    public void persist() {
        PersistHelper.save(documents);
    }

    public void load() {
        documents = PersistHelper.load();
    }

    private ObjectId getObjectId(JsonObject object) {
        return object.get(ReservedWords.ID.getRepresentation()).;
    }

    public JsonObject get(ObjectId id) {
        return documents.get(id);
    }


}
