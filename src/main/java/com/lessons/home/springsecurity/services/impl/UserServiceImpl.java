package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.entity.user.MyUserDetails;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.repositories.UserRepository;
import com.lessons.home.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
       User user = userRepository.getByUsername(username);
       return new MyUserDetails(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public void create(User user, Role role) {
        user.setPassword(user.encodePassword(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void create(User entity) {
        userRepository.save(entity);
    }
}
