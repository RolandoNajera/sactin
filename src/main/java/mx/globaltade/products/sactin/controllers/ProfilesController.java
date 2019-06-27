package mx.globaltade.products.sactin.controllers;

import mx.globaltade.products.sactin.models.Profile;
import mx.globaltade.products.sactin.modelviews.SearchProfile;
import mx.globaltade.products.sactin.services.INoteService;
import mx.globaltade.products.sactin.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfilesController {

    @Autowired
    public IProfileService profileService;

    @Autowired
    public INoteService noteService;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String getProfiles(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("search", new SearchProfile());
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProfile(Profile profile, Model model) {
        profileService.createProfile(profile);
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("search", new SearchProfile());
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.GET)
    public String getProfile(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfile(id));
        model.addAttribute("notes", noteService.getNotesByProfile(id));
        model.addAttribute("search", new SearchProfile());
        return "profiles/detailProfile";
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProfile(@PathVariable(name = "id") Long id, Profile profile, Model model) {
        profileService.updateProfile(profile);
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("search", new SearchProfile());
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.DELETE)
    public String deleteProfile(@PathVariable(name = "id") Long id, Model model) {
        Boolean status = profileService.deleteProfile(id);
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("search", new SearchProfile());
        return "profiles/getProfiles";
    }

    @RequestMapping(value = "/profiles/create-profile", method = RequestMethod.GET)
    public String initCreateProfile(Model model) {
        model.addAttribute("newProfile", new Profile());
        return "profiles/newProfile";
    }

    @RequestMapping(value = "/profiles/{id}/update-profile", method = RequestMethod.GET)
    public String initUpdateProfile(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("updateProfile", profileService.getProfile(id));
        return "profiles/updateProfile";
    }

    @RequestMapping(value = "/profiles/{id}/delete-profile", method = RequestMethod.GET)
    public String initDeleteProfile(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("deleteProfile", profileService.getProfile(id));
        return "profiles/deleteProfile";
    }

    @RequestMapping(value = "/profiles/search-profile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProfile(SearchProfile search, Model model) {
        model.addAttribute("profiles", profileService.searchProfiles(search.getValue()));
        model.addAttribute("search", new SearchProfile());
        return "profiles/getProfiles";
    }


}
