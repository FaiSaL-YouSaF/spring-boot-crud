package com.faisalyousaf777.service;

import com.faisalyousaf777.entity.Note;

import java.util.List;

public interface NotesService {
    public List<Note> getAllNotes();
    public Note getNoteById(final Long id);
    public void saveNote(final Note note);
    public void updateNoteById(final Long id, final Note note);
    public void deleteNoteById(final Long id);
}
