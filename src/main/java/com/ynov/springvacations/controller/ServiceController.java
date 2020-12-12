package com.ynov.springvacations.controller;


import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.Service;
import com.ynov.springvacations.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    ResidenceService mResidenceService;

    public ServiceController(ResidenceService residenceService) {
        mResidenceService = residenceService;
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public List<Residence> create(String name, ArrayList<Residence> linkedResidences){
//        Service newService = new Service(name);
        return mResidenceService.getResidences();
    }

}
