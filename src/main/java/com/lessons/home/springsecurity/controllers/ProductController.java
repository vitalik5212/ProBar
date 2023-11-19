package com.lessons.home.springsecurity.controllers;

import com.lessons.home.springsecurity.entity.Drink;
import com.lessons.home.springsecurity.services.DrinkService;
import com.lessons.home.springsecurity.services.IngredientService;
import com.lessons.home.springsecurity.services.impl.DrinkServiceImpl;
import com.lessons.home.springsecurity.services.impl.IngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final DrinkService drinkService;

    @GetMapping("/alcohol")
    public String alcoholPage(Model model,
                              @RequestParam(required = false, defaultValue = "1") Integer size,
                              @RequestParam(required = false, defaultValue = "6") Integer page) {

        Page<Drink> cocktails = drinkService.getPageCocktails(page - 1, size);

        model.addAttribute("drinks", cocktails.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("amountPages", cocktails.getTotalPages());

        return "Alcohol";
    }
}
