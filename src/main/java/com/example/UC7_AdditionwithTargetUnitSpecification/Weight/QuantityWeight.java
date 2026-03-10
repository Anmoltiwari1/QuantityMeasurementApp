package com.example.UC7_AdditionwithTargetUnitSpecification.Weight;

import java.lang.classfile.AnnotationValue.OfAnnotation;
import java.lang.foreign.ValueLayout;

public class QuantityWeight {

	private final double value;
	private final WeightUnit unit;
	
	public QuantityWeight(double value,WeightUnit unit) {
		
		if(unit==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		if(!Double.isFinite(value))
			throw new IllegalArgumentException("Invalid value");
		
		this.value=value;
		this.unit=unit;
	}
	
	public double getValue() {
		return value;
	}
	
	public WeightUnit getUnit() {
		return unit;
	}
	
	 public QuantityWeight convertTo(WeightUnit targetUnit){

	        if(targetUnit == null)
	            throw new IllegalArgumentException("Target unit cannot be null");

	        double base = unit.toKiloGram(value);

	        double result = targetUnit.fromKiloGram(base);

	        return new QuantityWeight(result, targetUnit);
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
		 
		 if(this==obj)
			 return true;
		 
		 if(obj==null  || getClass()!=obj.getClass()) {
			 return false;
		 }
		 
		 QuantityWeight other=(QuantityWeight)obj;
		 
		 double thisBase = unit.toKiloGram(value);
		    double otherBase = other.unit.toKiloGram(other.value);

		    return Double.compare(thisBase, otherBase) == 0;
	 }
	 
	 public QuantityWeight add(QuantityWeight other){

		    double base1 = unit.fromKiloGram(value);
		    double base2 = other.unit.fromKiloGram(other.value);

		    double sum = base1 + base2;

		    double result = unit.fromKiloGram(sum);

		    return new QuantityWeight(result, unit);
	}
}
