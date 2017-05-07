package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    public List<Post> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
