package com.ynov.springvacations.repository;

import com.ynov.springvacations.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query(value = "SELECT *\n" +
            "from apartment\n" +
            "         JOIN residence r on r.id = apartment.residence_id\n" +
            "         JOIN residence_services rs on r.id = rs.residence_id\n" +
            "         JOIN services s on s.id = rs.service_id\n" +
            "where lower(s.name) like lower(concat('%', 'piscine', '%'));", nativeQuery = true)
    Optional<List<Apartment>> findByService(String serviceName);

    @Query(value = "SELECT * " +
            "from apartment " +
            "JOIN residence r on r.id = apartment.residence_id " +
            "where lower(r.type) like lower(concat('%', 'montagne', '%'));", nativeQuery = true)
    Optional<List<Apartment>> findByType(String type);

    @Query(value = "SELECT * " +
            "FROM apartment " +
            "JOIN reservation r on apartment.id = r.apartment_id " +
            "WHERE (:start < starts_at and :end < starts_at) " +
            "OR (:start > ends_at and :end > ends_at);", nativeQuery = true)
    Optional<List<Apartment>> getAvailableBetween(String start, String end);

    @Query(value = "SELECT * " +
            "FROM apartment " +
            "JOIN reservation r on apartment.id = r.apartment_id " +
            "WHERE (:end >= (ends_at + interval :duration day)) " +
            "OR ((:start + interval :duration day) <= starts_at );", nativeQuery = true)
    Optional<List<Apartment>> getAvailableBetweenDatesWithDuration(String start, String end, Integer duration);

    @Query(value = "SELECT * " +
            "FROM apartment " +
            "JOIN reservation r on apartment.id = r.apartment_id " +
            "join residence r2 on r2.id = apartment.residence_id " +
            "WHERE ((:startDate < starts_at and :endDate < starts_at) " +
            "OR (:startDate > ends_at and :endDate > ends_at)) " +
            "AND lower(r2.type) = 'mer' " +
            "ORDER BY apartment.rent_per_day;", nativeQuery = true)
    Optional<List<Apartment>> getAvailableAtSea(String startDate, String endDate);

    @Query(value = "SELECT * " +
            "FROM apartment " +
            "JOIN reservation r on apartment.id = r.apartment_id " +
            "JOIN residence r2 on r2.id = apartment.residence_id " +
            "JOIN residence_services rs on r2.id = rs.residence_id " +
            "JOIN services s on s.id = rs.service_id " +
            "WHERE ((:startDate < starts_at and :endDate < starts_at) " +
            "OR (:startDate > ends_at and :endDate > ends_at)) " +
            "AND lower(r2.type) = 'mer' " +
            "AND lower(r2.region) = :region " +
            "AND nb_beds >= 4 " +
            "AND lower(s.name) = 'piscine' " +
            "ORDER BY apartment.rent_per_day;", nativeQuery = true)
    Optional<List<Apartment>> specificQuery(String startDate, String endDate, String region);



}
