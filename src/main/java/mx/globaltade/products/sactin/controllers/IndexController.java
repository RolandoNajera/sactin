package mx.globaltade.products.sactin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
public class IndexController {

    @RequestMapping(value={"/index", "/", "/home"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "SACTIN");
        model.addAttribute("initMessage", "Bienvenido a Sactin");
        return "index";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String salutation(@RequestParam(name = "salutation", required = false) String salutation, Model model) {
        model.addAttribute("message", "El mensaje es:" + salutation);
        return "salutation";
    }

    @RequestMapping(value = "/mix-params", method = RequestMethod.GET)
    public String mixParams(@RequestParam(name = "salutation", required = false) String salutation,
                            @RequestParam(name = "number", required = false) Integer number,
                            Model model) {
        model.addAttribute("message", "El mensaje es:" + salutation + "y el numero es:" +number);
        return "mix-params";
    }

}
