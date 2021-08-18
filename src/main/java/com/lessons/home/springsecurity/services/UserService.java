package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.entity.user.MyUserDetails;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
       User user = userRepository.getUserByUsername(username);

       if (user == null) {
           throw new UsernameNotFoundException("Could not find user");
       }

       return new MyUserDetails(user);
    }

    public void create(User user, Role role) {
        user.setPassword(user.encodePassword(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }
}