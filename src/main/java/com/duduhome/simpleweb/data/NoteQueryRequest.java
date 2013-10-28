package com.duduhome.simpleweb.data;

public class NoteQueryRequest {
    private String _author;
    private String _contentKeyWord;
    private int _id ;
    private String _date;

    public NoteQueryRequest(String author, String contentKeyWord, int id, String date){
        _author = author;
        _contentKeyWord = contentKeyWord;

        _id = id;
        _date = date;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public NoteQueryRequest withAuthor(String author) {
        _author = author;
        return this;
    }
    public String getContentKeyWord() {
        return _contentKeyWord;
    }

    public void setContentKeyWord(String contentKeyWord) {
        _contentKeyWord = contentKeyWord;
    }

    public NoteQueryRequest withContentKeyWord(String contentKeyWord) {
        _contentKeyWord = contentKeyWord;
        return this;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public NoteQueryRequest withId(int id){
        _id = id;
        return this;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    public NoteQueryRequest withDate(String date){
        _date = date;
        return this;
    }
}
