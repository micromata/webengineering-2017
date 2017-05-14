package com.micromata.webengineering.demo.post;

import com.micromata.webengineering.demo.util.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private AddressService addressService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/api/post", method = RequestMethod.GET)
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/api/post", method = RequestMethod.POST)
    public ResponseEntity<Object> addPost(@RequestBody Post post) {
        // Option 2: validating the title length is driven by a technical (non-functional) requirement.
        // We choose this option to show the usage of ResponseEntity.
        if (post.getTitle() != null && post.getTitle().length() > Post.TITLE_LENGTH) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.addPost(post);
        PostCreated postCreated = new PostCreated();
        postCreated.url = addressService.getServerURL() + "/post/" + post.getId();
        return ResponseEntity.ok(postCreated);
    }

    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
