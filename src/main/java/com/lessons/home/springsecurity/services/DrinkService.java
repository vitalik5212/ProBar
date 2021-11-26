package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.content.Drink;
import com.lessons.home.springsecurity.repositories.DrinkRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class DrinkService implements DaoService<Drink> {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Page<Drink> getPageCocktails(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Drink> page = drinkRepository.findAll(pageable);
        return page;
    }

    public Collection<String> getAllObjectsName() {
        return drinkRepository.getAllNames();
    }

    @Override
    public Collection<Drink> getAllObjects() {
        Collection<Drink> drinks = new HashSet<>();
        drinkRepository
                .findAll()
                .forEach(drinks::add);

        return drinks;
    }

    @Override
    public Drink getObjectById(Long id) {
        Optional<Drink> drinkOptional = drinkRepository.findById(id);

        if (drinkOptional.isEmpty()) {
            throw new IllegalStateException("Drink with id " + id + " does not exist");
        }

        return drinkOptional.get();
    }

    @Override
    public Drink getObjectByName(String name) {
        Drink drink = drinkRepository.findByName(name);

        if (drink == null) {
            throw new IllegalStateException("Drink with name " + name + " does not exist");
        }

        return drink;
    }

    @Override
    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public void update(Drink drink) {
        if (drink == null) {
            throw new NullPointerException("Cocktail cannot be null");
        }
        drinkRepository.save(drink);
    }

    @Override
    public void create(Drink drink) {
        if (drink == null) {
            throw new NullPointerException("Cocktail cannot be null");
        }
        drinkRepository.save(drink);
    }
}