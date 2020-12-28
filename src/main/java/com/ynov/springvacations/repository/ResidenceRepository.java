package com.ynov.springvacations.repository;

import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    Optional<List<Residence>> findByCountry(String country);

    Optional<List<Residence>> findByRegion(String region);

    @Query(value = "SELECT * " +
            "from residence " +
            "JOIN residence_services rs on residence.id = rs.residence_id " +
            "join services s on s.id = rs.service_id " +
            "where lower(s.name) like lower(concat('%',:serviceName ,'%'))", nativeQuery = true)
    Optional<List<Residence>> findByService(String serviceName);
}
