package com.ynov.springvacations.controller;


import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> getVehicles() {
        List<Apartment> apartments = new ArrayList<>();
        Apartment apartment = new Apartment(2,150f,true,true,500f);
        apartments.add(apartment);
        return apartmentService.getApartments();
    }

    @GetMapping("/generate")
    @ResponseStatus(HttpStatus.OK)
    public Apartment generate() {
        return apartmentService.generateApartment();
    }


}
