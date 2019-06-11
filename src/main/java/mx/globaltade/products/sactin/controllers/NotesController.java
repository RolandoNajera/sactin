package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.Note;
import mx.globaltade.products.sactin.models.Profile;
import mx.globaltade.products.sactin.services.INoteService;
import mx.globaltade.products.sactin.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profiles/{id}")
public class NotesController {

    @Value("${title}")
    public String title;

    @Autowired
    public INoteService noteService;

    @Autowired
    public IProfileService profileService;

    @RequestMapping(value = "/notes/ByProfile", method = RequestMethod.GET)
    public String getNotesByProfile(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("notes", noteService.getNotesByProfile(id));
        return "notes/getNotes";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("profiles", profileService.getProfiles());
        return "notes/getNotes";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createNote(@PathVariable(name = "id") Long id, Note note, Model model) {
        Profile profile = profileService.getProfile(id);
        note.setProfile(profile);
        note.setId(null);
        noteService.createNote(note);
        model.addAttribute("notes", noteService.getNotesByProfile(id));
        model.addAttribute("profile", profile);
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.GET)
    public String getProfile(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfile(id));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/notes/{note-id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateNote(@PathVariable(name = "id") Long id, @PathVariable(name = "note-id") Long noteId, Note note, Model model) {
        note.setProfile(profileService.getProfile(id));
        noteService.updateNote(note);
        model.addAttribute("notes", noteService.getNotesByProfile(id));
        model.addAttribute("profile", profileService.getProfile(id));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/notes/{note-id}", method = RequestMethod.DELETE)
    public String deleteNote(@PathVariable(name = "id") Long id, @PathVariable(name = "note-id") Long noteId, Model model) {
        noteService.deleteNote(noteId);
        model.addAttribute("notes", noteService.getNotesByProfile(id));
        model.addAttribute("profile", profileService.getProfile(id));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/notes/new-note", method = RequestMethod.GET)
    public String initCreateNote(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfile(id));
        model.addAttribute("newNote", new Note());
        return "notes/newNote";
    }

    @RequestMapping(value = "/notes/{note-id}/update-note", method = RequestMethod.GET)
    public String initUpdateNote(@PathVariable(name = "id") Long id, @PathVariable(name = "note-id") Long noteId, Model model) {
        model.addAttribute("profile", profileService.getProfile(id));
        model.addAttribute("updateNote", noteService.getNote(noteId));
        return "notes/updateNote";
    }

    @RequestMapping(value = "/notes/{note-id}/delete-note", method = RequestMethod.GET)
    public String initDeleteNote(@PathVariable(name = "id") Long id, @PathVariable(name = "note-id") Long noteId, Model model) {
        model.addAttribute("profile", profileService.getProfile(id));
        model.addAttribute("deleteNote", noteService.getNote(noteId));
        return "notes/deleteNote";
    }


}
