package com.micromata.webengineering.demo.integration;


import com.micromata.webengineering.demo.post.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
        String title = "test-post";
        Post post = new Post();
        post.setTitle(title);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Map> response = rest.postForEntity(getPostURL(), getEntity(post), Map.class);

        String url = fixResponseURL((String) response.getBody().get("url"));
        Post storedPost = rest.getForObject(url, Post.class);
        assertEquals(title, storedPost.getTitle());
        assertEquals("kai", storedPost.getAuthor().getEmail());
    }


    /**
     * Create a HTTP entity to be used in authenticated requests. The default user is kai.
     *
     * @param entity object
     * @param <T>    Object's type
     * @return an entityt with authentication header.
     */
    private <T> HttpEntity<T> getEntity(T entity) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWkiLCJqdGkiOiIyIn0.h3ezvhsje3tpvHbXxz7TUmy7KhT5yjtljXKvDeo8MM2RTAEIP6l2vdRHw2KKg0-HgK-8CsMY5im3kp6zIogUTQ");
        return new HttpEntity<>(entity, headers);
    }


    private String getPostURL() {
        return "http://localhost:" + port + "/api/post";
    }

    private String fixResponseURL(String url) {
        return url.replaceAll(":8080/", ":" + port + "/");
    }
}
