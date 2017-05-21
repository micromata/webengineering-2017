package com.micromata.webengineering.demo.comment;

import com.micromata.webengineering.demo.post.PostService;
import com.micromata.webengineering.demo.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class CommentService {
    private static final Logger LOG = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    /**
     * Remove a single comment.
     *
     * @param id the comments's id.
     */
    public void deleteComment(Long id) {
        // Validate that user is allowed to delete comment.
        Comment comment = repository.findOne(id);
        if (!comment.getAuthor().equals(userService.getCurrentUser())) {
            LOG.info("Deleting comment not allowed. user={}, id={}", userService.getCurrentUser().getEmail(), id);
            throw new IllegalStateException("User not allowed to delete comment");
        }

        // Since a comment is part of a post, its functional removal is also part of the PostService.
        LOG.info("Deleting comment. user={}, id={}", userService.getCurrentUser().getEmail(), id);
        postService.removeComment(comment);
    }


    /**
     * Update a comment's text.
     *
     * @param id            id of the comment
     * @param updateComment the updated comment. Note that currently only its text value is used.
     */
    public void update(Long id, Comment updateComment) {
        // Validate that user is allowed to delete comment.
        Comment comment = repository.findOne(id);
        if (!comment.getAuthor().equals(userService.getCurrentUser())) {
            LOG.info("Updating comment not allowed. user={}, id={}", userService.getCurrentUser().getEmail(), id);
            throw new IllegalStateException("User not allowed to update comment");
        }
        LOG.info("Updating comment. user={}, id={}", userService.getCurrentUser().getEmail(), id);

        comment.setText(updateComment.getText());
        repository.save(comment);
    }


    /**
     * Add a comment to an existing post.
     *
     * @param postId id of a post
     * @param text   text of the comment
     * @return id of the corresponding comment
     */
    public Long addComment(Long postId, String text) {
        // Persist comment.
        Comment comment = new Comment();
        comment.setText(text);
        comment.setAuthor(userService.getCurrentUser());
        repository.save(comment);

        if (true) {
            throw new IllegalStateException("Something went wrong");
        }

        // Append technically to post.
        postService.addComment(postId, comment);

        return comment.getId();
    }


    /**
     * Return a single comment.
     *
     * @param id comment id
     * @return a comment
     */
    public Comment getComment(Long id) {
        LOG.info("Retrieving comment. user={}, id={}", userService.getCurrentUser().getEmail(), id);
        return repository.findOne(id);
    }
}
