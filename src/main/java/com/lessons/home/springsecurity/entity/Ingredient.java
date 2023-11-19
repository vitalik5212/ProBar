package com.lessons.home.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @NotNull(message = "Name is mandatory")
    private String name;

    private String info;

    @ManyToMany
    @JoinTable(
            name = "cocktails_ingredients",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "cocktail_id")
    )
    private Set<Cocktail> cocktails = new HashSet<>();
}
