package com.ynov.springvacations.controller;


import com.ynov.springvacations.domain.Apartment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ApartmentController {


    @GetMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> getVehicles() {
        List<Apartment> apartments = new ArrayList<>();
        Apartment apartment = new Apartment(0L,2,150f,true,true,500f);
        apartments.add(apartment);
        return apartments;
    }
}
