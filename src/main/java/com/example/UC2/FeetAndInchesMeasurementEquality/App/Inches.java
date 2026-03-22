package com.example.UC2.FeetAndInchesMeasurementEquality.App;

public class Inches {
	
private final double value;
	
	public Inches(double value) {
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
		
		Inches other=(Inches)obj;
		
		 if(Double.compare(this.value,other.value)==0)
			  return true;
		 else
			 return false;	 
	}
}
