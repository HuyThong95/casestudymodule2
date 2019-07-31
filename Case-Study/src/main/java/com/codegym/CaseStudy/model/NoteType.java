package com.codegym.CaseStudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Type")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Note.class)
    private List<Note> notes;

    public NoteType(String name) {
        this.name = name;
    }

    public NoteType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes(){
        return notes;
    }
    public void setNotes(List<Note> notes){
        this.notes = notes;
    }

}
