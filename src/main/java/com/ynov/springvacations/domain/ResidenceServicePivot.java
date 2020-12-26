package com.ynov.springvacations.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "residence_services")
@IdClass(ResidenceServicePivotId.class)
public class ResidenceServicePivot implements Serializable {

    @Id
    private Long residence_id;
    @Id
    private Long service_id;

    public ResidenceServicePivot() {
    }

    public ResidenceServicePivot(Long residence_id, Long service_id) {
        this.residence_id = residence_id;
        this.service_id = service_id;
    }

    public Long getResidence_id() {
        return residence_id;
    }

    public void setResidence_id(Long residence_id) {
        this.residence_id = residence_id;
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }
}
