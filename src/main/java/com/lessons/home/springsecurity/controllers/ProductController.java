package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.Drink;
import com.lessons.home.springsecurity.services.DrinkService;
import com.lessons.home.springsecurity.services.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    private DrinkService drinkService;
    private IngredientService ingredientService;

    public ProductController(DrinkService drinkService, IngredientService ingredientService) {
        this.drinkService = drinkService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/alcohol")
    public String alcoholPage(Model model,
                              @RequestParam("size") Optional<Integer> size,
                              @RequestParam("page") Optional<Integer> page) {
        int pageNumber = page.orElse(1);
        int pageSize = size.orElse(6);

        Page<Drink> cocktails = drinkService.getPageCocktails(pageNumber - 1, pageSize);

        model.addAttribute("drinks", cocktails.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("amountPages", cocktails.getTotalPages());

        return "Alcohol";
    }
}
