package com.hitema.jee.services;

import com.hitema.jee.entities.Country;
import com.hitema.jee.interfaces.CRUDService;
import com.mysql.cj.log.Log;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CountryServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Autowired
    private CRUDService<Country, Long> service;

    @BeforeEach
    void setUp() {

    }

    @Order(1)
    @Test
    void create() {
        log.info("Start creating a new country");

        Country newCountry = new Country();
        newCountry.setCountry("Francee");
        newCountry.setLastUpdate(LocalDateTime.now());
        service.create(newCountry);


        log.trace("{}", newCountry);
        assertNotNull(newCountry.getId(), "Error while creating a new country");
    }

    @Test
    void read() {
        log.info("Start reading a country");
        Country country = service.read(1L);
        log.trace("{}", country);
        assertEquals("Afghanistan", country.getCountry(), "Error while reading a country");
    }

    @Test
    @Order(2)
    void update() {
        var countries = service.readAll();

        Country country = countries.stream()
        .filter(
            c-> "Francee".equals(c.getCountry())
        ).findFirst().orElseThrow(()->new RuntimeException("No country found"));
        country.setCountry("Francee_updated");
        service.update(country);
        log.trace("{}", country);
        assertEquals("Francee_updated", country.getCountry(), "Error while updating a country");
    }

    @Test
    @Order(3)
    void delete() {
        var countries = service.readAll();

        Country country = countries.stream()
                .filter(
                        c-> "Francee_updated".equals(c.getCountry())
                ).findFirst().orElseThrow(()->new RuntimeException("No country found"));

        service.delete(country.getId());

        log.trace("{}", country);

    }

    @Test
    void readAll() {
            service.readAll().forEach(c->log.trace("{}",c)
        );
    }
}