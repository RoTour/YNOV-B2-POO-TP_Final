package com.ynov.springvacations.service;

import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void create(com.ynov.springvacations.domain.Service service) {
        serviceRepository.save(service);
    }

    public List<com.ynov.springvacations.domain.Service> getAll() {
        return serviceRepository.findAll();
    }

    public com.ynov.springvacations.domain.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(new com.ynov.springvacations.domain.Service());
    }

    public void update(Long id, com.ynov.springvacations.domain.Service newValues) {
        newValues.setId(id);
        serviceRepository.save(newValues);
    }
}
