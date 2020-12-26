package com.ynov.springvacations.domain;

public class ApartmentDto {
    private Long id;
    private Integer nbBeds;
    private Float area;
    private Boolean babyKit;
    private Boolean airConditioning;
    private Float rentPerDay;

    public ApartmentDto() {
    }

    public ApartmentDto(Apartment apartment) {
        this.id = apartment.getId();
        this.nbBeds = apartment.getNbBeds();
        this.area = apartment.getArea();
        this.babyKit = apartment.getBabyKit();
        this.airConditioning = apartment.getAirConditioning();
        this.rentPerDay = apartment.getRentPerDay();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbBeds() {
        return nbBeds;
    }

    public void setNbBeds(Integer nbBeds) {
        this.nbBeds = nbBeds;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Boolean getBabyKit() {
        return babyKit;
    }

    public void setBabyKit(Boolean babyKit) {
        this.babyKit = babyKit;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Float getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(Float rentPerDay) {
        this.rentPerDay = rentPerDay;
    }
}