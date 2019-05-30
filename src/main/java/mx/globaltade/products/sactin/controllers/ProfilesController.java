package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProfilesController {

    @Value("${title}")
    public String title;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String getUsers(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Profile> profiles = Arrays.asList(
                new Profile("", "Rolando Najera", "ernajera@correo.com", "5544667788", "Iztacalco"),
                new Profile("", "Rolando Najera", "ernajera@correo.com", "5544667788", "Iztacalco"),
                new Profile("", "Rolando Najera", "ernajera@correo.com", "5544667788", "Iztacalco")
        );
        model.addAttribute("profiles", profiles);
        model.addAttribute("title", title);
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProfile(Profile profile, Model model) {
        model.addAttribute("profile", profile);
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.GET)
    public String getUser( Model model) {
        return "detailProfile";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.PUT)
    public String updateUser() {
        return "";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "";
    }

    @RequestMapping(value = "/create-profile", method = RequestMethod.GET)
    public String initCreateUser(Model model) {
        model.addAttribute("newProfile", new Profile());
        return "profiles/newProfile";
    }

}
