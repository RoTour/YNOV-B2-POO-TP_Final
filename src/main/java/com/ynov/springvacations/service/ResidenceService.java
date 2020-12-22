package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.repository.ResidenceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidenceService{
    ResidenceRepository mResidenceRepository;

    public ResidenceService(ResidenceRepository residenceRepository) {
        mResidenceRepository = residenceRepository;
    }

    public List<ResidenceDto> getResidences() {
        return mResidenceRepository.findAll().stream().map((ResidenceDto::new)).collect(Collectors.toList());
    }

    public ResidenceDto getResidence(Long id) {
        return new ResidenceDto(mResidenceRepository.findById(id).orElseThrow());
    }

    public void setResidence(ResidenceDto residenceDto) {
        mResidenceRepository.save(new Residence(residenceDto));
    }

    public void delete(Long id) {
        mResidenceRepository.deleteById(id);
    }
}
