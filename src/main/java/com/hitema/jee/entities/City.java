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
    private Country countryId;

    @Column(name = "city")
    private String city;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "capital")
    private Boolean isCapital;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country country_id) {
        this.countryId = country_id;
    }

    public Boolean getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(Boolean isCapital) {
        this.isCapital = isCapital;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", city='" + city + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", isCapital=" + isCapital +
                '}';
    }
}
