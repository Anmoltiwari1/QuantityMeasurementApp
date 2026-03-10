package com.example.UC7_AdditionwithTargetUnitSpecification.Length;

public class QuantityMeasurementApp {
public static void main(String[] args) {
		
		QuantityLength a=new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength b=new QuantityLength(12.0, LengthUnit.INCHES);
		
		QuantityLength result=a.add(b,LengthUnit.CENTIMETERS);
		
		System.out.println(result.getValue()+" "+result.getUnit());
	}
}
