package com.hitema.jee.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country_id;

    @Column(name = "city")
    private String city;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("id=").append(id);
        sb.append(", country_id=").append(country_id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }
}
