package com.example.UC7_AdditionwithTargetUnitSpecification;

import java.lang.foreign.ValueLayout;

public class QuantityWeight {

	private final double value;
	private final WeightUnit unit;
	
	public QuantityWeight(double value,WeightUnit unit) {
		
		if(unit==null)
			throw new IllegalArgumentException("Value should be null");
		
		this.value=value;
	}
}
