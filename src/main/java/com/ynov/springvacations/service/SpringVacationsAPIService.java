package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.*;
import com.ynov.springvacations.repository.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SpringVacationsAPIService {
    ResidenceRepository mResidenceRepository;
    ServiceRepository mServiceRepository;
    ApartmentRepository mApartmentRepository;
    ReservationRepository mReservationRepository;
    ResidenceServicePivotRepository mPivotRepository;

    public SpringVacationsAPIService(ResidenceRepository mResidenceRepository, ServiceRepository mServiceRepository, ApartmentRepository mApartmentRepository, ReservationRepository mReservationRepository, ResidenceServicePivotRepository mPivotRepository) {
        this.mResidenceRepository = mResidenceRepository;
        this.mServiceRepository = mServiceRepository;
        this.mApartmentRepository = mApartmentRepository;
        this.mReservationRepository = mReservationRepository;
        this.mPivotRepository = mPivotRepository;
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
            dateFormat.parse(start);
            dateFormat.parse(end);
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(startDate);
            dateFormat.parse(endDate);
            return mApartmentRepository.getAvailableBetweenDatesWithDuration(startDate, endDate, duration)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<ApartmentDto> getApartmentsAvailableAtSea(String startDate, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(startDate);
            dateFormat.parse(endDate);
            return mApartmentRepository.getAvailableAtSea(startDate, endDate)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }

    public List<ApartmentDto> specificQuery(String startDate, String endDate, String region) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(startDate);
            dateFormat.parse(endDate);
            return mApartmentRepository.specificQuery(startDate, endDate, region)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(it -> new ApartmentDto(it, it.getResidence().getId()))
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }



    // Database seeder
    public void fillDatabase() {
        String region;
        String type;
        mApartmentRepository.deleteAll();
        mResidenceRepository.deleteAll();
        mServiceRepository.deleteAll();
        mReservationRepository.deleteAll();
        mPivotRepository.deleteAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<com.ynov.springvacations.domain.Service> services = new ArrayList<>();

        services.add(new com.ynov.springvacations.domain.Service("jacuzzi"));
        services.add(new com.ynov.springvacations.domain.Service("spa"));
        services.add(new com.ynov.springvacations.domain.Service("cocktail bar"));
        services.add(new com.ynov.springvacations.domain.Service("piscine"));

        mServiceRepository.save(services.get(0));
        mServiceRepository.save(services.get(1));
        mServiceRepository.save(services.get(2));
        mServiceRepository.save(services.get(3));

        for (int i = 0; i < 10; i++) {
            region = i % 2 == 0 ? "occitanie" : "bretagne";
            type = i % 2 == 0 ? "montagne" : "mer";
            Residence newResidence = new Residence(
                    "VacationResidence" + i,
                    "france",
                    region,
                    (i * 10 + " Allée de la rue"),
                    "" + i * i * i * 1234,
                    type
            );
            mResidenceRepository.save(newResidence);

            if (i % 2 == 0)
                mPivotRepository.save(new ResidenceServicePivot(newResidence.getId(), services.get(0).getId()));
            if (i % 3 == 0)
                mPivotRepository.save(new ResidenceServicePivot(newResidence.getId(), services.get(1).getId()));
            if (i % 4 == 0)
                mPivotRepository.save(new ResidenceServicePivot(newResidence.getId(), services.get(2).getId()));
            if (i % 5 == 0)
                mPivotRepository.save(new ResidenceServicePivot(newResidence.getId(), services.get(3).getId()));

            for (int j = 0; j < 2; j++) {
                Apartment newApartment = new Apartment(i, i * 50f + 50, i % 3 == 0, i % 2 == 0, (i * 70) * 1.5f + 200,
                        mResidenceRepository.findById(newResidence.getId()).orElseThrow());
                mApartmentRepository.save(newApartment);

                    try {
                        Date start = dateFormat.parse("2015-0" + 6 + "-" + 2 + j + i + 2);

                        mReservationRepository.save(
                                new Reservation(
                                        start,
                                        dateFormat.parse("2015-0" + 6 + "-" + 2 + j + i + 9),
                                        mApartmentRepository.findById(newApartment.getId()).orElseThrow()
                                )
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }
    }



}
