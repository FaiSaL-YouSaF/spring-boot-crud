package com.faisalyousaf777.controller;

import com.faisalyousaf777.entity.Note;
import com.faisalyousaf777.exceptions.BlankNoteException;
import com.faisalyousaf777.exceptions.NoteAlreadyExistsException;
import com.faisalyousaf777.exceptions.NoteNotFoundException;
import com.faisalyousaf777.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/notes")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllNotes() {
        try {
            return ResponseEntity.ok(notesService.getAllNotes());
        } catch (final Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNoteById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(notesService.getNoteById(id));
        } catch (final NoteNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNote(@RequestBody Note note) {
        try {
            notesService.saveNote(note);
            return ResponseEntity.created(URI.create("/notes/add")).body("Added Successfully!");
        } catch (final NoteAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        } catch (final BlankNoteException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (final Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public void updateNoteById(@PathVariable(name = "id") Long id, @RequestBody Note note) {
        try {
            notesService.updateNoteById(id, note);
        } catch (final NoteNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (final Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getCause());
        }
        notesService.updateNoteById(id, note);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNoteById(@PathVariable(name = "id") Long id) {
        try {
            notesService.deleteNoteById(id);
        } catch (final NoteNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (final Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
