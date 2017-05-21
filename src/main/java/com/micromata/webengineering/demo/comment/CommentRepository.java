package com.micromata.webengineering.demo.comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    // Empty.
}
