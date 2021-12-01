package com.lessons.home.springsecurity.dto.post;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NewPostDto {

    private String name;
    private String textContent;
}
