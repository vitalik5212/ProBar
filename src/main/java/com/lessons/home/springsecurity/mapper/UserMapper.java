package com.lessons.home.springsecurity.mapper;

import com.lessons.home.springsecurity.dto.user.UserForViewDto;
import com.lessons.home.springsecurity.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserForViewDto toViewDto(User user);
}
