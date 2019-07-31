package com.codegym.CaseStudy.service.Impl;

import com.codegym.CaseStudy.model.Note;
import com.codegym.CaseStudy.model.NoteType;
import com.codegym.CaseStudy.repository.NoteRepository;
import com.codegym.CaseStudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable){
        return noteRepository.findAll(pageable);
    }
    @Override
    public Note findById(Long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }
    @Override
    public void remove(Long id) {
        noteRepository.delete(id);
    }
    @Override
    public Iterable<Note> findAllByNoteType(NoteType noteType){
        return noteRepository.findAllByNoteType(noteType);
    }
    @Override
    public Page<Note> findAllByContentContaining(String content, Pageable pageable){
        return noteRepository.findAllByContentContaining(content, pageable);
    }
}
