package com.hitema.jee.repositories;

import com.hitema.jee.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCityContaining(String city);
}
