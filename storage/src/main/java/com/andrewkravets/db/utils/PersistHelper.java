package com.andrewkravets.db.utils;

import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class PersistHelper {

    private static final String DATA_FILE = "data.db";
    private static final Logger LOG = LoggerFactory.getLogger(PersistHelper.class);

    public static Map<Long, JsonObject> load() {
        try {
            return (Map<Long, JsonObject>) SerializationUtils.deserialize(FileUtils.readFileToByteArray(getOrCreateFile()));
        } catch (IOException e) {
            LOG.error("Data loading fail", e);
        }
        return new HashMap<Long, JsonObject>();
    }

    public static void save(Map<Long, JsonObject> documents) {
        try {
            byte[] data = SerializationUtils.serialize((java.io.Serializable) documents);
            FileUtils.writeByteArrayToFile(getOrCreateFile(), data);
        } catch (IOException e) {
            LOG.error("Persist fail", e);
        }
    }

    private static File getOrCreateFile() throws IOException {
        File data = new File(DATA_FILE);
        if (!data.exists() && data.createNewFile())
            LOG.info("New DB storage created");

        return data;
    }


}
