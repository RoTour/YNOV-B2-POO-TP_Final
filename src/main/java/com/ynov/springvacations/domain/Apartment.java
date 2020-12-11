package com.ynov.springvacations.domain;

import javax.persistence.*;

@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer nbBeds;
    private Float area;
    private Boolean babyKit;
    private Boolean airConditioning;
    private Float rent;

    public Apartment(Long id, Integer nbBeds, Float area, Boolean babyKit, Boolean airConditioning, Float rent) {
        this.id = id;
        this.nbBeds = nbBeds;
        this.area = area;
        this.babyKit = babyKit;
        this.airConditioning = airConditioning;
        this.rent = rent;
    }

    public Apartment() {
        this.nbBeds = 0;
        this.area = 0f;
        this.babyKit = false;
        this.airConditioning = false;
        this.rent = 0f;
    }

    @Override
    public String toString() {
        return "id:"+this.id+"; nbBeds:"+this.nbBeds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbBeds() {
        return nbBeds;
    }

    public void setNbBeds(Integer nbBeds) {
        this.nbBeds = nbBeds;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Boolean getBabyKit() {
        return babyKit;
    }

    public void setBabyKit(Boolean babyKit) {
        this.babyKit = babyKit;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Float getRent() {
        return rent;
    }

    public void setRent(Float rent) {
        this.rent = rent;
    }
}
