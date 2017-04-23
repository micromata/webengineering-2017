package com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostService {
    private List<String> posts = new LinkedList<>();

    public List<String> getPosts() {
        return posts;
    }

    public void addPost(String title) {
        posts.add(title);
    }
}
