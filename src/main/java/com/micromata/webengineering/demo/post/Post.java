package com.micromata.webengineering.demo.post;

import com.micromata.webengineering.demo.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    public static final int TITLE_LENGTH = 1024;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private User author;

    @Column(length = Post.TITLE_LENGTH)
    private String title;
    private Date createdAt;


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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * This method is called before an entity is persisted in the database. This is in contrast to our previous
     * approach where an object's createdAt depends on the date of its instantiation.
     * <p>
     * Information about @PrePersist where found by using the search terms "jpa annotations createdat".
     */
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
