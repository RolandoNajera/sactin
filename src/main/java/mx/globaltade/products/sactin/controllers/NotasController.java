package mx.globaltade.products.sactin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users/{key}")
public class NotasController {


    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String createNote(@PathVariable(name = "code") String key, Model model) {
        model.addAttribute("userKey", key);
        return "createNewNote";
    }

}
