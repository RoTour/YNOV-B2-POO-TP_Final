package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.repository.ResidenceRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResidenceService {
    ResidenceRepository mResidenceRepository;

    public ResidenceService(ResidenceRepository residenceRepository) {
        mResidenceRepository = residenceRepository;
    }

    public List<ResidenceDto> getResidences() {
        return mResidenceRepository.findAll().stream()
                .map(it -> new ResidenceDto(it, true))
                .collect(Collectors.toList());
    }

    public ResidenceDto getResidence(Long id) {
        return new ResidenceDto(mResidenceRepository.findById(id).orElseThrow(), true);
    }

    public void setResidence(ResidenceDto residenceDto) {
        mResidenceRepository.save(new Residence(residenceDto));
    }

    public void delete(Long id) {
        mResidenceRepository.deleteById(id);
    }

    public Set<ServiceDto> getResidenceServices(Long id) {
        return mResidenceRepository.findById(id).orElseThrow()
                .getServices()
                .stream()
                .map(ServiceDto::new)
                .collect(Collectors.toSet());
    }
}
