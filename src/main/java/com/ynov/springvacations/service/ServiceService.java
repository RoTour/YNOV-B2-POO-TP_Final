package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceService {
    ServiceRepository mServiceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.mServiceRepository = serviceRepository;
    }

    public List<ServiceDto> getServices() {
        return mServiceRepository.findAll().stream()
                .map(it -> new ServiceDto(it, true))
                .collect(Collectors.toList());
    }

    public ServiceDto getService(Long id) {
        return new ServiceDto(mServiceRepository.findById(id).orElseThrow(), true);
    }

    public void setService(ServiceDto serviceDto) {
        mServiceRepository.save(new com.ynov.springvacations.domain.Service(serviceDto));
    }

    public void delete(Long id) {
        mServiceRepository.deleteById(id);
    }

    public Set<ResidenceDto> getResidences(Long id) {
        return mServiceRepository.findById(id).orElseThrow()
                .getResidences()
                .stream()
                .map(ResidenceDto::new)
                .collect(Collectors.toSet());
    }
}
