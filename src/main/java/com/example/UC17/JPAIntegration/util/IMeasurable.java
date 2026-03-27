package com.example.UC17.JPAIntegration.util;

public interface IMeasurable {

	public double convertToBaseUnit(double value);
	
	public double convertFromBaseUnit(double Basevalue);

	default void validateOperationSupport(String operation) {
		
	}
}
