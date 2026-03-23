package com.example.UC4.ExtendedUnitSupport.App;



public enum LengthUnit {

	
	FEET(1.0),
	INCHES(1.0/12.0),
	YARDS(3.0),
	CENTIMETERS(0.0328084);
	
	private final double conversionFactor;
	
	
	LengthUnit(double conversionFactor) {
		this.conversionFactor=conversionFactor;
	}


	public double getConversionFactor() {
		return conversionFactor;
	}
	
	public double toFeet(double value) {
		return value*conversionFactor;
	}
	
	
}
