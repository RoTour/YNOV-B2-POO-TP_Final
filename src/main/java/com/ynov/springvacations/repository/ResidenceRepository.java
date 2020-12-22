package com.ynov.springvacations.repository;

import com.ynov.springvacations.HibernateUtils;
import com.ynov.springvacations.domain.Residence;
import com.ynov.springvacations.domain.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    default Set<Service> getServicesOf(Long id) {
        Session session = null;
        Set<Service> services = null;

        try {
            session = HibernateUtils.getSession();
            services = findById(id).orElseThrow().getServices();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return services;
    }


}
