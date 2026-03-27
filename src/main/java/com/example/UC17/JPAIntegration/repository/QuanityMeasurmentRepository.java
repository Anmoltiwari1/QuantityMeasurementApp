package com.example.UC17.JPAIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UC17.JPAIntegration.entity.QuantityMeasurementEntity;

public interface QuanityMeasurmentRepository extends JpaRepository<QuantityMeasurementEntity,Long>{

	List<QuantityMeasurementEntity> findByOperation(String operation);
	
	List<QuantityMeasurementEntity> findByBooleanResultTrue();
	
	long countByOperation(String operation);
}
