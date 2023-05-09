package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import com.hitema.jee.interfaces.CityService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Autowired
    private CityService cityService;

    @BeforeEach
    void setUp() {

    }

    @Order(1)
    @Test
    void create() {
        log.info("<<<<<<<< Start creating a new city >>>>>>>>>");
        City newCity = new City();
        Country country = new Country();

        country.setId(1L);

        newCity.setCity("Pariss");
        newCity.setCountryId(country);
        newCity.setLastUpdate(LocalDateTime.now());
        log.trace("{}", newCity);

        cityService.create(newCity);

        assertNotNull(newCity.getId(), "Error while creating a new city");
        log.info("<<<<<<<< Finish creating the city >>>>>>>>>");
    }

    @Test
    void read() {
        log.info("<<<<<<<< Start reading the city >>>>>>>>>");
        City city = cityService.read(1L);
        log.trace("{}", city);
        assertEquals("A Corua (La Corua)", city.getCity(), "Error while reading a city");
        log.info("<<<<<<<< Finish reading the city >>>>>>>>>");
    }

    @Test
    @Order(2)
    void update() {
        log.info("<<<<<<<< Start updating a city >>>>>>>>>");
        var cities = cityService.readAll();

        City city = cities.stream()
                .filter(
                        c-> "Pariss".equals(c.getCity())
                ).findFirst().orElseThrow(()->new RuntimeException("No city found"));
        city.setCity("Pariss_updated");
        cityService.update(city);
        log.trace("{}", city);
        assertEquals("Pariss_updated", city.getCity(), "Error while updating a city");
        log.info("<<<<<<<< Finish updating a city >>>>>>>>>");
    }

    @Test
    @Order(4)
    void delete() {
        log.info("<<<<<<<< Start deleting city >>>>>>>>>");
        var cities = cityService.readAll();

        City city = cities.stream()
                .filter(
                        c-> "Pariss_updated".equals(c.getCity())
                ).findFirst().orElseThrow(()->new RuntimeException("No city found"));

        cityService.delete(city.getId());

        log.trace("{}", city);
        log.info("<<<<<<<< Finish deleting city >>>>>>>>>");
    }

    @Test
    @Order(3)
    void searchByCity(){
        log.info("<<<<<<<< Start searching city >>>>>>>>>");
        List<City> cities = cityService.searchByCityByName("Pariss");

        AtomicReference<Boolean> cityIsFound = new AtomicReference<>(false);

        cities.forEach(c->{
            if(c.getCity().equals("Pariss")){
                cityIsFound.set(true);
            }
            log.trace("Read city {}",c);
        });

        assertEquals(true, cityIsFound.get(), "Error while searching a city");
        log.info("<<<<<<<< Finish searching city >>>>>>>>>");
    }

    @Test
    void readAll() {
        cityService.readAll().forEach(c->log.trace("{}",c));
    }
}