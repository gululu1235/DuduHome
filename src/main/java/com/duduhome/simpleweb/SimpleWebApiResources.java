package com.duduhome.simpleweb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class SimpleWebApiResources {
    private String _headline;

    public SimpleWebApiResources(String headline){
        _headline = headline;
    }

    @GET
    public String showHeadline(){
        return _headline;
    }
}
