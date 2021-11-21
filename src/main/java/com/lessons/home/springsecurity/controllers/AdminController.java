package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.user.User;
import com.lessons.home.springsecurity.services.RoleService;
import com.lessons.home.springsecurity.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public final UserService userService;
    public final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String editUsers(Model model,
                            @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {
        int pageNumber = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<User> users = userService.getPageUsers(pageNumber - 1, pageSize);

        model.addAttribute("users", users.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("amountPages", users.getTotalPages());
        return "admin/users";
    }

    @PostMapping("/usersSave")
    public String changeUserEnabled(@RequestParam User user, Model model) {
        model.addAttribute("user", user);
        return "redirect:/admin/users";
    }
}
