package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.repository.ResidenceRepository;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResidenceService implements IResidenceService {
    ResidenceRepository mResidenceRepository;
    ServiceRepository mServiceRepository;

    public ResidenceService(ResidenceRepository residenceRepository, ServiceRepository serviceRepository) {
        mResidenceRepository = residenceRepository;
        mServiceRepository = serviceRepository;
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
        try {
            ResidenceDto residenceDto = new ResidenceDto(mResidenceRepository.findById(residenceId).orElseThrow(), true);
            residenceDto.getServices().add(new ServiceDto(mServiceRepository.findById(serviceId).orElseThrow()));
            Residence residence = new Residence(residenceDto);
            mResidenceRepository.save(residence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeService(Long residenceId, Long serviceId) {
        try {
            ResidenceDto residenceDto = new ResidenceDto(mResidenceRepository.findById(residenceId).orElseThrow(), true);
            residenceDto.setServices(residenceDto.getServices().stream()
                    .filter(it -> !it.getId().equals(serviceId)).collect(Collectors.toSet()));
            Residence residence = new Residence(residenceDto);
            mResidenceRepository.save(residence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
