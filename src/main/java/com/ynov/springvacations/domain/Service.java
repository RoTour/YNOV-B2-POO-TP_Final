package com.ynov.springvacations.domain;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
