package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
