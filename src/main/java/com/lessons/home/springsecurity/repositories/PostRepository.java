package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p WHERE p.name = ?1")
    public Post findByName(String name);

    @Override
    Page<Post> findAll(Pageable pageable);
}
