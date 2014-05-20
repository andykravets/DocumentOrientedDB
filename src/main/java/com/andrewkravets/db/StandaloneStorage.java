package com.andrewkravets.db;

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

        CamelContext context = camelMain.getApplicationContext().getBean(CamelContext.class);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("jetty:http://localhost:" + port + "/service")
                        .to("direct:start");
            }
        });

    }

    public void stop() throws Exception {
        camelMain.stop();
    }
}
