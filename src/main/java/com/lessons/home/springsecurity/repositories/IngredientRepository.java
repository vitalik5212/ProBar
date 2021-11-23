package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.content.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // TODO This method doesn't work
    @Query(value = "SELECT name FROM Ingredient")
    public Collection<String> getAllNames();

    @Query(value = "SELECT c FROM Cocktail c WHERE c.name = ?1")
    public Ingredient findByName(String name);
}
