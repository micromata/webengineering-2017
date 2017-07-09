package com.micromata.webengineering.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("date", new Date());
        return "index";
    }
}

