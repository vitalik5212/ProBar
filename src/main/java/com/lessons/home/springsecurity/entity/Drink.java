package com.lessons.home.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "drinks")
public class Drink extends BaseEntity {

    @NotNull(message = "Name is mandatory")
    private String name;

    private boolean hasAlcohol;

    private String info;

    private String land;

    private int strenght;

    @ManyToMany
    @JoinTable(
            name = "cocktails_drinks",
            joinColumns = @JoinColumn(name = "drink_id"),
            inverseJoinColumns = @JoinColumn(name = "cocktail_id")
    )
    private Set<Cocktail> cocktails = new HashSet<>();
}
