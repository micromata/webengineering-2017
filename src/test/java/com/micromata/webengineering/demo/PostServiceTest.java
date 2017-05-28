package com.micromata.webengineering.demo;


import com.micromata.webengineering.demo.post.Post;
import com.micromata.webengineering.demo.post.PostService;
import com.micromata.webengineering.demo.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        userService.setCurrentUser(1L, "michael");
    }

    /**
     * Test that dependency injection works.
     */
    @Test
    public void notNull() {
        assertNotNull("We should have an instance of postService", postService);
    }


    /**
     * Test that adding a new post leads to an id (and the post is thus persisted).
     */
    @Test
    public void testPostAdd() {
        Post post = new Post();
        post.setTitle("Test");

        assertNull(post.getId());
        postService.addPost(post);
        assertNotNull(post.getId());
    }


    /**
     * Test that a post is actually persisted.
     * <p>
     * NOTE: Usually we would actually test business logic which is implemented in the service. In our case there is
     * de facto no business logic hence we simply test a few persistence features, but keep in mind what I said about
     * testing core technologies in the lecture.
     */
    @Test
    public void testPostPersisted() {
        String uuid = UUID.randomUUID().toString();

        Post post = new Post();
        post.setTitle(uuid);

        assertNull(post.getId());
        postService.addPost(post);
        assertNotNull(post.getId());
        Long id = post.getId();

        Post storedPost = postService.getPost(id);
        assertEquals("Post correctly stored", storedPost.getTitle(), uuid);
    }
}
