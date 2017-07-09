package com.micromata.webengineering.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {
    @RequestMapping("/")
    public String index() {
        return new Date().toString();
    }
}

