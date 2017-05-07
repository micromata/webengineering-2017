package com.micromata.webengineering.demo.post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    // Empty for now.
}
