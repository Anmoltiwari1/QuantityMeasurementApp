package com.example.UC6.AdditionOfTwoLength;

public class QuantityLength {

	private final double value;
	private final LengthUnit unit;
	
	public QuantityLength(double value,LengthUnit unit) {
		this.value=value;
		this.unit=unit;
	}
	
	public double getValue() {
		return value;
	}
	
	public LengthUnit getUnit() {
		return unit;
	}
	
	public QuantityLength add(QuantityLength other) {
	
		if(other==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		double thisFeet=unit.toFeet(value);
		double otherFeet=unit.toFeet(other.value);
		
		double sum=thisFeet+otherFeet;
		
		double result=unit.fromFeet(sum);
		
		return new QuantityLength(result, this.unit);
	}	
}
