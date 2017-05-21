package com.micromata.webengineering.demo.comment;

import com.micromata.webengineering.demo.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * HTTP endpoint for a comment-related HTTP requests.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/api/comment", method = RequestMethod.POST)
    public ResponseEntity<Object> addComment(@RequestBody Post post) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> editComment(@PathVariable Long id, @RequestBody Comment comment) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
