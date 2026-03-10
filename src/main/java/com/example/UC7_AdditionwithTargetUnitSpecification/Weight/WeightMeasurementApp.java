package com.example.UC7_AdditionwithTargetUnitSpecification.Weight;

public class WeightMeasurementApp {
	public static void main(String[] args) {
		
		QuantityWeight a=new QuantityWeight(1, WeightUnit.KILOGRAM);
		QuantityWeight b=new QuantityWeight(1000, WeightUnit.GRAM);
		
		boolean res=a.equals(b);
		System.out.println(res);
	}
}
