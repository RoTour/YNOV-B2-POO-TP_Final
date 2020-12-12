package com.ynov.springvacations.repository;

import com.ynov.springvacations.domain.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
