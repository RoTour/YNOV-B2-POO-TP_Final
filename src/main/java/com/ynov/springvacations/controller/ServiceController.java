package com.ynov.springvacations.controller;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/service")
public class ServiceController {

    ServiceService mServiceService;
    public ServiceController(ServiceService serviceService) {
        mServiceService = serviceService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ServiceDto> getServices(){
        return mServiceService.getServices();
    }

    @GetMapping("/create_or_update")
    @ResponseStatus(HttpStatus.OK)
    public void setService(ServiceDto serviceDto){
        mServiceService.setService(serviceDto);
    }

    @GetMapping("{id}/residences")
    @ResponseStatus(HttpStatus.OK)
    public Set<ResidenceDto> getResidences(@PathVariable String id) {
        return mServiceService.getResidences(Long.parseLong(id));
    }

    @GetMapping("/{id}/addResidence")
    @ResponseStatus(HttpStatus.OK)
    public void addResidence(@PathVariable String id, Long residenceId) {
        mServiceService.addResidence(Long.parseLong(id), residenceId);
    }

    @GetMapping("/{id}/removeResidence")
    @ResponseStatus(HttpStatus.OK)
    public void removeResidence(@PathVariable String id, Long residenceId) {
        mServiceService.removeResidence(Long.parseLong(id), residenceId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceDto getService(@PathVariable String id) {
        return mServiceService.getService(Long.parseLong(id));
    }


    @GetMapping("/{id}/destroy")
    @ResponseStatus(HttpStatus.OK)
    public void destroy(@PathVariable String id) {
        mServiceService.delete(Long.parseLong(id));
    }

}
