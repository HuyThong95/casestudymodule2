package com.codegym.CaseStudy.repository;

import com.codegym.CaseStudy.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType, Long> {
}
