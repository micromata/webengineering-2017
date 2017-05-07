package com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private List<Post> posts = new LinkedList<>();

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public List<Post> getPosts() {
        return posts;
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(String title) {
        Post post = new Post(title);
        posts.add(post);
    }
}
