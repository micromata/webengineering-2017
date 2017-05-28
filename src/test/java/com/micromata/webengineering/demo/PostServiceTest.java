package com.micromata.webengineering.demo;


import com.micromata.webengineering.demo.post.PostService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    public void notNull() {
        assertNotNull("We should have an instance of postService", postService);
    }
}
