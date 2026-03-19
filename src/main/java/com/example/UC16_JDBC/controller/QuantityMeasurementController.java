package com.example.UC16_JDBC.controller;

import com.example.UC16_JDBC.entity.QuantityMeasurementEntity;
import com.example.UC16_JDBC.service.IQuantityMeasurementService;

public class QuantityMeasurementController {
	
	private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void run() {
        service.saveMeasurement(new QuantityMeasurementEntity(10, "KG", "ADD"));
        service.saveMeasurement(new QuantityMeasurementEntity(5, "KG", "COMPARE"));

        service.getAllMeasurements().forEach(System.out::println);
    }
}
