package com.lessons.home.springsecurity.mapper;

import com.lessons.home.springsecurity.dto.post.FullPostDto;
import com.lessons.home.springsecurity.dto.post.NewPostDto;
import com.lessons.home.springsecurity.dto.post.ShortPostDto;
import com.lessons.home.springsecurity.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostMapper {

    ShortPostDto toShortDto(Post post);

    FullPostDto toFullDto(Post post);
    
    Post fromNewDto(NewPostDto post);

    Post fromFullDto(FullPostDto post);
}
