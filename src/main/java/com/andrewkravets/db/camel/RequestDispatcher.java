package com.andrewkravets.db.camel;

import com.andrewkravets.db.storage.base.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by akravets on 5/20/14.
 */
@Path(value = "/db")
public class RequestDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(RequestDispatcher.class);

    @GET
    @Path("/{id}")
    public String get(@PathParam("id") String id) throws IOException {
        return "Hello world " + id;
    }

    public String badRequest() {
        LOG.error("Bad request" + new Date());
        return "Bad request";
    }

    public String create(){
        return "create";
    }

    public String update(){
        return "update";
    }

    public String delete(){
        return "delete";
    }


}
