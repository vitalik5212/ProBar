package com.lessons.home.springsecurity.dto.user;

import com.lessons.home.springsecurity.dto.post.ShortPostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PageWithPostsDto {

    private int amountPages;
    private int currentPage;
    private Set<ShortPostDto> posts;
}
