package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Ingredient;

import java.util.List;

public interface IngredientService extends BaseService<Ingredient> {

    List<Ingredient> findAll();
}
