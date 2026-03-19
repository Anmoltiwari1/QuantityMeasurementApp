package com.example.UC16_JDBC.service;

import java.util.List;

import com.example.UC16_JDBC.entity.QuantityMeasurementEntity;
import com.example.UC16_JDBC.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{
	 private IQuantityMeasurementRepository repository;

	    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repo) {
	        this.repository = repo;
	    }

	  
	    public void saveMeasurement(QuantityMeasurementEntity entity) {
	        repository.save(entity);
	    }

	 
	    public List<QuantityMeasurementEntity> getAllMeasurements() {
	        return repository.getAll();
	    }
}
