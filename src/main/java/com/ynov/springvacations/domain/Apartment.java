package com.ynov.springvacations.domain;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer nbBeds;
    private Float area;
    private Boolean babyKit;
    private Boolean airConditioning;
    private Float rentPerDay;

    public Apartment() {
    }

    public Apartment(ApartmentDto apartmentDto) {
        this.id = apartmentDto.getId();
        this.nbBeds = apartmentDto.getNbBeds();
        this.area = apartmentDto.getArea();
        this.babyKit = apartmentDto.getBabyKit();
        this.airConditioning = apartmentDto.getAirConditioning();
        this.rentPerDay = apartmentDto.getRentPerDay();
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

    public Float getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(Float rentPerDay) {
        this.rentPerDay = rentPerDay;
    }
}
