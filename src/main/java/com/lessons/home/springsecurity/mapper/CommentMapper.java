package com.lessons.home.springsecurity.mapper;

import com.lessons.home.springsecurity.dto.CommentDto;
import com.lessons.home.springsecurity.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = {UserMapper.class})
public interface CommentMapper {
    
    CommentDto toDto(Comment comment);
}
