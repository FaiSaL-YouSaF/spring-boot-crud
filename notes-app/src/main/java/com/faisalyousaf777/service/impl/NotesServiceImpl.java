package com.faisalyousaf777.service.impl;

import com.faisalyousaf777.entity.Note;
import com.faisalyousaf777.exceptions.BlankNoteException;
import com.faisalyousaf777.exceptions.NoteAlreadyExistsException;
import com.faisalyousaf777.exceptions.NoteNotFoundException;
import com.faisalyousaf777.repository.NotesRepository;
import com.faisalyousaf777.service.NotesService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Optional<List<Note>> getAllNotes() {
        return Optional.of(notesRepository.findAll());
    }

    @Override
    public Optional<Note> getNoteById(final Long id) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : " + id + " does not exists.");
        }
        return Optional.of(notesRepository.findById(id).get());
    }

    @Override
    public void saveNote(final Note note) {
        if (notesRepository.findById(note.getId()).isPresent()) {
            throw new NoteAlreadyExistsException("Invalid ID : Note with the ID : " + note.getId() + " already exists.");
        }
        if (note.getTitle().isBlank() && note.getDescription().isBlank()) {
            throw new BlankNoteException("Invalid Note : Note is blank.");
        }
        Note newNote = new Note(note.getTitle().trim(), note.getDescription().trim(), LocalDateTime.now());
        notesRepository.save(newNote);
    }

    @Override
    public void updateNoteById(final Long id, final Note note) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : " + id + " does not exists.");
        }
        Note currentNote = notesRepository.findById(id).get();
        currentNote.setTitle(note.getTitle().trim());
        currentNote.setDescription(note.getDescription().trim());
        currentNote.setUpdatedAt(LocalDateTime.now());
        notesRepository.save(currentNote);
    }

    @Override
    public void deleteNoteById(Long id) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : " + id + " does not exists.");
        }
        notesRepository.deleteById(id);
    }
}
