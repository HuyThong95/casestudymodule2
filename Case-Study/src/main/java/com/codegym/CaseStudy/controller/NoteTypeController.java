package com.codegym.CaseStudy.controller;


import com.codegym.CaseStudy.model.Note;
import com.codegym.CaseStudy.model.NoteType;
import com.codegym.CaseStudy.service.NoteService;
import com.codegym.CaseStudy.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/notetype")
    public ModelAndView listNoteType(){
        Iterable<NoteType> noteTypes = noteTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/notetype/list");
        modelAndView.addObject("notetypes", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create-notetype")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/notetype/create");
        modelAndView.addObject("notetype", new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-notetype")
    public ModelAndView saveProvince(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.save(noteType);

        ModelAndView modelAndView = new ModelAndView("/notetype/create");
        modelAndView.addObject("notetype", new NoteType());
        modelAndView.addObject("message", "New notetype created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-notetype/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/notetype/edit");
            modelAndView.addObject("notetype", noteType);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-notetype")
    public ModelAndView updateNotetypes(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("notetype", noteType);
        modelAndView.addObject("message", "Notetype updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-notetype/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/notetype/delete");
            modelAndView.addObject("notetype", noteType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-notetype")
    public String deleteProvince(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.remove(noteType.getId());
        return "redirect:notetype";
    }

    @GetMapping("/view-notetype/{id}")
    public ModelAndView viewNoteType(@PathVariable("id") Long id){
        NoteType noteType = noteTypeService.findById(id);
        if (noteType == null){
            return new ModelAndView("/error.404");
        }
        Iterable<Note> notes = noteService.findAllByNoteType(noteType);
        ModelAndView modelAndView = new ModelAndView("/notetype/view");
        modelAndView.addObject("notetype", noteType);
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }




}
