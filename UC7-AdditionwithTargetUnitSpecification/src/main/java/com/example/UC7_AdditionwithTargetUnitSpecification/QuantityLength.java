package com.example.UC7_AdditionwithTargetUnitSpecification;

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
	
	public QuantityLength add(QuantityLength other,LengthUnit targetUnit) {
	
		if(other==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		double thisFeet=this.unit.toFeet(this.value);
		double otherFeet=other.unit.toFeet(other.value);
		
		double sum=thisFeet+otherFeet;
		
		double result=targetUnit.fromFeet(sum);
	
		return new QuantityLength(result,targetUnit);
	}	
}
