package com.codegym.CaseStudy.service.Impl;

import com.codegym.CaseStudy.model.NoteType;
import com.codegym.CaseStudy.repository.NoteTypeRepository;
import com.codegym.CaseStudy.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    public NoteTypeRepository noteTypeRepository;
    @Override
    public Iterable<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);

    }

    @Override
    public void remove(Long id) {
        noteTypeRepository.delete(id);

    }
}
