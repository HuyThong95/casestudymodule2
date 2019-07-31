package com.codegym.CaseStudy.repository;

import com.codegym.CaseStudy.model.Note;
import com.codegym.CaseStudy.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    Iterable<Note> findAllByNoteType(NoteType noteType);
    Page<Note> findAllByContentContaining(String content, Pageable pageable);
}
