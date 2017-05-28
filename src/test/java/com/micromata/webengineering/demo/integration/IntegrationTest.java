package com.micromata.webengineering.demo.integration;


import com.micromata.webengineering.demo.post.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Create a test which starts a real application container listening on a given port.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    private static final Logger LOG = LoggerFactory.getLogger(IntegrationTest.class);

    @LocalServerPort
    int port;

    /**
     * Test that listing posts works.
     */
    @Test
    public void testPostList() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> response = rest.getForEntity(getPostURL(), List.class);
        List<Post> posts = response.getBody();
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(posts.size() == 0);
    }

    /**
     * Test that authentication and posting posts works.
     */
    @Test
    public void testAddPost() {
        RestTemplate rest = new RestTemplate();

        Post post = new Post();
        post.setTitle("test-post");
        ResponseEntity<Map> response = rest.postForEntity(getPostURL(), post, Map.class);
    }


    private String getPostURL() {
        return "http://localhost:" + port + "/api/post";
    }


}
