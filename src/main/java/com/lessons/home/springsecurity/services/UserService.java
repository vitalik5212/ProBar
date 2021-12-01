package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.user.CustomUserDetails;
import com.lessons.home.springsecurity.entity.user.Role;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.repositories.RoleRepository;
import com.lessons.home.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);

        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User saveUser(User user) {
        Role userRole = roleRepository.getRoleByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findUserByUsername(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
