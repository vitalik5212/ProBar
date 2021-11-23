package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.content.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Query(value = "SELECT name FROM Drink")
    public Collection<String> getAllNames();

    @Query(value = "SELECT c FROM Cocktail c WHERE c.name = ?1")
    public Drink findByName(String name);

    @Override
    Page<Drink> findAll(Pageable pageable);
}
