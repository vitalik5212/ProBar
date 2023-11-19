package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Drink;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrinkService extends BaseService<Drink> {

    Page<Drink> getPageCocktails(int pageNumber, int pageSize);

    List<Drink> findAll(String name);
}
