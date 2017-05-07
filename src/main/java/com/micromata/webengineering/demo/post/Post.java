package com.micromata.webengineering.demo.post;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Post {
    // Until we use actual data identity management over spring-data, we simulate unique id generation using
    // atomic integers. This ensures that multiple requests to create new posts will receive unique ids.
    private static AtomicLong nextId = new AtomicLong();

    private Long id;

    private String title;
    private Date createdAt;

    public Post() {
        id = nextId.getAndIncrement();
        createdAt = new Date();
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }
}
