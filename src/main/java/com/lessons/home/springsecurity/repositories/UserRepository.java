package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByUsername(@Param("username") String username);
}
