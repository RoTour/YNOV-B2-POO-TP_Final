package com.ynov.springvacations.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String address;
    private String gps;
    private String type;

//    private List<Service> services;


    public Residence(ResidenceDto residenceDto) {
        this.id = residenceDto.getId();
        this.country = residenceDto.getCountry();
        this.address = residenceDto.getAddress();
        this.gps = residenceDto.getGps();
        this.type = residenceDto.getType();
    }

    public Residence() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
