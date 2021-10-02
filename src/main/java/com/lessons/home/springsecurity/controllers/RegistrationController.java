package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.services.RoleService;
import com.lessons.home.springsecurity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    private final UserService userService;
    private final RoleService roleService;

    public RegistrationController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/registration")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         Model model) {
        if(userService.loadUserByUsername(user.getUsername()) != null) {
            bindingResult.addError(new FieldError("user", "username", "This username already exists"));
            return "user/registration";
        }
        if(bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.create(user, roleService.getRoleByName("USER"));
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String login(@ModelAttribute("user") User user) {
        return "user/registration";
    }
}