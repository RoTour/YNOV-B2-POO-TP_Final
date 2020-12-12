package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.repository.ApartmentRepository;
import com.ynov.springvacations.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResidenceService {
    private final ApartmentRepository apartmentRepository;
    private final ResidenceRepository residenceRepository;

    public ResidenceService(ApartmentRepository apartmentRepository, ResidenceRepository residenceRepository) {
        this.apartmentRepository = apartmentRepository;
        this.residenceRepository = residenceRepository;
    }

    public Residence generateResidence(Set<Apartment> apartments){
        Residence newResidence = new Residence(
                "France",
                "Haute-Garonne",
                "RandomAddress",
                "GPS",
                "Mountain",
                List.of(new com.ynov.springvacations.domain.Service("Ski")),
                Set.of()
        );
        residenceRepository.save(newResidence);
        apartments.forEach(it -> {
            it.setResidence_id(newResidence);
            apartmentRepository.save(it);
        });
        return newResidence;
    }

    public List<Residence> getResidences() {
        return residenceRepository.findAll();
    }

    public void add(Residence residence) {
        residenceRepository.save(residence);
    }
}
