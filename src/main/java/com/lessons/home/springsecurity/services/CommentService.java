package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Comment;
import com.lessons.home.springsecurity.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Collection<Comment> getAllObjects() {
        List<Comment> comments = new ArrayList<>();
        commentRepository
                .findAll()
                .forEach(comments::add);

        return comments;
    }

    public Comment getObjectById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);

        if (commentOptional.isEmpty()) {
            throw new IllegalStateException("Comment with id " + id + " does not exist");
        }

        return commentOptional.get();
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public void update(Comment comment) {
        if (comment == null) {
            throw new NullPointerException("Comment cannot be null");
        }
        commentRepository.save(comment);
    }

    public void create(Comment comment) {
        if (comment == null) {
            throw new NullPointerException("Cocktail cannot be null");
        } else {
            commentRepository.save(comment);
        }
    }
}
