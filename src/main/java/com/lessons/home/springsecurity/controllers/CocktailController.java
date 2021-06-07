package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.Cocktail;
import com.lessons.home.springsecurity.services.CocktailService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CocktailController {

    private final CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/cocktails")
    public String cocktailPage(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int pageNumber = page.orElse(1);
        int pageSize = size.orElse(4);

        Page<Cocktail> cocktails = cocktailService.getPageCocktails(pageNumber - 1, pageSize);

        model.addAttribute("cocktails", cocktails.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("amountPages", cocktails.getTotalPages());
        return "cocktails";
    }
}
