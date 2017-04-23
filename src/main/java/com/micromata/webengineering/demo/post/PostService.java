package com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private List<String> posts = new LinkedList<>();

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public List<String> getPosts() {
        return posts;
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(String title) {
        posts.add(title);
    }
}
