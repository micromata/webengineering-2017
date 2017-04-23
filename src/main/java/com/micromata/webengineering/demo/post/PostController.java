package com.micromata.webengineering.demo.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PostController {
    private List<String> posts = new LinkedList<>();

    @RequestMapping("/post")
    public List<String> getPostList() {
        return posts;
    }

    @RequestMapping(value = "/post/add")
    public void addPost(@RequestParam("title") String title) {
        posts.add(title);
    }
}
