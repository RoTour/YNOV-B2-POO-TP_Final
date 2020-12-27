package com.ynov.springvacations.repository;

import com.ynov.springvacations.domain.ResidenceServicePivot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceServicePivotRepository extends JpaRepository<ResidenceServicePivot, Long> {
}
