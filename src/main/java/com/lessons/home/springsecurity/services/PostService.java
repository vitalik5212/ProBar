package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.dto.post.FullPostDto;
import com.lessons.home.springsecurity.dto.post.NewPostDto;
import com.lessons.home.springsecurity.dto.post.ShortPostDto;
import com.lessons.home.springsecurity.dto.user.PageWithPostsDto;
import com.lessons.home.springsecurity.entity.Post;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.mapper.PostMapper;
import com.lessons.home.springsecurity.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    private PostMapper postMapper;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public PageWithPostsDto getPagePosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postsPage = postRepository.findAll(pageable);

        Set<ShortPostDto> posts = postsPage.stream()
                .map(postMapper::toShortDto)
                .collect(Collectors.toSet());

        return PageWithPostsDto.builder()
                .posts(posts)
                .currentPage(page)
                .amountPages(postsPage.getTotalPages())
                .build();
    }

    public Collection<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository
                .findAll()
                .forEach(posts::add);

        return posts;
    }

    public FullPostDto getPostById(Long id) {
        Post post = postRepository.getOne(id);
        return postMapper.toFullDto(post);
    }

    public FullPostDto getPostByName(String name) {
        Post post = postRepository.findByName(name);

        if (post == null) {
            throw new IllegalStateException("Post with name " + name + " does not exist");
        }

        return postMapper.toFullDto(post);
    }

    @Transient
    public void delete(Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Post post = postRepository.getOne(id);
        User currentUser = userService.findUserByUsername(username);
        User creatorUser = userService.getUserById(post.getAuthor().getId());

        if (currentUser.equals(creatorUser)) {
            postRepository.deleteById(id);
        } else {
            throw new IllegalStateException("This user is not creator for this post");
        }
    }

    public void update(FullPostDto post) {
        if (post == null) {
            throw new NullPointerException("Post cannot be null");
        }

        Post updatedPost = postMapper.fromFullDto(post);

        postRepository.save(updatedPost);
    }

    @Transient
    public Long create(NewPostDto post) {
        if (post == null) {
            throw new NullPointerException("Post cannot be null");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);

        Post newPost = postMapper.fromNewDto(post);
        newPost.setAuthor(user);
        newPost.setDateOfCreate(LocalDate.now());

        postRepository.save(newPost);

        return getPostByName(post.getName()).getId();
    }
}
