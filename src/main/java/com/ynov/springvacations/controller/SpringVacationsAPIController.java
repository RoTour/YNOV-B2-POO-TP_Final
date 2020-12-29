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

import java.util.Date;
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

    @GetMapping("/apartmentsByRegion")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsByRegion(String region) {
        return apiService.getApartmentsByRegion(region);
    }

    @GetMapping("apartmentsByService")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsByService(String serviceName) {
        return apiService.getApartmentsByService(serviceName);
    }

    @GetMapping("apartmentsWithPool")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsWithPool() {
        return apiService.getApartmentsWithPool();
    }

    @GetMapping("apartmentsByType")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsByType(String type) {
        return apiService.getApartmentsByType(type);
    }

    @GetMapping("apartmentsAtMountain")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsAtMountain() {
        return apiService.getApartmentsAtMountain();
    }

    @GetMapping("apartmentsAvailable")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartmentsAvailable(String startDate, String endDate) {
        return apiService.getApartmentsAvailable(startDate, endDate);
    }




}
