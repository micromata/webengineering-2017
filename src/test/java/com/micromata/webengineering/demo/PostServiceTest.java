package com.micromata.webengineering.demo;


import com.micromata.webengineering.demo.post.Post;
import com.micromata.webengineering.demo.post.PostService;
import com.micromata.webengineering.demo.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.UUID;

import static org.junit.Assert.*;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class PostServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(PostServiceTest.class);

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
    @Transactional
    public void testPostAdd() {
        LOG.info("Number of posts: {}", countPosts());
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
    @Transactional
    public void testPostPersisted() {
        LOG.info("Number of posts: {}", countPosts());
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


    private int countPosts() {
        int count = 0;
        Iterator<Post> it = postService.getPosts().iterator();
        while (it.hasNext()) {
            it.next();
            count++;
        }

        return count;
    }
}
