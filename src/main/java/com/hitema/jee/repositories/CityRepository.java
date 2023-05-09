package com.hitema.jee.repositories;

import com.hitema.jee.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
