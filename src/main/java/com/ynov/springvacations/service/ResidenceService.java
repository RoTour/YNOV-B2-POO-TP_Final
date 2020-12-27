package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.*;
import com.ynov.springvacations.repository.ResidenceRepository;
import com.ynov.springvacations.repository.ResidenceServicePivotRepository;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResidenceService implements IResidenceService {
    ResidenceRepository mResidenceRepository;
    ServiceRepository mServiceRepository;
    ResidenceServicePivotRepository mPivotRepository;

    public ResidenceService(ResidenceRepository mResidenceRepository, ServiceRepository mServiceRepository, ResidenceServicePivotRepository mPivotRepository) {
        this.mResidenceRepository = mResidenceRepository;
        this.mServiceRepository = mServiceRepository;
        this.mPivotRepository = mPivotRepository;
    }

    @Override
    public List<ResidenceDto> getResidences() {
        return mResidenceRepository.findAll().stream()
                .map(it -> new ResidenceDto(it, true))
                .collect(Collectors.toList());
    }

    @Override
    public ResidenceDto getResidence(Long id) {
        return new ResidenceDto(mResidenceRepository.findById(id).orElseThrow(), true);
    }

    @Override
    public void setResidence(ResidenceDto residenceDto) {
        mResidenceRepository.save(new Residence(residenceDto));
    }

    @Override
    public void delete(Long id) {
        mResidenceRepository.deleteById(id);
    }

    @Override
    public Set<ServiceDto> getResidenceServices(Long id) {
        return mResidenceRepository.findById(id).orElseThrow()
                .getServices()
                .stream()
                .map(ServiceDto::new)
                .collect(Collectors.toSet());
    }

    public void addService(Long residenceId, Long serviceId) {
        ResidenceServicePivot newPivot = new ResidenceServicePivot(residenceId, serviceId);
        mPivotRepository.save(newPivot);
    }

    public void removeService(Long residenceId, Long serviceId) {
        mPivotRepository.delete(new ResidenceServicePivot(residenceId, serviceId));
    }

    public List<ApartmentDto> getApartments(Long residenceId) {
        return mResidenceRepository.findById(residenceId).orElseThrow()
                .getApartments().stream()
                .map(it -> new ApartmentDto(it, residenceId)).collect(Collectors.toList());
    }
}
