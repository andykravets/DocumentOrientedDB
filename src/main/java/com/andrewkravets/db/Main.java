package com.andrewkravets.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {


        StandaloneStorage standaloneStorage = new StandaloneStorage();

        LOG.info("Trying to start server on port: 8000");
        standaloneStorage.start(8000);
        LOG.info("Successfully started server on port: 8000");

    }
}
