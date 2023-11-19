package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.services.RoleService;
import com.lessons.home.springsecurity.services.UserService;
import com.lessons.home.springsecurity.services.impl.RoleServiceImpl;
import com.lessons.home.springsecurity.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/registration")
    public String create(@ModelAttribute @Valid User user,
                         BindingResult bindingResult) {

        if(userService.findByUsername(user.getUsername()) != null) {
            bindingResult.addError(
                new FieldError("user", "username", "This username already exists")
            );

            return "user/registration";
        }
        if(bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.create(user, roleService.findByName("USER"));
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String login(@ModelAttribute("user") User user) {
        return "user/registration";
    }
}