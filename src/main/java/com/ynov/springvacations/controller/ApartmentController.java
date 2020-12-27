package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.service.ApartmentService;
import com.ynov.springvacations.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {
    final ApartmentService mApartmentService;
    public ApartmentController(ApartmentService apartmentService) {
        mApartmentService = apartmentService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ApartmentDto> getApartments(){
        return mApartmentService.getApartments();
    }

    @GetMapping("/create_or_update")
    @ResponseStatus(HttpStatus.OK)
    public void setApartment(ApartmentDto apartmentDto){
        mApartmentService.setApartment(apartmentDto);
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Long id) {
        mApartmentService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApartmentDto getApartment(@PathVariable String id){
        return mApartmentService.getApartment(Long.parseLong(id));
    }

}
