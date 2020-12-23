package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.domain.ServiceDto;
import com.ynov.springvacations.repository.ResidenceRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IResidenceService {
    List<ResidenceDto> getResidences();
    ResidenceDto getResidence(Long id);
    void setResidence(ResidenceDto residenceDto);
    void delete(Long id);
    Set<ServiceDto> getResidenceServices(Long id);
}
