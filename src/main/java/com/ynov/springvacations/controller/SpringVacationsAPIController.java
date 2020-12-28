package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.service.SpringVacationsAPIService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SpringVacationsAPIController {

    SpringVacationsAPIService apiService;

    public SpringVacationsAPIController(SpringVacationsAPIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/residencesByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<ResidenceDto> getResidenceByCountry(String country) {
        return apiService.getResidenceByCountry(country);
    }

    @GetMapping("/apartsByRegion")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsByRegion(String region) {
        return apiService.getApartmentsByRegion(region);
    }


}
