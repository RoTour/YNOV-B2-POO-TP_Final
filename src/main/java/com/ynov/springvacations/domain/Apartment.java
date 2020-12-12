package com.ynov.springvacations.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartment_id;

    @Column(name = "number_of_beds")
    private Integer nbBeds;

    @Column(name = "area")
    private Float area;

    @Column(name = "has_baby_kit")
    private Boolean babyKit;

    @Column(name = "has_air_conditioning")
    private Boolean airConditioning;

    @Column(name = "rent_per_day")
    private Float rent;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "residence_id")
    private Residence residence_id;

    public Apartment() {
    }

    public Apartment(Integer nbBeds, Float area, Boolean babyKit, Boolean airConditioning, Float rent) {
        this.nbBeds = nbBeds;
        this.area = area;
        this.babyKit = babyKit;
        this.airConditioning = airConditioning;
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "id:"+this.apartment_id +"; nbBeds:"+this.nbBeds;
    }

    public Long getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(Long id) {
        this.apartment_id = id;
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

    public Residence getResidence_id() {
        return residence_id;
    }

    public void setResidence_id(Residence residence_id) {
        this.residence_id = residence_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
