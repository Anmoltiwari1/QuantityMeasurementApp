package com.example.UC9.WeightMeasurementEquality.App.Weight;

public enum WeightUnit {
	
	KILOGRAM(1.0),
	GRAM(0.001),
	POUNDS(0.453592);
	
	private final double factor;
	
	
	WeightUnit(double factor) {
		this.factor=factor;
	}


	public double getConversionFactor() {
		return factor;
	}
	
	//To Kilogram(Base)
	public double convertToBaseUnit(double value) {
		return value*factor;
	}
	
	//From Kilogram to target
	public double convertFromBaseUnit(double baseValue) {
		return baseValue/factor;
	}
	
}
