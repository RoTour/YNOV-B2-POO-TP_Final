package com.ynov.springvacations.domain;

import com.sun.istack.Nullable;

public class ServiceDto {

    @Nullable
    private Long id = null;

    private String name;

    public ServiceDto() {
    }

    public ServiceDto(Service service) {
        this.id = service.getId();
        this.name = service.getName();
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
}
