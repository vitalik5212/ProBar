package com.lessons.home.springsecurity.dto.post;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Setter
@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ShortPostDto {

    private Long id;
    private String name;
    private String linkForImage;
    private LocalDate dateOfCreate;
    private boolean likes;
    private boolean dislikes;
    private int raiting;
}
