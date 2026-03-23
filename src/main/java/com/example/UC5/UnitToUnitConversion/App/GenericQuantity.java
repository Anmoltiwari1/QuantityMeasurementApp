package com.example.UC5.UnitToUnitConversion.App;



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
	}
}
