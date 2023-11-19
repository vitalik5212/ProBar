package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.entity.Drink;
import com.lessons.home.springsecurity.repositories.DrinkRepository;
import com.lessons.home.springsecurity.services.BaseService;
import com.lessons.home.springsecurity.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    @Override
    public Page<Drink> getPageCocktails(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Drink> page = drinkRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Drink> findAll(String name) {

        if(name == null) {
            return drinkRepository.findAll();
        } else {
            return drinkRepository.findByName(name);
        }
    }

    @Override
    public Drink getById(Long id) {
        return drinkRepository
            .findById(id)
            .orElseThrow(() -> new IllegalStateException("Drink with id " + id + " does not exist"));
    }

    @Override
    public void deleteById(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public void update(Drink drink) {
        if(drink == null) throw new NullPointerException("Cocktail cannot be null");
        drinkRepository.save(drink);
    }

    @Override
    public void create(Drink drink) {
        if(drink == null) throw new NullPointerException("Cocktail cannot be null");
        drinkRepository.save(drink);
    }
}