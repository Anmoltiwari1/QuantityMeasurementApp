package com.example.UC16_JDBC.app;

import com.example.UC16_JDBC.controller.QuantityMeasurementController;
import com.example.UC16_JDBC.repository.*;
import com.example.UC16_JDBC.service.*;



public class QuantityMeasurementApp {
	 public static void main(String[] args) {

		 IQuantityMeasurementRepository repo =
	                new QuantityMeasurementDatabaseRepository();

	        IQuantityMeasurementService service =
	                new QuantityMeasurementServiceImpl(repo);

	        QuantityMeasurementController controller =
	                new QuantityMeasurementController(service);

	        controller.run();

	        System.out.println("Total records: " + repo.getTotalCount());
	    }
}