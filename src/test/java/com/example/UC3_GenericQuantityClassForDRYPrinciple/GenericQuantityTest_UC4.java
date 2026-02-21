package com.example.UC3_GenericQuantityClassForDRYPrinciple;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class GenericQuantityTest_UC4 {

	// ---------------- YARD TESTS ----------------

	@Test
	void testEquality_YardToYard_SameValue() {
		GenericQuantity q1 = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity q2 = new GenericQuantity(1, LengthUnit.YARDS);
		assertTrue(q1.equals(q2));
	}

	@Test
	void testEquality_YardToYard_DifferentValue() {
		GenericQuantity q1 = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity q2 = new GenericQuantity(2, LengthUnit.YARDS);
		assertFalse(q1.equals(q2));
	}

	@Test
	void testEquality_YardToFeet_EquivalentValue() {
		GenericQuantity yard = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity feet = new GenericQuantity(3, LengthUnit.FEET);
		assertTrue(yard.equals(feet));
	}

	@Test
	void testEquality_YardToInches_EquivalentValue() {
		GenericQuantity yard = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity inch = new GenericQuantity(36, LengthUnit.INCH);
		assertTrue(yard.equals(inch));
	}

	@Test
	void testEquality_YardToFeet_NonEquivalentValue() {
		GenericQuantity yard = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity feet = new GenericQuantity(2, LengthUnit.FEET);
		assertFalse(yard.equals(feet));
	}

	// ---------------- CENTIMETER TESTS ----------------

	@Test
	void testEquality_CentimeterToCentimeter_SameValue() {
		GenericQuantity q1 = new GenericQuantity(2, LengthUnit.CENTIMETERS);
		GenericQuantity q2 = new GenericQuantity(2, LengthUnit.CENTIMETERS);
		assertTrue(q1.equals(q2));
	}

	@Test
	void testEquality_CentimeterToInch_EquivalentValue() {
		GenericQuantity cm = new GenericQuantity(1, LengthUnit.CENTIMETERS);
		GenericQuantity inch = new GenericQuantity(0.393701, LengthUnit.INCH);
		assertTrue(cm.equals(inch));
	}

	@Test
	void testEquality_CentimeterToFeet_NonEquivalentValue() {
		GenericQuantity cm = new GenericQuantity(1, LengthUnit.CENTIMETERS);
		GenericQuantity feet = new GenericQuantity(1, LengthUnit.FEET);
		assertFalse(cm.equals(feet));
	}

	// ---------------- TRANSITIVE PROPERTY ----------------

	@Test
	void testEquality_MultiUnit_TransitiveProperty() {
		GenericQuantity yard = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity feet = new GenericQuantity(3, LengthUnit.FEET);
		GenericQuantity inch = new GenericQuantity(36, LengthUnit.INCH);

		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inch));
		assertTrue(yard.equals(inch));
	}

	// ---------------- COMPLEX SCENARIO ----------------

	@Test
	void testEquality_AllUnits_ComplexScenario() {
		GenericQuantity yard = new GenericQuantity(2, LengthUnit.YARDS);
		GenericQuantity feet = new GenericQuantity(6, LengthUnit.FEET);
		GenericQuantity inch = new GenericQuantity(72, LengthUnit.INCH);

		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inch));
		assertTrue(yard.equals(inch));
	}

	// ---------------- NULL SAFETY ----------------

	@Test
	void testEquality_YardNullComparison() {
		GenericQuantity yard = new GenericQuantity(1, LengthUnit.YARDS);
		assertFalse(yard.equals(null));
	}

	@Test
	void testConstructor_CentimeterNullUnit_ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new GenericQuantity(1, null);
		});
	}
}