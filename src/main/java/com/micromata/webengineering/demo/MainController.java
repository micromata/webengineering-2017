package com.micromata.webengineering.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MainController {
    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return new Date().toString();
    }
}

