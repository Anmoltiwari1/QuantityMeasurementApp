package com.example.UC2.FeetAndInchesMeasurementEquality.App;



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
	
	
	public static void main(String[] args) {
		
		GenericQuantity q1=new GenericQuantity(12, LengthUnit.INCH);
		GenericQuantity q2=new GenericQuantity(1, LengthUnit.FEET);
		
		System.out.println(q1.equals(q2));
	}
}
