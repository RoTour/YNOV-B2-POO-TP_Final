package com.ynov.springvacations.domain;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations;

    public Apartment() {
    }

    public Apartment(ApartmentDto apartmentDto, Residence residence) {
        this.id = apartmentDto.getId();
        this.nbBeds = apartmentDto.getNbBeds();
        this.area = apartmentDto.getArea();
        this.babyKit = apartmentDto.getBabyKit();
        this.airConditioning = apartmentDto.getAirConditioning();
        this.rentPerDay = apartmentDto.getRentPerDay();
        this.residence = residence;
    }

    public Apartment(Integer nbBeds, Float area, Boolean babyKit, Boolean airConditioning, Float rentPerDay, Residence residence) {
        this.nbBeds = nbBeds;
        this.area = area;
        this.babyKit = babyKit;
        this.airConditioning = airConditioning;
        this.rentPerDay = rentPerDay;
        this.residence = residence;
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

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
