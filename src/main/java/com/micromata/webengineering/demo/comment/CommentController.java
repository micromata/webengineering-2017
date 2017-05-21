package com.micromata.webengineering.demo.comment;

import com.micromata.webengineering.demo.post.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * HTTP endpoint for a comment-related HTTP requests.
 */
@RestController
public class CommentController {
    @RequestMapping(value = "/api/comment", method = RequestMethod.GET)
    public Iterable<Post> getPostList() {
        // TODO ML
        return null;
    }

    @RequestMapping(value = "/api/comment", method = RequestMethod.POST)
    public ResponseEntity<Object> addComment(@RequestBody Post post) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> editComment(@PathVariable Long id, @RequestBody Comment comment) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Long id) {
        // TODO ML
    }
}
