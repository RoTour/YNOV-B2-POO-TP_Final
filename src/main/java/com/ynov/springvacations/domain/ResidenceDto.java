package com.ynov.springvacations.domain;

import com.sun.istack.Nullable;

import java.util.Set;
import java.util.stream.Collectors;

public class ResidenceDto {

    @Nullable
    private Long id = null;
    private String country;
    private String address;
    private String gps;
    private String type;
    private Set<ServiceDto> services;

    public ResidenceDto() {
    }

    public ResidenceDto(Residence residence) {
        this.id = residence.getId();
        this.country = residence.getCountry();
        this.address = residence.getAddress();
        this.gps = residence.getGps();
        this.type = residence.getType();
    }

    public ResidenceDto(Residence residence, Boolean setServices) {
        this.id = residence.getId();
        this.country = residence.getCountry();
        this.address = residence.getAddress();
        this.gps = residence.getGps();
        this.type = residence.getType();
        if (setServices) {
            this.services = residence.getServices().stream()
                    .map(ServiceDto::new)
                    .collect(Collectors.toSet());
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<ServiceDto> getServices() {
        return services;
    }

    public void setServices(Set<ServiceDto> services) {
        this.services = services;
    }
}
