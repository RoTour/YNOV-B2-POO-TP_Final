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
            "OR (:start > ends_at and :end > ends_at)", nativeQuery = true)
    Optional<List<Apartment>> getAvailableBetween(String start, String end);
}
