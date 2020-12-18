package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Service;
import com.ynov.springvacations.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    ServiceService mServiceService;
    public ServiceController(ServiceService serviceService) {
        mServiceService = serviceService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Service> getServices(){
        return mServiceService.getAll();
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(Service service){
        mServiceService.create(service);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Service show(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return mServiceService.findById(idLong);
    }

    // If id does not exist, creates new service with provided id
    @GetMapping("/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable String id, Service service) {
        Long idLong = Long.parseLong(id);
        mServiceService.update(idLong, service);
    }

    @GetMapping("/{id}/destroy")
    @ResponseStatus(HttpStatus.OK)
    public void destroy(@PathVariable String id) {
        mServiceService.destroy(Long.parseLong(id));
    }

}
