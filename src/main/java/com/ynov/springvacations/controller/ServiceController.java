package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Service;
import com.ynov.springvacations.service.ServiceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    ServiceService mServiceService;

    public ServiceController(ServiceService serviceService) {
        mServiceService = serviceService;
    }

    @RequestMapping("/")
    public List<Service> getServices(){
        return mServiceService.getAll();
    }

    @RequestMapping("/create")
    public void create(Service service){
        mServiceService.create(service);
    }

    @RequestMapping("/{id}")
    public Service show(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return mServiceService.findById(idLong);
    }

    // If id does not exist, creates new service with provided id
    @RequestMapping("/{id}/edit")
    public void edit(@PathVariable String id, Service service) {
        Long idLong = Long.parseLong(id);
        mServiceService.update(idLong, service);
    }

}
