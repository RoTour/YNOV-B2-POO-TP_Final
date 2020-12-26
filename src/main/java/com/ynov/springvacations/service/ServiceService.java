package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.*;
import com.ynov.springvacations.repository.ResidenceRepository;
import com.ynov.springvacations.repository.ResidenceServicePivotRepository;
import com.ynov.springvacations.repository.ServiceRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceService {
    ServiceRepository mServiceRepository;
    ResidenceRepository mResidenceRepository;
    ResidenceServicePivotRepository mPivotRepository;

    public ServiceService(
            ServiceRepository serviceRepository,
            ResidenceRepository residenceRepository,
            ResidenceServicePivotRepository pivotRepository) {
        this.mServiceRepository = serviceRepository;
        this.mResidenceRepository = residenceRepository;
        this.mPivotRepository = pivotRepository;
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

    public void addResidence(Long serviceId, Long residenceId) {
        ResidenceServicePivot newPivot = new ResidenceServicePivot(residenceId, serviceId);
        mPivotRepository.save(newPivot);
    }

    public void removeResidence(Long serviceId, Long residenceId) {
        mPivotRepository.delete(new ResidenceServicePivot(residenceId, serviceId));
    }

//    public void addResidence(Long serviceId, Long residenceId) {
//        ServiceDto serviceDto = new ServiceDto(mServiceRepository.findById(serviceId).orElseThrow(), true);
//        serviceDto.getResidences().add(new)
//    }
}
