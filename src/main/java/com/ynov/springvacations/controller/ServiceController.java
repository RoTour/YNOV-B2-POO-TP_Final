package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Service;
import com.ynov.springvacations.service.ServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

    ServiceService mServiceService;

    public ServiceController(ServiceService serviceService) {
        mServiceService = serviceService;
    }

    @RequestMapping("/create")
    public void create(Service service){
        mServiceService.create(service);
    }

}
