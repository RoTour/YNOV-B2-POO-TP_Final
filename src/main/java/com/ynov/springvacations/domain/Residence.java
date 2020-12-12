package com.ynov.springvacations.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "residence")
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long residence_id;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;

    @Column(name = "gps_location")
    private String gpsLocation;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "services_available")
    private String services;

    @Column(name = "created_at")
    private Date created_at = new Date();

    @Column(name = "updated_at")
    private Date updated_at = new Date();

    @OneToMany
    @JoinColumn(name = "residence_id")
    private Set<Apartment> apartments;

    public Residence() {
    }

    public Residence(String country, String state, String address, String gpsLocation, String locationType, String services, Set<Apartment> apartments) {
        this.country = country;
        this.state = state;
        this.address = address;
        this.gpsLocation = gpsLocation;
        this.locationType = locationType;
        this.services = services;
        this.apartments = apartments;
    }

    /**
     * ******************* *
     * Getters and Setters *
     * ******************* *
     */

    public Long getResidence_id() {
        return residence_id;
    }

    public void setResidence_id(Long residence_id) {
        this.residence_id = residence_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
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