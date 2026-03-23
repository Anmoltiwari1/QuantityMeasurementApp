package com.example.UC7.AdditionWithTargetUnitSpecification.App;


public class GenericQuantity {
	
	private final double value;
	private final LengthUnit unit;
	
	
	public GenericQuantity(double value, LengthUnit unit) {
		super();
		this.value = value;
		this.unit = unit;
	}
	
	public double convert() {
		
		return unit.toFeet(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)
			return false;
		
		if(this == obj)
			return true;
		
		if(getClass()!=obj.getClass())
			return false;
		
		GenericQuantity other=(GenericQuantity)obj;
		
		 return Double.compare(this.convert(),other.convert())==0; 
		
	}
	
	public static double convert(double value,LengthUnit source,LengthUnit target) {
		
		if(source==null)
			return 0;
		
		if(target==null)
			return 0;
		
		double valueInFeet=source.toFeet(value);
		
		return valueInFeet/target.getConversionFactor();
	}
	
	public static double addInternal(double value1,double value2,LengthUnit v1,LengthUnit v2,LengthUnit target) {
		
		if(v1==null || v2==null || target==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		if(!Double.isFinite(value1) || !Double.isFinite(value2))
			throw new IllegalArgumentException("Invalid value");
		
		
		double sumInFeet=v1.toFeet(value1)+v2.toFeet(value2);
		
		return sumInFeet/target.getConversionFactor();
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
		
		
		GenericQuantity q1=new GenericQuantity(12, LengthUnit.INCHES);
		GenericQuantity q2=new GenericQuantity(1, LengthUnit.FEET);
		
		GenericQuantity f1=new GenericQuantity(1, LengthUnit.CENTIMETERS);
		GenericQuantity f2=new GenericQuantity(0.032, LengthUnit.FEET);
		
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
