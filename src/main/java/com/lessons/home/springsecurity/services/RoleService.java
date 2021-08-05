package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.repositories.RoleRepository;
import com.lessons.home.springsecurity.entity.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
