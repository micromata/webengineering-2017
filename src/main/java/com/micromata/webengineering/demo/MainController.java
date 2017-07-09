package com.micromata.webengineering.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("value", "some message");
        return "index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String updateValue(@ModelAttribute("value") String value, Model model) {
        model.addAttribute("value", value);
        return "index";
    }
}

