package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.Profile;
import mx.globaltade.products.sactin.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfilesController {

    @Value("${title}")
    public String title;

    @Autowired
    public IProfileService profileService;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String getProfiles(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("title", title);
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProfile(Profile profile, Model model) {
        model.addAttribute("profile", profileService.createProfile(profile));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.GET)
    public String getProfile(@PathVariable(name = "key") String key, Model model) {
        model.addAttribute("profile", profileService.getProfile(key));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProfile(@PathVariable(name = "key") String key, Profile profile, Model model) {
        model.addAttribute("profile", profileService.updateProfile(profile));
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{key}", method = RequestMethod.DELETE)
    public String deleteProfile(@PathVariable(name = "key") String key, Model model) {
        Boolean status = profileService.deleteProfile(key);
        model.addAttribute("deleted", status);
        model.addAttribute("profiles", profileService.getProfiles());
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles/create-profile", method = RequestMethod.GET)
    public String initCreateProfile(Model model) {
        model.addAttribute("newProfile", new Profile());
        return "profiles/newProfile";
    }

    @RequestMapping(value = "/profiles/{key}/update-profile", method = RequestMethod.GET)
    public String initUpdateProfile(@PathVariable(name = "key") String key, Model model) {
        model.addAttribute("updateProfile", profileService.getProfile(key));
        return "profiles/updateProfile";
    }

}
