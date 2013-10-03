package com.duduhome.simpleweb.data;

public interface NoteDao {
    public void putNote(Note note);

    public Note getNoteById(int id);

    public Iterable<Note> queryNoteByAuthor(String author, String orderBy);

    public Iterable<Note> queryNoteByContent(String content, String orderBy);

    public Iterable<Note> getAllNotes(String orderBy);

    public Iterable<Note> queryNote(NoteQueryRequest request);
}
