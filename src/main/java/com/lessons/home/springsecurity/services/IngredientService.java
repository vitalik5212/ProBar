package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Ingredient;
import com.lessons.home.springsecurity.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class IngredientService implements DaoService<Ingredient> {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Collection<String> getAllObjectsName() {
        return ingredientRepository.getAllNames();
    }

    @Override
    public Collection<Ingredient> getAllObjects() {
        Collection<Ingredient> ingredients = new HashSet<>();
        ingredientRepository
                .findAll()
                .forEach(ingredients::add);

        return ingredients;
    }

    @Override
    public Ingredient getObjectById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

        if(ingredientOptional.isEmpty()) throw new IllegalStateException("Ingredient with id " + id + " does not exist");

        return ingredientOptional.get();
    }

    @Override
    public Ingredient getObjectByName(String name) {
        Ingredient ingredient = ingredientRepository.findByName(name);

        if(ingredient == null) throw new IllegalStateException("Ingredient with name " + name + " does not exist");

        return ingredient;
    }

    @Override
    public void delete(Long id) {
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
