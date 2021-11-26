package com.lessons.home.springsecurity.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

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
