package com.ynov.springvacations.controller;


import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.Service;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/residences")
public class ResidenceController {

    final ResidenceService mResidenceService;

    public ResidenceController(ResidenceService residenceService) {
        mResidenceService = residenceService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ResidenceDto> getResidences(){
        return mResidenceService.getResidences();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResidenceDto getResidence(@PathVariable String id){
        return mResidenceService.getResidence(Long.parseLong(id));
    }
    @GetMapping("/{id}/services")
    @ResponseStatus(HttpStatus.OK)
    public Set<ServiceDto> getResidenceServices(@PathVariable String id){
        return mResidenceService.getResidenceServices(Long.parseLong(id));
    }
    @GetMapping("/create_or_update")
    @ResponseStatus(HttpStatus.OK)
    public void setResidence(ResidenceDto residenceDto){
        mResidenceService.setResidence(residenceDto);
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void create(Long id) {
        mResidenceService.delete(id);
    }

}
