package com.lessons.home.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cocktails")
public class Cocktail extends BaseEntity {

    @NotNull(message = "Name is mandatory")
    private String name;

    private String info;

    private String image;

    @ManyToMany
    @JoinTable(
            name = "cocktails_drinks",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private Set<Drink> drinks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cocktails_ingredients",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Drink> ingredients = new HashSet<>();

    public Set<Drink> getAllIngredients() {
        Set<Drink> allIngredients = new HashSet<>();
        allIngredients.addAll(ingredients);
        allIngredients.addAll(drinks);
        return allIngredients;
    }
}

