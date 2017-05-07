package com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.Iterator;
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
    public void addPost(Post post) {
        posts.add(post);
    }

    /**
     * Retrieve a single post.
     *
     * @param id post id
     * @return post with the id or null if no post is found
     */
    public Post getPost(Long id) {
        // This is enough functionality until we use proper data persistence techniques.
        // Do not use this approach in production!
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }

    /**
     * Remove a single post.
     *
     * @param id the post's id.
     */
    public void deletePost(Long id) {
        Iterator<Post> it = posts.iterator();
        while (it.hasNext()) {
            Post post = it.next();
            if (post.getId().equals(id)) {
                it.remove();
                return;
            }
        }
    }
}
