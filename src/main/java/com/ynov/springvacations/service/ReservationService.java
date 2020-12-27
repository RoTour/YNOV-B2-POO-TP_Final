package com.ynov.springvacations.service;


import com.ynov.springvacations.domain.Reservation;
import com.ynov.springvacations.domain.ReservationDto;
import com.ynov.springvacations.repository.ApartmentRepository;
import com.ynov.springvacations.repository.ReservationRepository;
import com.ynov.springvacations.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    ApartmentRepository apartmentRepository;
    ReservationRepository reservationRepository;

    public ReservationService(ApartmentRepository apartmentRepository, ReservationRepository reservationRepository) {
        this.apartmentRepository = apartmentRepository;
        this.reservationRepository = reservationRepository;
    }

    public void setReservation(ReservationDto reservationDto) {
        reservationRepository.save(
                new Reservation(
                        reservationDto,
                        apartmentRepository.findById(reservationDto.getApartment_id()).orElseThrow()
                )
        );
    }
}
