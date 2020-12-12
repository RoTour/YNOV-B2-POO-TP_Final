package com.ynov.springvacations.service;

import com.ynov.springvacations.domain.Apartment;
import com.ynov.springvacations.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public Apartment generateApartment() {
        Apartment apartment = new Apartment(2,150f,true,true,500f);
        apartmentRepository.save(apartment);
        return apartment;
    }

    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }
}
