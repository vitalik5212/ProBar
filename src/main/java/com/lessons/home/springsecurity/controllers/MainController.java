package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.services.GeneralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final GeneralService generalService;

    public MainController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("text1", generalService.getInfoByName("main_text_1"));
        model.addAttribute("text2", generalService.getInfoByName("main_text_2"));
        model.addAttribute("text3", generalService.getInfoByName("main_text_3"));

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
