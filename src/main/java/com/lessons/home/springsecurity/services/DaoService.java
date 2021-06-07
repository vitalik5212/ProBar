package com.lessons.home.springsecurity.services;

import java.util.Collection;

/**
 * Base Interface for services, that describes general methods persistent objects for work with database;
 *
 * @author Vitalik Skuratovskyj
 * @param <T>
 */
public interface DaoService<T> {

    Collection<String> getAllObjectsName();

    Collection<T> getAllObjects();

    T getObjectById(Long id);

    T getObjectByName(String name);

    void delete(Long id);

    void update(T object);

    void create(T object);
}