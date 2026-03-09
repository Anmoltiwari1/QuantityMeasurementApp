package com.example.UC7_AdditionwithTargetUnitSpecification;

public class QuantityLength {

	private final double value;
	private final LengthUnit unit;
	
	public QuantityLength(double value,LengthUnit unit) {
		
		if(unit ==null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		
		 if(!Double.isFinite(value))
		        throw new IllegalArgumentException("Invalid value");
		
		this.value=value;
		this.unit=unit;
	}
	
	public double getValue() {
		return value;
	}
	
	public LengthUnit getUnit() {
		return unit;
	}
	
	
	public QuantityLength convertTo(LengthUnit targetUnit) {
		
		if(targetUnit==null)
			throw new IllegalArgumentException("Target unit cannot be null");
		
		double base=unit.toFeet(value);
		double result=targetUnit.toFeet(base);
		
		return new QuantityLength(result, targetUnit);
	}
	
	public QuantityLength add(QuantityLength other,LengthUnit targetUnit) {
	
		if(other==null || targetUnit==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		double thisFeet=this.unit.toFeet(this.value);
		double otherFeet=other.unit.toFeet(other.value);
		
		double sum=thisFeet+otherFeet;
		
		double result=targetUnit.fromFeet(sum);
	
		return new QuantityLength(result,targetUnit);
	}	
}
