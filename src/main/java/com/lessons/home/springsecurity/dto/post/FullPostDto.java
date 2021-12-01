package com.lessons.home.springsecurity.dto.post;

import com.lessons.home.springsecurity.dto.CommentDto;
import com.lessons.home.springsecurity.dto.user.UserForViewDto;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FullPostDto {

    private Long id;
    private String name;
    private UserForViewDto author;
    private String textContent;
    private String linkForImage;
    private LocalDate dateOfCreate;
    private boolean likes;
    private boolean dislikes;
    private int raiting;
    private Set<CommentDto> comments;
}
