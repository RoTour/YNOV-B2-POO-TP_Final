package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.repository.ApartmentRepository;
import com.ynov.springvacations.repository.ReservationRepository;
import com.ynov.springvacations.repository.ResidenceRepository;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpringVacationsAPIService {
    ResidenceRepository mResidenceRepository;
    ServiceRepository mServiceRepository;
    ApartmentRepository mApartmentRepository;
    ReservationRepository mReservationRepository;

    public SpringVacationsAPIService(ResidenceRepository mResidenceRepository, ServiceRepository mServiceRepository, ApartmentRepository mApartmentRepository, ReservationRepository mReservationRepository) {
        this.mResidenceRepository = mResidenceRepository;
        this.mServiceRepository = mServiceRepository;
        this.mApartmentRepository = mApartmentRepository;
        this.mReservationRepository = mReservationRepository;
    }

    // Doesn't return apartment to not send too much data
    public List<ResidenceDto> getResidenceByCountry(String country) {
        return mResidenceRepository.findByCountry(country).orElseThrow().stream()
                .map(it -> new ResidenceDto(it, true, false))
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> getApartmentsByRegion(String region) {
        List<ApartmentDto> result = new ArrayList<>();
        List<Residence> residences = mResidenceRepository.findByRegion(region).orElseThrow();
        residences.forEach(residence ->
                result.addAll(
                        residence.getApartments().stream()
                                .map(it -> new ApartmentDto(it, residence.getId()))
                                .collect(Collectors.toList())
                )
        );

        return result;
    }
}
