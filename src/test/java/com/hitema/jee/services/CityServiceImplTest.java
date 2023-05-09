package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import com.hitema.jee.interfaces.CRUDService;
import com.mysql.cj.log.Log;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Autowired
    private CRUDService<City, Long> service;

    @BeforeEach
    void setUp() {

    }

    @Order(1)
    @Test
    void create() {
        log.info("Start creating a new city");

        City newCity = new City();
        newCity.setCity("Pariss");
        service.create(newCity);


        log.trace("{}", newCity);
        assertEquals("Pariss", newCity.getCity(), "Error while creating a new city");
    }

    @Test
    void read() {
        log.info("Start reading a city");
        City city = service.read(1L);
        log.trace("{}", city);
        assertEquals("A Corua (La Corua)", city.getCity(), "Error while reading a city");
    }

    @Test
    @Order(2)
    void update() {
        var cities = service.readAll();

        City city = cities.stream()
                .filter(
                        c-> "Pariss".equals(c.getCity())
                ).findFirst().orElseThrow(()->new RuntimeException("No city found"));
        city.setCity("Pariss_updated");
        service.update(city);
        log.trace("{}", city);
        assertEquals("Pariss_updated", city.getCity(), "Error while updating a city");
    }

    @Test
    @Order(3)
    void delete() {
        var cities = service.readAll();

        City city = cities.stream()
                .filter(
                        c-> "Pariss_updated".equals(c.getCity())
                ).findFirst().orElseThrow(()->new RuntimeException("No city found"));

        service.delete(city.getId());

        log.trace("{}", city);

    }

    @Test
    void readAll() {
        service.readAll().forEach(c->log.trace("{}",c)
        );
    }
}