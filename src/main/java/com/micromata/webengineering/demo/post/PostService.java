package com.micromata.webengineering.demo.post;

import com.micromata.webengineering.demo.comment.Comment;
import com.micromata.webengineering.demo.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository repository;

    @Autowired
    private UserService userService;

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public Iterable<Post> getPosts() {
        LOG.info("Returning posts. user={}", userService.getCurrentUser().getEmail());
        return repository.findAll();
    }


    /**
     * Add a new post.
     *
     * @param post the post to add
     */
    public void addPost(Post post) {
        // Remark: I usually try to avoid variables and helper functions for logging, since it clutters the soruce code.
        LOG.info("Adding post. user={}, title={}", userService.getCurrentUser().getEmail(), post.getTitle());

        for (Comment comment : post.getComments()) {
            comment.setAuthor(userService.getCurrentUser());
        }

        post.setAuthor(userService.getCurrentUser());
        repository.save(post);
    }

    /**
     * Retrieve a single post.
     *
     * @param id post id
     * @return post with the id or null if no post is found
     */
    public Post getPost(Long id) {
        LOG.info("Retrieving post. user={}, id={}", userService.getCurrentUser().getEmail(), id);
        return repository.findOne(id);
    }

    /**
     * Remove a single post.
     *
     * @param id the post's id.
     */
    public void deletePost(Long id) {
        // Validate that user is allowed to delete post.
        Post post = repository.findOne(id);
        if (!post.getAuthor().equals(userService.getCurrentUser())) {
            LOG.info("Deleting post not allowed. user={}, id={}", userService.getCurrentUser().getEmail(), id);
            throw new IllegalStateException("User not allowed to delete post");
        }
        LOG.info("Deleting post. user={}, id={}", userService.getCurrentUser().getEmail(), id);

        repository.delete(id);
    }
}
