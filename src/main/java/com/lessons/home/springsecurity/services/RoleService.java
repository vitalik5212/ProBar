package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.user.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();
}
