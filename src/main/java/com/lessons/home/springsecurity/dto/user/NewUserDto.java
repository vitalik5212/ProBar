package com.lessons.home.springsecurity.dto.user;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Setter
@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NewUserDto {

    private String username;
    private String firsName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirthday;
}
