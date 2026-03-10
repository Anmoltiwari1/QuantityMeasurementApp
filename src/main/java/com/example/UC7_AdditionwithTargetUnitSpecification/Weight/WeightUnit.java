package com.example.UC7_AdditionwithTargetUnitSpecification.Weight;

public enum WeightUnit {

	KILOGRAM(1.0),
	GRAM(0.0001),
	POUND(0.453592);
	
	private final double toKilogramFactor;
	
	WeightUnit(double toKilogramFactor) {
		this.toKilogramFactor=toKilogramFactor;
	}
	
	public double toKiloGram(double value) {
		return value*toKilogramFactor;
	}
	
	public double fromKiloGram(double value) {
		return value/toKilogramFactor;
	}
}
