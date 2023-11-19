package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.Cocktail;
import com.lessons.home.springsecurity.services.CocktailService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailService cocktailService;

    @GetMapping("/cocktails")
    public String cocktails (Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "6") Integer size) {

        Page<Cocktail> cocktails = cocktailService.getPage(page - 1, size);

        model.addAttribute("cocktails", cocktails.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("amountPages", cocktails.getTotalPages());
        return "cocktails";
    }


    @GetMapping("/cocktail/{id}")
    public String cocktail (Model model,
                            @PathVariable Long id) {

        model.addAttribute("cocktail", cocktailService.getById(id));
        return "cocktail";
    }
}