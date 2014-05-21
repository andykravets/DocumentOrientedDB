package com.andrewkravets.db.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

/**
 * Created by andrey.kravets on 5/20/2014.
 */
public class StandaloneStorage {
    private Main camelMain;

    public void start(final int port) throws Exception {
        camelMain = new Main();
        camelMain.setApplicationContextUri("META-INF/spring/config.xml");
        camelMain.enableHangupSupport();
        camelMain.start();
    }

    public void stop() throws Exception {
        camelMain.stop();
    }
}
