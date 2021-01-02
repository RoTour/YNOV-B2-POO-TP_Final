package com.ynov.springvacations.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationDto {
    private Long id;

    private String startsAt;
    private String endsAt;

    private Long apartment_id;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.startsAt = dateFormat.format(reservation.getStartsAt());
            this.endsAt = dateFormat.format(reservation.getEndsAt());
        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Date format is incorrect. Should be: yyyy-MM-dd");
        }
        this.apartment_id = reservation.getApartment().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public Long getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(Long apartment_id) {
        this.apartment_id = apartment_id;
    }
}
