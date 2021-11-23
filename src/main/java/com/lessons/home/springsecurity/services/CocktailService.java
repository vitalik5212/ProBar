package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.content.Cocktail;
import com.lessons.home.springsecurity.repositories.CocktailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CocktailService implements DaoService<Cocktail> {

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public Page<Cocktail> getPageCocktails(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return cocktailRepository.findAll(pageable);
    }

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

        if (cocktailOptional.isEmpty()) {
            throw new IllegalStateException("Cocktail with id " + id + " does not exist");
        }

        return cocktailOptional.get();
    }

    @Override
    public Cocktail getObjectByName(String name) {
        Cocktail cocktail = cocktailRepository.findByName(name);

        if (cocktail == null) {
            throw new IllegalStateException("Cocktail with name " + name + " does not exist");
        }

        return cocktail;
    }

    @Override
    public void delete(Long id) {
        cocktailRepository.deleteById(id);
    }

    @Override
    public void update(Cocktail cocktail) {
        if (cocktail == null) {
            throw new NullPointerException("Cocktail cannot be null");
        }
        cocktailRepository.save(cocktail);
    }

    @Override
    public void create(Cocktail cocktail) {
        if (cocktail == null) {
            throw new NullPointerException("Cocktail cannot be null");
        } else {
            cocktailRepository.save(cocktail);
        }
    }
}
