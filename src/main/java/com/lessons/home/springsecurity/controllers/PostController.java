package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.dto.post.FullPostDto;
import com.lessons.home.springsecurity.dto.post.NewPostDto;
import com.lessons.home.springsecurity.dto.user.PageWithPostsDto;
import com.lessons.home.springsecurity.services.CommentService;
import com.lessons.home.springsecurity.services.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/post")
    public FullPostDto getPost(@RequestParam("id") Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public PageWithPostsDto getPosts(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        return postService.getPagePosts(page, pageSize);
    }

    @PostMapping("/post")
    public String createPost(NewPostDto newPost) {
        Long id = postService.create(newPost);
        return "redirect:/post?id=" + id;
    }

    @PutMapping("/post")
    public String updatePost(FullPostDto fullPostDto) {
        postService.update(fullPostDto);
        return "redirect:/post?id=" + fullPostDto.getId();
    }

    @PostMapping("/post/delete")
    public String deletePost(@RequestParam Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
