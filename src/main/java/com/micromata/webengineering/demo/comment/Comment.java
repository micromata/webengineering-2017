package com.micromata.webengineering.demo.comment;

import com.micromata.webengineering.demo.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    public static final int COMMENT_LENGTH = 65536;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private User author;

    @Column(length = Comment.COMMENT_LENGTH)
    private String text;
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
