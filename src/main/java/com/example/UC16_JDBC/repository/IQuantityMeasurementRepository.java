package com.example.UC16_JDBC.repository;

import java.util.List;

import com.example.UC16_JDBC.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();

    int getTotalCount();

    void deleteAll();
}
