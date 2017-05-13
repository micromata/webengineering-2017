package com.micromata.webengineering.demo.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    // Note that everythin is case insensitive except for the Table (entity) name.
    @Query("SELECT p from Post p ORDER BY p.createdAt DESC")
    List<Post> findAll();
}
