package com.lessons.home.springsecurity.mapper;

import com.lessons.home.springsecurity.dto.post.FullPostDto;
import com.lessons.home.springsecurity.dto.post.NewPostDto;
import com.lessons.home.springsecurity.dto.post.ShortPostDto;
import com.lessons.home.springsecurity.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {CommentMapper.class, UserMapper.class})
public interface PostMapper {

    ShortPostDto toShortDto(Post post);

    FullPostDto toFullDto(Post post);

    Post fromNewDto(NewPostDto post);

    Post fromFullDto(FullPostDto post);
}
