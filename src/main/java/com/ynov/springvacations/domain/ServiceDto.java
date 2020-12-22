package com.ynov.springvacations.domain;

import com.sun.istack.Nullable;

import java.util.Set;
import java.util.stream.Collectors;

public class ServiceDto {

    @Nullable
    private Long id = null;

    private String name;
    private Set<ResidenceDto> residences;

    public ServiceDto() {
    }

    public ServiceDto(Service service) {
        this.id = service.getId();
        this.name = service.getName();
    }
    public ServiceDto(Service service, Boolean setResidences) {
        this.id = service.getId();
        this.name = service.getName();
        if(setResidences) this.residences = service.getResidences().stream()
                .map(ResidenceDto::new)
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ResidenceDto> getResidences() {
        return residences;
    }

    public void setResidences(Set<ResidenceDto> residences) {
        this.residences = residences;
    }
}
