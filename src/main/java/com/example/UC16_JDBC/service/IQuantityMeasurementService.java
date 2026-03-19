package com.example.UC16_JDBC.service;

import java.util.List;

import com.example.UC16_JDBC.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

	  void saveMeasurement(QuantityMeasurementEntity entity);

	    List<QuantityMeasurementEntity> getAllMeasurements();
	}

