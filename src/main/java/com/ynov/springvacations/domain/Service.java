package com.ynov.springvacations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "services")
//@JsonIgnoreProperties(value = {"residences"})
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Service implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "services")
    private Set<Residence> residences = new HashSet<>();


    public Service(ServiceDto serviceDto) {
        this.id = serviceDto.getId();
        this.name = serviceDto.getName();
    }

    public Service() {
    }

    public Service(ServiceDto serviceDto, Boolean setResidences) {
        this.id = serviceDto.getId();
        this.name = serviceDto.getName();
        if(setResidences){
            this.residences = serviceDto.getResidences().stream()
                    .map(Residence::new)
                    .collect(Collectors.toSet());
        }
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
