package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.entity.Cocktail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CocktailService extends BaseService<Cocktail> {

    Page<Cocktail> getPage(int pageNumber, int pageSize);

    List<Cocktail> findAll();
}
