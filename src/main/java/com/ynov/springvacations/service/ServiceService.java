package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {
    ServiceRepository mServiceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.mServiceRepository = serviceRepository;
    }

    public List<ServiceDto> getServices() {
        return mServiceRepository.findAll().stream().map((ServiceDto::new)).collect(Collectors.toList());
    }

    public ServiceDto getService(Long id) {
        return new ServiceDto(mServiceRepository.findById(id).orElseThrow());
    }

    public void setService(ServiceDto serviceDto) {
        mServiceRepository.save(new com.ynov.springvacations.domain.Service(serviceDto));
    }

    public void delete(Long id) {
        mServiceRepository.deleteById(id);
    }
}
