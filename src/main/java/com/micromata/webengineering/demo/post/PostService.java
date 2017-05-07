package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public Iterable<Post> getPosts() {
        return repository.findAll();
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(Post post) {
        repository.save(post);
    }

    /**
     * Retrieve a single post.
     *
     * @param id post id
     * @return post with the id or null if no post is found
     */
    public Post getPost(Long id) {
        return repository.findOne(id);
    }

    /**
     * Remove a single post.
     *
     * @param id the post's id.
     */
    public void deletePost(Long id) {
        repository.delete(id);
    }
}
