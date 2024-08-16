package com.faisalyousaf777.service.impl;

import com.faisalyousaf777.entity.Note;
import com.faisalyousaf777.exceptions.NoteNotFoundException;
import com.faisalyousaf777.repository.NotesRepository;
import com.faisalyousaf777.service.NotesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : "+id+" does not exists.");
        }
        return notesRepository.findById(id).get();
    }

    @Override
    public void saveNote(Note note) {
        notesRepository.save(note);
    }

    @Override
    public void updateNoteById(Long id, Note note) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : "+id+" does not exists.");
        }
        Note currentNote = notesRepository.findById(id).get();
        currentNote.setTitle(note.getTitle());
        currentNote.setDescription(note.getDescription());
        notesRepository.save(currentNote);
    }

    @Override
    public void deleteNoteById(Long id) {
        if (notesRepository.findById(id).isEmpty()) {
            throw new NoteNotFoundException("Invalid ID : Note with the ID : "+id+" does not exists.");
        }
        notesRepository.deleteById(id);
    }
}
