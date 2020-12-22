package com.ynov.springvacations.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Service {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "services")
    private Set<Residence> residences = new HashSet<>();


    public Service(ServiceDto serviceDto) {
        this.id = serviceDto.getId();
        this.name = serviceDto.getName();
    }

    public Service() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Residence> getResidences() {
        return residences;
    }

    public void setResidences(Set<Residence> residences) {
        this.residences = residences;
    }
}
