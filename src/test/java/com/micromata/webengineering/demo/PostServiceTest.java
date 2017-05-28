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

import static org.junit.Assert.assertNotNull;

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

    @Test
    public void notNull() {
        assertNotNull("We should have an instance of postService", postService);
    }

    @Test
    public void testPostAdd() {
        Post post = new Post();
        post.setTitle("Test");
        postService.addPost(post);
    }
}
