package com.ynov.springvacations.controller;


import com.ynov.springvacations.domain.ApartmentDto;
import com.ynov.springvacations.domain.ReservationDto;
import com.ynov.springvacations.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationRepository) {
        this.reservationService = reservationRepository;
    }

    @GetMapping("create_or_update")
    @ResponseStatus(HttpStatus.OK)
    public void createOrUpdate(ReservationDto reservationDto) {
        reservationService.setReservation(reservationDto);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> getReservations(){
        return reservationService.getReservations();
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Long id) {
        reservationService.delete(id);
    }
}
