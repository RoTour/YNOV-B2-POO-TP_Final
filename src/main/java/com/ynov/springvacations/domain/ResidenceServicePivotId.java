package com.ynov.springvacations.domain;

import java.io.Serializable;
import java.util.Objects;

public class ResidenceServicePivotId implements Serializable {

    private Long residence_id;
    private Long service_id;

    public ResidenceServicePivotId() {
    }

    public ResidenceServicePivotId(Long residence_id, Long service_id) {
        this.residence_id = residence_id;
        this.service_id = service_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidenceServicePivotId residenceServicePivotId = (ResidenceServicePivotId) o;
        return residence_id.equals(residenceServicePivotId.residence_id) &&
                service_id.equals(residenceServicePivotId.service_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residence_id, service_id);
    }
}