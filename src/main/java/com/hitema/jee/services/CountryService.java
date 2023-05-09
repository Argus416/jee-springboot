package com.hitema.jee.services;

import com.hitema.jee.entities.Country;

import java.util.List;

/**
 * CRUD Interface
 */
public interface CountryService {
    Country create(Country country);
    Country read(Long id);
    Country update(Country country);
    void delete(Long id);
    List<Country> readAll();


}
