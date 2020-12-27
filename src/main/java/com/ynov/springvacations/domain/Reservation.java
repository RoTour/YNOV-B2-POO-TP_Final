package com.ynov.springvacations.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date startsAt;
    private Date endsAt;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    public Reservation() {
    }

    public Reservation(ReservationDto reservationDto, Apartment apartment) {
        this.id = reservationDto.getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.apartment = apartment;
        try {
            this.startsAt = dateFormat.parse(reservationDto.getStartsAt());
            this.endsAt = dateFormat.parse(reservationDto.getEndsAt());
        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Date format is incorrect. Should be: yyyy-MM-dd");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
