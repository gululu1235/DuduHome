package com.duduhome.simpleweb.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.joda.time.DateTime;

public class Note {
    @JsonProperty("id")
    private int _id;
    @JsonProperty("author")
    private String _author;
    @JsonProperty("content")
    private String _content;
    @JsonProperty("icon")
    private String _icon;
    @JsonProperty("time")
    private String _time;
    @JsonProperty("timestamp")
    private DateTime _timestamp;

    public Note(final String author, final String content) {
        _author = author;
        _content = content;
        _icon = author;
    }

    public Note() {
    }

    public int getId() {
        return _id;
    }

    public String getAuthor() {
        return _author;
    }

    public String getContent() {
        return _content;
    }

    public String getTime() {
        return _time;
    }

    public void setId(final int id) {
        _id = id;
    }

    public void setTime(String time) {
        _timestamp = DateTime.parse(time.replace(" ", "T"));
        _time = time;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public void setContent(String content) {
        _content = content;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass()).add("id", _id).add("author", _author).add("content", _content).add("timestamp", _timestamp).toString();
    }

    public String getIcon() {
        return _icon;
    }

    public void setIcon(final String icon) {
        _icon = icon;
    }
}

