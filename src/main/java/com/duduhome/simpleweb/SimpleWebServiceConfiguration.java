package com.duduhome.simpleweb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class SimpleWebServiceConfiguration extends Configuration{
    @JsonProperty("headline")
    private String _headline;

    public String getHeadline() {
        return _headline;
    }
}
