package com.faisalyousaf777.controller;

import com.faisalyousaf777.entity.Note;
import com.faisalyousaf777.service.NotesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    private final NotesService notesService;

    public NoteController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes/all")
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(name = "id") Long id) {
        return notesService.getNoteById(id);
    }

    @PostMapping("/notes/save")
    public void saveNote(@RequestBody Note note) {
        notesService.saveNote(note);
    }

    @PutMapping("/notes/update/{id}")
    public void updateNoteById(@PathVariable(name = "id") Long id, @RequestBody Note note) {
        notesService.updateNoteById(id, note);
    }

    @DeleteMapping("/notes/delete/{id}")
    public void deleteNoteById(@PathVariable(name = "id") Long id) {
        notesService.deleteNoteById(id);
    }
}
