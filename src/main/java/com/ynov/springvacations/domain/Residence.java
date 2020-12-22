package com.ynov.springvacations.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "residence")
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String address;
    private String gps;
    private String type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "residence_services",
            joinColumns = {
                    @JoinColumn(name = "residence_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "service_id")
            })
    private Set<Service> services = new HashSet<>();

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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
