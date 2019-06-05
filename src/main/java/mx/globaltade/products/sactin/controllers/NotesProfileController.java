package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.Note;
import mx.globaltade.products.sactin.models.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profiles/{profile-key}")
public class NotesProfileController {

    @RequestMapping(value = "/notes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createNote(@PathVariable(name = "profile-key") String profileKey, Note newNote, Model model) {
        model.addAttribute("profileKey", profileKey);
        model.addAttribute("note", newNote);
        return "notes/detailNote";
    }

    @RequestMapping(value = "/create-note", method = RequestMethod.GET)
    public String initNewNote(@PathVariable(name = "profile-key") String profileKey, Model model) {
        model.addAttribute("profileKey", profileKey);
        model.addAttribute("newNote", new Note());
        return "notes/newNote";
    }

}
