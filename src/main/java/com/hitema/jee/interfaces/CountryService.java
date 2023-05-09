package com.hitema.jee.interfaces;

import com.hitema.jee.entities.Country;

import java.util.List;

/**
 * CRUD Interface
 */
public interface CountryService{
    Country create(Country entity);
    Country read(Long id);
    Country update(Country entity);
    void delete(Long id);
    List<Country> readAll();
}
