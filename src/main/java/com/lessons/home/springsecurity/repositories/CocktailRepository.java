package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.content.Cocktail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    @Query(value = "SELECT name FROM Cocktail")
    public List<String> getAllNames();

    @Query(value = "SELECT c FROM Cocktail c WHERE c.name = ?1")
    public Cocktail findByName(String name);

    @Override
    Page<Cocktail> findAll(Pageable pageable);
}
