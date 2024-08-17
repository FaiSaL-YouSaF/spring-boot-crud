package com.faisalyousaf777.service;

import com.faisalyousaf777.entity.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface NotesService {
    public Optional<List<Note>> getAllNotes();
    public Optional<Note> getNoteById(final Long id);
    public void saveNote(final Note note);
    public void updateNoteById(final Long id, final Note note);
    public void deleteNoteById(final Long id);
}
