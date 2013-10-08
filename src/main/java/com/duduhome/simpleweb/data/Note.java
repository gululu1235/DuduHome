package com.duduhome.simpleweb.data;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

public class Note {
    private int _id;
    private String _author;
    private String _content;
    private String _time;
    private DateTime _timestamp;

    public Note(final String author, final String content) {
        _author = author;
        _content = content;
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
}

