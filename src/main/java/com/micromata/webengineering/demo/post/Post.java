package com.micromata.webengineering.demo.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.micromata.webengineering.demo.comment.Comment;
import com.micromata.webengineering.demo.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Post {
    public static final int TITLE_LENGTH = 1024;

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private User author;

    @Column(length = Post.TITLE_LENGTH)
    private String title;
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Post() {
        // Default constructor for JPA.
        comments = new LinkedList<>();
    }

    /**
     * Constructor for Post's CrudRepository (findAll).
     *
     * @param author
     * @param title
     * @param createdAt
     */
    public Post(Long id, User author, String title, Date createdAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.createdAt = createdAt;
        comments = new LinkedList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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


    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
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
