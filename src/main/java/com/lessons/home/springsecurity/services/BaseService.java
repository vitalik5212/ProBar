package com.lessons.home.springsecurity.services;

/**
 * Base Interface for services, that describes general methods persistent objects for work with database;
 *
 * @author Vitalik Skuratovskyj
 * @param <T>
 */
public interface BaseService<T> {

    T getById(Long id);

    void deleteById(Long id);

    void update(T object);

    void create(T object);
}