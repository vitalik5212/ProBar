package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.entity.Cocktail;
import com.lessons.home.springsecurity.repositories.CocktailRepository;
import com.lessons.home.springsecurity.services.CocktailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CocktailServiceImpl implements CocktailService {

    private final CocktailRepository cocktailRepository;

    @Override
    public Page<Cocktail> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return cocktailRepository.findAll(pageable);
    }

    @Override
    public List<Cocktail> findAll() {
        return cocktailRepository.findAll();
    }

    @Override
    public Cocktail getById(Long id) {
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(id);

        if(cocktailOptional.isEmpty()) throw new EntityNotFoundException("Cocktail with id " + id + " does not exist");

        return cocktailOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        cocktailRepository.deleteById(id);
    }

    @Override
    public void update(Cocktail cocktail) {
        if(cocktail == null) throw new NullPointerException("Cocktail cannot be null");
        cocktailRepository.save(cocktail);
    }

    @Override
    public void create(Cocktail cocktail) {
        if(cocktail == null) throw new NullPointerException("Cocktail cannot be null");
        else    cocktailRepository.save(cocktail);
    }
}
