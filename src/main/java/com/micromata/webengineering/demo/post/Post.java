package com.micromata.webengineering.demo.post;

import java.util.Date;

public class Post {
    private String title;
    private Date createdAt;

    public Post(String title) {
        this.title = title;
        createdAt = new Date();
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
