package com.lessons.home.springsecurity.dto;

import com.lessons.home.springsecurity.dto.user.UserForViewDto;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Setter
@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommentDto {

    private Long id;
    private String text;
    private LocalDate dateOfCreate;
    private boolean likes;
    private boolean dislikes;
    private UserForViewDto author;
}
