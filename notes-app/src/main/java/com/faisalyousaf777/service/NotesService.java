package com.faisalyousaf777.service;

import com.faisalyousaf777.entity.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface NotesService {
    Optional<List<Note>> getAllNotes();
    Optional<Note> getNoteById(final Long id);
    void saveNote(final Note note);
    void updateNoteById(final Long id, final Note note);
    void deleteNoteById(final Long id);
}
