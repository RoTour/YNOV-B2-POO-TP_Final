package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/residences")
public class ResidenceController {

    ResidenceService residenceService;

    public ResidenceController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> getVehicles() {
        List<Apartment> apartments = new ArrayList<>();
        Apartment apartment = new Apartment(2, 150f, true, true, 500f);
        apartments.add(apartment);
        return apartments;
    }

    @GetMapping("/generate")
    @ResponseStatus(HttpStatus.OK)
    public Residence generateResidence() {
        return residenceService.generateResidence(
                Set.of(new Apartment(2, 150f, true, true, 500f))
        );
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(Residence residence) {
        residenceService.add(residence);
    }
}
