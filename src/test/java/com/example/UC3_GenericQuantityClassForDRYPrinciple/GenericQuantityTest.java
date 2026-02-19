package com.example.UC3_GenericQuantityClassForDRYPrinciple;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GenericQuantityTest {

	    // Reflexive property: object equals itself
	    @Test
	    void testEquality_SameReference() {
	        GenericQuantity q = new GenericQuantity(1, LengthUnit.FEET);
	        assertTrue(q.equals(q), "Object must equal itself");
	    }

	    // Same unit, same value
	    @Test
	    void testEquality_FeetToFeet_SameValue() {
	        GenericQuantity q1 = new GenericQuantity(1, LengthUnit.FEET);
	        GenericQuantity q2 = new GenericQuantity(1, LengthUnit.FEET);
	        assertTrue(q1.equals(q2), "1 ft should equal 1 ft");
	    }

	    // Same unit, different value
	    @Test
	    void testEquality_FeetToFeet_DifferentValue() {
	        GenericQuantity q1 = new GenericQuantity(1, LengthUnit.FEET);
	        GenericQuantity q2 = new GenericQuantity(2, LengthUnit.FEET);
	        assertFalse(q1.equals(q2), "1 ft should not equal 2 ft");
	    }

	    // Inch to inch equality
	    @Test
	    void testEquality_InchToInch_SameValue() {
	        GenericQuantity q1 = new GenericQuantity(5, LengthUnit.INCH);
	        GenericQuantity q2 = new GenericQuantity(5, LengthUnit.INCH);
	        assertTrue(q1.equals(q2), "5 inch should equal 5 inch");
	    }

	    // Inch to inch different value
	    @Test
	    void testEquality_InchToInch_DifferentValue() {
	        GenericQuantity q1 = new GenericQuantity(5, LengthUnit.INCH);
	        GenericQuantity q2 = new GenericQuantity(6, LengthUnit.INCH);
	        assertFalse(q1.equals(q2), "5 inch should not equal 6 inch");
	    }

	    // Cross-unit equality (core UC3)
	    @Test
	    void testEquality_FeetToInch_EquivalentValue() {
	        GenericQuantity feet = new GenericQuantity(1, LengthUnit.FEET);
	        GenericQuantity inch = new GenericQuantity(12, LengthUnit.INCH);
	        assertTrue(feet.equals(inch), "1 ft should equal 12 inch");
	    }

	    // Symmetry check
	    @Test
	    void testEquality_InchToFeet_Symmetric() {
	        GenericQuantity inch = new GenericQuantity(12, LengthUnit.INCH);
	        GenericQuantity feet = new GenericQuantity(1, LengthUnit.FEET);
	        assertTrue(inch.equals(feet), "Equality must be symmetric");
	    }

	    // Null comparison
	    @Test
	    void testEquality_NullComparison() {
	        GenericQuantity q = new GenericQuantity(1, LengthUnit.FEET);
	        assertFalse(q.equals(null), "Object should not equal null");
	    }

	    // Constructor validation: null unit should throw exception
	    @Test
	    void testConstructor_NullUnit_ShouldThrowException() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new GenericQuantity(1, null);
	        });
	    }
}
