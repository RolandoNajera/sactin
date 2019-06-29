package mx.globaltade.products.sactin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
            Model model, Principal principal, RedirectAttributes redirectAttribute) {
        if (principal != null) {
            redirectAttribute.addFlashAttribute("message", "Sesión iniciada");
            return "redirect:/";
        }
        if(error != null) {
            model.addAttribute("errorMessage", error);
        }
        if(logout != null) {
            model.addAttribute("errorMessage", "hasta luego");
        }
        return "login";
    }

}
