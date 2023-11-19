package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.repositories.RoleRepository;
import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findFirstByName(name);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
