package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Query(value = "SELECT c FROM Cocktail c WHERE c.name = ?1")
    List<Drink> findByName(String name);
}
