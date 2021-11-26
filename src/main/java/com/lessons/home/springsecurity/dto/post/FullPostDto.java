package com.lessons.home.springsecurity.dto.post;

import com.lessons.home.springsecurity.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FullPostDto {

    private Long id;
    private String name;
    private String textContent;
    private String linkForImage;
    private LocalDate dateOfCreate;
    private boolean likes;
    private boolean dislikes;
    private int raiting;
    private Set<Comment> comments;
}
