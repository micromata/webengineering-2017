package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    private static class PostCreated {
        public String url;
    }

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public PostCreated addPost(@RequestBody Post post) {
        postService.addPost(post);

        PostCreated postCreated = new PostCreated();
        postCreated.url = "http://localhost:8080/post/" + post.getId();
        return postCreated;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
