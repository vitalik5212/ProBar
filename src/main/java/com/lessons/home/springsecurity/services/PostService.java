package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Post;
import com.lessons.home.springsecurity.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements DaoService<Post> {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPagePosts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return postRepository.findAll(pageable);
    }

    @Override
    public Collection<Post> getAllObjects() {
        List<Post> posts = new ArrayList<>();
        postRepository
                .findAll()
                .forEach(posts::add);

        return posts;
    }

    @Override
    public Post getObjectById(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isEmpty()) {
            throw new IllegalStateException("Post with id " + id + " does not exist");
        }

        return postOptional.get();
    }

    @Override
    public Post getObjectByName(String name) {
        Post post = postRepository.findByName(name);

        if (post == null) {
            throw new IllegalStateException("Post with name " + name + " does not exist");
        }

        return post;
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void update(Post post) {
        if (post == null) {
            throw new NullPointerException("Post cannot be null");
        }
        postRepository.save(post);
    }

    @Override
    public void create(Post post) {
        if (post == null) {
            throw new NullPointerException("Cocktail cannot be null");
        } else {
            postRepository.save(post);
        }
    }
}
