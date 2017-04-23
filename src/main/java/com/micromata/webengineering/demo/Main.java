package com.micromata.webengineering.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@SpringBootApplication
public class Main {
    private List<String> posts = new LinkedList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/posts")
    public List<String> getPostList() {
        return posts;
    }
}
