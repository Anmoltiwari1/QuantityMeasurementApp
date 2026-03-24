package com.example.UC13.CentralizedArithmeticLogic.Controller;

import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
import com.example.UC13.CentralizedArithmeticLogic.Service.IQuantityMeasurementService;

public class QuantityMeasurementController {

	 private final IQuantityMeasurementService service;

	    public QuantityMeasurementController(IQuantityMeasurementService service) {
	        this.service = service;
	    }

	    public void performAdd(QuantityDTO q1, QuantityDTO q2, String unit) {
	        try {
	            QuantityDTO result = service.add(q1, q2, unit);
	            System.out.println("Add Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Add Error: " + e.getMessage());
	        }
	    }

	    public void performSubtract(QuantityDTO q1, QuantityDTO q2, String unit) {
	        try {
	            QuantityDTO result = service.subtract(q1, q2, unit);
	            System.out.println("Subtract Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Subtract Error: " + e.getMessage());
	        }
	    }

	    public void performDivide(QuantityDTO q1, QuantityDTO q2) {
	        try {
	            double result = service.divide(q1, q2);
	            System.out.println("Divide Result: " + result);
	        } catch (Exception e) {
	            System.out.println("Divide Error: " + e.getMessage());
	        }
	    }

	    public void performConvert(QuantityDTO q, String unit) {
	        try {
	            QuantityDTO result = service.convert(q, unit);
	            System.out.println("Convert Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Convert Error: " + e.getMessage());
	        }
	    }

	    public void performCompare(QuantityDTO q1, QuantityDTO q2) {
	        try {
	            boolean result = service.compare(q1, q2);
	            System.out.println("Compare Result: " + result);
	        } catch (Exception e) {
	            System.out.println("Compare Error: " + e.getMessage());
	        }
	    }
}
