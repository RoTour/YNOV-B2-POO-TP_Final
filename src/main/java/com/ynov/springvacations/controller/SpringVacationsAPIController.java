package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.service.SpringVacationsAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SpringVacationsAPIController {

    SpringVacationsAPIService apiService;

    public SpringVacationsAPIController(SpringVacationsAPIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/country")
    public List<ResidenceDto> getResidenceByCountry(String country){
        return apiService.getResidenceByCountry(country);
    }

}
