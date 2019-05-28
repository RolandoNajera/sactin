package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/account")
public class UsersController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(@RequestParam(name = "name", required = false) String name, Model model) {
        List<User> users = Arrays.asList(
                new User("Rolando", "Najera", "ernajera@correo.com"),
                new User("Jessica", "Alvarez", "jjalvarez@correo.com"),
                new User("Irving", "Najera", "ijnajera@correo.com")
        );
        model.addAttribute("users", users);
        model.addAttribute("title", "SACTIN");
        return "users/profile";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUser() {
        return "";
    }

    @RequestMapping(value = "/users/{code}", method = RequestMethod.GET)
    public String getUser( Model model) {
        return "users/profile-detail";
    }

    @RequestMapping(value = "/users/{code}", method = RequestMethod.PUT)
    public String updateUser() {
        return "";
    }

    @RequestMapping(value = "/users/{code}", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "";
    }

    @ModelAttribute("common")
    public String commonText() {
        return "";
    }

}
