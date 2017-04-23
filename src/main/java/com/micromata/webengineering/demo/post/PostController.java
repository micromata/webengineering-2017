package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    public List<String> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/post/add")
    public void addPost(@RequestParam("title") String title) {
        postService.addPost(title);
    }
}
