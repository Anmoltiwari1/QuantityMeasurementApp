package com.example.UC2.FeetAndInchesMeasurementEquality.App;


public class Feet {
	
	private final double value;
	
	public Feet(double value) {
		this.value=value;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)
			return false;
		
		
		if(this==obj) {
			return true;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Feet other=(Feet)obj;
		
		 if(Double.compare(this.value,other.value)==0)
			  return true;
		 else
			 return false;	 
	}
}
