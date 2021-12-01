package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.dto.post.FullPostDto;
import com.lessons.home.springsecurity.dto.post.NewPostDto;
import com.lessons.home.springsecurity.dto.user.PageWithPostsDto;
import com.lessons.home.springsecurity.services.CommentService;
import com.lessons.home.springsecurity.services.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "PostController")
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
    public FullPostDto createPost(@RequestBody NewPostDto newPost) {
        return postService.create(newPost);
    }

    @PutMapping("/post")
    public String updatePost(FullPostDto fullPostDto) {
        postService.update(fullPostDto);
        return "redirect:/post?id=" + fullPostDto.getId();
    }

    @DeleteMapping("/post")
    public String deletePost(@RequestParam Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
