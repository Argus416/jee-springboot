package com.hitema.jee.interfaces;

import com.hitema.jee.entities.Country;

import java.util.List;

/**
 * CRUD Interface
 */
public interface CRUDService<T, id> {
    T create(T entity);
    T read(Long id);
    T update(T entity);
    void delete(Long id);
    List<T> readAll();
}
