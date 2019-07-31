package com.codegym.CaseStudy.service;

import com.codegym.CaseStudy.model.NoteType;

public interface NoteTypeService {
    Iterable<NoteType> findAll();
    NoteType findById(Long id);
    void save(NoteType noteType);
    void remove(Long id);

}
