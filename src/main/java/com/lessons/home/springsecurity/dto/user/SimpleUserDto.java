package com.lessons.home.springsecurity.dto.user;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SimpleUserDto {

    private Long id;
    private Long userName;
}
