package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.services.GeneralService;
import com.lessons.home.springsecurity.services.impl.GeneralServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final GeneralService generalService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("text1", generalService.getInfoByName("main_text_1"));
        model.addAttribute("text2", generalService.getInfoByName("main_text_2"));
        model.addAttribute("text3", generalService.getInfoByName("main_text_3"));

        return "index";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
