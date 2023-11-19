package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.entity.Ingredient;
import com.lessons.home.springsecurity.repositories.IngredientRepository;
import com.lessons.home.springsecurity.services.BaseService;
import com.lessons.home.springsecurity.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getById(Long id) {
        return ingredientRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Ingredient with id " + id + " does not exist"));
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public void update(Ingredient ingredient) {
        if(ingredient == null) throw new NullPointerException("Ingredient cannot be null");
        ingredientRepository.save(ingredient);
    }

    @Override
    public void create(Ingredient ingredient) {
        if(ingredient == null) throw new NullPointerException("Ingredient cannot be null");
        ingredientRepository.save(ingredient);
    }
}
