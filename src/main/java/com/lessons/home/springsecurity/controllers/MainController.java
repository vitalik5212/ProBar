package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.services.GeneralService;
import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.services.RoleService;
import com.lessons.home.springsecurity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final GeneralService generalService;
    private final UserService userService;
    private final RoleService roleService;

    public MainController(GeneralService generalService, UserService userService, RoleService roleService) {
        this.generalService = generalService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("text1", generalService.getInfoByName("main_text_1"));
        model.addAttribute("text2", generalService.getInfoByName("main_text_2"));
        model.addAttribute("text3", generalService.getInfoByName("main_text_3"));

        return "index";
    }

    @GetMapping("/registration")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @PostMapping("logout")
    public String logout() {
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String newUser(@ModelAttribute User user) {
            userService.create(user, roleService.getRoleByName("USER"));
        return "redirect:/";
    }
}
