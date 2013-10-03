package com.duduhome.simpleweb.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class Note {
    @JsonProperty
    private int _id;

    @JsonProperty
    private String _author;

    @JsonProperty
    private String _content;

    @JsonProperty
    private DateTime _createDate;

    public int getId(){
        return _id;
    }

    public String getAuthor(){
        return _author;
    }

    public String getContent() {
        return _content;
    }

    public DateTime getCreateDate() {
        return _createDate;
    }
}
