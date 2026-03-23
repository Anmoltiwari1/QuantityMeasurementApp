package com.example.UC1.FeetMeasurementEqualtiy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.UC4.ExtendedUnitSupport.App.Feet;

public class FeetTest {

	@Test
	void sameValue() {
		Feet f1=new Feet(1);
		Feet f2=new Feet(1);
		
		assertEquals(f1.equals(f2), true);
	}
	
	@Test
	void differentValue() {
		Feet f1=new Feet(1);
		Feet f2=new Feet(2);
		
		assertEquals(f1.equals(f2), false);
	}
}
