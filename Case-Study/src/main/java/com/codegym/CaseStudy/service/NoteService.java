package com.codegym.CaseStudy.service;

import com.codegym.CaseStudy.model.Note;
import com.codegym.CaseStudy.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);
    Note findById(Long id);
    void save(Note note);
    void remove(Long id);
    Iterable<Note> findAllByNoteType(NoteType noteType);
    Page<Note> findAllByContentContaining(String content, Pageable pageable);
}
