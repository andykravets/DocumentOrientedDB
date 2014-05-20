package com.andrewkravets.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by akravets on 5/20/14.
 */
@Service("dispatcher")
public class RequestDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(RequestDispatcher.class);

    public String get(List<Object> params) throws IOException {

        return "Hello world";
    }

    public String badRequest() {
        LOG.error("Dad request" + new Date());
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
