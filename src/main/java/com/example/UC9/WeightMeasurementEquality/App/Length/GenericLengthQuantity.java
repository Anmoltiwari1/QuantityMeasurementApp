package com.example.UC9.WeightMeasurementEquality.App.Length;

public class GenericLengthQuantity {
	
	private final double value;
	private final LengthUnit unit;
	
	
	public GenericLengthQuantity(double value, LengthUnit unit) {
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
		
		GenericLengthQuantity other=(GenericLengthQuantity)obj;
		
		 return Double.compare(this.convert(),other.convert())==0; 
		
	}
	
	public static double convert(double value,LengthUnit source,LengthUnit target) {
		
		if(source==null)
			return 0;
		
		if(target==null)
			return 0;
		
		double valueInFeet=source.convertToBaseUnit(value);
		
		return target.convertFromBaseUnit(valueInFeet);
	}
	
	public static double addInternal(double value1,double value2,LengthUnit v1,LengthUnit v2,LengthUnit target) {
		
		if(v1==null || v2==null || target==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		if(!Double.isFinite(value1) || !Double.isFinite(value2))
			throw new IllegalArgumentException("Invalid value");
		
		
		double sumInFeet=v1.convertToBaseUnit(value1)+v2.convertToBaseUnit(value2);
		
		return target.convertFromBaseUnit(sumInFeet);
	}
	
	
	//UC6:
	public static double add(double value1,double value2,LengthUnit v1,LengthUnit v2) {
		
		return addInternal(value1, value2, v1, v2,v1);
			
	}
	
	//UC7:
	public static double addTarget(double value1,double value2,LengthUnit v1,LengthUnit v2,LengthUnit Target) {
		
		return addInternal(value1, value2, v1, v2, Target);	
	}
	
	
	public static void main(String[] args) {
		
		
		GenericLengthQuantity q1=new GenericLengthQuantity(12, LengthUnit.INCHES);
		GenericLengthQuantity q2=new GenericLengthQuantity(1, LengthUnit.FEET);
		
		GenericLengthQuantity f1=new GenericLengthQuantity(1, LengthUnit.CENTIMETERS);
		GenericLengthQuantity f2=new GenericLengthQuantity(0.032, LengthUnit.FEET);
		
		//Checking equals
		System.out.println(q1.equals(q2));
		System.out.println(f1.equals(f2));
		
		//Converting the value
		System.out.println(convert(12, LengthUnit.INCHES, LengthUnit.FEET));
		
		//Adding two value
		double result=add(1, 12, LengthUnit.FEET, LengthUnit.INCHES);
		System.out.println("After addition :" +result+" "+LengthUnit.FEET);
		
		
		//Adding according to target
		double resultTarget=addTarget(12, 1,LengthUnit.INCHES, LengthUnit.FEET,  LengthUnit.YARDS);
		System.out.println("After Addition "+"and converted to "+LengthUnit.YARDS+" result is: "+ resultTarget);
		
	}
}
