package com.example.UC9.WeightMeasurementEquality.App.Length;



public enum LengthUnit {

	
	FEET(1.0),
	INCHES(1.0/12.0),
	YARDS(3.0),
	CENTIMETERS(0.0328084);
	
	private final double factor;
	
	
	LengthUnit(double factor) {
		this.factor=factor;
	}


	public double getConversionFactor() {
		return factor;
	}
	
	//TO Feet(Base)
	public double convertToBaseUnit(double value) {
		return value*factor;
	}
	
	public double convertFromBaseUnit(double baseValue) {
		return baseValue/factor;
	}
	
	
}
