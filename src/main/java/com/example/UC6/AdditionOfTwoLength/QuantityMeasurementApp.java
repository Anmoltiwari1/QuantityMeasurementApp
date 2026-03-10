package com.example.UC6.AdditionOfTwoLength;

public class QuantityMeasurementApp {

	public static void main(String[] args) {
		
		QuantityLength a=new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength b=new QuantityLength(12.0, LengthUnit.INCHES);
		
		QuantityLength result=a.add(b);
		
		System.out.println(result.getValue()+" "+result.getUnit());
	}
}
