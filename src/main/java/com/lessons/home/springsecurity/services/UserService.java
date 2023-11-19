package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.entity.user.User;

public interface UserService extends BaseService<User> {

    User findByUsername(String username);

    void create(User user, Role role);
}
