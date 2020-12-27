package com.ynov.springvacations.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ReservationDto {
    private Long id;

    private String startsAt;
    private String endsAt;

    private Long apartment_id;

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
