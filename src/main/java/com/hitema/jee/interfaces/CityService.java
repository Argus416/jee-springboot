package com.hitema.jee.interfaces;

import com.hitema.jee.entities.City;

import java.util.List;

/**
 * CRUD Interface
 */
public interface CityService {
    City create(City entity);
    City read(Long id);
    City update(City entity);
    void delete(Long id);
    List<City> readAll();
    List<City> searchByCityByName(String city);

    List<City> getAllCapitals();
}
