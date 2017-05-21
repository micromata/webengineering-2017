package com.micromata.webengineering.demo.post;

import com.micromata.webengineering.demo.comment.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    // Note that everythin is case insensitive except for the Table (entity) name.
    @Query("SELECT new Post(p.id, p.author, p.title, p.createdAt) from Post p ORDER BY p.createdAt DESC")
    List<Post> findAll();

    @Query("SELECT p FROM Post p WHERE :comment MEMBER OF p.comments")
    Post findPostForComment(@Param("comment") Comment comment);
}
