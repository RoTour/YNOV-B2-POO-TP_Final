package com.ynov.springvacations.domain;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Service {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
