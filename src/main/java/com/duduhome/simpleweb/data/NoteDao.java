package com.duduhome.simpleweb.data;

import com.yammer.dropwizard.lifecycle.Managed;

public interface NoteDao extends Managed {
    public void putNote(Note note) throws Exception;

    public Note getNoteById(int id) throws Exception;

    public Iterable<Note> queryNoteByAuthor(String author, String orderBy) throws Exception;

    public Iterable<Note> queryNoteByContent(String content, String orderBy) throws Exception;

    public Iterable<Note> getAllNotes(String orderBy) throws Exception;

    public Iterable<Note> queryNote(NoteQueryRequest request) throws Exception;
}
