package com.example.UC2.FeetAndInchesMeasurementEquality.App;

public class Main {
	
	public static void main(String[] args) {
		
		Main main=new Main();
		
		Feet f1=new Feet(1);
		Feet f2=new Feet(1);
		
		System.out.println(main.compareFeet(f1, f2));
	}
	
	public boolean compareFeet(Feet f1,Feet f2) {
		
		return f1.equals(f2);
	}
	
	public boolean compareInches(Inches i1,Inches i2) {
		
		return i1.equals(i2);
	}
}
