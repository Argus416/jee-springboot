package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import com.hitema.jee.interfaces.CRUDService;
import com.hitema.jee.interfaces.CityService;
import com.hitema.jee.repositories.CityRepository;
import com.hitema.jee.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    @Override
    public City create(City country) {
        return repository.save(country);
    }

    @Override
    public City read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public City update(City country) {
        return repository.save(country);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override

    public List<City> searchByCityByName(String city) {
        return repository.findByCityContaining(city);
    }
}
