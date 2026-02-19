package com.example.UC3_GenericQuantityClassForDRYPrinciple;

enum LengthUnit{
	
	FEET(1.0),
	INCH(1.0/12.0);
	
	private final double toFeetFactor;
	
	LengthUnit(double toFeetFactor) {
		this.toFeetFactor=toFeetFactor;
	}
	
	public double toFeet(double value) {
		return value* toFeetFactor;
	}
}


public class GenericQuantity {
	
	private final double value;
	private final LengthUnit unit;
	
	public GenericQuantity(double value,LengthUnit unit) {
		if(unit==null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		
		this.value=value;
		this.unit=unit;
	}
	
	private double toFeet() {
		return unit.toFeet(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this==obj) return true;
		
		if(obj==null || getClass()!=obj.getClass()) return false;
		
		GenericQuantity other=(GenericQuantity)obj;
		
		return Double.compare(this.toFeet(), other.toFeet())==0;
	}
	
	
	public static void main(String[] args) {
		
		GenericQuantity q1=new GenericQuantity(1, LengthUnit.FEET);
		GenericQuantity q2=new GenericQuantity(12, LengthUnit.INCH);
		
		System.out.println(q1.equals(q2));
		
	}
}
