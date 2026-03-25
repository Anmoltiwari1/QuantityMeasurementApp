package com.example.UC13.CentralizedArithmeticLogic.repository;

import java.util.List;

import com.example.UC13.CentralizedArithmeticLogic.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

	void save(QuantityMeasurementEntity entity);
	
	List<QuantityMeasurementEntity> getAllMeasurements();
	
	void deleteAll();
	
	int getTotalCount();
}
