package com.example.UC9.WeightMeasurementEquality.App.Weight;


public class GenericWeightQuantity {

	private final double value;
	private final WeightUnit unit;
	
	
	public GenericWeightQuantity(double value, WeightUnit unit) {
		super();
		this.value = value;
		this.unit = unit;
	}
	
	public double convert() {
		
		return unit.convertToBaseUnit(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)
			return false;
		
		if(this == obj)
			return true;
		
		if(getClass()!=obj.getClass())
			return false;
		
		GenericWeightQuantity other=(GenericWeightQuantity)obj;
		
		 return Double.compare(this.convert(),other.convert())==0; 
		
	}
	
	public static double convert(double value,WeightUnit source,WeightUnit target) {
		
		if(source==null)
			return 0;
		
		if(target==null)
			return 0;
		
		double valueInKilo=source.convertToBaseUnit(value);
		
		return target.convertFromBaseUnit(valueInKilo);
	}
	
	public static double addInternal(double value1,double value2,WeightUnit v1,WeightUnit v2,WeightUnit target) {
		
		if(v1==null || v2==null || target==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		if(!Double.isFinite(value1) || !Double.isFinite(value2))
			throw new IllegalArgumentException("Invalid value");
		
		
		double sumInKilo=v1.convertToBaseUnit(value1)+v2.convertToBaseUnit(value2);
		
		return target.convertFromBaseUnit(sumInKilo);
	}
	
	
	//UC6:
	public static double add(double value1,double value2,WeightUnit v1,WeightUnit v2) {
		
		return addInternal(value1, value2, v1,v2,v1);
			
	}
	
	//UC7:
	public static double addTarget(double value1,double value2,WeightUnit v1,WeightUnit v2,WeightUnit Target) {
		
		return addInternal(value1, value2, v1, v2, Target);	
	}
	
	
	public static void main(String[] args) {
		
		
		GenericWeightQuantity q1=new GenericWeightQuantity(12, WeightUnit.KILOGRAM);
		GenericWeightQuantity q2=new GenericWeightQuantity(1, WeightUnit.GRAM);
		
		GenericWeightQuantity f1=new GenericWeightQuantity(1, WeightUnit.GRAM);
		GenericWeightQuantity f2=new GenericWeightQuantity(0.032, WeightUnit.KILOGRAM);
		
		//Checking equals
		System.out.println(q1.equals(q2));
		System.out.println(f1.equals(f2));
		
		//Converting the value
		System.out.println(convert(1, WeightUnit.GRAM, WeightUnit.KILOGRAM));
		
		//Adding two value
		double result=add(1, 12, WeightUnit.POUNDS, WeightUnit.KILOGRAM);
		System.out.println("After addition :" +result+" "+WeightUnit.POUNDS);
		
		
		//Adding according to target
		double resultTarget=addTarget(12, 1,WeightUnit.GRAM, WeightUnit.KILOGRAM,  WeightUnit.POUNDS);
		System.out.println("After Addition "+"and converted to "+WeightUnit.POUNDS+" result is: "+ resultTarget);
		
	}
}
