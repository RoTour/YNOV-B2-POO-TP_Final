package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.ResidenceDto;
import com.ynov.springvacations.repository.ApartmentRepository;
import com.ynov.springvacations.repository.ReservationRepository;
import com.ynov.springvacations.repository.ResidenceRepository;
import com.ynov.springvacations.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
        return mResidenceRepository.findByCountry(country).orElse(Collections.emptyList()).stream()
                .map(it -> new ResidenceDto(it, true, false))
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> getApartmentsByRegion(String region) {
        List<ApartmentDto> result = new ArrayList<>();
        List<Residence> residences = mResidenceRepository.findByRegion(region).orElse(Collections.emptyList());
        residences.forEach(residence ->
                result.addAll(
                        residence.getApartments().stream()
                                .map(it -> new ApartmentDto(it, residence.getId()))
                                .collect(Collectors.toList())
                )
        );

        return result;
    }

    public List<ApartmentDto> getApartmentsByService(String serviceName) {
        return mApartmentRepository.findByService(serviceName).orElse(Collections.emptyList()).stream()
                .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> getApartmentsWithPool() {
        return getApartmentsByService("piscine");
    }

    public List<ApartmentDto> getApartmentsByType(String type) {
        return mApartmentRepository.findByType(type).orElse(Collections.emptyList()).stream()
                .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> getApartmentsAtMountain() {
        return getApartmentsByType("montagne");
    }

    public List<ApartmentDto> getApartmentsAvailable(String start, String end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(start);
            Date endDate = dateFormat.parse(end);
            return mApartmentRepository.getAvailableBetween(start, end)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<ApartmentDto> getApartmentsAvailableWithDuration(String startDate, String endDate, Integer duration) {
        return mApartmentRepository
                .getAvailableBetweenDatesWithDuration(startDate, endDate, duration)
                .orElse(Collections.emptyList()).stream()
                .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                .collect(Collectors.toList());
    }
}
