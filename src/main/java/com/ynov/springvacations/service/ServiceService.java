package com.ynov.springvacations.service;

import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void create(com.ynov.springvacations.domain.Service service) {
        serviceRepository.save(service);
    }
}
