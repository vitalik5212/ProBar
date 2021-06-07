package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Cocktail;
import com.lessons.home.springsecurity.repositories.CocktailRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CocktailService implements DaoService<Cocktail> {

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public Page<Cocktail> getPageCocktails(int pageNumber, int pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<Cocktail> page = cocktailRepository.findAll(pageable);
    return page;
}

    @Override
    public List<String> getAllObjectsName() {
        return cocktailRepository.getAllNames();
    }

    @Override
    public List<Cocktail> getAllObjects() {
        List<Cocktail> cocktails = new ArrayList<>();
        cocktailRepository
                .findAll()
                .forEach(cocktails::add);

        return cocktails;
    }

    @Override
    public Cocktail getObjectById(Long id) {
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(id);

        if(cocktailOptional.isEmpty()) throw new IllegalStateException("Cocktail with id " + id + " does not exist");

        return cocktailOptional.get();
    }

    @Override
    public Cocktail getObjectByName(String name) {
        Cocktail cocktail = cocktailRepository.findByName(name);

        if(cocktail == null) throw new IllegalStateException("Cocktail with name " + name + " does not exist");

        return cocktail;
    }

    @Override
    public void delete(Long id) {
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
