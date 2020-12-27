package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.ReservationDto;
import com.ynov.springvacations.repository.ApartmentRepository;
import com.ynov.springvacations.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {

    ApartmentRepository apartmentRepository;
    ResidenceRepository residenceRepository;

    public ApartmentService(ApartmentRepository apartmentRepository, ResidenceRepository residenceRepository) {
        this.apartmentRepository = apartmentRepository;
        this.residenceRepository = residenceRepository;
    }

    public List<ApartmentDto> getApartments() {
        return apartmentRepository.findAll().stream().map(ApartmentDto::new).collect(Collectors.toList());
    }

    public void setApartment(ApartmentDto apartmentDto) {
        apartmentRepository.save(
                new Apartment(
                        apartmentDto,
                        residenceRepository.findById(apartmentDto.getResidence_id()).orElseThrow()
                )
        );
    }

    public void delete(Long id) {
        apartmentRepository.deleteById(id);
    }

    public ApartmentDto getApartment(Long id) {
        return new ApartmentDto(apartmentRepository.findById(id).orElseThrow());
    }

}
