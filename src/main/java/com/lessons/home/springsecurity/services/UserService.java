package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.user.MyUserDetails;
import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return new MyUserDetails(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void create(User user, Role role) {
        user.setPassword(user.encodePassword(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }

    public Page<User> getPageUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);
    }

    public void changeUserEnableById(Integer id) {
        MyUserDetails user = new MyUserDetails(userRepository.getUserById(id));
        user.setEnable(!user.isEnabled());
    }
}
